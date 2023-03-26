package net.lucymc.archive;

import net.lucymc.archive.listener.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class LucyArchiveMain extends JavaPlugin {
    private static LucyArchiveMain instance;

    @Override
    public void onEnable() {
        /* SETUP
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        instance = this;

        /* EVENT
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        getServer().getPluginManager().registerEvents(new BlockListener(), instance);
        getServer().getPluginManager().registerEvents(new EntityListener(), instance);
        getServer().getPluginManager().registerEvents(new InventoryListener(), instance);
        getServer().getPluginManager().registerEvents(new JoinQuitListener(), instance);
    }

    public static LucyArchiveMain getInstance() {
        return instance;
    }

    private boolean isPluginEnabled(String name) {
        Plugin plugin = getServer().getPluginManager().getPlugin(name);
        return plugin != null && plugin.isEnabled();
    }
}
