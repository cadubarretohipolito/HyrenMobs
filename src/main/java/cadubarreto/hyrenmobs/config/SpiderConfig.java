package cadubarreto.hyrenmobs.config;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class SpiderConfig {

    private static ConfigReader config;
    public SpiderConfig(JavaPlugin plugin){
        config = new ConfigReader(plugin, "mobs" + File.separator  , "spider.yml");
        config.getConfig().options().copyDefaults(true);

    }


    public static ConfigReader getConfig() {
        return config;
    }

    public static String getSpiderPrefix(String path){
        return config.getConfig().getString(path + ".prefix").replace("&","§");
    }

    public static int getSpiderLife(String path){
        return config.getConfig().getInt(path + ".vida");
    }

    public static int getSpiderHenchmanAmount(String path){
        return config.getConfig().getInt(path + ".capangas-quantidade");
    }


    public static int getSpiderTimeCombat(String path){
        return config.getConfig().getInt(path + ".tempo-de-combate");

    }

    public static double getSpiderItemChance(String path){
        return config.getConfig().getDouble(path + ".capangas-quantidade");

    }

    public static double getSpiderChance(String path){
        return config.getConfig().getDouble(path + ".chance-de-spawn");
    }

    public static double getSpiderValue(){
        return  config.getConfig().getDouble( "Shop.valor-de-compra");
    }

    public static double getSpiderDamage(String path){
        return config.getConfig().getDouble(path + ".dano-de-ataque");
    }

    public static boolean isHenchman(String path){
        return config.getConfig().getBoolean(path + ".capangas");
    }

    public static boolean isEffect(String path){
        return config.getConfig().getBoolean(path + ".efeitos");
    }

}
