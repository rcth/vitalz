package me.marthi.vitalz;

import me.marthi.vitalz.commands.Commandfly;
import me.marthi.vitalz.commands.Commandhelp;
import me.marthi.vitalz.commands.Commandpl;
import me.marthi.vitalz.commands.Commandvanish;
import me.marthi.vitalz.commands.Commandvitalz;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class vitalz extends JavaPlugin {

	@Override
	public void onEnable() {
		@SuppressWarnings("unused")
		final PluginManager pm = this.getServer().getPluginManager();

		System.out.println(ChatColor.RED + "[Vitalz]" + ChatColor.GOLD
				+ "Version [" + this.getDescription().getVersion()
				+ "] is enabled.");

		getCommand("pl").setExecutor(new Commandpl(this));
		getCommand("help").setExecutor(new Commandhelp(this));
		getCommand("vitalz").setExecutor(new Commandvitalz(this));
		getCommand("vanish").setExecutor(new Commandvanish(this));
		getCommand("fly").setExecutor(new Commandfly(this));
		
		System.out.println(ChatColor.RED + "[Vitalz]" + ChatColor.GOLD + "Commands registered");

		super.onEnable();
	}

	@Override
	public void onDisable() {
		System.out.println(ChatColor.RED + "[Vitalz]" + ChatColor.GOLD
				+ "Version [" + this.getDescription().getVersion()
				+ "] is disabled.");
		super.onDisable();
	}

}
