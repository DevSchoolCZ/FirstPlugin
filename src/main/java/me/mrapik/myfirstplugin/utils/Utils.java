package me.mrapik.myfirstplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    public static boolean isInteger(String intInString) {
        try {
            int number = Integer.parseInt(intInString);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static Integer parseInteger(String intInString) {
        try {
            return Integer.parseInt(intInString);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    public static void broadcast(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    public static void broadcast(String message, String permission) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.hasPermission(permission)) {
                continue;
            }
            player.sendMessage(message);
        }
    }


}
