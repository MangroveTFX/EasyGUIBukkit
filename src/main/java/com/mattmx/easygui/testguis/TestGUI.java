package com.mattmx.easygui.testguis;

import com.mattmx.easygui.GUI;
import com.mattmx.easygui.ItemBuilder;
import com.mattmx.easygui.Main;
import com.mattmx.easygui.Utils;
import com.mattmx.easygui.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class TestGUI extends GUI {

    UUID ownerID;
    Inventory INV;

    public TestGUI(UUID id) {
        ownerID = id;
        init();
    }

    public void init() {
        INV = Bukkit.createInventory(null, 54, Utils.chat("&c&oKit Menu"));
        ItemBuilder chest = new ItemBuilder(Material.CHEST)
                .lore(new String[] {
                        Utils.chat("&cRight-click &fTo view kit"),
                        Utils.chat("&cLeft-click &fTo receive kit")
                });
        ItemBuilder echest = new ItemBuilder(Material.ENDER_CHEST)
                .lore(new String[] {
                        Utils.chat("&cRight-click &fTo view EChest"),
                        Utils.chat("&cLeft-click &fTo load EChest")
                });
        Player p = Bukkit.getPlayer(ownerID);
        for (int i = 0; i < 9; i++) {
            if (p.hasPermission("pk.kit." + (i + 1))) {
                INV.setItem(i + 18, chest
                        .name(Utils.chat("&cKit &f" + (i + 1)))
                        .amount(i + 1)
                        .make());
            } else {
                INV.setItem(i + 18, chest
                        .name(Utils.chat("&cKit &f" + (i + 1)))
                        .clearLores()
                        .lores(new String[] {
                                Utils.chat("&cLOCKED"),
                                Utils.chat("&fYou &cdon't &fhave perms for this kit.")
                        })
                        .amount(i + 1)
                        .make());
            }

            if (p.hasPermission("pk.ec." + (i + 1))) {
                INV.setItem(i + 27, echest
                        .name(Utils.chat("&cEChest &f" + (i + 1)))
                        .amount(i + 1)
                        .make());
            } else {
                INV.setItem(i + 18, echest
                        .name(Utils.chat("&cEChest &f" + (i + 1)))
                        .clearLores()
                        .lores(new String[] {
                                Utils.chat("&cLOCKED"),
                                Utils.chat("&fYou &cdon't &fhave perms for this echest.")
                        })
                        .amount(i + 1)
                        .make());
            }
        }
        ItemBuilder star = new ItemBuilder(Material.NETHER_STAR)
                .lore(Utils.chat("&6Kit creator menu"))
                .amount(1)
                .name(Utils.chat("&cKit creator"));
        INV.setItem(49, star.make());
        ItemBuilder earthSkull = new ItemBuilder(Material.PLAYER_HEAD)
                .skullOwner("Earth2Bets")
                .name(Utils.chat("&cPublic kits"));
        INV.setItem(53, earthSkull.make());
    }

    @Override
    public void setPage(int page) {

    }

    @Override
    public void open(UUID id) {
        Bukkit.getPlayer(id).openInventory(INV);
        Listeners.INVS.put(id, this);
    }

    @Override
    public void click(UUID clickerID, InventoryClickEvent e) {
        Player p = Bukkit.getPlayer(clickerID);
        if (e.getClick().isLeftClick()) {
            p.sendMessage("Left clicked");
        } else {
            p.sendMessage("Right clicked");
        }

        // Open kit creator menu
        if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
            close(clickerID);
        }
        e.setCancelled(true);
    }

    @Override
    public void close(UUID closerID) {
        Listeners.INVS.remove(closerID);
    }
}
