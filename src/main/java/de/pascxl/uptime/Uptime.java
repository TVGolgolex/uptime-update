package de.pascxl.uptime;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * # Date: Mai 11, 2023
 * # Time. 21:51:43
 * # Name: uptime-update
 */
public class Uptime extends JavaPlugin {

    private long timeStartup;

    @Override
    public void onLoad() {
        this.timeStartup = System.currentTimeMillis();
    }

    @Override
    public void onEnable() {
        try {
            final Metrics metrics = new Metrics(this);
            metrics.start();
            this.getServer().getCommandMap().register("uptime", new Command(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printUptime(final CommandSender sender) {
        final long timeCurrent = System.currentTimeMillis();
        final long timeElapsed = timeCurrent - this.timeStartup;
        final long totalSeconds = timeElapsed / 1000L;
        final long totalMinutes = totalSeconds / 60L;
        final long totalHours = totalMinutes / 60L;
        final long totalDays = totalHours / 24L;
        final long fmtSeconds = totalSeconds - totalMinutes * 60L;
        final long fmtMinutes = totalMinutes - totalHours * 60L;
        final long fmtHours = totalHours - totalDays * 24L;
        final String upSeconds = String.valueOf(fmtSeconds);
        final String upMinutes = String.valueOf(fmtMinutes);
        final String upHours = String.valueOf(fmtHours);
        final String upDays = String.valueOf(totalDays);
        final ChatColor green = ChatColor.GREEN;
        final ChatColor white = ChatColor.WHITE;
        sender.sendMessage(green + "Uptime: " + white + upDays + "d " + upHours + "h " + upMinutes + "m " + upSeconds + "s");
    }

}
