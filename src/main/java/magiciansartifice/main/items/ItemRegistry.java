package magiciansartifice.main.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.items.magicalitems.*;
import magiciansartifice.main.items.ores.ItemDustMeta;
import magiciansartifice.main.items.ores.ItemIngotMeta;
import magiciansartifice.main.items.tools.*;
import magiciansartifice.main.items.wood.ItemSticksMeta;
import magiciansartifice.main.items.tools.starsteel.*;
import magiciansartifice.main.items.tools.steel.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;

public class ItemRegistry
{
    private static Item.ToolMaterial iron = Item.ToolMaterial.IRON;
    private static Item.ToolMaterial diamond = Item.ToolMaterial.EMERALD;

    public static ArrayList<Item> items = new ArrayList<Item>();

    public static Item.ToolMaterial steel = EnumHelper.addToolMaterial("steel", iron.getHarvestLevel(), iron.getMaxUses() + 50, iron.getEfficiencyOnProperMaterial(), iron.getDamageVsEntity(), iron.getEnchantability());
    public static Item.ToolMaterial starSteel = EnumHelper.addToolMaterial("starSteel", diamond.getHarvestLevel(), diamond.getMaxUses() + 100, diamond.getEfficiencyOnProperMaterial(), diamond.getDamageVsEntity(), diamond.getEnchantability());

    public static Item ingotsMeta;
    public static Item dustsMeta;
    public static Item sticksMeta;
    public static Item saplingMeta;

    public static Item magiciansWand;
    public static Item magiciansWand2;
    public static Item magiciansWand3;
    public static Item creativeWand;
    public static Item chiselTool;
    public static Item netherChisel;
    public static Item enderChisel;
    public static Item book;
    public static Item advBook;
    public static Item ritualBook;
    public static Item unforgivableBook;
    public static Item darkestBook;
    public static Item spellBook;
    public static Item merlinLetter;
    public static Item ritualCatalyst;
    public static Item horcrux;

    public static Item steelSword;
    public static Item steelPick;
    public static Item steelShovel;
    public static Item steelAxe;
    public static Item steelHoe;
    public static Item starSteelSword;
    public static Item starSteelPick;
    public static Item starSteelShovel;
    public static Item starSteelAxe;
    public static Item starSteelHoe;

    public static Item spiderFang;
    
    public static Item debugger;

    public static void initItems() {

        dustsMeta = new ItemDustMeta();
        ingotsMeta = new ItemIngotMeta();
        sticksMeta = new ItemSticksMeta();
        
        magiciansWand = new ItemWand(1);
        magiciansWand2 = new ItemWand(2);
        magiciansWand3 = new ItemWand(3);
        creativeWand = new ItemWand(4);
        book = new ItemMagicBook();
        advBook = new ItemMagicBookAdv();
        ritualBook = new ItemRitualBook();
        spellBook = new ItemSpellBook();
        unforgivableBook = new ItemUnforgivableBook();
        darkestBook = new ItemDarkestBook();
        chiselTool = new ItemToolChisel();
        netherChisel = new ItemToolChisel(1);
        enderChisel = new ItemToolChisel(2);
        merlinLetter = new ItemLetterMerlin();
        ritualCatalyst = new ItemRitualCatalyst();

        steelSword = new ItemSwordSteel();
        steelPick = new ItemPickSteel();
        steelShovel = new ItemShovelSteel();
        steelAxe = new ItemAxeSteel();
        steelHoe = new ItemHoeSteel();

        starSteelSword = new ItemSwordStarSteel();
        starSteelPick = new ItemPickStarSteel();
        starSteelShovel = new ItemShovelStarSteel();
        starSteelAxe = new ItemAxeStarSteel();
        starSteelHoe = new ItemHoeStarSteel();

        horcrux = new ItemHorcrux();

        spiderFang = new ItemSpiderFang();
        debugger = new Debugger();
        
        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }
    }
}
