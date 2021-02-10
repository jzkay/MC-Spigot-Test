package me.jayzeekay.Test.Events;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

import me.jayzeekay.Test.Items.CustomItems;

public class EventsClass implements Listener {
	
	Player player = null;
	
	CustomItems customItem = new CustomItems();
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		//System.out.println(1);
		player = event.getPlayer();
//		Inventory pInv = player.getInventory();
//		ItemStack item = new ItemStack(Material.GOLDEN_CARROT, 1);
		
		player.setWalkSpeed((float) 0.5);
//		if (player.isSprinting()) {
//			//player.sendMessage(ChatColor.LIGHT_PURPLE + "You are sprinting!");
//			player.setWalkSpeed((float) 0.6);
//		} else {
//			player.setWalkSpeed((float) 0.4);
//		}
		//pInv.addItem(item);
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Location loc = block.getLocation();
//		
//		//player.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
//		player.getWorld().createExplosion(loc, 1F, false, false);
		
		if (!(player == null)) {
		if (player.getInventory().getItemInMainHand().equals(customItem.giveStardustPickaxe())) {
			
		int px = 3;
		int py = 3;
		int pz = 3;
		
		double lx = loc.getX();
		double ly = loc.getY();
		double lz = loc.getZ();
		
		//ArrayList<Block> blockList = new ArrayList<>();
		
		for (int x = -px; x <= px; x++) {
			for (int y = -py; y <= py; y++) {
				for (int z = -pz; z <= pz; z++) {
					Block checkBlock = player.getWorld().getBlockAt((int)lx+x, (int)ly+y, (int)lz+z);
					if (checkBlock.getType().equals(block.getType())) {
						checkBlock.breakNaturally();
					}
					//player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
				}
			}
		}
		
//		for (Block b : blockList) {
//			if (b.getType().equals(block.getType())) {
//				b.breakNaturally();
//			}
//		}
		
		}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
//		Entity entity = event.getEntity();
//		if (event.getCause() == DamageCause.ENTITY_ATTACK) {
//			Location loc = entity.getLocation();
//			PotionEffect effect = new PotionEffect(PotionEffectType.HEAL, 1, -1);
//			player.addPotionEffect(effect);
//		}
	}
	
	@EventHandler
	public void onTarget(EntityTargetEvent event) {
//		if (event.getTarget() == null) {
//			List<Player> players = loc.getWorld().getPlayers();
//			for (int i = 0; i < players.size(); i++) {
//				if (players.get(i).getWalkSpeed() == 0.05) {
//					players.get(i).setWalkSpeed((float) 0.2);
//				}
//			}
//			return;
//		}
//		if (event.getTarget().getType() == EntityType.PLAYER && event.getReason() == EntityTargetEvent.TargetReason.CLOSEST_PLAYER) {
//			Location loc = event.getTarget().getLocation();
//			List<Player> players = loc.getWorld().getPlayers();
//			for (int i = 0; i < players.size(); i++) {
//				if (players.get(i).getLocation().equals(loc)) {
//					players.get(i).setWalkSpeed((float) 0.05);
//				}
//			}
//		}
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
//		if (event.isSneaking()) {
//			Location loc = event.getPlayer().getLocation();
//			loc.add(10, 0, 0);
//			event.getPlayer().teleport(loc);
//		}
		Player player = event.getPlayer();
		Inventory inv = player.getInventory();
		ItemStack item = customItem.giveStardustPickaxe();
		//inv.addItem(item);
		
		if (!inv.contains(item)) {
			inv.addItem(item);
		}
	}
	
	@EventHandler
	public void onInteractBlock(PlayerInteractEvent event) {
//		Action action = event.getAction();
//		Player player = event.getPlayer();
//		Block block = event.getClickedBlock();
//		Location loc = block.getLocation();
//		//Location loc = player.getTargetBlock(null, 10).getLocation();
//		PlayerInventory inv = player.getInventory();
//		
//		if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
////			if (block.getType().equals(Material.OAK_BUTTON)) {
////				player.getWorld().spawnEntity(loc, EntityType.COW);
////			} else if (block.getType().equals(Material.JUNGLE_BUTTON)) {
////				Collection<Entity> entities = player.getWorld().getNearbyEntities(loc, 10, 10, 10);
////				for (Entity e : entities) {
////					if (!e.getType().equals(EntityType.PLAYER)) {
////						e.teleport(loc);
////					}
////				}
////			}
//			if (event.getMaterial().equals(Material.STICK)) {
//				Collection<Entity> entities = player.getWorld().getNearbyEntities(loc, 10, 10, 10);
//				for (Entity e : entities) {
//					if (!e.getType().equals(EntityType.PLAYER)) {
//						e.teleport(loc);
//					}
//				}
//			}
//		}
//	
		
//		if (action.equals(Action.PHYSICAL)) {
//			if (inv.getItemInMainHand().getType().equals(Material.STICK)) {
//				Collection<Entity> entities = player.getWorld().getNearbyEntities(loc, 10, 10, 10);
//				for (Entity e : entities) {
//					if (!e.getType().equals(EntityType.PLAYER)) {
//						e.teleport(loc);
//					}
//				}
//			}
//		}
	}
		
	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();
		Vector vec = new Vector(0.5, 0.5, 0.5);
		Vector pushVec = entity.getVelocity().add(vec);
		
		entity.setVelocity(pushVec);
	}
}
