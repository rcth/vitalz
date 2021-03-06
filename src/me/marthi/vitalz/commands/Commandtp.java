package me.marthi.vitalz.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.marthi.vitalz.vitalz;
import me.marthi.vitalz.exceptions.PlayerNotFoundException;

public class Commandtp implements CommandExecutor {

	private vitalz plugin;

	public Commandtp(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;

		if (!args[0].isEmpty()) {
			if (sender instanceof Player) {
				if (player.hasPermission("vitalz.tp")) {
					Player target = plugin.getServer().getPlayer(args[0]);
					if (target != null) {
						player.teleport(target);
						player.sendMessage(ChatColor.GOLD + "Teleporting you to " + ChatColor.AQUA + target);
						return true;
					} else {
						try {
							throw new PlayerNotFoundException(player);
						} catch (PlayerNotFoundException e) {
							e.printStackTrace();
						}
					}
				} else {
					player.sendMessage(ChatColor.RED
							+ "You do not have access to that command!");
					player.sendMessage(ChatColor.RED
							+ "If you believe this is incorrect, contact an operator.");
				}
			} else {
				System.out
						.println("A non-player tried to execute a player only command!");
				System.out.println("The command was /tp");
			}
		} else {
			player.sendMessage(ChatColor.RED + "You must specify a target.");
		}
		return false;
	}

}
