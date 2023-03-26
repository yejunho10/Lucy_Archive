package net.lucymc.archive.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EntityListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (!(event.getDamager() instanceof Player damager)) return;
        if (damager.isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockDamage(EntityDamageByBlockEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getFoodLevel() != 20) return;

        event.setCancelled(true);
    }
}
