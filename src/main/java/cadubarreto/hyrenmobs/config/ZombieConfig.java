package cadubarreto.hyrenmobs.config;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class ZombieConfig {

    private static ConfigReader config;
    public ZombieConfig(JavaPlugin plugin){
        config = new ConfigReader(plugin, "mobs" + File.separator  , "zombie.yml");
        config.getConfig().options().copyDefaults(true);

    }


    public static ConfigReader getConfig() {
        return config;
    }

    public static String getZombiePrefix(String path){
        return config.getConfig().getString(path + ".prefix").replace("&","§");
    }

    public static int getZombieLife(String path){
        return config.getConfig().getInt(path + ".vida");
    }

    public static int getZombieHenchmanAmount(String path){
        return config.getConfig().getInt(path + ".capangas-quantidade");
    }


    public static int getZombieTimeCombat(String path){
        return config.getConfig().getInt(path + ".tempo-de-combate");

    }

    public static double getZombieItemChance(String path){
        return config.getConfig().getDouble(path + ".capangas-quantidade");

    }

    public static double getZombieChance(String path){
        return config.getConfig().getDouble(path + ".chance-de-spawn");
    }

    public static double getZombieValue(){
        return  config.getConfig().getDouble( "Shop.valor-de-compra");
    }

    public static double getZombieDamage(String path){
        return config.getConfig().getDouble(path + ".dano-de-ataque");
    }

    public static boolean isHenchman(String path){
        return config.getConfig().getBoolean(path + ".capangas");
    }

    public static boolean isEffect(String path){
        return config.getConfig().getBoolean(path + ".efeitos");
    }

}
