package cadubarreto.hyrenmobs.arena;

import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.mob.zombie.ZombieMob;
import lombok.Getter;
import org.bukkit.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.io.File;

import java.util.Random;


@Getter
public class Arena {

    public Player player;

    public World world;

    public Arena(Player player){
        this.player = player;
    };

    public void createWorld(){
        String worldName = player.getName();
        if (Bukkit.getWorld(worldName) == null){

            WorldCreator worldCreator = new WorldCreator(worldName);
            worldCreator.generateStructures(false);
            worldCreator.generator(new ChunkGenerator() {
                @Override
                public byte[] generate(World world, Random random, int x, int z) {
                    return new byte[32768];
                }

                @Override
                public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomeGrid)
                {
                    byte[][] result = new byte[world.getMaxHeight() / 16][]; //world height / chunk part height (=16, look above)
                    return result;
                }
            });
            HyrenMobs.debug("§aCriando o Mundo §f" + worldName);
            world = worldCreator.createWorld();
            int x = 0;
            int z = 0;
            world.setSpawnLocation(x , 75 , z);
            Location spawn = world.getSpawnLocation();
            Location pLoc = spawn.clone().add(0.5, 3 ,0.5);
            ArenaSchematic.createStructure(pLoc);
            player.teleport(spawn);

        } else {
            HyrenMobs.debug("§c" + player.getName() +" §cEstá tentando criar o mesmo mundo");
        }
    }

    public void removePlayerWorld(){
        player.teleport((Location) Bukkit.getWorlds().get(0).getSpawnLocation());
    }

    public World getWorld(Player player){
        String worldName = player.getName();
        return Bukkit.getWorld(worldName);
    }

    public void deleteWorldFolder(){
        String worldName = player.getName();
        World w = Bukkit.getWorld(worldName);
        File worldFolder = Bukkit.getWorld(worldName).getWorldFolder();
        Bukkit.unloadWorld(worldName, false);
        deleteFolder(worldFolder);

        HyrenMobs.debug("§cApagando o mundo do §f" + w.getName());
    }

    private void deleteFolder(File folder){
        File[] files = folder.listFiles();
        if(files!=null) {
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    private void spawnMonster(Location spawn){

        new ZombieMob.Common().generateEntity(spawn);

    }
}
