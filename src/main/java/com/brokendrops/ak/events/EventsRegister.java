package com.brokendrops.ak.events;

import com.brokendrops.ak.Main;
import com.brokendrops.ak.listeners.BlockListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsRegister {

    private Plugin plugin;

    public EventsRegister(Plugin plugin){
        this.plugin = plugin;
    }

    public void registerListeners(){
        registerListener(new BlockListener());
    }

    public void registerCommands(){}


    private void registerListener(Listener listener){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(listener, plugin);
    }

    private void registerCommand(String cmd, CommandExecutor command){
        Main.getInstance().getCommand(cmd).setExecutor(command);
    }
}
