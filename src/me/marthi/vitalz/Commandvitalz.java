package me.marthi.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandvitalz implements CommandExecutor {
	
	private vitalz plugin;
	
	public Commandvitalz(vitalz plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player) {
			sender.sendMessage("[Vitalz] Version: " + plugin.getDescription().getVersion() );
			sender.sendMessage("Commands to be displayed here!");
		}
		return false;
	}

}
