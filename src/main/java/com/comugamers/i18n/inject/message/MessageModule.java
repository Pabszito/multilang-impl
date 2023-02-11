package com.comugamers.i18n.inject.message;

import com.comugamers.i18n.message.interceptors.ColorizeMessageInterceptor;
import com.comugamers.i18n.message.linguist.CommandSenderLinguist;
import com.comugamers.i18n.message.sender.CommandSenderMessageSender;
import com.comugamers.i18n.utils.YamlFile;
import me.yushust.message.MessageHandler;
import me.yushust.message.source.MessageSource;
import me.yushust.message.source.MessageSourceDecorator;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.Provides;

import javax.inject.Singleton;
import java.util.List;

import static me.yushust.message.bukkit.BukkitMessageAdapt.newYamlSource;

public class MessageModule {

    @Singleton
    @Provides
    public MessageHandler provideMessageHandler(Plugin plugin, YamlFile config) {
        List<String> allowedLanguages = config.getStringList("config.allowed-languages.list");

        // less hacky thing ever
        allowedLanguages.forEach(lang -> new YamlFile(plugin, "i18n/" + lang));

        // Create a new message source
        MessageSource source = MessageSourceDecorator.decorate(newYamlSource(plugin, "i18n/%lang%.yml"))
                .addFallbackLanguage(config.getString("config.fallback"))
                .get();

        // Build the message handler
        return MessageHandler.of(
                source,
                settings -> settings
                        .addInterceptor(new ColorizeMessageInterceptor(config))
                        .specify(CommandSender.class)
                        .setLinguist(new CommandSenderLinguist())
                        .setMessageSender(new CommandSenderMessageSender())
        );
    }
}
