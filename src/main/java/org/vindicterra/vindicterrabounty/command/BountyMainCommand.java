package org.vindicterra.vindicterrabounty.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vindicterra.vindicterrabounty.command.subcommands.AddBountyCommand;
import org.vindicterra.vindicterrabounty.command.util.MainCommand;

import java.util.Arrays;
import java.util.List;

public class BountyMainCommand extends MainCommand implements CommandExecutor {
    public BountyMainCommand() {
        super("bounty");

        registerSubCommand("add", new AddBountyCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }
}
