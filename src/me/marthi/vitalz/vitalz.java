package me.marthi.vitalz;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class vitalz extends JavaPlugin {

	@Override
	public void onEnable() {
		final PluginManager pm = this.getServer().getPluginManager();
		
		
		System.out.println("[Vitalz] version [" + this.getDescription().getVersion() + "] is enabled.");
		
		
		super.onEnable();
	}

	@Override
	public void onDisable() {
		System.out.println("[Vitalz] version [" + this.getDescription().getVersion() + "] is disabled.");
		super.onDisable();
	}

}
