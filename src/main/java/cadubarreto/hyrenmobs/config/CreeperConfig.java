package cadubarreto.hyrenmobs.config;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class CreeperConfig {

    private static ConfigReader config;
    public CreeperConfig(JavaPlugin plugin){
        config = new ConfigReader(plugin, "mobs" + File.separator  , "creeper.yml");
        config.getConfig().options().copyDefaults(true);

    }


    public static ConfigReader getConfig() {
        return config;
    }

    public static String getCreeperPrefix(String path){
        return config.getConfig().getString(path + ".prefix").replace("&","§");
    }

    public static int getCreeperLife(String path){
        return config.getConfig().getInt(path + ".vida");
    }

    public static int getCreeperHenchmanAmount(String path){
        return config.getConfig().getInt(path + ".capangas-quantidade");
    }


    public static int getCreeperTimeCombat(String path){
        return config.getConfig().getInt(path + ".tempo-de-combate");

    }

    public static double getCreeperItemChance(String path){
        return config.getConfig().getDouble(path + ".capangas-quantidade");

    }

    public static double getCreeperChance(String path){
        return config.getConfig().getDouble(path + ".chance-de-spawn");
    }

    public static double getCreeperValue(){
        return  config.getConfig().getDouble( "Shop.valor-de-compra");
    }

    public static double getCreeperDamage(String path){
        return config.getConfig().getDouble(path + ".dano-de-ataque");
    }

    public static boolean isHenchman(String path){
        return config.getConfig().getBoolean(path + ".capangas");
    }

    public static boolean isEffect(String path){
        return config.getConfig().getBoolean(path + ".efeitos");
    }

}
