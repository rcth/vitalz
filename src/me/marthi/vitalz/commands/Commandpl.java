package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandpl implements CommandExecutor {

	@SuppressWarnings("unused")
	private vitalz plugin;

	public Commandpl(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub
		return true;
	}
}
