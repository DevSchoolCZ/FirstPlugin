package me.mrapik.myfirstplugin.item.command;

import me.mrapik.myfirstplugin.FirstPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            System.out.println("Tento prikaz muze zadat pouze hrac!");
            return true;
        }

        Player player = (Player) commandSender;

        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            System.out.println("Interni chyba!");
            return true;
        }

        itemMeta.setDisplayName("§3§lMuj super meč");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Muj super popisek");
        lore.add("§7Dalsi radek.");

        itemMeta.setLore(lore);

        // DIG_SPEED = Efficiency
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);

        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Custom texture pack
        itemMeta.setCustomModelData(10);

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(new NamespacedKey(FirstPlugin.getInstance(), "custom_ability"), PersistentDataType.STRING, "heal");

        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        return true;
    }


}
