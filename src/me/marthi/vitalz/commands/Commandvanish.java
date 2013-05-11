package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandvanish implements CommandExecutor {

	@SuppressWarnings("unused")
	private vitalz plugin;

	public Commandvanish(vitalz plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			if (args[0] == null) {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.hidePlayer(player);
				}
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					for (Player t : Bukkit.getServer().getOnlinePlayers()) {
						t.hidePlayer(target);
					}
				}
			}
		} else {
			System.out
					.println("A non-player tried to execute a player only command!");
			System.out.println("The command was /vanish");
		}
		return false;
	}

}
