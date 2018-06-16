package de.didi090302.lobbysystem;

import de.didi090302.lobbysystem.commands.LsHelpCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String ver="1.0";

    @Override
    public void onEnable() {
        //Load all main Methods
        loadConfiguration();
        loadListener();
        loadCommands();
        Bukkit.getServer().getConsoleSender().sendMessage(getConfig().getString("LobbySystem.prefix")+"§aStarted!");
        Bukkit.getServer().getConsoleSender().sendMessage(getConfig().getString("LobbySystem.prefix")+"§aVersion: §6"+ver);
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(getConfig().getString("LobbySystem.prefix")+"§cStopped!");
    }

    //Load commands
    public void loadCommands() {
        new LsHelpCMD(this);
    }

    //Load Listener/Events
    public void loadListener() {

    }

    //Load default Configuration file!
    public void loadConfiguration() {
        reloadConfig();
        getConfig().options().header("Main Configuration of this Plugin!");
        getConfig().addDefault("LobbySystem.prefix", "§7[§6LobbySystem§7]§r");
        getConfig().addDefault("LobbySystem.noperms", "§4You don't have permissions");
        getConfig().options().copyDefaults();
        getConfig().options().copyHeader();
        saveConfig();
    }

}
