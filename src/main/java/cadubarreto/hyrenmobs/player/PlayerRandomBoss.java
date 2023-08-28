package cadubarreto.hyrenmobs.player;

import cadubarreto.hyrenmobs.mob.Mob;
import lombok.Data;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

@Data
public class PlayerRandomBoss {

    private final Player player;
    private final Mob common;
    private final  Mob rare;
    private final  Mob legendary;

    private final  Location location;

    public PlayerRandomBoss(Player player, Location location, Mob common , Mob rare , Mob legendary){
        this.player = player;
        this.common = common;
        this.rare = rare;
        this.legendary = legendary;
        this.location = location;
    }

    public void random(){

        Random random = new Random();
        int chance = random.nextInt(100) + 1;

        if (chance >= common.getChance()){
            common.generateEntity(location);
        } else if (chance >= rare.getChance()){
            rare.generateEntity(location);
        } else if (chance >= legendary.getChance()){
            legendary.generateEntity(location);
        }

    }

}
