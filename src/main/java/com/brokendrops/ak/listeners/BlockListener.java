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

            ItemStack item = null;
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
                case STONE:
                    item = new ItemStack(Material.COBBLESTONE, 1);
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
                case OAK_LEAVES:
                    Material[] items = {
                            Material.APPLE,
                            Material.STICK,
                            Material.OAK_SAPLING
                    };

                    Random random = new Random();
                    Material chosenItem = items[random.nextInt(items.length)];

                    item = new ItemStack(chosenItem, 1);
                    break;
                case SPRUCE_LEAVES:
                    Material[] items1 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.SPRUCE_SAPLING
                    };

                    Random random1 = new Random();
                    Material chosenItem1 = items1[random1.nextInt(items1.length)];

                    item = new ItemStack(chosenItem1, 1);
                    break;
                case BIRCH_LEAVES:
                    Material[] items2 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.BIRCH_SAPLING
                    };

                    Random random2 = new Random();
                    Material chosenItem2 = items2[random2.nextInt(items2.length)];

                    item = new ItemStack(chosenItem2, 1);
                    break;
                case JUNGLE_LEAVES:
                    Material[] items3 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.JUNGLE_SAPLING
                    };

                    Random random3 = new Random();
                    Material chosenItem3 = items3[random3.nextInt(items3.length)];

                    item = new ItemStack(chosenItem3, 1);
                    break;
                case ACACIA_LEAVES:
                    Material[] items4 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.ACACIA_SAPLING
                    };

                    Random random4 = new Random();
                    Material chosenItem4 = items4[random4.nextInt(items4.length)];

                    item = new ItemStack(chosenItem4, 1);
                    break;
                case DARK_OAK_LEAVES:
                    Material[] items5 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.DARK_OAK_SAPLING
                    };

                    Random random5 = new Random();
                    Material chosenItem5 = items5[random5.nextInt(items5.length)];

                    item = new ItemStack(chosenItem5, 1);
                    break;
                case MANGROVE_LEAVES:
                    Material[] items6 = {
                            Material.APPLE,
                            Material.STICK,
                            Material.MANGROVE_LEAVES
                    };

                    Random random6 = new Random();
                    Material chosenItem6 = items6[random6.nextInt(items6.length)];

                    item = new ItemStack(chosenItem6, 1);
                    break;

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