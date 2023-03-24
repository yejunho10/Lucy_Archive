package net.lucymc.archive.listener;

import net.lucymc.archive.util.MessageUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class InventoryListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (player.isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onPickupItem(EntityPickupItemEvent event) {
        Entity entity = event.getEntity();
        if (entity.isOp()) return;

        event.setCancelled(true);

        /* MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        MessageUtil.sendActionBar((Player) entity, "&c당신은 아이템을 먹을 권한이 없습니다.");
    }

    @EventHandler
    public void onDropItem(EntityDropItemEvent event) {
        Entity entity = event.getEntity();
        if (entity.isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) return;

        event.setCancelled(true);

        /* MESSAGE
         ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
        MessageUtil.sendActionBar(player, "&c당신은 아이템을 버릴 권한이 없습니다.");
    }
}
