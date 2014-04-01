package me.tommycake50.sprintspeed;

import me.tommycake50.sprintspeed.Listeners.SprintListener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SprintSpeed extends JavaPlugin{
	
	FileConfiguration fc;
	
	public void onEnable(){
		saveDefaultConfig();
		reloadConfig();
		fc = getConfig();
		getServer().getPluginManager().registerEvents(new SprintListener((float)fc.getDouble("maxSpeed")), this);
	}
}
