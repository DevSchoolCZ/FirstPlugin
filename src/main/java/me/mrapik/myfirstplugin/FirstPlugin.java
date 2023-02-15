package me.mrapik.myfirstplugin;

import me.mrapik.myfirstplugin.user.command.FlyCommand;
import me.mrapik.myfirstplugin.item.command.ItemCommand;
import me.mrapik.myfirstplugin.user.listener.JoinListener;
import me.mrapik.myfirstplugin.user.UserManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {

    private static FirstPlugin instance;

    private UserManager userManager;

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("Turning on");

        // 0. Config & Databáze + setup prostředí
        loadConfig();

        // 1. Internal
        userManager = new UserManager();

        // 2. Listenery

        // 3. Commandy
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

    public UserManager getUserManager() {
        return userManager;
    }
}
