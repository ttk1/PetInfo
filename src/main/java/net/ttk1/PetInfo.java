package net.ttk1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class PetInfo extends JavaPlugin {
    private Set<String> mode;

    public Set<String> getMode(){
        return mode;
    }

    @Override
    public void onEnable() {
        mode = new HashSet<>();
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getLogger().info("PetInfo enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("PetInfo disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String uuid = player.getUniqueId().toString();
            if (player.hasPermission("petinfo.info")) {
                if(!mode.contains(uuid)) {
                    mode.add(uuid);
                    player.sendMessage("PetInfo enabled");
                } else {
                    mode.remove(uuid);
                    player.sendMessage("PetInfo disabled");
                }
            } else {
                player.sendMessage("You don't have permission.");
            }
        }

        return true;
    }
}
