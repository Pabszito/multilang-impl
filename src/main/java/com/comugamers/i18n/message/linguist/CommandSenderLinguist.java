package com.comugamers.i18n.message.linguist;

import me.yushust.message.language.Linguist;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandSenderLinguist implements Linguist<CommandSender> {

    @Override
    public @Nullable String getLanguage(CommandSender sender) {
        return "en-US"; // TODO: replace this later with an actual storage method
    }
}
