package com.comugamers.i18n;

import com.comugamers.i18n.inject.MultiLangModule;
import com.comugamers.i18n.service.Service;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;

public class MultiLangPlugin extends JavaPlugin {

    @Inject
    private Service service;

    @Override
    public void onEnable() {
        // Create a new injector & inject members
        Injector injector = Injector.create(new MultiLangModule(this));
        injector.injectMembers(this);

        // Start the main service
        service.start();
    }

    @Override
    public void onDisable() {
        if (service != null) {
            // Stop the main service
            service.stop();
        }
    }
}
