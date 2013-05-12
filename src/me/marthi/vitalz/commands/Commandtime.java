package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtime implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private vitalz plugin;

	public Commandtime(vitalz plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		Long time = player.getWorld().getTime();
		
		
		if (sender instanceof Player) {
			if (player.hasPermission("vitalz.time")) {
				if (args[0] == null) {
					player.sendMessage(ChatColor.AQUA + "Current time is: " + time + ".");
					player.sendMessage(ChatColor.RED + "Insufficient Arguments!");
				} else {
					if ((args[0].equalsIgnoreCase("day")) || args[0].equalsIgnoreCase("morning")) {
						if (args[1] == null) {
							player.getWorld().setTime(0);
							player.sendMessage(ChatColor.AQUA + "Time set to 0.");
						}
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have access to that command!");
				player.sendMessage(ChatColor.RED + "If you believe this is incorrect, contact an operator.");
			}
		} else {
			System.out
					.println("A non-player tried to execute a player only command!");
			System.out.println("The command was /vanish");
		}
		return false;
	}

}
