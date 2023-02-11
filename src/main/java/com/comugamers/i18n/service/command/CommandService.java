package com.comugamers.i18n.service.command;

import com.comugamers.i18n.service.Service;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.bukkit.message.BukkitMessageKey;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.message.MessageKey;
import dev.triumphteam.cmd.core.message.context.MessageContext;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.util.Set;

public class CommandService implements Service {

    @Inject
    private Set<BaseCommand> commandSet;

    @Inject
    private BukkitCommandManager<CommandSender> commandManager;

    @Inject
    private MessageHandler messageHandler;

    @Override
    public void start() {
        // Register all known commands
        commandSet.forEach(commandManager::registerCommand);
    }

    @Override
    public void stop() {
        // Unregister all known commands
        commandSet.forEach(commandManager::unregisterCommand);
    }

    private void configureMessage(BukkitMessageKey<? extends MessageContext> key, String path) {
        commandManager.registerMessage(key, (sender, context) ->
                messageHandler.send(sender,
                        path.replace("%command%", context.getCommand())
                            .replace("%subcommand%", context.getSubCommand())
                )
        );
    }

    private void configureMessage(MessageKey<? extends MessageContext> key, String path) {
        commandManager.registerMessage(key, (sender, context) ->
                messageHandler.send(sender,
                        path.replace("%command%", context.getCommand())
                            .replace("%subcommand%", context.getSubCommand())
                )
        );
    }
}
