package me.mrapik.myfirstplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * All listener classes must implement Listener interface (check if import is from org.bukkit!!!)
 */
public class MyListener implements Listener {

    /**
     * Listener's methods can be named whatever you want, but you NEED to add
     * @EventHandler annotation! Without that it won't work!
     *
     * @param event Which event you want to listen - in our case, PlayerJoinEvent is the one
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Obtain a Player object from the event
        Player player = event.getPlayer();

        // Obtain player's name from player
        String playerName = player.getName();

        // Send welcome message
        player.sendMessage(MyFirstPlugin.getInstance().getPrefix() + "§aRádi tě vidíme!");

        // Update join message, so it's not the ugly default one
        event.setJoinMessage("§a+ §7" + playerName);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        event.setQuitMessage("§c- §7" + playerName);
    }


}
