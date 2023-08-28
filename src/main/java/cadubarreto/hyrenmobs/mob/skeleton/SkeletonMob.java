package cadubarreto.hyrenmobs.mob.skeleton;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.config.SkeletonConfig;
import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.Location;
import org.bukkit.entity.Skeleton;

public class SkeletonMob {

    public static class Common extends Mob {
        public Common() {
            String path = "Comum";
            setAClass(Skeleton.class);
            setName("id_hyren_common_skeleton");

            setHenchman(SkeletonConfig.isHenchman(path));
            setHenchmanAmount(SkeletonConfig.getSkeletonHenchmanAmount(path));

            setChanceItem(SkeletonConfig.getSkeletonItemChance(path));
            setChance(SkeletonConfig.getSkeletonChance(path));

            setDamage(SkeletonConfig.getSkeletonDamage(path));

            setEffects(SkeletonConfig.isEffect(path));

            setLife(SkeletonConfig.getSkeletonLife(path));

            setPrefix(SkeletonConfig.getSkeletonPrefix(path));

            setValue(SkeletonConfig.getSkeletonValue());
            setTime(SkeletonConfig.getSkeletonTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(), this);
        }

        public void toSpawn(Location location) {
            generateEntity(location);
        }
    }

        public static class Rare extends Mob{
            public Rare(){
                String path = "Raro";
                setAClass(Skeleton.class);
                setName("id_hyren_rare_skeleton");

                setHenchman(SkeletonConfig.isHenchman(path));
                setHenchmanAmount(SkeletonConfig.getSkeletonHenchmanAmount(path));

                setChanceItem(SkeletonConfig.getSkeletonItemChance(path));
                setChance(SkeletonConfig.getSkeletonChance(path));

                setDamage(SkeletonConfig.getSkeletonDamage(path));

                setEffects(SkeletonConfig.isEffect(path));

                setLife(SkeletonConfig.getSkeletonLife(path));

                setPrefix(SkeletonConfig.getSkeletonPrefix(path));

                setValue(SkeletonConfig.getSkeletonValue());
                setTime(SkeletonConfig.getSkeletonTimeCombat(path));
                HyrenMobs.getPlugin().mobs.put(getName(),this);
            }

            public void toSpawn(Location location){
                generateEntity(location);
            }

    }


    public static class Legendary extends Mob{
        public Legendary(){
            String path = "Lendario";
            setAClass(Skeleton.class);
            setName("id_hyren_legendary_skeleton");

            setHenchman(SkeletonConfig.isHenchman(path));
            setHenchmanAmount(SkeletonConfig.getSkeletonHenchmanAmount(path));

            setChanceItem(SkeletonConfig.getSkeletonItemChance(path));
            setChance(SkeletonConfig.getSkeletonChance(path));

            setDamage(SkeletonConfig.getSkeletonDamage(path));

            setEffects(SkeletonConfig.isEffect(path));

            setLife(SkeletonConfig.getSkeletonLife(path));

            setPrefix(SkeletonConfig.getSkeletonPrefix(path));

            setValue(SkeletonConfig.getSkeletonValue());
            setTime(SkeletonConfig.getSkeletonTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(),this);
        }

        public void toSpawn(Location location){
            generateEntity(location);
        }

    }


}
