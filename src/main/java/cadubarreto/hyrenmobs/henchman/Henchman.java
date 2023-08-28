package cadubarreto.hyrenmobs.henchman;

import cadubarreto.hyrenmobs.HyrenMobs;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

@Getter
public class Henchman {
    private BukkitTask hanchmanTask;
    private int count;
    private int timer;

    private final int SPAWN_DELAY = 10;
    private int currentIndex = 0;
    private final List<EntityType> mobTypes;
    private final List<String> mobNames;
    private final Location location;
    public Henchman(Location location, int timer, List<EntityType> mobTypes, List<String> mobNames){
        this.location = location;
        this.timer = timer;
        this.mobTypes = mobTypes;
        this.mobNames = mobNames;
    }

    public void attack(){
        count = 0;
        hanchmanTask = new BukkitRunnable(){
            @Override
            public void run() {

                timer = timer >= count ? timer - 1 : +1;
                if (timer <= count || timer == 0 ){
                    hanchmanTask.cancel();
                    stop();
                    return;
                }

                EntityType mobType = mobTypes.get(currentIndex % mobTypes.size());
                String mobName = mobNames.get(currentIndex % mobNames.size());

                // Gerar um mob aqui
                LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, mobType);
                entity.setCustomName(mobName);
                entity.setCustomNameVisible(true);
                Bukkit.broadcastMessage("§aSpawnando §f-> " + mobName);
                currentIndex++;


            }
        }.runTaskTimer(HyrenMobs.getPlugin() , 0L ,40L);
    }

    public void stop(){
        hanchmanTask.cancel();
    }
}
