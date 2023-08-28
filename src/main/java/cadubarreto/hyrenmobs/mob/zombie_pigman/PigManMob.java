package cadubarreto.hyrenmobs.mob.zombie_pigman;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.config.PigManConfig;
import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.Location;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Zombie;

public class PigManMob {

    public static class Common extends Mob {
        public Common() {
            String path = "Comum";
            setAClass(PigZombie.class);
            setName("id_hyren_common_pigman");

            setHenchman(PigManConfig.isHenchman(path));
            setHenchmanAmount(PigManConfig.getPigManHenchmanAmount(path));

            setChanceItem(PigManConfig.getPigManItemChance(path));
            setChance(PigManConfig.getPigManChance(path));

            setDamage(PigManConfig.getPigManDamage(path));

            setEffects(PigManConfig.isEffect(path));

            setLife(PigManConfig.getPigManLife(path));

            setPrefix(PigManConfig.getPigManPrefix(path));

            setValue(PigManConfig.getPigManValue());
            setTime(PigManConfig.getPigManTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(), this);
        }

        public void toSpawn(Location location) {
            generateEntity(location);
        }
    }

        public static class Rare extends Mob{
            public Rare(){
                String path = "Raro";
                setAClass(PigZombie.class);
                setName("id_hyren_rare_pigman");

                setHenchman(PigManConfig.isHenchman(path));
                setHenchmanAmount(PigManConfig.getPigManHenchmanAmount(path));

                setChanceItem(PigManConfig.getPigManItemChance(path));
                setChance(PigManConfig.getPigManChance(path));

                setDamage(PigManConfig.getPigManDamage(path));

                setEffects(PigManConfig.isEffect(path));

                setLife(PigManConfig.getPigManLife(path));

                setPrefix(PigManConfig.getPigManPrefix(path));

                setValue(PigManConfig.getPigManValue());
                setTime(PigManConfig.getPigManTimeCombat(path));
                HyrenMobs.getPlugin().mobs.put(getName(),this);
            }

            public void toSpawn(Location location){
                generateEntity(location);
            }

    }


    public static class Legendary extends Mob{
        public Legendary(){
            String path = "Lendario";
            setAClass(PigZombie.class);
            setName("id_hyren_legendary_pigman");

            setHenchman(PigManConfig.isHenchman(path));
            setHenchmanAmount(PigManConfig.getPigManHenchmanAmount(path));

            setChanceItem(PigManConfig.getPigManItemChance(path));
            setChance(PigManConfig.getPigManChance(path));

            setDamage(PigManConfig.getPigManDamage(path));

            setEffects(PigManConfig.isEffect(path));

            setLife(PigManConfig.getPigManLife(path));

            setPrefix(PigManConfig.getPigManPrefix(path));

            setValue(PigManConfig.getPigManValue());
            setTime(PigManConfig.getPigManTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(),this);
        }

        public void toSpawn(Location location){
            generateEntity(location);
        }

    }


}
