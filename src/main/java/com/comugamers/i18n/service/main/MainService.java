package com.comugamers.i18n.service.main;

import com.comugamers.i18n.service.Service;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

public class MainService implements Service {

    @Inject @Named("command")
    private Service commandService;

    @Inject @Named("listener")
    private Service listenerService;

    @Inject @Named("placeholder")
    private Service placeholderService;

    @Inject
    private Plugin plugin;

    @Override
    public void start() {
        startMany(commandService, listenerService, placeholderService);

        // Send onEnable message
        plugin.getLogger().info("MultiLangImpl has been enabled!");
        plugin.getLogger().info("Currently running version " + plugin.getDescription().getVersion() + ".");
    }

    @Override
    public void stop() {
        stopMany();

        // Send onDisable message
        plugin.getLogger().info("MultiLangImpl has been disabled!");
    }

    private void startMany(Service... services) {
        Arrays.stream(services).forEach(Service::start);
    }

    private void stopMany(Service... services) {
        Arrays.stream(services).forEach(Service::stop);
    }
}
