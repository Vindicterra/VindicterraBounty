package org.vindicterra.vindicterrabounty.command.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vindicterra.vindicterrabounty.VindicterraBounty;
import org.vindicterra.vindicterrabounty.util.Config;

import java.util.*;

public class MainCommand implements CommandExecutor, TabExecutor {

    private Map<String, SubCommand> subCommands = new HashMap<>();
    private String commandName;
    private VindicterraBounty plugin;

    //TODO: Add configurable settings for main commands

    public MainCommand(String name) {
        setCommandName(name);
        plugin = VindicterraBounty.getInstance();

        plugin.getCommand(name).setExecutor(this);
    }
    protected void registerSubCommand(String name, SubCommand subCommand) {
        subCommands.put(name, subCommand);

        subCommand.setData(Config.getInstance().getCommandData(String.format("commands.%s.subcommands.%s", commandName, name)));
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(String.format("Usage: /%s <subcommand>"), commandName);
            return true;
        }

        SubCommand subCommand = subCommands.get(args[0].toLowerCase());
        if (subCommand == null) {
            sender.sendMessage("Invalid subcommand!");
            return true;
        }

        //TODO: Add permission check
        //TODO: Add help message

        subCommand.execute((Player) sender, args);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // If there are no arguments, return the subcommands
        if (args.length == 1) return subCommands.keySet().stream().toList();

        SubCommand subCommand = subCommands.get(args[0]);
        if (subCommand != null)
            // Return the tab completion for the subcommand
            return subCommand.getSubCommandTab(sender, args[0], Arrays.copyOfRange(args, 1, args.length));

        // If the subcommand is not found, return null
        return null;
    }

    // Getters and Setters
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
}
