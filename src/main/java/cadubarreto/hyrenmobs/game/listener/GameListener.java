package cadubarreto.hyrenmobs.game.listener;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.arena.Arena;
import cadubarreto.hyrenmobs.game.Game;
import cadubarreto.hyrenmobs.game.scheduler.AnimationScheduler;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.utils.Titles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.Random;

public class GameListener implements Listener {

    private int counter;
    private BukkitTask task;

    @EventHandler(priority = EventPriority.MONITOR)
    public void killBoss(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (event.getEntity() instanceof Monster) {
                for (Mob mob : HyrenMobs.getPlugin().mobs.values()) {
                    Player player = (Player) event.getDamager();
                    String csName = mob.getPrefix();
                    if (event.getEntity().getCustomName() != null) {
                        if (event.getEntity().getCustomName().equals(csName)) {
                            Monster boss = (Monster) event.getEntity();

                            if (event.getFinalDamage() >= boss.getHealth()) {
                                event.setCancelled(true);
                                event.getEntity().remove();
                                Game.stop();
                                Location location = new Location(player.getWorld() , 0 , 77 , 0);
                                player.teleport(location.clone().add(0,0,3));
                                Location animation = location.clone().add(0 , 0 , 12);

                                new AnimationScheduler(animation,player).startScheduler();
                                Titles titles = new Titles(
                                        "§a§lVITÓRIA",
                                        "§fVocê eliminou o boss " + mob.getPrefix() + " §fa tempo!");
                                titles.send(player);

                            }
                        }
                    }
                }

            }
        }
    }


    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName() == player.getName()){
            event.setCancelled(true);
        }
    }



}
