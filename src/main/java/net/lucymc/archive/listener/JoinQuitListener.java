package net.lucymc.archive.listener;

import net.lucymc.archive.LucyArchiveMain;
import net.lucymc.archive.util.MessageUtil;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.Bukkit.getServer;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        /* WELCOME MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        getServer().getScheduler().runTaskLater(LucyArchiveMain.getInstance(), () -> {
            player.sendMessage("§6안녕하세요! LucyNetwork Archive에 오신 것을 환영합니다.\n§7이 서버는 LucyNetwork의 아카이브 서버입니다. (비공식)");

            TextComponent yejunDiscord = new TextComponent("호예준#1234"); yejunDiscord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.com/users/1039809905537859615"));
            BaseComponent[] message = new ComponentBuilder()
                    .append("☺ 문의 : ").color(ChatColor.GRAY)
                    .append(yejunDiscord).color(ChatColor.YELLOW)
                    .create();
            player.spigot().sendMessage(message);

            player.sendMessage("§7⭐ 무료 플러그인 배포/외주 : §fhttps://starly.kr/discord");
        }, 3L);


        /* JOIN MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        event.setJoinMessage(null);
        MessageUtil.broadcastActionBar("&a› &6" + player.getName() + "&7님이 접속하셨습니다.");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        /* QUIT MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        event.setQuitMessage(null);
        MessageUtil.broadcastActionBar("&c‹ &6" + player.getName() + "&7님이 퇴장하셨습니다.");
    }
}