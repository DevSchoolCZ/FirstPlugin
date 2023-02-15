package me.mrapik.myfirstplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {


    //  /fly [nick]
    //  /fly

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {

        if (!(commandSender instanceof Player)) {
            System.out.println("Tento prikaz muze zadat pouze hrac!");
            return true;
        }

        Player senderPlayer = (Player) commandSender;

        Player targetPlayer;

        if (args.length == 0) {
            targetPlayer = senderPlayer;
        } else {
            String nickname = args[0];
            targetPlayer = Bukkit.getPlayer(nickname);
        }

        if (targetPlayer == null) {
            senderPlayer.sendMessage("§cTento hráč neexistuje, nebo není online!");
            return true;
        }


        Location location = new Location(Bukkit.getWorld("world"), 100.0, 100.0, 100.0, targetPlayer.getLocation().getYaw(), targetPlayer.getLocation().getPitch());

        Location playerLocation = targetPlayer.getLocation().clone();
        playerLocation.setX(playerLocation.getX() + 100.0);

        targetPlayer.teleport(playerLocation);


        if (targetPlayer.getAllowFlight()) {
            targetPlayer.setAllowFlight(false);
            targetPlayer.setFlying(false);
            targetPlayer.sendMessage("§cLétání vypnuto!");
        } else {
            targetPlayer.setAllowFlight(true);
            targetPlayer.sendMessage("§aLétání zapnuto!");
        }

        if (targetPlayer != senderPlayer) {
            senderPlayer.sendMessage("§aLétání hráči '" + targetPlayer.getName() + "' změněno!");
        }

        return true;
    }


}
