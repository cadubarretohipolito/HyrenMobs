package cadubarreto.hyrenmobs.utils;

/*import cadubarreto.hyrenmobs.utils.particle.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleAPI {

    public enum Shape {
        LINE,
        HELIX,
        CIRCLE
    }

    public static void displayShape(Shape shape, Location location, Player player, ParticleEffect particle, int count, double speed) {
        switch (shape) {
            case LINE:
                displayLine(location, player, particle, count, speed);
                break;
            case HELIX:
                displayHelix(location, player, particle, count, speed);
                break;
            case CIRCLE:
                displayCircle(location, player, particle, count, speed);
                break;
        }
    }

    private static void displayLine(Location location, Player player, Particle particle, int count, double speed) {
        for (int i = 0; i < count; i++) {
            player.spawnParticle(particle, location, 0, i * speed, 0, 0, 0);
        }
    }

    private static void displayHelix(Location location, Player player, Particle particle, int count, double speed) {
        for (int i = 0; i < count; i++) {
            double angle = i * Math.PI / count * 5;
            double x = Math.cos(angle) * count / 5;
            double y = i * speed;
            double z = Math.sin(angle) * count / 5;
            location.add(x, y, z);
            player.spawnParticle(particle, location, 0, 0, 0, 0, 0);
            location.subtract(x, y, z);
        }
    }

    private static void displayCircle(Location location, Player player, Particle particle, int count, double speed) {
        for (int i = 0; i < count; i++) {
            double angle = i * Math.PI * 2 / count;
            double x = Math.cos(angle) * count / 5;
            double y = i * speed;
            double z = Math.sin(angle) * count / 5;
            location.add(x, y, z);
            player.spawnParticle(particle, location, 0, 0, 0, 0, 0);
            location.subtract(x, y, z);
        }
    }
}*/