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
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		Player player = (Player) arg0;
		if (arg0 instanceof Player) {
			if (arg2 == null) {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.hidePlayer(player);
				}
			} else {
				Player target = Bukkit.getPlayer(arg2);
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
