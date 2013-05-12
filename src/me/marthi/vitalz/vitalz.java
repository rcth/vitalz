package me.marthi.vitalz;

import java.util.List;

import me.marthi.vitalz.commands.Commandfly;
import me.marthi.vitalz.commands.Commandhelp;
import me.marthi.vitalz.commands.Commandpl;
import me.marthi.vitalz.commands.Commandtime;
import me.marthi.vitalz.commands.Commandvanish;
import me.marthi.vitalz.commands.Commandvitalz;
import me.marthi.vitalz.commands.Commandtop;
import me.marthi.vitalz.commands.Commandping;

import me.marthi.vitalz.listeners.LoginListener;

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
		getCommand("ping").setExcecutor(new Commandping(this));

		System.out.println("[Vitalz] Commands registered!");

		pm.registerEvents(new LoginListener(), this);

		this.saveDefaultConfig();
		MOTD = this.getConfig().getStringList("motd");

		super.onEnable();
	}

	@Override
	public void onDisable() {
		System.out.println("[Vitalz] Version ["
				+ this.getDescription().getVersion() + "] is disabled.");
		super.onDisable();
	}

}