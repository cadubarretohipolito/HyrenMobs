package cadubarreto.hyrenmobs.game;

import cadubarreto.bungee.HyrenBungeeAPI;
import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.arena.Arena;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.utils.ActionBar;
import cadubarreto.hyrenmobs.utils.StringUtils;
import cadubarreto.hyrenmobs.utils.Titles;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.awt.image.RasterOp;
import java.util.concurrent.TimeUnit;

@Data
public class Game {

    private Player player;
    private Mob mob;

    private static BukkitTask task;
    private static BukkitTask spawnTask;

    private int count;
    private int time;
    private static int counter;

    private Location spawnMob;


    public Game(Player player, Mob mob){
        this.player = player;
        this.mob = mob;
        this.time = mob.getTime();
        new Arena(player).createWorld();
        startGame();
        Location loc = player.getLocation().clone().add(-1.1 , 0 , 31);
        mob.generateEntity(loc);
        new GameManager(player, mob).add();
    }

    public void startGame(){
        count = 0;

        time = getTime();
        task = new BukkitRunnable(){
            @Override
            public void run() {
                for (Mob mob : HyrenMobs.getPlugin().mobs.values()) {

                    //STOP
                    time = time >= count ? time - 1 : +1;
                    if (time <= count || time == 0) {
                        task.cancel();
                        teleportPlayerToSpawn(player);
                        new GameManager(player, mob).remove();
                        return;
                    }
                    Monster boss = (Monster) getMob().getEntity();
                    int life = (int) boss.getHealth();
                    int maxlife = (int) boss.getMaxHealth();

                    //PRE-STOP
                    if (time < 11) {
                        ActionBar.sendAction(player, "§eBoss: §8[§6"
                                + StringUtils.getProgressBar(life, maxlife, 10, "■", ChatColor.YELLOW, ChatColor.DARK_GRAY)
                                +
                                "§8] |  §eTempo: §c" + secondsToTime(time));

                    }

                    //REPEATING
                    ActionBar.sendAction(player, "§eBoss: §c"
                    +
                            StringUtils.getProgressBar(life, maxlife, 10, "■", ChatColor.YELLOW, ChatColor.DARK_GRAY)
                            + " |  §eTempo: §f" + secondsToTime(time));
                }
            }
        }.runTaskTimer(HyrenMobs.getPlugin(), 0L , 20L);
    }

    private String secondsToTime(int seconds) {
        long mins = (int) TimeUnit.SECONDS.toMinutes(seconds) % 60;
        long secs = (int) TimeUnit.SECONDS.toSeconds(seconds) % 60;

        return String.format("%02d:%02d", mins, secs);
    }

    public static void teleportPlayerToSpawn(Player player){
        counter = 5;
        spawnTask = new BukkitRunnable(){
            @Override
            public void run() {

                if (counter > 0){
                    Titles titles = new Titles("§aTeleporte", "§fTeleportando para o spawn §b" + counter--);
                    titles.send(player);

                } else {
                    spawnTask.cancel();
                    player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                    new Arena(player).deleteWorldFolder();
                    new Arena(player).removePlayerWorld();
                }

            }
        }.runTaskTimer(HyrenMobs.getPlugin() , 0L , 20L);
    }

    public int getTime() {
        return mob.getTime();
    }

    public static void stop(){
        task.cancel();
    }
}
