package me.mrapik.myfirstplugin.user.controller;

import me.mrapik.myfirstplugin.FirstPlugin;
import me.mrapik.myfirstplugin.user.User;
import org.bukkit.Location;

public class HomeController {

    private FirstPlugin plugin;

    public HomeController() {
        this.plugin = FirstPlugin.getInstance();
    }

    public void home(User user) {
        Location homeLocation = user.getHomeLocation();
        if (homeLocation == null) {
            user.getPlayer().sendMessage("§cNemáš nastavený home! Použij /sethome pro nastavení!");
            return;
        }

        user.getPlayer().teleport(homeLocation);
        user.getPlayer().sendMessage("§aTeleportuji...");
    }

    public void setHome(User user) {
        user.setHomeLocation(user.getPlayer().getLocation());
        plugin.getUserManager().updateUser(user);

        user.getPlayer().sendMessage("§aLokace domova úspěšně nastavena!");
    }

}
