package cadubarreto.hyrenmobs.shop.layout.page;

import cadubarreto.hyrenmobs.config.CreeperConfig;
import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.SwordLevel;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.mob.creeper.CreeperMob;
import cadubarreto.hyrenmobs.mob.zombie.ZombieMob;
import cadubarreto.hyrenmobs.shop.ShopItems;
import cadubarreto.hyrenmobs.shop.layout.ShopLayout;
import cadubarreto.hyrenmobs.utils.SoundRadius;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CreeperPage extends ShopLayout {

    public CreeperPage(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMobName() {
        return "Zumbi";
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player player  = playerMenuUtility.getOwner();
        switch (e.getCurrentItem().getItemMeta().getDisplayName()){
            case "§bEvoluir Espada":{
                if (SwordLevel.isMaxLevel(player)) return;
                SwordLevel.upgradeSword(player);
                player.closeInventory();
                player.sendMessage("§aVocê evoluiu 1 ponto de §d§lEspada!");
                SoundRadius.playSound(Sound.NOTE_PLING , 1 , player.getLocation());
                break;
            }
            case "§bEvoluir Armadura":{
                if (ArmorLevel.isMaxLevel(player)) return;
                ArmorLevel.upgradeArmor(player);
                player.closeInventory();
                player.sendMessage("§aVocê evoluiu 1 ponto de §d§lArmadura!");
                SoundRadius.playSound(Sound.NOTE_PLING, 1, player.getLocation());
                break;
            }
            case "§bEvoluir Encantamentos":{
                if (EnchantmentLevel.isMaxLevel(player))  return;
                EnchantmentLevel.upgradeEnchantment(player);
                player.closeInventory();
                player.sendMessage("§aVocê evoluiu 1 ponto de §d§lEncantamentos!");
                SoundRadius.playSound(Sound.NOTE_PLING , 1 , player.getLocation());
                break;
            }

            case "§aComprar Poção":{
                ShopItems.givePlayerPotions(player);
                break;
            }
            case "§aComprar Arco e Flecha":{
                ShopItems.givePlayerBow(player);
                break;
            }

            case "§6Comprar Boss":{
                new ZombieMob.Common().toSpawn(player.getLocation());
                break;
            }
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return 50;
    }

    @Override
    public double price() {
        return CreeperConfig.getCreeperValue();
    }

    @Override
    public double commonChance() {
        return new CreeperMob.Common().getChance();
    }

    @Override
    public double rareChance() {
        return new CreeperMob.Rare().getChance();
    }

    @Override
    public double legendaryChance() {
        return new CreeperMob.Legendary().getChance();
    }

}
