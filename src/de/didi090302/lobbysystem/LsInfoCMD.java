package de.didi090302.lobbysystem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LsInfoCMD implements CommandExecutor {

    private Main main;

    public LsInfoCMD(Main main) {
        this.main = main;
        Bukkit.getServer().getPluginCommand("lshelp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("lobbysystem.commands.lsinfo")) {
            if(args.length == 0) {
                sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+"Current version: §6"+Main.ver);
            }

        } else {
            sender.sendMessage(main.getConfig().getString("LobbySystem.prefix")+main.getConfig().getString("LobbySystem.noperms"));
        }

        return true;
    }

}
