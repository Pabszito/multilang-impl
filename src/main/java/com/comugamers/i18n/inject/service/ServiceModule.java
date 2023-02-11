package com.comugamers.i18n.inject.service;

import com.comugamers.i18n.service.Service;
import com.comugamers.i18n.service.command.CommandService;
import com.comugamers.i18n.service.listener.ListenerService;
import com.comugamers.i18n.service.main.MainService;
import team.unnamed.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Service.class)
                .to(MainService.class)
                .singleton();

        this.bind(Service.class)
                .named("command")
                .to(CommandService.class)
                .singleton();

        this.bind(Service.class)
                .named("listener")
                .to(ListenerService.class)
                .singleton();
    }
}
