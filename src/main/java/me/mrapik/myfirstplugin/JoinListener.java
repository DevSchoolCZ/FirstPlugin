package me.mrapik.myfirstplugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class JoinListener implements Listener {

    /*
    1. hráč mu dá damage
    2. hráči ubydou HP

    1. Vytvoří se Event typu EntityDamageByEntityEvent
    2. Do Eventu se nadhodí informace o damage, player, damager atd.
    3. Event se "spustí" (tzn. všechny pluginy, co ho poslouchají, tak mají informace o tom eventu)
    4. Ověří, jestli event nebyl zrušen
    5. Hráč dostane takovou damage, která odpovídá event.getFinalDamage()


     */

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        event.setCancelled(true);
        event.getPlayer().sendMessage("Na toto nemas opravneni!");
    }

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }

        event.setDamage(10.0);

        Entity whoGetDamage = event.getEntity();
        Entity whoDamaged = event.getDamager();

        if (whoDamaged.getType() == EntityType.PLAYER) {

            Player damagerPlayer = (Player) whoDamaged;

            System.out.println("Hrac: " + damagerPlayer.getName() + " něco hitnul (type: " + whoGetDamage.getType() + ")!");

        }
    }

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
