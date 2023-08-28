package cadubarreto.hyrenmobs.shop;

import cadubarreto.hyrenmobs.shop.layout.ShopLayout;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;

public class ShopListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        InventoryHolder holder = e.getInventory().getHolder();
        if (holder instanceof ShopLayout) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) return;
            ShopLayout menu = (ShopLayout) holder;
            menu.handleMenu(e);
        }

    }


}
