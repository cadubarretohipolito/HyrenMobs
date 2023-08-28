package cadubarreto.hyrenmobs.level;

import cadubarreto.hyrenmobs.HyrenMobs;

public class LevelData {

    public static double getSwordPrice(int level){
        switch (level){
            case 0:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Espada.Inicial");
            }
            case 1:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Espada.Nivel_I");
            }
            case 2:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Espada.Nivel_II");
            }
            case 3:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Espada.Nivel_III");
            }
            default:
                break;
        }
        return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Espada.Inicial");
    }

    public static double getArmorPrice(int level) {
        switch (level) {
            case 0: {
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Armadura.Inicial");
            }
            case 1: {
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Armadura.Nivel_I");
            }
            case 2: {
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Armadura.Nivel_II");
            }
            case 3: {
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Armadura.Nivel_III");
            }
            default:
                break;
        }
        return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Armadura.Inicial");
    }
    public static double getEnchantmentPrice(int level){
        switch (level){
            case 0:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Inicial");
            }
            case 1:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Nivel_I");
            }
            case 2:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Nivel_II");
            }
            case 3:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Nivel_III");
            }
            case 4:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Nivel_IV");
            }
            case 5:{
                return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Nivel_V");
            }
            default:
                break;
        }
        return HyrenMobs.getPlugin().getConfig().getDouble("Atributos.Encantamento.Inicial");
    }

}
