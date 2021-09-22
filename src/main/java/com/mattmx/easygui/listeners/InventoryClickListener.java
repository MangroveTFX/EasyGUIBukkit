package com.mattmx.easygui.listeners;

import com.mattmx.easygui.GUI;
import com.mattmx.easygui.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private Main plugin;
    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        for (GUI gui : GUI.getGuis()) {
            if (gui.getTitle().equalsIgnoreCase(title)) {
                e.setCancelled(true);
                if (e.getCurrentItem() == null) {
                    return;
                }
                gui.onClick((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory(), e);
            }
        }
    }
}
