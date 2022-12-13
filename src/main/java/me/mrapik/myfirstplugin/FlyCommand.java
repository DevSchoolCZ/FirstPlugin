package me.mrapik.myfirstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * All command classes must implement CommandExecutor interface
 */
public class FlyCommand implements CommandExecutor {

    /**
     * This method is called when command registered to this class (in our case "fly") is executed by
     * command sender (console, command_block, player)
     *
     * @param commandSender Who executed the command
     * @param command  Commands which was executed (you can register more commands to one class)
     * @param label What command was exactly written to chat (there can be aliases in plugin.yml specified)
     * @param args   Arguments of the command (e.g. /fly args[0] args[1] - /fly apik007 on)
     * @return  Whether the command was handled or not (recommended to always use "true")
     */
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check if the command sender is Player, if not, print warn message and return
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Tento prikaz muze zadat pouze hrac!");
            return true;
        }

        // Now we know that commandSender is player
        Player player = (Player) commandSender;

        // We want to reverse player's flight mode
        // So if he IS allowed to fly, new state will be NOT allowed
        //    if he is NOT allowed, new state will be allowed
        boolean newState = !player.getAllowFlight();

        // Update player's flight mode - caution! do not use setFlying
        player.setAllowFlight(newState);

        // Send message to the player - if he can now fly, it shall print "zapnut", otherwise "vypnut"
        player.sendMessage(MyFirstPlugin.getInstance().getPrefix() + "§eFly byl " + (newState ? "§azapnut" : "§cvypnut")  + "§e!");

        return true;
    }



}
