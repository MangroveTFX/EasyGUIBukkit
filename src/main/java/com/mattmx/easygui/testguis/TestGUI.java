package com.mattmx.easygui.testguis;

import com.mattmx.easygui.GUI;
import com.mattmx.easygui.Main;
import com.mattmx.easygui.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUI extends GUI {

    private Main plugin;

    public TestGUI(Main plugin) {
        this.init(Utils.chat(Main.PREFIX + "Example Menu"), 5 * 9, this);
        this.plugin = plugin;
    }

    public Inventory getGui() {
        Inventory toReturn = Bukkit.getServer().createInventory(null, INV_ROWS, INV_NAME);
        Utils.createItem(getInv(), "diamond_sword", 1, 5, "&7MattMX's &b&oEasyGUI", "&8&oVersion 1.0");
        Utils.createItem(getInv(), "compass", 1, 23, "&7Website", "&8&oClick for link");
        Utils.createItem(getInv(), "arrow", 1, 36, "&7&oNext Page");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 37, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 38, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 39, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 40, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 41, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 42, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 43, " ");
        Utils.createItem(getInv(), "gray_stained_glass_pane", 1, 44, " ");
        Utils.createItem(getInv(), "barrier", 1, 45, "&cClose Menu");
        toReturn.setContents(getInv().getContents());
        return toReturn;
    }

    @Override
    public void onClick(Player p, int slot, ItemStack clicked, Inventory inv, Main plugin) {
        if (Utils.isItemName(clicked, "&7MattMX's &b&oEasyGUI")) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.0f);
            p.sendMessage(Utils.chat(Main.PREFIX + "MattMX's EasyGUI"));
            return;
        }else if (Utils.isItemName(clicked, "&7Website")) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.0f);
            p.sendMessage(Utils.chat(Main.PREFIX + "&nhttps://www.mattmx.com/"));
            return;
        }else if (Utils.isItemName(clicked, "&cClose Menu")) {
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, 1.0f, 1.0f);
            p.closeInventory();
            return;
        }else if (Utils.isItemName(clicked, "&7&oNext Page")) {
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, 1.0f, 1.0f);
            p.openInventory(RegisterTestGuis.ANOTHER_TEST_GUI.getGui());
            return;
        }
        p.openInventory(this.getGui());
    }
}
