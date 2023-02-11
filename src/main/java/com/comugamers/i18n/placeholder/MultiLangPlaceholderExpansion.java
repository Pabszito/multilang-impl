package com.comugamers.i18n.placeholder;

import com.comugamers.i18n.MultiLangPlugin;
import com.comugamers.i18n.utils.YamlFile;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.yushust.message.MessageHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class MultiLangPlaceholderExpansion extends PlaceholderExpansion {

    @Inject
    private MultiLangPlugin plugin;

    @Inject
    private MessageHandler messageHandler;

    @Inject
    private YamlFile config;

    @Override
    public @NotNull String getIdentifier() {
        return "translation";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Pabszito";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String path) {
        plugin.debug("Using path 'translations." + path + "' to request translation.");
        String message = messageHandler.get(player, "translations." + path);
        return config.getBoolean("config.apply-placeholders", true)
                ? PlaceholderAPI.setPlaceholders(player, message)
                : message;
    }
}
