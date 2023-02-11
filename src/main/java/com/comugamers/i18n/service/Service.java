package com.comugamers.i18n.service;

public interface Service {

    void start();

    default void stop() {}
}
