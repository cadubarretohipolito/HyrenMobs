package cadubarreto.hyrenmobs.config;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class SkeletonConfig {

    private static ConfigReader config;
    public SkeletonConfig(JavaPlugin plugin){
        config = new ConfigReader(plugin, "mobs" + File.separator  , "skeleton.yml");
        config.getConfig().options().copyDefaults(true);

    }


    public static ConfigReader getConfig() {
        return config;
    }

    public static String getSkeletonPrefix(String path){
        return config.getConfig().getString(path + ".prefix").replace("&","§");
    }

    public static int getSkeletonLife(String path){
        return config.getConfig().getInt(path + ".vida");
    }

    public static int getSkeletonHenchmanAmount(String path){
        return config.getConfig().getInt(path + ".capangas-quantidade");
    }


    public static int getSkeletonTimeCombat(String path){
        return config.getConfig().getInt(path + ".tempo-de-combate");

    }

    public static double getSkeletonItemChance(String path){
        return config.getConfig().getDouble(path + ".capangas-quantidade");

    }

    public static double getSkeletonChance(String path){
        return config.getConfig().getDouble(path + ".chance-de-spawn");
    }

    public static double getSkeletonValue(){
        return  config.getConfig().getDouble( "Shop.valor-de-compra");
    }

    public static double getSkeletonDamage(String path){
        return config.getConfig().getDouble(path + ".dano-de-ataque");
    }

    public static boolean isHenchman(String path){
        return config.getConfig().getBoolean(path + ".capangas");
    }

    public static boolean isEffect(String path){
        return config.getConfig().getBoolean(path + ".efeitos");
    }

}
