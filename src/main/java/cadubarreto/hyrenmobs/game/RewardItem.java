package cadubarreto.hyrenmobs.game;

import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import cadubarreto.hyrenmobs.utils.menu.RewardMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RewardItem extends RewardMenu {

    public RewardItem(PlayerMenuUtility playerMenuUtility){
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Visualize seus Prêmios:";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();


        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack item2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack item3 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack item4 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack item5 = new ItemStack(Material.GOLD_INGOT);
        ItemStack item6 = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack item7 = new ItemStack(Material.EMERALD_BLOCK);
        ItemStack item8 = new ItemStack(Material.PAPER);
        ItemStack item9 = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack item1 = new ItemStack(Material.DIAMOND_PICKAXE);

        inventory.addItem(item);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);
        inventory.addItem(item5);
        inventory.addItem(item6);
        inventory.addItem(item7);
        inventory.addItem(item8);
        inventory.addItem(item9);
        inventory.addItem(item1);

    }


}
