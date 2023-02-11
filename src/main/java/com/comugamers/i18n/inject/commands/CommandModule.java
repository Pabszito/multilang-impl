package com.comugamers.i18n.inject.commands;

import com.comugamers.i18n.commands.MainCommand;
import com.comugamers.i18n.commands.subcommand.ReloadSubCommand;
import com.comugamers.i18n.commands.subcommand.TestSubCommand;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.BaseCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.Provides;

import javax.inject.Singleton;

public class CommandModule extends AbstractModule {

    @Singleton
    @Provides
    public BukkitCommandManager<CommandSender> provideCommandManager(Plugin plugin) {
        return BukkitCommandManager.create(plugin);
    }

    @Override
    protected void configure() {
        multibind(BaseCommand.class)
                .asSet()
                .to(MainCommand.class)
                .to(ReloadSubCommand.class)
                .to(TestSubCommand.class)
                .singleton();
    }
}
