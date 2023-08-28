package cadubarreto.hyrenmobs.shop;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import org.bukkit.Material;
import org.bukkit.PortalType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShopItems {

    public static double getPotionPrice(){
        return HyrenMobs.getPlugin().getConfig().getDouble("Shop.Kit_Pocao.Preco");
    }

    public static double getBowPrice(){
        return HyrenMobs.getPlugin().getConfig().getDouble("Shop.Kit_Arco.Preco");
    }

    public static void givePlayerPotions(Player player){

        ItemStack pot1 = createPot(PotionType.FIRE_RESISTANCE);
        ItemStack pot2 = createPot(PotionType.SPEED);
        ItemStack pot3 = createPot(PotionType.STRENGTH);
        ItemStack pot4 = createPot(PotionType.REGEN);

        player.getInventory().addItem(pot1);
        player.getInventory().addItem(pot2);
        player.getInventory().addItem(pot3);
        player.getInventory().addItem(pot4);

    }

    public static void givePlayerBow(Player player){
        ItemStack bow = new ItemStack(Material.BOW ,1);
        ItemMeta meta = bow.getItemMeta();
        ItemStack arrow  = new ItemStack(Material.ARROW , 64);

        switch (EnchantmentLevel.getLevel(player)){
            case 0:{
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            case 1:{
                meta.addEnchant(Enchantment.DURABILITY , 1 , true);
                meta.addEnchant(Enchantment.ARROW_DAMAGE  , 1 , true);
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            case 2:{
                meta.addEnchant(Enchantment.DURABILITY , 1 , true);
                meta.addEnchant(Enchantment.ARROW_DAMAGE  , 2 , true);
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            case 3:{
                meta.addEnchant(Enchantment.DURABILITY , 2 , true);
                meta.addEnchant(Enchantment.ARROW_DAMAGE  , 2 , true);
                meta.addEnchant(Enchantment.ARROW_FIRE , 1 , true);
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            case 4:{
                meta.addEnchant(Enchantment.ARROW_DAMAGE  , 3 , true);
                meta.addEnchant(Enchantment.ARROW_FIRE , 2 , true);
                meta.addEnchant(Enchantment.DURABILITY , 3 , true);
                meta.addEnchant(Enchantment.ARROW_KNOCKBACK  , 1 , true);
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            case 5:{
                meta.addEnchant(Enchantment.ARROW_DAMAGE  , 5 , true);
                meta.addEnchant(Enchantment.ARROW_FIRE , 2 , true);
                meta.addEnchant(Enchantment.DURABILITY , 4 , true);
                meta.addEnchant(Enchantment.ARROW_KNOCKBACK  , 2 , true);
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1 , true);
                bow.setItemMeta(meta);

                player.getInventory().addItem(bow);
                player.getInventory().addItem(arrow);

                break;
            }
            default:
                break;
        }


    }

    static ItemStack createPot(PotionType type){
        return new Potion(type , 1 , false , false).toItemStack(1);
    }
}
