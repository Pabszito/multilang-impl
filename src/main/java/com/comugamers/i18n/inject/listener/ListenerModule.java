package com.comugamers.i18n.inject.listener;

import com.comugamers.i18n.listener.PlayerJoinListener;
import org.bukkit.event.Listener;
import team.unnamed.inject.AbstractModule;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        multibind(Listener.class)
                .asSet()
                .to(PlayerJoinListener.class)
                .singleton();
    }
}
