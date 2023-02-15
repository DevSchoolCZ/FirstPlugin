package me.mrapik.myfirstplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class FirstPlugin extends JavaPlugin {

    private static FirstPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("Turning on");

        // 1. Internal
        // 2. Listenery
        // 3. Commandy

        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("item").setExecutor(new ItemCommand());
    }

    public void loadConfig() {

        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        // Nahraje config.yml do složky
        this.saveDefaultConfig();

        // "Stáhne" data z nahraného config.yml do paměti
        this.reloadConfig();

        // "Načte" data - ta už jsou uložená v paměti - zde NEPRACUJEME se souborem
        FileConfiguration fileConfiguration = this.getConfig();

        // ---------- NAČÍTÁNÍ DAT Z KONFIGURACE -------------
        String value1 = fileConfiguration.getString("vipGroups.premium.test2");
        int value2 = fileConfiguration.getInt("test3");


        if (fileConfiguration.contains("vipGroups")) {

            for (String key : fileConfiguration.getConfigurationSection("vipGroups").getKeys(false)) {

                //  vipGroups.key
                String test2 = fileConfiguration.getConfigurationSection("vipGroups." + key).getString("test2");
                test2 = fileConfiguration.getString("vipGroups." + key + ".test2");

            }

            fileConfiguration.getConfigurationSection("commands").getInt("premium.subSubSection.test");
        }

        // ---------- UPDATE & INSERT DAT DO KONFIGURACE -------------

        if (!fileConfiguration.contains("commands.premium.subSubSection.test")) {
            fileConfiguration.set("commands.premium.subSubSection.test", 54);
        }
        fileConfiguration.set("commands.premium.subSubSection.g4sg4f", "Test");
        fileConfiguration.set("commands.premium.subSubSection.test", 54);

        // ---------- ULOŽENÍ KONFIGURACE DO SOUBORU -------------
        this.saveConfig();
    }


    @Override
    public void onDisable() {
        System.out.println("Turning off");

    }

    public static FirstPlugin getInstance() {
        return instance;
    }
}
