package de.pascxl.uptime;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * # Date: Mai 11, 2023
 * # Time. 21:58:08
 * # Name: uptime-update
 */
public class Command extends org.bukkit.command.Command {

    private final Uptime uptime;

    public Command(Uptime uptime) {
        super("uptime");
        this.uptime = uptime;
        setPermission("uptime");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        this.uptime.printUptime(sender);
        return false;
    }
}
