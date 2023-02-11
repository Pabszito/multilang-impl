package com.comugamers.i18n.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class StringUtils {

    public static String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static List<String> colorize(List<String> list) {
        list.forEach(StringUtils::colorize);
        return list;
    }
}
