package com.mattmx.easygui.testguis;

import com.mattmx.easygui.Main;

public class RegisterTestGuis {
    private static Main plugin;
    public RegisterTestGuis(Main plugin) {
        RegisterTestGuis.plugin = plugin;
    }
    public static TestGUI TEST_GUI = new TestGUI(plugin);
    public static TestGUIExtended ANOTHER_TEST_GUI = new TestGUIExtended(plugin);
}
