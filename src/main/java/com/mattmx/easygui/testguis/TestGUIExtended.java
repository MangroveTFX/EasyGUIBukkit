package com.mattmx.easygui.testguis;

import com.mattmx.easygui.GUI;
import com.mattmx.easygui.Main;
import com.mattmx.easygui.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUIExtended extends GUI {

    private Main plugin;

    public TestGUIExtended(Main plugin) {
        this.init(Utils.chat(Main.PREFIX + "Another Menu"), 1 * 9, this);
        this.plugin = plugin;
    }

    public Inventory getGui() {
        Inventory toReturn = Bukkit.getServer().createInventory(null, INV_ROWS, INV_NAME);
        Utils.createItem(getInv(), "diamond_sword", 1, 5, "&7MattMX's &b&oEasyGUI", "&8&oVersion 1.0");
        Utils.createItem(getInv(), "barrier", 1, 9, "&cClose Menu");
        toReturn.setContents(getInv().getContents());
        return toReturn;
    }

    @Override
    public void onClick(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (Utils.isItemName(clicked, "&7MattMX's &b&oEasyGUI")) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.0f);
            p.sendMessage(Utils.chat(Main.PREFIX + "MattMX's EasyGUI"));
            return;
        }else if (Utils.isItemName(clicked, "&cClose Menu")) {
            p.playSound(p.getLocation(), Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, 1.0f, 1.0f);
            p.closeInventory();
            return;
        }
        p.openInventory(this.getGui());
    }
}
