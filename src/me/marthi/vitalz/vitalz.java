package me.marthi.vitalz;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class vitalz extends JavaPlugin {

	@Override
	public void onEnable() {
		final PluginManager pm = this.getServer().getPluginManager();

		System.out.println(ChatColor.RED + "[Vitalz]" + ChatColor.GOLD + "version ["
				+ this.getDescription().getVersion() + "] is enabled.");
		
		getCommand("pl").setExecutor(new Commandpl(this));
		getCommand("help").setExecutor(new Commandhelp(this));
		getCommand("vitalz").setExecutor(new Commandvitalz(this));
		
		

		super.onEnable();
	}

	@Override
	public void onDisable() {
		System.out.println(ChatColor.RED + "[Vitalz]" + ChatColor.GOLD + "version ["
				+ this.getDescription().getVersion() + "] is disabled.");
		super.onDisable();
	}

}
