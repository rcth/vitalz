package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;

public class Commandgamemode implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private vitalz plugin;
	
	public Commandgamemode(vitalz plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			if (args[1] == null) {
				//Set gamemode for yourself:
				if (player.hasPermission("vitalz.gamemode")) {
					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
						player.setGameMode(GameMode.CREATIVE);
					}
					
					if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
						player.setGameMode(GameMode.SURVIVAL);
					}
					
					if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
						player.setGameMode(GameMode.ADVENTURE);
					}
				}
			} else {
				//Set gamemode for others:
				Player target = plugin.getServer().getPlayer(args[1]);
				if (target != null) {
					if (player.hasPermission("vitalz.gamemode.others")) {
						if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
							target.setGameMode(GameMode.CREATIVE);
						}
						
						if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
							target.setGameMode(GameMode.SURVIVAL);
						}
						
						if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
							target.setGameMode(GameMode.ADVENTURE);
						}
					} else {
						player.sendMessage(ChatColor.RED + "You do not have access to that command!");
						player.sendMessage(ChatColor.RED + "If you believe this incorrect, contact an operator.");
					}
				} else {
					player.sendMessage(ChatColor.RED + "That player could not be found!");
				}
			}
		} else {
			System.out.println("A non-player tried to execute a player only command!");
			System.out.println("The command was /gamemode");
		}
		return false;
	}

}
