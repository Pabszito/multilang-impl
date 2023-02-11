package com.comugamers.i18n.commands.subcommand;

import com.comugamers.i18n.commands.MainCommand;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class TestSubCommand extends MainCommand {

    @SubCommand("test")
    @Permission("multilang-impl.admin")
    public void execute(Player player) {
        player.sendMessage(PlaceholderAPI.setPlaceholders(player, "%translation_example%"));
    }
}
