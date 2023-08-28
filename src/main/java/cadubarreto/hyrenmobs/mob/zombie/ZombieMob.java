package cadubarreto.hyrenmobs.mob.zombie;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.config.ZombieConfig;
import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.Location;
import org.bukkit.entity.Zombie;

public class ZombieMob {

    public static class Common extends Mob {
        public Common() {
            String path = "Comum";
            setAClass(Zombie.class);
            setName("id_hyren_common_zombie");

            setHenchman(ZombieConfig.isHenchman(path));
            setHenchmanAmount(ZombieConfig.getZombieHenchmanAmount(path));

            setChanceItem(ZombieConfig.getZombieItemChance(path));
            setChance(ZombieConfig.getZombieChance(path));

            setDamage(ZombieConfig.getZombieDamage(path));

            setEffects(ZombieConfig.isEffect(path));

            setLife(ZombieConfig.getZombieLife(path));

            setPrefix(ZombieConfig.getZombiePrefix(path));

            setValue(ZombieConfig.getZombieValue());
            setTime(ZombieConfig.getZombieTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(), this);
        }

        public void toSpawn(Location location) {
            generateEntity(location);
        }
    }

        public static class Rare extends Mob{
            public Rare(){
                String path = "Raro";
                setAClass(Zombie.class);
                setName("id_hyren_rare_zombie");

                setHenchman(ZombieConfig.isHenchman(path));
                setHenchmanAmount(ZombieConfig.getZombieHenchmanAmount(path));

                setChanceItem(ZombieConfig.getZombieItemChance(path));
                setChance(ZombieConfig.getZombieChance(path));

                setDamage(ZombieConfig.getZombieDamage(path));

                setEffects(ZombieConfig.isEffect(path));

                setLife(ZombieConfig.getZombieLife(path));

                setPrefix(ZombieConfig.getZombiePrefix(path));

                setValue(ZombieConfig.getZombieValue());
                setTime(ZombieConfig.getZombieTimeCombat(path));
                HyrenMobs.getPlugin().mobs.put(getName(),this);
            }

            public void toSpawn(Location location){
                generateEntity(location);
            }

    }


    public static class Legendary extends Mob{
        public Legendary(){
            String path = "Lendario";
            setAClass(Zombie.class);
            setName("id_hyren_legendary_zombie");

            setHenchman(ZombieConfig.isHenchman(path));
            setHenchmanAmount(ZombieConfig.getZombieHenchmanAmount(path));

            setChanceItem(ZombieConfig.getZombieItemChance(path));
            setChance(ZombieConfig.getZombieChance(path));

            setDamage(ZombieConfig.getZombieDamage(path));

            setEffects(ZombieConfig.isEffect(path));

            setLife(ZombieConfig.getZombieLife(path));

            setPrefix(ZombieConfig.getZombiePrefix(path));

            setValue(ZombieConfig.getZombieValue());
            setTime(ZombieConfig.getZombieTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(),this);
        }

        public void toSpawn(Location location){
            generateEntity(location);
        }

    }


}
