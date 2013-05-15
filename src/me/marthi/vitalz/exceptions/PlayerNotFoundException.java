package me.marthi.vitalz.exceptions;

import org.bukkit.entity.Player;

public class PlayerNotFoundException extends Exception {
	
	public PlayerNotFoundException(Player player) {
		player.sendMessage("The given player is either not online or doesn't exist!");
	}

}
