package com.comugamers.i18n.service.main;

import com.comugamers.i18n.service.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

public class MainService implements Service {

    @Inject @Named("command")
    private Service commandService;

    @Inject @Named("listener")
    private Service listenerService;

    @Override
    public void start() {
        startMany(commandService, listenerService);
    }

    @Override
    public void stop() {
        stopMany();
    }

    private void startMany(Service... services) {
        Arrays.stream(services).forEach(Service::start);
    }

    private void stopMany(Service... services) {
        Arrays.stream(services).forEach(Service::stop);
    }
}
