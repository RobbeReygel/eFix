package com.ruthlessdev.efix.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ruthlessdev.efix.Main;
import com.ruthlessdev.efix.manager.FilesCreator;



public class Efix implements CommandExecutor {
	FilesCreator cInstance = FilesCreator.getInstance() ;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("efix.admin")) {
			if (!(sender instanceof Player)) {
				p.sendMessage("&cYou must be a player to use this command");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Main.toColor("&8&m------------------------------------------"));
				p.sendMessage(Main.toColor("&9» &e/eFix AntiGlitch &8(&aToggle AntiGlitch&8)"));
				p.sendMessage(Main.toColor("&9» &a-----Status-----"));
				if (cInstance.getConfig().getBoolean("anti-glitch") == true) {
					p.sendMessage(Main.toColor("&9» &eAntiGlitch: &a" + cInstance.getConfig().getString("anti-glitch")));
				}else{
					p.sendMessage(Main.toColor("&9» &eAntiGlitch: &c" + cInstance.getConfig().getString("anti-glitch")));
				}
				p.sendMessage(Main.toColor("&8&m------------------------------------------"));
			}
			if  (args.length == 1) {
				if (args[0].equalsIgnoreCase("antiglitch")) {
					if (cInstance.getConfig().getBoolean("anti-glitch") == true) {
						cInstance.getConfig().set("anti-glitch", false);
						p.sendMessage(Main.toColor("&9eFix &8» &eAntiGlitch &8(&cFalse&8)"));
					}else{
						cInstance.getConfig().set("anti-glitch", true);
						p.sendMessage(Main.toColor("&9eFix &8» &eAntiGlitch &8(&aTrue&8)"));
					}
				}
			}

		} else {
			p.sendMessage(Main.toColor("&9eFix &8» &cYou do not have Permission to use this command!"));
		}
		return false;
	}

}

