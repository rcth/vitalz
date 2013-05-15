package me.marthi.vitalz.commands;

import java.util.List;

import me.marthi.vitalz.vitalz;
import me.marthi.vitalz.exceptions.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandclearinventory implements CommandExecutor {

	private vitalz plugin;

	public Commandclearinventory(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;

		if (sender instanceof Player) {
			if (player.hasPermission("vitalz.ci")) {
				if (args.length > 0 && player.hasPermission("vitalz.ci.others")) {
					List<Player> targets = plugin.getServer().matchPlayer(
							args[0]);
					if (!targets.isEmpty()) {
						for (Player t : targets) {
							t.getInventory().clear();
							player.sendMessage(ChatColor.AQUA
									+ "Inventory of: " + t.getDisplayName()
									+ " has been cleared!");
						}
					} else {
						try {
							throw new PlayerNotFoundException(player);
						} catch (PlayerNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return false;
	}

}
