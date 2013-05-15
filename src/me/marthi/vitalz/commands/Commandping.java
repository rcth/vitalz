package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandping implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private vitalz plugin;
	
	public Commandping(vitalz plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("Pong. You like Ping-Pong too?");
		} else {
			System.out.println("Pong. You like Ping-Pong too?");
		}
		return true;
	}
}
