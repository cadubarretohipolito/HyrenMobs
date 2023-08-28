package cadubarreto.hyrenmobs.utils;

import lombok.Getter;

public enum IconsUtils {

    Arrow("→"),
    Swords("⚔"),
    Defense("❖"),
    Enchantments("✸");

    private String src;
    IconsUtils(String src){
        this.src = src;
    }

    public String getSrc() {
        return src;
    }
}
