package cadubarreto.hyrenmobs.game;

import cadubarreto.hyrenmobs.mob.Mob;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GameManager {

    private Player player;
    private Mob mob;

    private HashMap<Player , Mob> hashMap;

    public GameManager(Player player,Mob mob){
        this.player = player;
        this.mob = mob;
        this.hashMap = new HashMap<>();
    }

    public void add(){
        hashMap.put(player , mob);
    }

    public void remove(){
        hashMap.remove(player);
        hashMap.remove(mob);
    }

}
