package cadubarreto.hyrenmobs.utils;

import org.bukkit.Location;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathUtils {
    public Location rotateX (Location location,Location center, double a){
        double x = location.getX() - center.getX();
        double y = location.getY() - center.getY();
        double z = location.getZ() - center.getZ();
        double xPrime = x;
        double yPrime = -Math.sin(a)*y + Math.cos(a)*z;
        double zPrime = Math.cos(a)*y + Math.sin(a)*z;
        return new Location(center.getWorld(),xPrime + center.getX(),yPrime + center.getY() + 1,zPrime+center.getZ());
    }

    public Location rotateY (Location location, Location center, double a){
        double x = location.getX() - center.getX();
        double y = location.getY() - center.getY();
        double z = location.getZ() - center.getZ();
        double xPrime = Math.cos(a)*x + Math.sin(a)*z;
        double yPrime = y;
        double zPrime = -Math.sin(a)*x + Math.cos(a)*z;
        return new Location(center.getWorld(),xPrime + center.getX(),yPrime + center.getY() + 1,zPrime+center.getZ());
    }

    public Location rotateZ (Location location,Location center, double a){
        double x = location.getX() - center.getX();
        double y = location.getY() - center.getY();
        double z = location.getZ() - center.getZ();
        double xPrime = Math.cos(a)*x - Math.sin(a)*y;
        double yPrime = -Math.sin(a)*x + Math.cos(a)*y;
        double zPrime = z;
        return new Location(center.getWorld(),xPrime + center.getX(),yPrime + center.getY() + 1,zPrime+center.getZ());
    }

    public static NumberFormat nf = new DecimalFormat("#,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String getTempo(long time) {
        if (time == 0L) {
            return "never";
        }
        final long day = TimeUnit.MILLISECONDS.toDays(time);
        final long hours = TimeUnit.MILLISECONDS.toHours(time) - day * 24L;
        final long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toHours(time) * 60L;
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MILLISECONDS.toMinutes(time) * 60L;
        final StringBuilder sb = new StringBuilder();
        if (day > 0L) {
            sb.append(day).append(" ").append((day == 1L) ? "dia" : "dias").append(" ");
        }
        if (hours > 0L) {
            sb.append(hours).append(" ").append((hours == 1L) ? "hora" : "horas").append(" ");
        }
        if (minutes > 0L) {
            sb.append(minutes).append(" ").append((minutes == 1L) ? "minuto" : "minutos").append(" ");
        }
        if (seconds > 0L) {
            sb.append(seconds).append(" ").append((seconds == 1L) ? "segundo" : "segundos");
        }
        final String diff = sb.toString();
        return diff.isEmpty() ? "agora" : diff;
    }


    public String formatDifferenceStr(final long time) {
        if (time == 0L) {
            return "never";
        }
        final long day = TimeUnit.MILLISECONDS.toDays(time);
        final long hours = TimeUnit.MILLISECONDS.toHours(time) - day * 24L;
        final long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toHours(time) * 60L;
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MILLISECONDS.toMinutes(time) * 60L;
        final StringBuilder sb = new StringBuilder();
        if (day > 0L) {
            sb.append(day).append(" ").append((day == 1L) ? "dia" : "dias").append(" ");
        }
        if (hours > 0L) {
            sb.append(hours).append(" ").append((hours == 1L) ? "hora" : "horas").append(" ");
        }
        if (minutes > 0L) {
            sb.append(minutes).append(" ").append((minutes == 1L) ? "minuto" : "minutos").append(" ");
        }
        if (seconds > 0L) {
            sb.append(seconds).append(" ").append((seconds == 1L) ? "segundo" : "segundos");
        }
        final String diff = sb.toString();
        return diff.isEmpty() ? "agora" : diff;
    }


}
