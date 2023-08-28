package cadubarreto.hyrenmobs.shop.layout;

import cadubarreto.hyrenmobs.level.ArmorLevel;
import cadubarreto.hyrenmobs.level.EnchantmentLevel;
import cadubarreto.hyrenmobs.level.LevelData;
import cadubarreto.hyrenmobs.level.SwordLevel;
import cadubarreto.hyrenmobs.mob.Mob;
import cadubarreto.hyrenmobs.shop.ShopItems;
import cadubarreto.hyrenmobs.utils.IconsUtils;
import cadubarreto.hyrenmobs.utils.MathUtils;
import cadubarreto.hyrenmobs.utils.menu.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class ShopLayout implements InventoryHolder {

    protected Inventory inventory;
    protected PlayerMenuUtility playerMenuUtility;

    public ShopLayout(PlayerMenuUtility playerMenuUtility){
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMobName();
    public abstract void handleMenu(InventoryClickEvent e);
    public abstract int getID();
    public abstract double price();
    public abstract double commonChance();
    public abstract double rareChance();
    public abstract double legendaryChance();


    public void learnLayout(){
        String title = "Boss " + IconsUtils.Arrow.getSrc() + " " + getMobName();
        inventory = Bukkit.createInventory(this, 5*9 , title);
        playerMenuUtility.getOwner().openInventory(inventory);
        setupItems();
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void setupItems(){

        ItemStack arco = makeItem(Material.BOW , "§aComprar Arco e Flecha" ,
                "§7Esse item pode te ajudar e seu combate ",
                "§7mantendo-o longe do Boss",
                "",
                "§a* Esse item só vai durar uma sessão *",
                "",
                "§fPreço: §e" + MathUtils.nf.format(ShopItems.getBowPrice()) ,
                "",
                "§eClique para comprar");

        ItemStack pocao = makeItem(Material.POTION , "§aComprar Poção" ,
                "§7As poções pode tem ajudar em seu combate",
                "§7tanto como a parte da defesa , como a do ataque!",
                "",
                "§a* Esse item só vai durar uma sessão *",
                "",
                "§fKit de Poção: §e" + MathUtils.nf.format(ShopItems.getPotionPrice()) ,
                "",
                "§eClique para comprar");


        ItemStack up_espada = makeItem(SwordLevel.swordItemStack(playerMenuUtility.getOwner()).getType(), "§bEvoluir Espada" ,
                "§7Você evoluindo sua espada , te ajudará e muito!",
                "",
                "§a* O Nivel também sobe para os outros bosses *",
                "",
                "§fSeu Nivel: " + SwordLevel.swordString(playerMenuUtility.getOwner()),
                "§fEvoluir: §e" +
                        SwordLevel.printMaxLevel(
                                playerMenuUtility.getOwner(),
                                MathUtils.nf.format(
                                        LevelData.getSwordPrice(
                                                SwordLevel.getLevel(
                                                        playerMenuUtility.getOwner())))),
                "",
                "§eClique para evoluir");

        ItemStack up_armor = makeItem(ArmorLevel.armorItemStack(playerMenuUtility.getOwner()).getType(), "§bEvoluir Armadura" ,

                "§7Evoluindo sua armadura será uma forma melhor de",
                "§7se defender dos bosses",
                "",
                "§a* O Nivel também sobe para os outros bosses *",
                "",
                "§fSeu Nivel: " + ArmorLevel.armorString(playerMenuUtility.getOwner()),
                "§fEvoluir: §e" +
                        ArmorLevel.printMaxLevel(
                                playerMenuUtility.getOwner(),
                                MathUtils.nf.format(
                                        LevelData.getArmorPrice(
                                                SwordLevel.getLevel(
                                                        playerMenuUtility.getOwner())))),
                "",
                "§eClique para evoluir");

        ItemStack up_enchant = makeItem(Material.ENCHANTED_BOOK , "§bEvoluir Encantamentos" ,
                "§7Para deixar seus items com mais ataque e",
                "§7defesa , é recomendado que você evolua seus encantamentos",
                "",
                "§a* O Nivel também sobe para os outros bosses *",
                "",
                "§fSeu Nivel: " + EnchantmentLevel.enchantmentString(playerMenuUtility.getOwner()),
                "§fEvoluir: §e" +
                        EnchantmentLevel.printMaxLevel(
                                playerMenuUtility.getOwner(),
                                MathUtils.nf.format(
                                        LevelData.getEnchantmentPrice(
                                                SwordLevel.getLevel(
                                                        playerMenuUtility.getOwner())))),
                "",
                "§eClique para evoluir");


        ItemStack egg = createEgg("§6Comprar Boss" , getID() ,
                "§7Agora se tornou algo simples de obter items valiosos!",
                "",
                "§7Para isso só basta você comprar um boss",
                "§7e torçer para cair um nivel que você queira",
                "",
                "§fProbabilidades:",
                " §fComum: §e(%"+ commonChance() +")",
                " §fRaro: §6(%"+ rareChance() +")",
                " §fLendario: §d§l(%" + legendaryChance() + ")",
                "",
                "§fPreço: §e" + MathUtils.nf.format(price()),
                "",
                "§eClique para comprar");

        ItemStack items = makeItem(Material.STORAGE_MINECART,"§aRecompensas",
                "§7Veja os possíveis items que você pode ganhar",
                "§7eliminando os bosses comprados",
                "",
                "§eClique para abrir");

        ItemStack tutorial = makeItem(Material.SIGN , "§6Tutorial",
                "§7Caso esteja com dúvida, sobre esse sistema",
                "§7clique e abra o vídeo onde vai mostrar um tutorial",
                "§7de como funciona o sistema de boss!",
                "",
                "§6Clique para ver o video");

        inventory.setItem(16, tutorial);
        inventory.setItem(25, items);

        inventory.setItem(22, egg);

        inventory.setItem(19, arco);
        inventory.setItem(28, pocao);

        inventory.setItem(39, up_espada);
        inventory.setItem(40, up_armor);
        inventory.setItem(41, up_enchant);


    }

    public ItemStack makeItem(Material material, String displayName, String... lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack makeItemShort(Material material,short id, String displayName, String... lore) {

        ItemStack item = new ItemStack(material,1 , id);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack createEgg(String name,int id,String... lore){
        ItemStack itemStack = new ItemStack(Material.MONSTER_EGG , 1 , (short) id);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }




}
