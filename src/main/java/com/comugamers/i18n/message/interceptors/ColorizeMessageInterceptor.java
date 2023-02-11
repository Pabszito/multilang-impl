package com.comugamers.i18n.message.interceptors;

import com.comugamers.i18n.utils.YamlFile;
import me.yushust.message.format.MessageInterceptor;
import org.jetbrains.annotations.NotNull;

import static com.comugamers.i18n.utils.StringUtils.colorize;

public class ColorizeMessageInterceptor implements MessageInterceptor {

    private final YamlFile config;

    public ColorizeMessageInterceptor(YamlFile config) {
        this.config = config;
    }

    @Override
    public @NotNull String intercept(String s) {
        return config.getBoolean("config.interceptors.colorize") ? colorize(s) : s;
    }
}
