package com.mattmx.easygui.testguis;

import com.mattmx.easygui.Main;
import com.mattmx.easygui.testguis.RegisterTestGuis;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    private Main plugin;
    public TestCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("easygui").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may execute this command!");
            return true;
        } else {
            Player p = (Player) sender;
            p.openInventory(RegisterTestGuis.TEST_GUI.getGui());
        }
        return false;
    }

}
