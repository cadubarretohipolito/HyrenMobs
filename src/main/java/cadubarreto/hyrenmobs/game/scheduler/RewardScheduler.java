package cadubarreto.hyrenmobs.game.scheduler;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.game.Game;
import cadubarreto.hyrenmobs.utils.particle.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class RewardScheduler {

    private int count;
    private BukkitTask task;
    private ArmorStand title;
    private ArmorStand subTitle;
    private ArmorStand seconds;

    private Location loc;

    private int step = 0;
    private int time;

    private Player player;

    public RewardScheduler(Location location,Player player){
        this.loc = location;
        this.player = player;
    }


    public void execute(){
        Location l1 = loc.clone().add(0 , -0.5, 0);
        Location l2 = loc.clone().add(0 , -0.8, 0);
        Location l3 = loc.clone().add(0 , -1.1, 0);

        count = 0;
        time = 30;
        task = new BukkitRunnable() {
            @Override
            public void run() {

                count = count <= 30 ? count + 1 : -1;
                if (count >= 30 || count == -1) {

                    task.cancel();
                    title.remove();
                    subTitle.remove();
                    seconds.remove();

                    if (loc.getBlock().getType() == Material.ENDER_CHEST){
                        loc.getBlock().setType(Material.AIR);
                    }

                    Game.teleportPlayerToSpawn(player);

                    return;
                }

                if (title == null) {
                    title = l1.getWorld().spawn(l1,  ArmorStand.class);
                    title.setVisible(true);
                    title.setCustomName("§eRecolha os Itens do Baú");
                    title.setCustomNameVisible(true);
                    title.setSmall(true);
                    title.setGravity(false);
                    title.setVisible(false);

                }

                if (subTitle == null){
                    subTitle = l2.getWorld().spawn(l2,  ArmorStand.class);
                    subTitle.setVisible(true);
                    subTitle.setCustomName("§eAntes que chegue aos §f30 segundos!");
                    subTitle.setCustomNameVisible(true);
                    subTitle.setSmall(true);
                    subTitle.setGravity(false);
                    subTitle.setVisible(false);
                }

                if (seconds == null){
                    seconds = l3.getWorld().spawn(l3,  ArmorStand.class);
                    seconds.setVisible(true);
                    seconds.setCustomNameVisible(true);
                    seconds.setSmall(true);
                    seconds.setGravity(false);
                    seconds.setVisible(false);
                }

                seconds.setCustomName("§cRestam §7§l" + count + " §csegundos");

                /*int scaleX = 1;
                int scaleZ = 1;
                double density = 0.1;
                for (double i=0; i < 2 * Math.PI ; i +=density) {
                    double x = Math.cos(i) * scaleX;
                    double z = Math.sin(i) * scaleZ;

                    Location particle = loc.clone().add( x ,  -0.7  ,  z );
                    ParticleEffect.REDSTONE.display(0f, 0f ,0f , 0f , 10 , particle , 10);
                }*/

                for (double y = 0; y <= 1; y+=0.05) {
                    double x = Math.cos(step / 5.0) * 1;
                    double z = Math.sin(step / 5.0) * 1;
                    loc.add(x, y, z);
                    ParticleEffect.PORTAL.display(0f, 0f ,0f , 0f , 10 , loc , 10);
                    loc.subtract(x, y, z);
                    step++;
                }




            }
        }.runTaskTimer(HyrenMobs.getPlugin(), 0, 20);
    }

}
