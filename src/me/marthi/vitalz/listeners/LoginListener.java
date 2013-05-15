package me.marthi.vitalz.listeners;

import me.marthi.vitalz.vitalz;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

	private vitalz plugin;

	public LoginListener(vitalz plugin) {
		this.plugin = plugin;
	}

	public LoginListener() {

	}

	@EventHandler(priority = EventPriority.LOW)
	public void playerLoginListener(PlayerLoginEvent e) {
		Player player = e.getPlayer();
		if (!plugin.MOTD.isEmpty()) {
			for (String s : plugin.MOTD) {
				player.sendMessage(s);
			}
		}
	}
}
