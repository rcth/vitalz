package me.marthi.vitalz.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.marthi.vitalz.vitalz;

public class Commandtp implements CommandExecutor {
	
	private vitalz plugin;
	
	public Commandtp(vitalz plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player)sender;
		Player target = plugin.getServer().getPlayer(args[0]);
		return false;
	}
	

}
