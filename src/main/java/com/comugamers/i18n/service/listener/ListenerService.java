package com.comugamers.i18n.service.listener;

import com.comugamers.i18n.service.Service;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;
import java.util.Set;

public class ListenerService implements Service {

    @Inject
    private Set<Listener> listeners;

    @Inject
    private Plugin plugin;

    @Override
    public void start() {
        listeners.forEach(listener -> plugin.getServer().getPluginManager().registerEvents(listener, plugin));
    }
}
