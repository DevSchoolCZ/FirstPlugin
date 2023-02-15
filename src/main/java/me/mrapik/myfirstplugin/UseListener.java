package me.mrapik.myfirstplugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class UseListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() != Material.DIAMOND_SWORD && itemStack.getType() != Material.IRON_SWORD) {
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null) {
            return;
        }

        String ability = itemMeta.getPersistentDataContainer().get(new NamespacedKey(FirstPlugin.getInstance(), "custom_ability"), PersistentDataType.STRING);

        if (ability == null) {
            return;
        }

        player.setHealth(20.0);

    }

}
