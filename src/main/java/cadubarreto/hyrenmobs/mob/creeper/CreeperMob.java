package cadubarreto.hyrenmobs.mob.creeper;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.config.CreeperConfig;
import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;

public class CreeperMob {

    public static class Common extends Mob {
        public Common() {
            String path = "Comum";
            setAClass(Creeper.class);
            setName("id_hyren_common_creeper");

            setHenchman(CreeperConfig.isHenchman(path));
            setHenchmanAmount(CreeperConfig.getCreeperHenchmanAmount(path));

            setChanceItem(CreeperConfig.getCreeperItemChance(path));
            setChance(CreeperConfig.getCreeperChance(path));

            setDamage(CreeperConfig.getCreeperDamage(path));

            setEffects(CreeperConfig.isEffect(path));

            setLife(CreeperConfig.getCreeperLife(path));

            setPrefix(CreeperConfig.getCreeperPrefix(path));

            setValue(CreeperConfig.getCreeperValue());
            setTime(CreeperConfig.getCreeperTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(), this);
        }

        public void toSpawn(Location location) {
            generateEntity(location);
        }
    }

        public static class Rare extends Mob{
            public Rare(){
                String path = "Raro";
                setAClass(Creeper.class);
                setName("id_hyren_rare_creeper");

                setHenchman(CreeperConfig.isHenchman(path));
                setHenchmanAmount(CreeperConfig.getCreeperHenchmanAmount(path));

                setChanceItem(CreeperConfig.getCreeperItemChance(path));
                setChance(CreeperConfig.getCreeperChance(path));

                setDamage(CreeperConfig.getCreeperDamage(path));

                setEffects(CreeperConfig.isEffect(path));

                setLife(CreeperConfig.getCreeperLife(path));

                setPrefix(CreeperConfig.getCreeperPrefix(path));

                setValue(CreeperConfig.getCreeperValue());
                setTime(CreeperConfig.getCreeperTimeCombat(path));
                HyrenMobs.getPlugin().mobs.put(getName(),this);
            }

            public void toSpawn(Location location){
                generateEntity(location);
            }

    }


    public static class Legendary extends Mob{
        public Legendary(){
            String path = "Lendario";
            setAClass(Creeper.class);
            setName("id_hyren_legendary_reeper");

            setHenchman(CreeperConfig.isHenchman(path));
            setHenchmanAmount(CreeperConfig.getCreeperHenchmanAmount(path));

            setChanceItem(CreeperConfig.getCreeperItemChance(path));
            setChance(CreeperConfig.getCreeperChance(path));

            setDamage(CreeperConfig.getCreeperDamage(path));

            setEffects(CreeperConfig.isEffect(path));

            setLife(CreeperConfig.getCreeperLife(path));

            setPrefix(CreeperConfig.getCreeperPrefix(path));

            setValue(CreeperConfig.getCreeperValue());
            setTime(CreeperConfig.getCreeperTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(),this);
        }

        public void toSpawn(Location location){
            generateEntity(location);
        }

    }


}
