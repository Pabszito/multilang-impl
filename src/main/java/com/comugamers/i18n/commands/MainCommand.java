package com.comugamers.i18n.commands;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;

@Command(value = "multilang", alias = { "i18n" })
public class MainCommand extends BaseCommand {

    @Inject
    private Plugin plugin;

    @Inject
    private MessageHandler messageHandler;

    @Default
    @Permission("multilang-impl.main")
    public void execute(CommandSender sender) {
        messageHandler.replacingMany(sender, "language.command.info",
                "%pluginName%", plugin.getDescription().getName(),
                "%pluginVersion%", plugin.getDescription().getVersion()
        ).forEach(sender::sendMessage);
    }
}
