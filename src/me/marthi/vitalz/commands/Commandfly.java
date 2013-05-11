package me.marthi.vitalz.commands;

import java.util.ArrayList;
import java.util.List;

import me.marthi.vitalz.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandfly implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private vitalz plugin;

	public Commandfly(vitalz plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		List<Player> allowedFly = new ArrayList<Player>();
		if (sender instanceof Player) {
			if (player.hasPermission("vitalz.fly")) {
				if (args[0] == null) {
					if (allowedFly.contains(player)) {
						player.setFlying(false);
						player.setAllowFlight(false);
						allowedFly.remove(player);
					} else {
						player.setAllowFlight(true);
						player.setFlying(true);
						allowedFly.add(player);
					}
				} else if (args[0].equalsIgnoreCase("stop")) {
					player.setFlying(false);
					player.setAllowFlight(false);
					allowedFly.remove(player);
				} else {
					Player target = Bukkit.getPlayer(args[0]);
					if (allowedFly.contains(target)) {
						target.setFlying(false);
						target.setAllowFlight(false);
						allowedFly.remove(target);
					} else {
						target.setAllowFlight(true);
						target.setFlying(true);
						allowedFly.add(target);
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have access to that command!");
				player.sendMessage(ChatColor.RED + "If you believe this is incorrect, contact an operator.");
			}
		} else {
			System.out
					.println("A non-player tried to execute a player only command!");
			System.out.println("The command was /fly");
		}
		return false;
	}

}
