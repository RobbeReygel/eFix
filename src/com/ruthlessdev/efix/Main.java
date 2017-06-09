package com.ruthlessdev.efix;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.ruthlessdev.efix.commands.Efix;
import com.ruthlessdev.efix.listeners.PlayerInteract;
import com.ruthlessdev.efix.listeners.PlayerTeleport;
import com.ruthlessdev.efix.manager.FilesCreator;

public class Main extends JavaPlugin {
	File f;
	FileConfiguration fc;
	FilesCreator FilesCreatorInstance = FilesCreator.getInstance();

	public void onEnable() {
		FilesCreatorInstance.setup(this);
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been enabled (V. " + pdfFile.getVersion() + ") ");
		getCommand("efix").setExecutor(new Efix());
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerTeleport(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		final FileConfiguration config = this.getConfig();
		config.addDefault("anti-glitch", true);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void onDisable() {
		reloadConfig();
	}

	public static String toColor(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}