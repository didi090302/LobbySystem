package de.didi090302.lobbysystem.commands;

import de.didi090302.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LsHelpCMD implements CommandExecutor {

    private Main main;

    public LsHelpCMD(Main main) {
        this.main = main;
        Bukkit.getServer().getPluginCommand("lshelp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(sender.hasPermission("lobbysystem.commands.lshelp")) {
                sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+"§e/lshelp §7|§aYou see that");
                sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+"§e/lsinfo §7|§aSee current Plugin Version");
                sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+"§e/lssetspawn §7|§aSet the LobbySpawn");
            } else {
                sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+main.getConfig().getString("LobbySystem.noperms"));
            }

        return true;
    }
}
