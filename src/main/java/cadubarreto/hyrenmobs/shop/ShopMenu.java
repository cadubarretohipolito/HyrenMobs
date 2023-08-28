package cadubarreto.hyrenmobs.shop;

import cadubarreto.hyrenmobs.shop.layout.page.*;
import cadubarreto.hyrenmobs.utils.menu.Menu;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ShopMenu extends Menu {
    public ShopMenu(PlayerMenuUtility playerMenuUtility){
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Bosses";
    }

    @Override
    public int getSlots() {
        return 5*9;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        switch (e.getCurrentItem().getItemMeta().getDisplayName()){
            case "§6Creeper":{
                new CreeperPage(playerMenuUtility).learnLayout();
                break;
            }
            case "§6Zumbi":{
                new ZombiePage(playerMenuUtility).learnLayout();
                break;
            }
            case "§6Esqueleto":{
                new SkeletonPage(playerMenuUtility).learnLayout();
                break;
            }
            case "§6Aranha":{
                new SpiderPage(playerMenuUtility).learnLayout();
                break;
            }
            case "§6Zumbi Pigman":{
                new PigManPage(playerMenuUtility).learnLayout();
                break;
            }

        }

    }

    @Override
    public void setMenuItems() {
        ItemStack creeper = createEgg("§6Creeper", 50);
        ItemStack zombie = createEgg("§6Zumbi", 54);
        ItemStack skeleton = createEgg("§6Esqueleto", 51);
        ItemStack spider = createEgg("§6Aranha", 52);
        ItemStack zombiePigman = createEgg("§6Zumbi Pigman", 57);


        inventory.setItem(20,creeper);
        inventory.setItem(21,zombie);
        inventory.setItem(22,skeleton);
        inventory.setItem(23,spider);
        inventory.setItem(24,zombiePigman);
    }

}
