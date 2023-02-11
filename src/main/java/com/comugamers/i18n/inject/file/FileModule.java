package com.comugamers.i18n.inject.file;

import com.comugamers.i18n.utils.YamlFile;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.Provides;

import javax.inject.Singleton;

public class FileModule extends AbstractModule {

    @Singleton
    @Provides
    public YamlFile provideSettingsFile(Plugin plugin) {
        return new YamlFile(plugin, "config");
    }
}
