package cadubarreto.hyrenmobs.config;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class PigManConfig {

    private static ConfigReader config;
    public PigManConfig(JavaPlugin plugin){
        config = new ConfigReader(plugin, "mobs" + File.separator  , "pigman.yml");
        config.getConfig().options().copyDefaults(true);

    }


    public static ConfigReader getConfig() {
        return config;
    }

    public static String getPigManPrefix(String path){
        return config.getConfig().getString(path + ".prefix").replace("&","§");
    }

    public static int getPigManLife(String path){
        return config.getConfig().getInt(path + ".vida");
    }

    public static int getPigManHenchmanAmount(String path){
        return config.getConfig().getInt(path + ".capangas-quantidade");
    }


    public static int getPigManTimeCombat(String path){
        return config.getConfig().getInt(path + ".tempo-de-combate");

    }

    public static double getPigManItemChance(String path){
        return config.getConfig().getDouble(path + ".capangas-quantidade");

    }

    public static double getPigManChance(String path){
        return config.getConfig().getDouble(path + ".chance-de-spawn");
    }

    public static double getPigManValue(){
        return  config.getConfig().getDouble( "Shop.valor-de-compra");
    }

    public static double getPigManDamage(String path){
        return config.getConfig().getDouble(path + ".dano-de-ataque");
    }

    public static boolean isHenchman(String path){
        return config.getConfig().getBoolean(path + ".capangas");
    }

    public static boolean isEffect(String path){
        return config.getConfig().getBoolean(path + ".efeitos");
    }

}
