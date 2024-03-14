package org.vindicterra.vindicterrabounty.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.vindicterra.vindicterrabounty.VindicterraBounty;
import org.vindicterra.vindicterrabounty.command.util.CommandData;

import java.util.List;

public class Config {
    private static Config instance;
    private VindicterraBounty plugin;
    private FileConfiguration configFile;
    public Config() {
        instance = this;
        plugin = VindicterraBounty.getInstance();
        configFile = plugin.getConfig();
    }
    public static Config getInstance() {
        return instance;
    }
    public CommandData getCommandData(String configPath) {
        // Get the command data from the config
        String name = configFile.getString(configPath + ".name", "No name specified!");
        String permission = configFile.getString(configPath + ".permission", "");
        String description = configFile.getString(configPath + ".description", "No description specified!");
        boolean playerOnly = configFile.getBoolean(configPath + ".playerOnly", false);
        String[] aliases = configFile.getStringList(configPath + ".aliases").toArray(new String[0]);
        String usage = configFile.getString(configPath + ".usage", "No usage specified!");
        int requiredArgs = configFile.getInt(configPath + ".requiredArgs", 0);

        return new CommandData(name, permission, description, playerOnly, aliases, usage, requiredArgs);
    }
}
