package com.comugamers.i18n.inject;

import com.comugamers.i18n.MultiLangPlugin;
import com.comugamers.i18n.inject.commands.CommandModule;
import com.comugamers.i18n.inject.file.FileModule;
import com.comugamers.i18n.inject.listener.ListenerModule;
import com.comugamers.i18n.inject.message.MessageModule;
import com.comugamers.i18n.inject.service.ServiceModule;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.AbstractModule;

public class MultiLangModule extends AbstractModule {

    private final MultiLangPlugin plugin;

    public MultiLangModule(MultiLangPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        // Bind plugin instance
        bind(Plugin.class).toInstance(plugin);
        bind(MultiLangPlugin.class).toInstance(plugin);

        // Install modules
        install(new FileModule());
        install(new CommandModule());
        install(new ListenerModule());
        install(new ServiceModule());
        install(new MessageModule());
    }
}
