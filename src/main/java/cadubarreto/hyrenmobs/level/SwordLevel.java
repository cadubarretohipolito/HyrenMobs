package cadubarreto.hyrenmobs.level;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.utils.SoundRadius;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SwordLevel {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private int level;

    public SwordLevel(String name,int level){
        this.name = name;
        this.level = level;
    }

    public static void upgradeSword(Player player){
        switch (getLevel(player)){
            case 0:{
                getSwordLevel(player).setLevel(1);
                break;
            }

            case 1:{
                getSwordLevel(player).setLevel(2);
                break;
            }

            case 2:{
                getSwordLevel(player).setLevel(3);
                break;
            }

            default:
                break;
        }

    }

    public static boolean isMaxLevel(Player player){
        if (getLevel(player)>= 3){
            return true;
        }
        return false;
    }

    public static void resetLevel(Player player){
        getSwordLevel(player).setLevel(0);
        HyrenMobs.getPlugin().swordData.saveConfig();
    }

    public static ItemStack swordItemStack(Player player){
        switch (getSwordLevel(player).getLevel()) {
            case 0: {
                return new ItemStack(Material.WOOD_SWORD);
            }
            case 1: {
                return new ItemStack(Material.STONE_SWORD);
            }
            case 2: {
                return new ItemStack(Material.IRON_SWORD);
            }
            case 3: {
                ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta meta = item.getItemMeta();
                meta.addEnchant(Enchantment.DURABILITY , 1 ,true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);
                return item;
            }
            default:
                break;
        }
        return new ItemStack(Material.WOOD_SWORD);

    }

    public static String printMaxLevel(Player player, String value){
        if (isMaxLevel(player)){
            return "§cUltimo Nível";
        }
        return value;
    }
    public static String swordString(Player player){
        switch (getSwordLevel(player).getLevel()) {
            case 0:{
                return "§7(Inicial)";
            }
            case 1:{
                return "§6(■)";
            }
            case 2:{
                return "§6(■■)";
            }
            case 3:{
                return "§6(■■■)";
            }
        }
        return "§7(Nenhum)";
    }

    public static void setLevel(Player player, int level) {
        HyrenMobs.getPlugin().playerLevelSword.get(player.getName()).setLevel(level);
        HyrenMobs.getPlugin().saveConfig();
    }

    public static int getLevel(Player player){
        return getSwordLevel(player).getLevel();
    }

    public static SwordLevel getSwordLevel(Player player){
        SwordLevel swordLevel;
        String name = player.getName();
        if (!(HyrenMobs.getPlugin().playerLevelSword.containsKey(name))){
            swordLevel = new SwordLevel(name, 0);
            HyrenMobs.getPlugin().playerLevelSword.put(name , swordLevel);

            return swordLevel;
        }
        return HyrenMobs.getPlugin().playerLevelSword.get(name);
    }

    public static List<SwordLevel> listToPlayers(){
        return HyrenMobs.getPlugin().playerLevelSword.values().stream().collect(Collectors.toList());
    }
    public void savePlayers(){
        HyrenMobs.getPlugin().swordData.set("Users." + getName() + ".Level" , getLevel());
    }


}
