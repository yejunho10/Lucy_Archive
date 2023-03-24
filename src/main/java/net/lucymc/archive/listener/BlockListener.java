package net.lucymc.archive.listener;

import net.lucymc.archive.util.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) return;

        /* MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        event.setCancelled(true);
        MessageUtil.sendActionBar(player, "&c당신은 블럭을 설치할 권한이 없습니다.");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) return;

        event.setCancelled(true);

        /* MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        MessageUtil.sendActionBar(player, "&c당신은 블럭을 파괴할 권한이 없습니다.");
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        event.setCancelled(true);
    }
}
