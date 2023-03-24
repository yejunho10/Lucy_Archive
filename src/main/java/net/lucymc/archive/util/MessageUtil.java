package net.lucymc.archive.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class MessageUtil {

    public static void broadcastActionBar(String message) {
        getServer().getOnlinePlayers().forEach(onlinePlayer -> sendActionBar(onlinePlayer, message));
    }

    public static void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', message)));
    }
}
