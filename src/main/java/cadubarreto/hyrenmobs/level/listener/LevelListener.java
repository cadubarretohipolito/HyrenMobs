package cadubarreto.hyrenmobs.level.listener;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.SwordLevel;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LevelListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!HyrenMobs.getPlugin().playerLevelSword.containsKey(player.getName())){
            SwordLevel l = new SwordLevel(player.getName() , 0);
            HyrenMobs.getPlugin().playerLevelSword.put(player.getName(), l);
            SwordLevel.resetLevel(event.getPlayer());
        }
        if (!HyrenMobs.getPlugin().playerLevelArmor.containsKey(player.getName())){
            ArmorLevel l = new ArmorLevel(player.getName() , 0);
            HyrenMobs.getPlugin().playerLevelArmor.put(player.getName(), l);
            ArmorLevel.resetLevel(event.getPlayer());
        }
        if (!HyrenMobs.getPlugin().playerLevelEnchantment.containsKey(player.getName())){
            EnchantmentLevel l = new EnchantmentLevel(player.getName() , 0);
            HyrenMobs.getPlugin().playerLevelEnchantment.put(player.getName(), l);
            EnchantmentLevel.resetLevel(event.getPlayer());
        }
    }


}
