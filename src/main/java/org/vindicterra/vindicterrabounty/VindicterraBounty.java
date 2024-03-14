package org.vindicterra.vindicterrabounty;

import org.bukkit.plugin.java.JavaPlugin;
import org.vindicterra.vindicterrabounty.command.BountyMainCommand;
import org.vindicterra.vindicterrabounty.command.util.MainCommand;

public final class VindicterraBounty extends JavaPlugin {

    private static VindicterraBounty instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info("VindicterraBounty has been enabled! Also, Sparks is based!");
    }

    private void registerCommands() {
        new BountyMainCommand();
    }

    @Override
    public void onDisable() {
        this.getLogger().info("VindicterraBounty has been disabled! Also, Sparks is still based!");
        // Plugin shutdown logic
    }

    // Getters and Setters
    public static VindicterraBounty getInstance() {
        return instance;
    }
}
