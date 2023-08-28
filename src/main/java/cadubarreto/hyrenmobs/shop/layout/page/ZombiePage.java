package cadubarreto.hyrenmobs.shop.layout.page;

import cadubarreto.hyrenmobs.config.ZombieConfig;
import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.SwordLevel;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.mob.zombie.ZombieMob;
import cadubarreto.hyrenmobs.player.PlayerRandomBoss;
import cadubarreto.hyrenmobs.shop.ShopItems;
import cadubarreto.hyrenmobs.shop.layout.ShopLayout;
import cadubarreto.hyrenmobs.utils.SoundRadius;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ZombiePage extends ShopLayout {

    public ZombiePage(PlayerMenuUtility playerMenuUtility) {
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

                PlayerRandomBoss randomBoss = new PlayerRandomBoss(
                        player,
                        player.getLocation(),
                        new ZombieMob.Common(),
                        new ZombieMob.Rare(),
                        new ZombieMob.Legendary()
                );

                randomBoss.random();
                break;
            }
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return 54;
    }

    @Override
    public double price() {return ZombieConfig.getZombieValue();}

    @Override
    public double commonChance() {return new ZombieMob.Common().getChance();}

    @Override
    public double rareChance() {return new ZombieMob.Rare().getChance();}

    @Override
    public double legendaryChance() {return new ZombieMob.Legendary().getChance();}


}
