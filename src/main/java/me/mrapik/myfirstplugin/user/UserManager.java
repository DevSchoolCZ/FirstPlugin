package me.mrapik.myfirstplugin.user;

import me.mrapik.myfirstplugin.FirstPlugin;
import me.mrapik.myfirstplugin.user.command.FlyCommand;
import me.mrapik.myfirstplugin.user.controller.HomeController;
import me.mrapik.myfirstplugin.user.listener.JoinListener;

import java.util.HashMap;

public class UserManager {

    private FirstPlugin plugin;

    private HashMap<String, User> userHashMap;

    private HomeController homeController;

    public UserManager() {
        this.plugin = FirstPlugin.getInstance();
        loadData();

        homeController = new HomeController();

        plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        plugin.getCommand("fly").setExecutor(new FlyCommand());
    }

    public void loadData() {
        this.userHashMap = new HashMap<>();

        // TODO: Load from data storage
    }

    public boolean updateUser(User user) {
        if (!userHashMap.containsKey(user.getName().toLowerCase())) {
            return false;
        }
        this.userHashMap.put(user.getName().toLowerCase(), user);

        // TODO: Update in data storage

        return true;
    }

    public boolean addUser(User user) {
        if (userHashMap.containsKey(user.getName().toLowerCase())) {
            return false;
        }
        this.userHashMap.put(user.getName().toLowerCase(), user);

        // TODO: Insert into data storage

        return true;
    }

    public User getUser(String username) {
        return this.userHashMap.get(username.toLowerCase());
    }

    public HashMap<String, User> getUserHashMap() {
        return userHashMap;
    }

    public HomeController getHomeController() {
        return homeController;
    }
}
