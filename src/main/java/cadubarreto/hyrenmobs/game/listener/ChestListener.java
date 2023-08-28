package cadubarreto.hyrenmobs.game.listener;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.game.RewardItem;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ChestListener implements Listener {
    @EventHandler
    public void onChestClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();
        if (block.getType() != Material.ENDER_CHEST) {
            return;
        }
        event.setCancelled(true);

        Player player = event.getPlayer();
        PlayerMenuUtility playerMenuUtility = HyrenMobs.getPlayerMenuUtility(player);
        new RewardItem(playerMenuUtility).open();

    }
}