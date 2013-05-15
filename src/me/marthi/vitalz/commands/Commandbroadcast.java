package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandbroadcast implements CommandExecutor {

	@SuppressWarnings("unused")
	private vitalz plugin;

	public Commandbroadcast(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		// We don't have to make a player as it's unnecessary, because if sender
		// = console, he has all permissions.

		if (sender.hasPermission("vitalz.broadcast")) {
			String broadcastMessage = "";

			for (int i = 0; i < args.length; i++) {
				broadcastMessage = broadcastMessage + " " + args[i];
			}
			Bukkit.broadcastMessage(ChatColor.GOLD + "[Broadcast]"
					+ broadcastMessage);
			return true;
		}

		else {
			sender.sendMessage(ChatColor.RED
					+ "You do not have access to that command!");
			sender.sendMessage(ChatColor.RED
					+ "If you believe this is incorrect, contact an operator.");
		}
		return false;
	}
}
