package com.comugamers.i18n.message.sender;

import me.yushust.message.send.MessageSender;
import org.bukkit.command.CommandSender;

public class CommandSenderMessageSender /* :skull: */ implements MessageSender<CommandSender> {

    @Override
    public void send(CommandSender sender, String string, String mode) {
        sender.sendMessage(string);
    }
}
