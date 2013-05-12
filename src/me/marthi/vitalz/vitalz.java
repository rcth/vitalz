package me.marthi.vitalz;

import me.marthi.vitalz.commands.Commandfly;
import me.marthi.vitalz.commands.Commandhelp;
import me.marthi.vitalz.commands.Commandpl;
import me.marthi.vitalz.commands.Commandtime;
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

<<<<<<< HEAD
		System.out.println("[Vitalz] Version [" + this.getDescription().getVersion() + "] is enabled.");
=======
		System.out.println("[Vitalz]" + "Version ["
				+ this.getDescription().getVersion() + "] is enabled.");
>>>>>>> 99264ce6d589f215b5ce4a62a4f4e3f6ca5fcbcf

		getCommand("pl").setExecutor(new Commandpl(this));
		getCommand("help").setExecutor(new Commandhelp(this));
		getCommand("vitalz").setExecutor(new Commandvitalz(this));
		getCommand("vanish").setExecutor(new Commandvanish(this));
		getCommand("fly").setExecutor(new Commandfly(this));
		getCommand("time").setExecutor(new Commandtime(this));
<<<<<<< HEAD
		
		System.out.println("[Vitalz] Commands registered!");
=======

		System.out.println("[Vitalz]" + "Commands registered");
>>>>>>> 99264ce6d589f215b5ce4a62a4f4e3f6ca5fcbcf

		super.onEnable();
	}

	@Override
	public void onDisable() {
<<<<<<< HEAD
		System.out.println("[Vitalz] Version [" + this.getDescription().getVersion() + "] is disabled.");
=======
		System.out.println("[Vitalz]" + "Version ["
				+ this.getDescription().getVersion() + "] is disabled.");
>>>>>>> 99264ce6d589f215b5ce4a62a4f4e3f6ca5fcbcf
		super.onDisable();
	}

}
