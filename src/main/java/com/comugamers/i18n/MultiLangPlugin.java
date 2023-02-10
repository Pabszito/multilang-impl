package com.comugamers.i18n;

import org.bukkit.plugin.java.JavaPlugin;

public class MultiLangPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello world!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye world!");
    }
}
