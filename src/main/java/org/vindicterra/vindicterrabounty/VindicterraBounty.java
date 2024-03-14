package org.vindicterra.vindicterrabounty;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;
import org.vindicterra.vindicterrabounty.command.BountyMainCommand;
import org.vindicterra.vindicterrabounty.command.util.MainCommand;
import org.vindicterra.vindicterrabounty.util.Config;

public final class VindicterraBounty extends JavaPlugin {

    private static VindicterraBounty instance;
    private static Config config;

    @Override
    public void onEnable() {
        instance = this;
        config = new Config(this);
        registerCommands();
        this.getLogger().info("VindicterraBounty has been enabled! Also, Sparks is based!");
    }

    private void registerCommands() {
        new BountyMainCommand(this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("VindicterraBounty has been disabled! Also, Sparks is still based!");
        // Plugin shutdown logic
    }

    // Getters and Setters
    public static VindicterraBounty getPluginInstance() {
        return instance;
    }
}
