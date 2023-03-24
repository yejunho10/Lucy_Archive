package net.lucymc.archive.listener;

import net.lucymc.archive.util.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);

        if (event.getEntity() instanceof Player player) {
            /* MESSAGE
            ──────────────────────────────────────────────────────────────────────────────────────────────────────────────── */
            MessageUtil.sendActionBar(player, "&c대미지를 막았습니다.");
        }
    }
}
