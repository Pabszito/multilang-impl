package com.comugamers.i18n.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.comugamers.i18n.utils.StringUtils.colorize;

public final class YamlFile extends YamlConfiguration {

    private final String fileName;
    private final Plugin plugin;
    private final File folder;

    public YamlFile(Plugin plugin, String fileName) {
        this(plugin, fileName, ".yml");
    }

    public YamlFile(Plugin plugin, String fileName, String fileExtension) {
        this(plugin, fileName, fileExtension, plugin.getDataFolder());
    }

    public YamlFile(Plugin plugin, String fileName, String fileExtension, File folder) {
        this.folder = folder;
        this.plugin = plugin;
        this.fileName = fileName + (fileName.endsWith(fileExtension) ? "" : fileExtension);

        this.options().copyDefaults(true);
        this.create();
    }

    @Override
    public String getString(String path) {
        return colorize(
                super.getString(path, path)
        );
    }

    @Override
    public List<String> getStringList(String path) {
        return getStringList(path, true);
    }

    public List<String> getStringList(String path, boolean colorize) {
        // Get the list
        List<String> list = super.getStringList(path);

        // Check if the list is null
        if(list == null) {
            // Return an empty array list
            return new ArrayList<>();
        }

        // Return the colorized list if wanted
        return colorize ? colorize(list) : list;
    }

    public void create() {
        try {
            File file = new File(this.folder, this.fileName);
            if (file.exists()) {
                this.load(file);
                this.save(file);
            } else {
                if (this.plugin.getResource(this.fileName) != null) {
                    this.plugin.saveResource(this.fileName, true);
                } else {
                    this.save(file);
                }

                this.load(file);
            }
        } catch (IOException | InvalidConfigurationException exception) {
            this.plugin.getLogger().log(Level.SEVERE, "Unable to create file '" + this.fileName + "'.", exception);
        }
    }

    public void save() {
        File folder = this.plugin.getDataFolder();
        File file = new File(folder, this.fileName);

        try {
            this.save(file);
        } catch (IOException exception) {
            this.plugin.getLogger().log(Level.SEVERE, "Unable to save file '" + this.fileName + "'.", exception);
        }
    }

    public void reload() {
        File folder = this.plugin.getDataFolder();
        File file = new File(folder, this.fileName);

        try {
            this.load(file);
        } catch (InvalidConfigurationException | IOException exception) {
            this.plugin.getLogger().log(Level.SEVERE, "Unable to reload file '" + this.fileName + "'.", exception);
        }
    }
}