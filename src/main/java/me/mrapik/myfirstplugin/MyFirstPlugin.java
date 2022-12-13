package me.mrapik.myfirstplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MyFirstPlugin extends JavaPlugin {

    // Singleton instance of our plugin
    // Instance is static, because ONLY ONE instance is created for our plugin!
    private static MyFirstPlugin instance;

    // Our plugin's prefix
    private String prefix;

    /**
     * This method is called when the server is starting
     */
    @Override
    public void onEnable() {
        // First we shall set the instance to "this". Write this line
        // before anything else!
        instance = this;

        // Set our prefix
        this.prefix = "§2§lServer §8§l>> ";

        // Write message to the console
        System.out.println("Zapinam se!");

        // Register our listener class
        this.getServer().getPluginManager().registerEvents(new MyListener(), instance);
        // Register our FlyCommand class to the command "fly"
        this.getCommand("fly").setExecutor(new FlyCommand());
    }

    /**
     * This method is called when the server is stopping
     */
    @Override
    public void onDisable() {
        System.out.println("Vypinam se!");
    }

    /**
     * Getter for our singleton instance
     *
     * @return
     */
    public static MyFirstPlugin getInstance() {
        return instance;
    }

    /**
     * Getter for prefix
     *
     * @return
     */
    public String getPrefix() {
        return prefix;
    }
}
