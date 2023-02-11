package com.comugamers.i18n.service.placeholder;

import com.comugamers.i18n.placeholder.MultiLangPlaceholderExpansion;
import com.comugamers.i18n.service.Service;

import javax.inject.Inject;

public class PlaceholderService implements Service {

    @Inject
    private MultiLangPlaceholderExpansion expansion;

    @Override
    public void start() {
        expansion.register();
    }
}
