package net.ttk1;

import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventListener implements Listener{
    private PetInfo plg;

    public EventListener(PetInfo plg) {
        this.plg = plg;
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Tameable){
            Tameable target = (Tameable) event.getRightClicked();

            Player player = event.getPlayer();
            String uuid = player.getUniqueId().toString();

            if(plg.getMode().contains(uuid)) {
                player.sendMessage("name: " + target.getName());
                player.sendMessage("custom name: " + target.getCustomName());
                if (target.isTamed() && target.getOwner() != null) {
                    player.sendMessage("tamer: " + target.getOwner().getName()+" ["+target.getOwner().getUniqueId()+"]");
                }
            }
        }
    }
}
