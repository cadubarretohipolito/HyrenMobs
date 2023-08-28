package cadubarreto.hyrenmobs.mob;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

@Getter @Setter
public class Mob {

    private String name;
    private String prefix;
    private double damage;
    private int life;
    private int time;
    private double value;
    private double chance;
    private LivingEntity entity;
    private Class aClass;
    private boolean effects;
    private boolean henchman;
    private int henchmanAmount;
    private double chanceItem;

    public void teleportMob(Location location){
        entity.teleport(location);
    }

    public void generateEntity(Location location){
        LivingEntity ent = (LivingEntity) location.getWorld().spawn(location, aClass);
        ent.setCustomName(getPrefix());
        ent.setCustomNameVisible(true);
        ent.setMaxHealth(getLife());
        ent.setHealth(getLife());
        ent.setFireTicks(0);
        this.entity = ent;
    }

    public int getMaxHealth(){
      return (int) entity.getMaxHealth();
    }

    public void remove(){
        entity.remove();
    }

    public int getTime() {
        return 60 * time;
    }
}
