package com.ruthlessdev.efix.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.ruthlessdev.efix.Main;
import com.ruthlessdev.efix.manager.FilesCreator;

public class PlayerTeleport implements Listener {
	FilesCreator cInstance = FilesCreator.getInstance();

	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		if (cInstance.getConfig().getBoolean("anti-glitch") == true) {
			if ((e.isCancelled()) || (e.getCause() != PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
				return;
			}
			if (e.getTo().getBlock().getType() == Material.FENCE_GATE
					|| e.getTo().getBlock().getType() == Material.ACACIA_FENCE_GATE
					|| e.getTo().getBlock().getType() == Material.BIRCH_FENCE_GATE
					|| e.getTo().getBlock().getType() == Material.DARK_OAK_FENCE_GATE
					|| e.getTo().getBlock().getType() == Material.JUNGLE_FENCE_GATE
					|| e.getTo().getBlock().getType() == Material.SPRUCE_FENCE_GATE) {
				e.setCancelled(true);
				p.sendMessage(Main.toColor("&9eFix &8» &cYou may not Teleport Directly into a Fence Gate!"));
			}

			Location target = e.getTo();
			target.setX(target.getBlockX() + 0.5D);
			target.setZ(target.getBlockZ() + 0.5D);
			e.setTo(target);

		}
	}
}
