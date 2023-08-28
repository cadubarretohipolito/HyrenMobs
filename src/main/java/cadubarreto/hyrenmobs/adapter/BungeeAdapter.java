package cadubarreto.hyrenmobs.adapter;

import cadubarreto.hyrenmobs.HyrenMobAPI;
import cadubarreto.hyrenmobs.HyrenMobs;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BungeeAdapter implements Runnable, PluginMessageListener {

    private static final Map<String, Integer> serverMap = new HashMap<>();

    private static final String[] SERVERS = {
            "lobby"
    };

    @Override
    public void run() {
        for (String server : SERVERS) {
              ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("PlayerCount");
            out.writeUTF(server);

            Bukkit.getServer().sendPluginMessage(
                    HyrenMobs.getPlugin(HyrenMobs.class), "BungeeCord", out.toByteArray()
            );
        }
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;

        final ByteArrayDataInput input = ByteStreams.newDataInput(message);

        final String value = input.readUTF();
        if (!value.equals("PlayerCount")) return;

        final String server = input.readUTF();
        final int online = input.readInt();

        serverMap.put(server, online);
    }

    public static int getServerCount(String server) {
        return serverMap.getOrDefault(server, 0);
    }
    public static void sendServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArrayOutputStream);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException exception) {
            System.out.println(exception);
        }
        Bukkit.getPlayer(player.getName()).sendPluginMessage(HyrenMobs.getPlugin(HyrenMobs.class), "BungeeCord", byteArrayOutputStream.toByteArray());

    }
}
