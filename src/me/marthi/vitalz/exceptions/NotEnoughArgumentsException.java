package me.marthi.vitalz.exceptions;

import org.bukkit.entity.Player;

public class NotEnoughArgumentsException extends Exception {

	public NotEnoughArgumentsException(Player player) {
		player.sendMessage("Not Enough Arguments Given!");
	}

}
