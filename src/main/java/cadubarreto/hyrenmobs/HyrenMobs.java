package cadubarreto.hyrenmobs;

import cadubarreto.hyrenmobs.adapter.BungeeAdapter;
import cadubarreto.hyrenmobs.config.*;
import cadubarreto.hyrenmobs.game.listener.ChestListener;
import cadubarreto.hyrenmobs.game.listener.GameListener;
import cadubarreto.hyrenmobs.game.command.GameCommand;
import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.listener.LevelListener;
import cadubarreto.hyrenmobs.level.SwordLevel;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.shop.ShopListener;
import cadubarreto.hyrenmobs.utils.FileConfig;
import cadubarreto.hyrenmobs.utils.menu.MenuListener;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import it.unimi.dsi.fastutil.Hash;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;

public class HyrenMobs extends JavaPlugin {

    @Getter
    public static HyrenMobs plugin;
    public static HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    public static HashMap<Player,Integer> cooldown = new HashMap<>();

    String worldName = "world_boss";
    public World world;
    public WorldEditPlugin worldedit;

    public HashMap<String, Mob> mobs = new HashMap<>();

    public HashMap<String, SwordLevel> playerLevelSword = new HashMap<>();
    public HashMap<String, ArmorLevel> playerLevelArmor = new HashMap<>();
    public HashMap<String, EnchantmentLevel> playerLevelEnchantment = new HashMap<>();

    public FileConfig swordData = new FileConfig(this , "database/sword_data.yml");
    public FileConfig enchantmentData = new FileConfig(this , "database/enchantment_data.yml");
    public FileConfig armorData = new FileConfig(this , "database/armor_data.yml");


    @Getter
    private static ZombieConfig zombieConfig;
    @Getter
    private static PigManConfig pigManConfig;
    @Getter
    private static SkeletonConfig skeletonConfig;
    @Getter
    private static SpiderConfig spiderConfig;
    @Getter
    private static CreeperConfig creeperConfig;

    private Messenger messenger;

    @Override
    public void onEnable() {
        plugin = this;

        this.saveDefaultConfig();
        debug("§aAtivando o Hyren Mobs");
        getCommand("combate").setExecutor(new GameCommand());

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new LevelListener(), this);
        pm.registerEvents(new MenuListener() , this);
        pm.registerEvents(new ShopListener() , this);
        pm.registerEvents(new GameListener() , this);
        pm.registerEvents(new ChestListener(), this);

        loadSword();
        loadArmor();
        loadEnchantment();

        zombieConfig = new ZombieConfig(this);
        pigManConfig = new PigManConfig(this);
        skeletonConfig = new SkeletonConfig(this);
        spiderConfig = new SpiderConfig(this);
        creeperConfig = new CreeperConfig(this);

        this.worldedit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if (worldedit == null) {
            debug("§4Não foi possivel inicializar o plugin, Pois não contem o  WORLD EDIT");
        } else {
        }

        messenger = getServer().getMessenger();
        messenger.registerIncomingPluginChannel(this, "BungeeCord", new BungeeAdapter());
        messenger.registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        debug("§cDesativando o Hyren Mobs");

        ArmorLevel.listToPlayers().forEach(ArmorLevel::savePlayers);
        EnchantmentLevel.listToPlayers().forEach(EnchantmentLevel::savePlayers);
        SwordLevel.listToPlayers().forEach(SwordLevel::savePlayers);

        this.saveConfig();

        armorData.saveConfig();
        enchantmentData.saveConfig();
        swordData.saveConfig();

        ConfigReader.save(ZombieConfig.getConfig());
        ConfigReader.save(PigManConfig.getConfig());
        ConfigReader.save(SkeletonConfig.getConfig());
        ConfigReader.save(SpiderConfig.getConfig());
        ConfigReader.save(CreeperConfig.getConfig());
    }

    public static void debug (String msg){
        Bukkit.getServer().getConsoleSender().sendMessage("§8(§4Hyren Mobs§8) " + msg);
    }


    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {

            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p);
        }
    }


    private void loadSword(){
        swordData.getConfig().getConfigurationSection("Users").getKeys(false).forEach(a ->{
            int level = swordData.getInt("Users." + a + ".Level" );
            playerLevelSword.put(a , new SwordLevel(a , level));
        });
    }

    private void loadEnchantment(){
        enchantmentData.getConfig().getConfigurationSection("Users").getKeys(false).forEach(a ->{
            int level = enchantmentData.getInt("Users." + a + ".Level" );
            playerLevelEnchantment.put(a , new EnchantmentLevel(a , level));
        });
    }

    private void loadArmor(){
        armorData.getConfig().getConfigurationSection("Users").getKeys(false).forEach(a ->{
            int level = armorData.getInt("Users." + a + ".Level" );
            playerLevelArmor.put(a , new ArmorLevel(a , level));
        });
    }

}