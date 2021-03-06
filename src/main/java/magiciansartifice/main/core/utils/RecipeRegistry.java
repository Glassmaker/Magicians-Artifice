package magiciansartifice.main.core.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.main.tileentities.recipes.RecipesMetalForge;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeRegistry
{
    private static void registerItems() {
        //book
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.book, 1), new ItemStack(ItemRegistry.dustsMeta, 1, 0), new ItemStack(Items.book, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.advBook,1),new ItemStack(ItemRegistry.dustsMeta,1,1), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ritualBook,1), new ItemStack(ItemRegistry.ritualCatalyst), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.spellBook,1), new ItemStack(ItemRegistry.magiciansWand,1), new ItemStack(Items.book,1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.unforgivableBook,1),new ItemStack(ItemRegistry.book,1), new ItemStack(ItemRegistry.dustsMeta,1,2));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.darkestBook,1),new ItemStack(ItemRegistry.advBook,1), new ItemStack(ItemRegistry.spiderFang,1));

        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.merlinLetter,1),new ItemStack(Items.book), new ItemStack(Items.ender_eye));

        //magical items
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.ritualCatalyst), "CC ", " CDC", " CC", 'C', Blocks.cobblestone, 'D', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.horcrux), "EeE", "eDe", "EeE", 'E', "dustEnderPearl",'e',new ItemStack(BlockRegistry.storage,1,2),'D', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.horcrux), "EeE", "eDe", "EeE", 'E', Items.ender_eye,'e',new ItemStack(BlockRegistry.storage,1,2),'D', "gemDiamond"));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.spiderFang), ItemRegistry.horcrux, ItemRegistry.spiderFang);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.chiselTool), "I", "S", 'I', "ingotIron", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.netherChisel), "D", "I", "S", 'I', "ingotIron", 'S', "stickWood",'D',new ItemStack(ItemRegistry.dustsMeta,1,1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.enderChisel), "D", "I", "S", 'I', "gemDiamond", 'S', "stickWood",'D',new ItemStack(ItemRegistry.dustsMeta,1,2)));

        //storage blocks to ingots
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 0), new ItemStack(BlockRegistry.storage, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 1), new ItemStack(BlockRegistry.storage, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.dustsMeta, 9, 2), new ItemStack(BlockRegistry.storage, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ingotsMeta, 9, 0), new ItemStack(BlockRegistry.storage, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.ingotsMeta, 9, 1), new ItemStack(BlockRegistry.storage, 1, 4));

        //tool recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelSword), "X", "X", "S", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelShovel), "X", "S", "S", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelPick), "XXX", " S ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelAxe), "XX ", "XS ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.steelHoe), "XX ", " S ", " S ", 'S', "stickWood", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelSword), "X", "X", "S", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelShovel), "X", "S", "S", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelPick), "XXX", " S ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelAxe), "XX ", "XS ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.starSteelHoe), "XX ", " S ", " S ", 'S', "stickWood", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)));

        //dye recipes
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 0), "O  ", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 1), " O ", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 2), "  O", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 3), "   ", "O  ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 4), "O O", " O ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 5), "   ", "  O", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 6), "   ", "   ", "O  ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 7), "   ", "   ", " O ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 8), "   ", "   ", "  O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 9), "  O", "   ", "  O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 10), "   ", " O ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 11), "O O", "   ", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 12), "   ", "O O", "   ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 13), "   ", "   ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 14), "O  ", "   ", "O  ", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.dye, 4, 15), "O O", "   ", "O O", 'O', new ItemStack(ItemRegistry.dustsMeta, 1, 0));

    }

    private static void registerBlocks() {
        //machines
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.mysticAnvil), "WWW", "IAI", "III", 'W', new ItemStack(Blocks.wool, 1, 14), 'A', Blocks.anvil, 'I', Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.metalForge, 8), "BBB", "BIB", "BBB", 'B', Blocks.stonebrick, 'I', Blocks.iron_block);
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.wandCarver), " GS", " OS", "SSS", 'G', Blocks.glass, 'S', new ItemStack(Blocks.stone_slab, 1, 0), 'O', ItemRegistry.dustsMeta);

        //magical blocks
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.ritualCornerStone), "CDC", "DRD", "CDC", 'C', BlockRegistry.containmentRing, 'D', ItemRegistry.dustsMeta, 'R', Blocks.redstone_block );
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentCornerstone), "OOO", "ONO", "OOO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentTop, 4), "OOO", "ONO", "ONO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.containmentPillar, 4), "ONO", "ONO", "ONO", 'O', BlockRegistry.containmentRing, 'N', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.containmentRing), new ItemStack(Blocks.obsidian), new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        
        //ingots to storage blocks
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 0), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 0));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 1), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 2), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 3), "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.storage, 1, 4), "XXX", "XXX", "XXX", 'X', "ingotSteel"));
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.potatoBlock,1),"XXX","XXX","XXX",'X',Items.potato);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), BlockRegistry.potatoBlock);

        for (int i = 0; i < 4; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.planks, 4,i),new ItemStack(BlockRegistry.logs,1,i));
            GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.sticksMeta,4,i), "W","W",'W',new ItemStack(BlockRegistry.planks,1,i));
        }
    }

    private static void registerMachines() {
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.iron_ingot), "molten.iron", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.iron_block), "molten.iron", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.coal, 1, 0), "gaseous.carbon", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Items.coal, 1, 1), "gaseous.carbon", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.coal_block), "gaseous.carbon", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(BlockRegistry.oresOres, 1, 0), "molten.star.steel", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(ItemRegistry.ingotsMeta, 1, 1), "molten.steel", TileEntityMetalForge.INGOT_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(BlockRegistry.storage, 1, 4), "molten.steel", TileEntityMetalForge.BLOCK_MB);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.iron_ore), "molten.iron", TileEntityMetalForge.INGOT_MB * 2);
        TileEntityMetalForge.registerMeltingItem(new ItemStack(Blocks.gold_ore), "molten.gold", TileEntityMetalForge.INGOT_MB * 2);

        RecipesMetalForge.addRecipe("molten.iron", TileEntityMetalForge.INGOT_MB, "gaseous.carbon", TileEntityMetalForge.INGOT_MB, new ItemStack(ItemRegistry.ingotsMeta, 1, 1));
        RecipesMetalForge.addRecipe("molten.steel", TileEntityMetalForge.INGOT_MB, "molten.star.steel", TileEntityMetalForge.INGOT_MB, new ItemStack(ItemRegistry.ingotsMeta, 1, 0));

        RecipesWandCarver.addRecipe(new ItemStack(Blocks.log, 1, 0), new ItemStack(ItemRegistry.chiselTool,1), new ItemStack(ItemRegistry.magiciansWand, 1), 100);
        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,0), new ItemStack(ItemRegistry.netherChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.magiciansWand2),200);
        RecipesWandCarver.addRecipe(new ItemStack(BlockRegistry.logs,1,2), new ItemStack(ItemRegistry.enderChisel,1,OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.magiciansWand3),400);
    }

    public static void registerModRecipes() {
        registerItems();
        registerBlocks();
        registerMachines();
    }
}