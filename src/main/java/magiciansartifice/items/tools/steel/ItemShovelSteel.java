package magiciansartifice.items.tools.steel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.item.ItemSpade;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemShovelSteel extends ItemSpade {
    public ItemShovelSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".steel.shovel");
        this.setTextureName(ModInfo.MODID + ":tools/steelShovel");
        ItemRegistry.items.add(this);
    }
}