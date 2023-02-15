package me.mrapik.myfirstplugin.user.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        System.out.println("Player '" + player.getName() + "' has joined!");
        player.setHealth( player.getMaxHealth() );
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        System.out.println("Player '" + player.getName() + "' has left!");
    }

}
