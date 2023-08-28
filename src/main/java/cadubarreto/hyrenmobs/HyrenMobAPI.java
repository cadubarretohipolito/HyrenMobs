package cadubarreto.hyrenmobs;

public class HyrenMobAPI {

    public static String getNormalWorldName(){

        return HyrenMobs.getPlugin().getConfig().getString(
                "Conexoes.RankUP.Nome_Do_Servidor");
    };

    public static String getVoidWorldName(){

        return HyrenMobs.getPlugin().getConfig().getString(
                "Conexoes.BossWorld.Nome_Do_Servidor");
    };
}
