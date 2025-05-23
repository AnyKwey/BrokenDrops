package com.brokendrops.ak.listeners;

import com.brokendrops.ak.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Sound sound = Main.getInstance().getConfig().getObject("sound", Sound.class);

        if (Main.getInstance().getConfig().getBoolean("enable")) {

            e.setDropItems(false);

            ItemStack item;
            switch (block.getType()) {
                /**
                 * Ore
                 */
                case DIAMOND_ORE:
                    item = new ItemStack(Material.DIAMOND, 1);
                    break;
                case EMERALD_ORE:
                    item = new ItemStack(Material.EMERALD, 1);
                    break;
                case IRON_ORE:
                    item = new ItemStack(Material.IRON_INGOT, 1);
                    break;
                case GOLD_ORE:
                    item = new ItemStack(Material.GOLD_INGOT, 1);
                    break;
                case COAL_ORE:
                    item = new ItemStack(Material.CHARCOAL, 1);
                    break;
                case LAPIS_ORE:
                    item = new ItemStack(Material.LAPIS_LAZULI, 1);
                    break;
                case COPPER_ORE:
                    item = new ItemStack(Material.COPPER_INGOT, 1);
                    break;
                case NETHERITE_BLOCK:
                    item = new ItemStack(Material.NETHERITE_INGOT, 1);
                    break;
                case NETHER_QUARTZ_ORE:
                    item = new ItemStack(Material.QUARTZ, 1);
                    break;

                /**
                 * Deepslate ore
                 */
                case DEEPSLATE_DIAMOND_ORE:
                    item = new ItemStack(Material.DIAMOND, 1);
                    break;
                case DEEPSLATE_EMERALD_ORE:
                    item = new ItemStack(Material.EMERALD, 1);
                    break;
                case DEEPSLATE_IRON_ORE:
                    item = new ItemStack(Material.IRON_INGOT, 1);
                    break;
                case DEEPSLATE_GOLD_ORE:
                    item = new ItemStack(Material.GOLD_INGOT, 1);
                    break;
                case DEEPSLATE_COAL_ORE:
                    item = new ItemStack(Material.CHARCOAL, 1);
                    break;
                case DEEPSLATE_LAPIS_ORE:
                    item = new ItemStack(Material.LAPIS_LAZULI, 1);
                    break;
                case DEEPSLATE_COPPER_ORE:
                    item = new ItemStack(Material.COPPER_INGOT, 1);
                    break;

                /**
                 * Plants
                 */
                case TALL_GRASS:
                    item = new ItemStack(Material.WHEAT_SEEDS, 1);
                    break;
                case RED_MUSHROOM_BLOCK:
                    item = new ItemStack(Material.RED_MUSHROOM, 1);
                    break;
                case BROWN_MUSHROOM_BLOCK:
                    item = new ItemStack(Material.BROWN_MUSHROOM, 1);
                    break;
                case WHEAT:
                    item = new ItemStack(Material.WHEAT, 1);
                    item = new ItemStack(Material.WHEAT_SEEDS, 2);
                    break;
                case OAK_SAPLING:
                    Material[] items = {
                            Material.APPLE,
                            Material.STICK,
                            Material.OAK_SAPLING
                    };

                    Random random = new Random();
                    Material chosenItem = items[random.nextInt(items.length)];

                    item = new ItemStack(chosenItem, 1);
                        break;


                /**
                 * Other
                 */
                default:
                    item = new ItemStack(block.getType(), 1);
                    break;
            }

            if (player.getInventory().firstEmpty() != -1) {
                player.getInventory().addItem(item);
            } else {
                e.setCancelled(true);
                player.sendMessage(Main.getMessage("full-message"));

                assert sound != null;
                player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
            }
        }
    }
}