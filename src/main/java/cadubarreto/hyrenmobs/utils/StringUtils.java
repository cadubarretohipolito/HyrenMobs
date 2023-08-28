package cadubarreto.hyrenmobs.utils;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;

public class StringUtils {
    public static String convert(int integer) {
        int roundedHealth = Math.round(integer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(roundedHealth, 10); i++) {
            sb.append('■');
        }
        return sb.toString();
    }

    public static String createBar(int progress, int total) {
        int percentage = (int) ((double) progress / total * 100);
        int barLength = 10;
        int progressBars = (int) ((double) percentage / 100 * barLength);
        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.RED);
        for (int i = 0; i < progressBars; i++) {
            sb.append("■'");
        }
        sb.append(ChatColor.RESET);
        for (int i = progressBars; i < barLength; i++) {
            sb.append("■'");
        }
        return sb.toString();
    }

    public static String getProgressBar(int current, int max, int totalBars, String symbol, ChatColor completedColor,
                                 ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + symbol, progressBars)
                + Strings.repeat("" + notCompletedColor + symbol, totalBars - progressBars);
    }
}
