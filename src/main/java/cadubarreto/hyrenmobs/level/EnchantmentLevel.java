package cadubarreto.hyrenmobs.level;

import cadubarreto.hyrenmobs.HyrenMobs;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class EnchantmentLevel {

    @Getter
    @Setter
    private String name;
    @Getter @Setter
    private int level;

    public EnchantmentLevel(String name,int level){
        this.name = name;
        this.level = level;
    }

    public static void upgradeEnchantment(Player player){
        switch (getLevel(player)){
            case 0:{
                getEnchantmentLevel(player).setLevel(1);
                break;
            }

            case 1:{
                getEnchantmentLevel(player).setLevel(2);
                break;
            }

            case 2:{
                getEnchantmentLevel(player).setLevel(3);
                break;
            }

            case 3:{
                getEnchantmentLevel(player).setLevel(4);
                break;
            }

            case 4:{
                getEnchantmentLevel(player).setLevel(5);
                break;
            }

            default:
                break;
        }

    }

    public static boolean isMaxLevel(Player player){
        if (getLevel(player)>= 5){
            return true;
        }
        return false;
    }

    public static void resetLevel(Player player){
        getEnchantmentLevel(player).setLevel(0);
        HyrenMobs.getPlugin().armorData.saveConfig();
    }


    public static String printMaxLevel(Player player, String value){
        if (isMaxLevel(player)){
            return "§cUltimo Nível";
        }
        return value;
    }

    public static String enchantmentString(Player player){
        switch (getEnchantmentLevel(player).getLevel()) {
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
            case 4:{
                return "§6(■■■■)";
            }
            case 5:{
                return "§6(■■■■■)";
            }
        }
        return "§7(Nenhum)";
    }

    public static void setLevel(Player player, int level) {
        HyrenMobs.getPlugin().playerLevelEnchantment.get(player.getName()).setLevel(level);
    }

    public static int getLevel(Player player){
        return getEnchantmentLevel(player).getLevel();
    }


    public static EnchantmentLevel getEnchantmentLevel(Player player){
        EnchantmentLevel enchantmentLevel;
        String name = player.getName();
        if (!(HyrenMobs.getPlugin().playerLevelEnchantment.containsKey(name))){
            enchantmentLevel = new EnchantmentLevel(name , 0);
            HyrenMobs.getPlugin().playerLevelEnchantment.put(name ,enchantmentLevel);

            return enchantmentLevel;
        }
        return HyrenMobs.getPlugin().playerLevelEnchantment.get(name);
    }

    public static List<EnchantmentLevel> listToPlayers(){
        return HyrenMobs.getPlugin().playerLevelEnchantment.values().stream().collect(Collectors.toList());
    }
    public void savePlayers(){
        HyrenMobs.getPlugin().enchantmentData.set("Users." + getName() + ".Level"  , getLevel());
    }

}

