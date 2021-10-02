package com.mattmx.easygui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public abstract class GUI {

    public abstract void setPage(int page);
    public abstract void open(UUID id);
    public abstract void click(UUID clickerID, InventoryClickEvent e);
    public abstract void close(UUID closerID);
}
