package cadubarreto.hyrenmobs.game.scheduler;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.utils.SoundRadius;
import cadubarreto.hyrenmobs.utils.particle.ParticleEffect;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class AnimationScheduler{

    private BukkitTask scheduler;
    private BukkitTask armorStandTask;
    private int count;
    private Location location;
    private Location chestLocation;

    private ArmorStand armorStand;
    private Player player;



    public AnimationScheduler(Location loc,Player player){
        this.location = loc;this.player = player;
    }

    public void startScheduler() {
        count = 0;

        scheduler = new BukkitRunnable() {

            @Override
            public void run() {

                if (count == 0){
                    armorStandScheduler();
                }

                count = count <= 10 ? count + 1 : -1;
                if (count >= 10 || count == -1) {

                    scheduler.cancel();
                    armorStandTask.cancel();
                    armorStand.remove();
                    return;

                }

            }
        }.runTaskTimer(HyrenMobs.getPlugin(), 0, 20);
    }
    public void armorStandScheduler(){
        Location center = location.getBlock().getLocation().clone().add(0.5, 6, 0.5);

        armorStandTask = new BukkitRunnable() {
            float angle = 0f;
            double rotation = 5;
            double crotation;

            @Override
            public void run() {

                crotation += rotation / 100;
                if (crotation >= 360) {
                    crotation -= 360;
                }

                if (armorStand == null){

                    armorStand = center.getWorld().spawn(center.clone(),  ArmorStand.class);
                    armorStand.setVisible(true);
                    armorStand.setCustomName("§a§lRECOMPENSA");
                    armorStand.setCustomNameVisible(true);
                    armorStand.setSmall(true);
                    armorStand.setGravity(false);
                    armorStand.setVisible(false);
                    armorStand.setHelmet(new ItemStack(Material.CHEST));

                }

                Location lo2 = center.clone().subtract(0 , angle , 0);

                if (lo2.getBlock() != null ){
                    if (lo2.getBlock().getType() != Material.AIR){

                        World w = lo2.getWorld();
                        Location chestLoc = new Location(w, lo2.getX(), lo2.getY() + 1 , lo2.getZ());
                        scheduler.cancel();
                        armorStandTask.cancel();
                        armorStand.remove();
                        chestLoc.getBlock().setType(Material.ENDER_CHEST);
                        new RewardScheduler(chestLoc, player).execute();
                        SoundRadius.playSound(Sound.NOTE_STICKS , 3 , chestLoc);
                        return;

                    }
                }


                angle += 0.1;
                armorStand.setHeadPose(armorStand.getHeadPose().setY(crotation));
                ParticleEffect.LAVA.display(0,0,0,0, 3 ,center.clone().subtract(0 , angle , 0) , 15);

                armorStand.teleport(center.clone().subtract(0 , angle , 0));


            }
        }.runTaskTimer(HyrenMobs.getPlugin(), 0, 1);
    }


}
