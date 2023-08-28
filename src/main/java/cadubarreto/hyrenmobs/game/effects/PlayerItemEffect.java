package cadubarreto.hyrenmobs.game.effects;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.utils.particle.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerItemEffect {
    public static void invokeThePower(Player player){
        Location location = player.getLocation();
        player.sendMessage("§aFuncionou");
        new BukkitRunnable(){
            double t = Math.PI/4;
            Location loc = player.getLocation();
            public void run(){
                t = t + 0.1*Math.PI;
                for (double y = 0; y <=2;y = y + 2){
                    float radius = 2;
                    double angle = 3 * 2  * Math.PI / 4 + (2 * Math.PI * y / 4) + 360;
                    double x = Math.cos(angle) *  2 * radius;
                    double z = Math.cos(angle) *  2 * radius;
                    loc.add(x,0,z);
                    ParticleEffect.FLAME.display(0,0,0,0,1,loc,10);
                    loc.subtract(x,0,z);
                }
                if (t > 20){
                    this.cancel();
                }
            }

        }.runTaskTimer(HyrenMobs.getPlugin(), 0, 1);

    }

}
