package com.mattmx.easygui;

import com.mattmx.easygui.testguis.RegisterTestGuis;
import com.mattmx.easygui.testguis.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public final static String PREFIX = "&b&oEasyGUI &f&l> &7";

    @Override
    public void onEnable() {
        // Plugin startup logic
        GUI.initEasyGUI(this);
        new TestCommand(this);
        new RegisterTestGuis(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
