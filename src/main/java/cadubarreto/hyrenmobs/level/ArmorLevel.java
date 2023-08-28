package cadubarreto.hyrenmobs.level;

import cadubarreto.hyrenmobs.HyrenMobs;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class ArmorLevel {

    @Getter
    @Setter
    private String name;
    @Getter @Setter
    private int level;

    public ArmorLevel(String name,int level){
        this.name = name;
        this.level = level;
    }

    public static void upgradeArmor(Player player){
        switch (getLevel(player)){
            case 0:{
                getArmorLevel(player).setLevel(1);
                break;
            }

            case 1:{
                getArmorLevel(player).setLevel(2);
                break;
            }

            case 2:{
                getArmorLevel(player).setLevel(3);
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

    public static String printMaxLevel(Player player, String value){
        if (isMaxLevel(player)){
            return "§cUltimo Nível";
        }
        return value;
    }


    public static void resetLevel(Player player){
        getArmorLevel(player).setLevel(0);
        HyrenMobs.getPlugin().armorData.saveConfig();
    }

    public static ItemStack armorItemStack(Player player){
        switch (getArmorLevel(player).getLevel()) {
            case 0: {
                return new ItemStack(Material.LEATHER_CHESTPLATE);
            }
            case 1: {
                return new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            }
            case 2: {
                return new ItemStack(Material.IRON_CHESTPLATE);
            }
            case 3: {
                ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
                item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL ,1);
                ItemMeta meta = item.getItemMeta();
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);
                return item;
            }
        }
        return new ItemStack(Material.LEATHER_CHESTPLATE);

    }

    public static String armorString(Player player){
        switch (getArmorLevel(player).getLevel()) {
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
        HyrenMobs.getPlugin().playerLevelArmor.get(player.getName()).setLevel(level);
    }

    public static int getLevel(Player player){
        return getArmorLevel(player).getLevel();
    }

    public static ArmorLevel getArmorLevel(Player player){
        ArmorLevel armorLevel;
        String name = player.getName();
        if (!(HyrenMobs.getPlugin().playerLevelArmor.containsKey(name))){
            armorLevel = new ArmorLevel(name, 0);
            HyrenMobs.getPlugin().playerLevelArmor.put(name , armorLevel);

            return armorLevel;
        }
        return HyrenMobs.getPlugin().playerLevelArmor.get(name);
    }

    public static List<ArmorLevel> listToPlayers(){
        return HyrenMobs.getPlugin().playerLevelArmor.values().stream().collect(Collectors.toList());
    }
    public void savePlayers(){
        HyrenMobs.getPlugin().armorData.set("Users." + getName() + ".Level"  , getLevel());
    }

}
