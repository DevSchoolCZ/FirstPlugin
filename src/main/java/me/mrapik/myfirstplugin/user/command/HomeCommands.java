package me.mrapik.myfirstplugin.user.command;

import me.mrapik.myfirstplugin.FirstPlugin;
import me.mrapik.myfirstplugin.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommands implements CommandExecutor {

    private FirstPlugin plugin;

    public HomeCommands() {
        this.plugin = FirstPlugin.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cTento prikaz muze byt pouzit pouze ze hry!");
            return true;
        }

        Player player = (Player) commandSender;

        User user = plugin.getUserManager().getUser(player.getName());
        if (user == null) {
            player.sendMessage("§cPři zpracování příkazu došlo k chybě!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("home")) {
            plugin.getUserManager().getHomeController().home(user);
            return true;
        }

        if (command.getName().equalsIgnoreCase("sethome")) {
            plugin.getUserManager().getHomeController().setHome(user);
            return true;
        }

        return false;
    }

}
