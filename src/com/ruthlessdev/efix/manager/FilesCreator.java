package com.ruthlessdev.efix.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class FilesCreator {

	public FilesCreator() {

	};

	static FilesCreator instance = new FilesCreator();

	public static FilesCreator getInstance() {

		return instance;

	}

	Plugin p;
	FileConfiguration config;
	File cfile;

	public void setup(Plugin p) {

		if (!p.getDataFolder().exists()) {

			p.getDataFolder().mkdir();

		}

		cfile = new File(p.getDataFolder(), "config.yml");

		if (!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create config.yml!");
			}

		}

		config = p.getConfig();

	}

	public FileConfiguration getConfig() {
		return config;
	}

	public void saveConfig() {
		try {

			config.save(cfile);

		} catch (IOException e) {

			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");

		}
	}
}
