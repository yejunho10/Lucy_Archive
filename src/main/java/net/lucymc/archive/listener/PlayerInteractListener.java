package net.lucymc.archive.listener;

import net.lucymc.archive.util.MessageUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction().name().contains("AIR")) return;
        if (event.getClickedBlock() != null && !List.of(Material.MINECART, Material.CHEST_MINECART, Material.TNT_MINECART, Material.HOPPER_MINECART, Material.FURNACE_MINECART, Material.COMMAND_BLOCK_MINECART).contains(event.getClickedBlock().getType())) return;

        Player player = event.getPlayer();
        if (player.isOp()) return;

        event.setCancelled(true);

        /* MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        MessageUtil.sendActionBar(player, "&c당신은 상호작용할 권한이 없습니다.");
    }
}
