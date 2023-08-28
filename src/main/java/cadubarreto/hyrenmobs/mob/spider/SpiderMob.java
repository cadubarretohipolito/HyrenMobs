package cadubarreto.hyrenmobs.mob.spider;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.config.SpiderConfig;
import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.Location;
import org.bukkit.entity.Spider;

public class SpiderMob {

    public static class Common extends Mob {
        public Common() {
            String path = "Comum";
            setAClass(Spider.class);
            setName("id_hyren_common_spider");

            setHenchman(SpiderConfig.isHenchman(path));
            setHenchmanAmount(SpiderConfig.getSpiderHenchmanAmount(path));

            setChanceItem(SpiderConfig.getSpiderItemChance(path));
            setChance(SpiderConfig.getSpiderChance(path));

            setDamage(SpiderConfig.getSpiderDamage(path));

            setEffects(SpiderConfig.isEffect(path));

            setLife(SpiderConfig.getSpiderLife(path));

            setPrefix(SpiderConfig.getSpiderPrefix(path));

            setValue(SpiderConfig.getSpiderValue());
            setTime(SpiderConfig.getSpiderTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(), this);
        }

        public void toSpawn(Location location) {
            generateEntity(location);
        }
    }

        public static class Rare extends Mob{
            public Rare(){
                String path = "Raro";
                setAClass(Spider.class);
                setName("id_hyren_rare_spider");

                setHenchman(SpiderConfig.isHenchman(path));
                setHenchmanAmount(SpiderConfig.getSpiderHenchmanAmount(path));

                setChanceItem(SpiderConfig.getSpiderItemChance(path));
                setChance(SpiderConfig.getSpiderChance(path));

                setDamage(SpiderConfig.getSpiderDamage(path));

                setEffects(SpiderConfig.isEffect(path));

                setLife(SpiderConfig.getSpiderLife(path));

                setPrefix(SpiderConfig.getSpiderPrefix(path));

                setValue(SpiderConfig.getSpiderValue());
                setTime(SpiderConfig.getSpiderTimeCombat(path));
                HyrenMobs.getPlugin().mobs.put(getName(),this);
            }

            public void toSpawn(Location location){
                generateEntity(location);
            }

    }


    public static class Legendary extends Mob{
        public Legendary(){
            String path = "Lendario";
            setAClass(Spider.class);
            setName("id_hyren_legendary_spider");

            setHenchman(SpiderConfig.isHenchman(path));
            setHenchmanAmount(SpiderConfig.getSpiderHenchmanAmount(path));

            setChanceItem(SpiderConfig.getSpiderItemChance(path));
            setChance(SpiderConfig.getSpiderChance(path));

            setDamage(SpiderConfig.getSpiderDamage(path));

            setEffects(SpiderConfig.isEffect(path));

            setLife(SpiderConfig.getSpiderLife(path));

            setPrefix(SpiderConfig.getSpiderPrefix(path));

            setValue(SpiderConfig.getSpiderValue());
            setTime(SpiderConfig.getSpiderTimeCombat(path));
            HyrenMobs.getPlugin().mobs.put(getName(),this);
        }

        public void toSpawn(Location location){
            generateEntity(location);
        }

    }


}
