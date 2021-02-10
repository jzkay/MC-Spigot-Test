package me.jayzeekay.Test;

import org.bukkit.plugin.java.JavaPlugin;

import me.jayzeekay.Test.Events.EventsClass;
import net.md_5.bungee.api.ChatColor;

public class Test extends JavaPlugin {
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nTest has been enabled\n\n");
		getServer().getPluginManager().registerEvents(new EventsClass(), this);
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nTest has been disabled\n\n");
	}
	
}
