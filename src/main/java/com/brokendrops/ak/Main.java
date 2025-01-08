package com.brokendrops.ak;

import com.brokendrops.ak.events.EventsRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        if(!getConfig().getBoolean("plugin")) getServer().getPluginManager().disablePlugin(this);
        if(getConfig().getBoolean("plugin")){
            getServer().getConsoleSender().sendMessage(getPrefix() + getMessage("start-message"));
            new EventsRegister(this).registerListeners();
            new EventsRegister(this).registerCommands();
        }
    }

    @Override
    public void onDisable() {
        if(getConfig().getBoolean("plugin")) {
            getServer().getConsoleSender().sendMessage(getPrefix() + getMessage("close-message"));
        }
    }

    public static String getPrefix() {
        return getInstance().getConfig().getString("prefix").replace("&", "§");
    }

    public static String getMessage(String path) {
        return getInstance().getConfig().getString(path).replace("&", "§");
    }

    public static Main getInstance() {
        return instance;
    }
}
