package com.ruthlessdev.efix.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ruthlessdev.efix.manager.FilesCreator;

public class PlayerInteract implements Listener {
	FilesCreator cInstance = FilesCreator.getInstance();

	@EventHandler
	public void blockInteractEvent(PlayerInteractEvent e) {
		if (cInstance.getConfig().getBoolean("anti-glitch") == true) {
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if ((e.getItem() != null) && (e.getItem().getType() == Material.ENDER_PEARL))
					e.setCancelled(true);
			}

		}
	}
}
