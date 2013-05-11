package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandhelp implements CommandExecutor {
	private vitalz plugin;
	
	public Commandhelp(vitalz plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
