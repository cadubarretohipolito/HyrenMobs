package cadubarreto.hyrenmobs.arena;

import cadubarreto.hyrenmobs.HyrenMobs;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;

public class ArenaSchematic {
    public static void createStructure(Location loc){
        File schematic = new File(HyrenMobs.getPlugin().getDataFolder() + File.separator + "/schematic/arena.schematic");
        EditSession session = HyrenMobs.getPlugin().worldedit.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(loc.getWorld()), 10000);
        try
        {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), false);
        }
        catch (MaxChangedBlocksException | DataException | IOException e)
        {
            e.printStackTrace();
        }

    }
}
