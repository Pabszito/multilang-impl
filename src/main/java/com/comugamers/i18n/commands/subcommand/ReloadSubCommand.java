package com.comugamers.i18n.commands.subcommand;

import com.comugamers.i18n.commands.MainCommand;
import com.comugamers.i18n.utils.YamlFile;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotation.Default;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

public class ReloadSubCommand extends MainCommand {

    @Inject
    private YamlFile config;

    @Inject
    private MessageHandler messageHandler;
    @Default
    @Permission("multilang-impl.reload")
    public void execute(CommandSender sender) {
        config.reload();
        messageHandler.send(sender, "language.command.reloaded");
    }
}
