package me.marthi.vitalz;

import java.util.List;

//import me.marthi.vitalz.commands.Commandbroadcast;
//import me.marthi.vitalz.commands.Commandclearinventory;
import me.marthi.vitalz.commands.Commandfly;
import me.marthi.vitalz.commands.Commandhelp;
import me.marthi.vitalz.commands.Commandpl;
import me.marthi.vitalz.commands.Commandtime;
import me.marthi.vitalz.commands.Commandvanish;
import me.marthi.vitalz.commands.Commandvitalz;
import me.marthi.vitalz.commands.Commandtop;
import me.marthi.vitalz.commands.Commandping;
import me.marthi.vitalz.commands.Commandgamemode;
//import me.marthi.vitalz.commands.Commandtp;

import me.marthi.vitalz.listeners.PlayerJoinListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class vitalz extends JavaPlugin {

	public List<String> MOTD;

	@Override
	public void onEnable() {
		final PluginManager pm = this.getServer().getPluginManager();

		System.out.println("[Vitalz] Version ["
				+ this.getDescription().getVersion() + "] is enabled.");

		getCommand("pl").setExecutor(new Commandpl(this));
		getCommand("help").setExecutor(new Commandhelp(this));
		getCommand("vitalz").setExecutor(new Commandvitalz(this));
		getCommand("vanish").setExecutor(new Commandvanish(this));
		getCommand("fly").setExecutor(new Commandfly(this));
		getCommand("time").setExecutor(new Commandtime(this));
		getCommand("top").setExecutor(new Commandtop(this));
		getCommand("ping").setExecutor(new Commandping(this));
		getCommand("gamemode").setExecutor(new Commandgamemode(this));
		//getCommand("tp").setExecutor(new Commandtp(this));
		//getCommand("broadcast").setExecutor(new Commandbroadcast(this));
		//getCommand("clearinventory").setExecutor(new Commandclearinventory(this));

		System.out.println("[Vitalz] Commands registered!");

		pm.registerEvents(new PlayerJoinListener(this), this);

		this.saveDefaultConfig();
		if (!this.getConfig().getStringList("motd").isEmpty()) {
			MOTD = this.getConfig().getStringList("motd");
		}

		super.onEnable();
	}

	@Override
	public void onDisable() {
		System.out.println("[Vitalz] Version ["
				+ this.getDescription().getVersion() + "] is disabled.");
		super.onDisable();
	}
}