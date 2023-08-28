package cadubarreto.hyrenmobs.utils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class SoundRadius
{
    public static void playSound(final Sound sound, final int radius, final Location loc) {
        for (final Entity en : loc.getWorld().getNearbyEntities(loc, (double)radius, (double)radius, (double)radius)) {
            if (en instanceof Player) {
                final Player p = (Player)en;
                p.playSound(loc, sound, (float)(radius - loc.distance(p.getLocation())), 1.0f);
            }
        }
    }
}
