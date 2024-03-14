package org.vindicterra.vindicterrabounty.command.util;

public class CommandData {
    private final String name;
    private final String permission;
    private final String description;
    private final boolean playerOnly;
    private final String[] aliases;
    private final String usage;
    private final int requiredArgs;

    public CommandData(String name, String permission, String description, boolean playerOnly, String[] aliases, String usage, int requiredArgs) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.playerOnly = playerOnly;
        this.aliases = aliases;
        this.usage = usage;
        this.requiredArgs = requiredArgs;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPermission() {
        return permission;
    }
    public String getDescription() {
        return description;
    }
    public boolean isPlayerOnly() {
        return playerOnly;
    }
    public String[] getAliases() {
        return aliases;
    }
    public String getUsage() {
        return usage;
    }
    public int getRequiredArgs() {
        return requiredArgs;
    }

}
