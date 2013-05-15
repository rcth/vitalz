package me.marthi.vitalz.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.marthi.vitalz.vitalz;

public class Commandtop implements CommandExecutor {

	private vitalz plugin;

	public Commandtop(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			if (player.hasPermission("vitalz.top")) {
				Location loc = player.getPlayer().getLocation();
				int highest = player.getWorld().getHighestBlockYAt(loc);
				loc.setY(highest);
				player.teleport(loc);
				return true;
			} else {
				player.sendMessage(ChatColor.RED
						+ "You do not have access to that command!");
				player.sendMessage(ChatColor.RED
						+ "If you believe this is incorrect, contact an operator.");
			}
		} else {
			System.out
					.println("A non-player tried to execute a player-only command!");
			System.out.println("The command was /top");
		}
		return false;
	}

}
