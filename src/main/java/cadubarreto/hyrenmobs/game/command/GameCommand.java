package cadubarreto.hyrenmobs.game.command;

import cadubarreto.bungee.HyrenBungeeAPI;
import cadubarreto.hyrenmobs.HyrenMobAPI;
import cadubarreto.hyrenmobs.HyrenMobs;
import cadubarreto.hyrenmobs.adapter.BungeeAdapter;
import cadubarreto.hyrenmobs.arena.Arena;
import cadubarreto.hyrenmobs.game.Game;
import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.SwordLevel;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.mob.zombie.ZombieMob;
import cadubarreto.hyrenmobs.shop.ShopMenu;
import cadubarreto.hyrenmobs.shop.layout.page.ZombiePage;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("combate")){
            PlayerMenuUtility p = HyrenMobs.getPlayerMenuUtility(player);

            if (player.isOp()){


                if (args.length == 0){
                    player.sendMessage("§c§l    BOSS -> COMBATE -> ADMIN");
                    player.sendMessage("");
                    player.sendMessage("§c/combate espada (player) (pontos) ");
                    player.sendMessage("§c/combate armadura (player) (pontos)");
                    player.sendMessage("§c/combate encantamento (player) (pontos)");
                    player.sendMessage("");
                    return true;
                }

                if (args.length == 1){
                    String sub = args[0];
                    if (sub.equalsIgnoreCase("teste")){
                        PlayerMenuUtility playerMenuUtility = HyrenMobs.getPlayerMenuUtility(player);

                        new ShopMenu(playerMenuUtility).open();

                    }
                    if (sub.equalsIgnoreCase("partida")){

                        BungeeAdapter.sendServer(player ,"hyren-lobby");

                    }
                    if (sub.equalsIgnoreCase("deletar")){
                            new Arena(player).deleteWorldFolder();
                            new Arena(player).removePlayerWorld();
                        player.sendMessage("§aTeleportando... §c§lSAINDO ARENA");
                    }

                    if (sub.equalsIgnoreCase("criar")){
                        new Arena(player).createWorld();
                        player.sendMessage("§aTeleportando... §e§lENTRANDO ARENA");
                    }
                    if (sub.equalsIgnoreCase("espada")){
                        player.sendMessage("§c/combate espada (player) (pontos)");
                        return true;
                    }
                    if (sub.equalsIgnoreCase("armadura")){
                        player.sendMessage("§c/combate armadura (player) (pontos)");
                        return true;
                    }
                    if (sub.equalsIgnoreCase("encantamento")){
                        player.sendMessage("§c/combate encantamento (player) (pontos)");
                        return true;
                    }
                }

                if (args.length == 2){
                    String sub = args[0];
                    UUID user = Bukkit.getPlayer(args[1]).getUniqueId();
                    Player ps = Bukkit.getPlayer(user);
                    if (sub.equalsIgnoreCase("espada")){
                        if (!HyrenMobs.getPlugin().playerLevelSword.containsKey(ps.getName())){
                            player.sendMessage("§cEsse jogador não existe");
                            return true;
                        }
                        player.sendMessage("§c/combate espada (player) (pontos)");
                    }
                }

                if (args.length == 3){
                    String sub = args[0];
                    UUID user = Bukkit.getPlayer(args[1]).getUniqueId();
                    Player ps = Bukkit.getPlayer(user);
                    String point = args[2];
                    if (sub.equalsIgnoreCase("espada")){
                        if (!HyrenMobs.getPlugin().playerLevelSword.containsKey(ps.getName())){
                            player.sendMessage("§cEsse jogador não existe");
                            return true;
                        }

                        if (isInt(point)){
                            player.sendMessage("§cVocê não digitou um numero");
                            return true;
                        }

                        int n = Integer.parseInt(point);
                        if (n <= 0){
                            player.sendMessage("§cVocê tem que digitar um numero maior que 0");
                            return true;
                        }

                        if (n >= 4){
                            player.sendMessage("§cO limite de pontos de Espada é 3");
                            return true;
                        }

                        player.sendMessage("§dVocê setou os pontos de §f§lEspada §b" + ps.getDisplayName() + " §dpara §b" + n);
                        SwordLevel.setLevel(ps, n);
                    }


                    if (sub.equalsIgnoreCase("armadura")){
                        if (!HyrenMobs.getPlugin().playerLevelArmor.containsKey(ps.getName())){
                            player.sendMessage("§cEsse jogador não existe");
                            return true;
                        }

                        if (isInt(point)){
                            player.sendMessage("§cVocê não digitou um numero");
                            return true;
                        }

                        int n = Integer.parseInt(point);
                        if (n <= 0){
                            player.sendMessage("§cVocê tem que digitar um numero maior que 0");
                            return true;
                        }

                        if (n >= 4){
                            player.sendMessage("§cO limite de pontos de Armadura é 3");
                            return true;
                        }

                        player.sendMessage("§dVocê setou os pontos de §f§lArmadura §b" + ps.getDisplayName() + " §dpara §b" + n);
                        ArmorLevel.setLevel(ps, n);
                    }

                    if (sub.equalsIgnoreCase("encantamento")){
                        if (!HyrenMobs.getPlugin().playerLevelArmor.containsKey(ps.getName())){
                            player.sendMessage("§cEsse jogador não existe");
                            return true;
                        }

                        if (isInt(point)){
                            player.sendMessage("§cVocê não digitou um numero");
                            return true;
                        }

                        int n = Integer.parseInt(point);
                        if (n <= 0){
                            player.sendMessage("§cVocê tem que digitar um numero maior que 0");
                            return true;
                        }

                        if (n >= 6){
                            player.sendMessage("§cO limite de pontos de encantamento é 5");
                            return true;
                        }

                        player.sendMessage("§dVocê setou os pontos de §f§lEncantamento §b" + ps.getDisplayName() + " §dpara §b" + n);
                        EnchantmentLevel.setLevel(ps, n);
                    }
                }
            } else {
                new ZombiePage(p).learnLayout();
            }



        }

        return false;
    }
    public static boolean isInt(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
