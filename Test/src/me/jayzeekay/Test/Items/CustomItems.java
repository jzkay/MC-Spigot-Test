package me.jayzeekay.Test.Items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
	
	public ItemStack giveStardustPickaxe() {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "Stardust Pickaxe");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "Pick go brr");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.DIG_SPEED, 100, true);
		item.setItemMeta(meta);
		
		return item;
	}
}
