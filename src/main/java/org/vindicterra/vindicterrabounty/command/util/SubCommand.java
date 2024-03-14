package org.vindicterra.vindicterrabounty.command.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {
    private String name;
    private String permission;
    private String description;
    private boolean playerOnly;
    private String[] aliases;
    private String usage;
    private int requiredArgs;
    public void setData(CommandData data) {
        this.name = data.getName();
        this.permission = data.getPermission();
        this.description = data.getDescription();
        this.playerOnly = data.isPlayerOnly();
        this.aliases = data.getAliases();
        this.usage = data.getUsage();
        this.requiredArgs = data.getRequiredArgs();
    }
    //TODO: Add configurable help command

    // Execute the subcommand
    public abstract void execute(Player player, String[] args);

    // Tab completion for subcommands
    public abstract List<String> getSubCommandTab(CommandSender sender, String subcommand, String[] args);
}
