package com.mattmx.easygui;

import com.mattmx.easygui.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.ArrayList;

public abstract class GUI {
    private static List<GUI> Guis = new ArrayList<GUI>();
    private Inventory INVENTORY;
    protected String INV_NAME;
    protected int INV_ROWS;

    public abstract void onClick(Player p, int slot, ItemStack clicked, Inventory inv);

    public static List<GUI> getGuis() {
        return Guis;
    }

    public String getTitle() {
        return this.INV_NAME;
    }

    public Inventory getInv() {
        return INVENTORY;
    }

    public int getRows() {
        return INV_ROWS;
    }

    public String getInvName() {
        return INV_NAME;
    }

    public void setRows(int i) {
        INV_ROWS = i;
    }

    public void setInvName(String str) {
        INV_NAME = str;
    }

    protected void init(String title, int rows, GUI gui) {
        registerGUI(gui);
        this.INV_NAME = Utils.chat(title);
        this.INV_ROWS = rows;
        this.INVENTORY = Bukkit.createInventory(null, INV_ROWS);
    }

    public static void initEasyGUI(Main plugin) {
        new InventoryClickListener(plugin);
    }

    public static void registerGUI(GUI gui) {
        Guis.add(gui);
    }
}
