package cadubarreto.hyrenmobs.henchman;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class HenchmanManager {

    public static void spawn(Location location, int timer){

        List<EntityType> types = new ArrayList<>();
        types.add(EntityType.ZOMBIE);
        types.add(EntityType.SKELETON);
        types.add(EntityType.SPIDER);
        types.add(EntityType.CREEPER);

        List<String> names = new ArrayList<>();
        names.add("§eZumbi Capanga");
        names.add("§eEsqueleto Capanga");
        names.add("§eAranha Capanga");
        names.add("§eCreeper Capanga");

        new Henchman(location , timer , types , names ).attack();
    }

}
