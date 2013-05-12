package me.marthi.vitalz.commands;

import me.marthi.vitalz.vitalz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtime implements CommandExecutor {

	private vitalz plugin;

	public Commandtime(vitalz plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		Long time = player.getWorld().getTime();

		if (sender instanceof Player) {
			if (player.hasPermission("vitalz.time")) {
				if (args[0] == null) {
					player.sendMessage(ChatColor.AQUA + "Current time is: "
							+ time + ".");
					player.sendMessage(ChatColor.RED
							+ "Insufficient Arguments!");
				} else {
					if ((args[0].equalsIgnoreCase("day"))
							|| args[0].equalsIgnoreCase("morning")) {
						if (args[1] == null) {
							player.getWorld().setTime(0);
							player.sendMessage(ChatColor.AQUA
									+ "Time set to 0.");
						} else {
							World targetWorld = plugin.getServer().getWorld(
									args[1]);
							if (targetWorld != null) {
								targetWorld.setTime(0);
								player.sendMessage(ChatColor.AQUA
										+ "Time set to 0 in world "
										+ targetWorld.toString() + ".");
							} else {
								player.sendMessage(ChatColor.RED
										+ "The world: " + args[1].toString()
										+ " could not be found!");
							}
						}
					} else if (args[0].equalsIgnoreCase("night")) {
						if (args[1] == null) {
							player.getWorld().setTime(12000);
							player.sendMessage(ChatColor.AQUA
									+ "Time set to 12000.");
						}
					} else if (isInt(args[0])) {
						int timeArgument = Integer.parseInt(args[0]);
						if (timeArgument <= 24000 && timeArgument >= 0) {
							player.getWorld().setTime(timeArgument);
							player.sendMessage(ChatColor.AQUA + "Time set to "
									+ timeArgument + ".");
						}
					} else {
						player.sendMessage(ChatColor.RED
								+ "Wrong time indication!");
						player.sendMessage(ChatColor.AQUA
								+ "Correct Use: /time day | night | {time indicator}");
					}
				}
			} else {
				player.sendMessage(ChatColor.RED
						+ "You do not have access to that command!");
				player.sendMessage(ChatColor.RED
						+ "If you believe this is incorrect, contact an operator.");
			}
		} else {
			if (args[1] == null) {
				System.out.println("You did not specify a world!");
			} else {
				World targetWorld = plugin.getServer().getWorld(args[1]);
				if (targetWorld != null) {
					if ((args[0].equalsIgnoreCase("day"))
							|| (args[0].equalsIgnoreCase("morning"))) {
						targetWorld.setTime(0);
						System.out.println("Time set to 0 in world: "
								+ targetWorld.toString() + ".");
					} else if ((args[0].equalsIgnoreCase("night"))
							|| (args[0].equalsIgnoreCase("evening"))) {
						targetWorld.setTime(12000);
						System.out.println("Time set to 12000 in world: "
								+ targetWorld.toString() + ".");
					} else if (isInt(args[0])) {
						int timeArgument = Integer.parseInt(args[0]);
						if (timeArgument <= 24000 && timeArgument >= 0) {
							targetWorld.setTime(timeArgument);
							System.out.println("Time set to " + timeArgument
									+ ".");
						}
					}
				} else {
					System.out
							.println("World: " + args[1] + ", was not found!");
				}
			}
		}
		return false;
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
