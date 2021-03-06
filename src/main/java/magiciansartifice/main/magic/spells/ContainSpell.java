package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import magiciansartifice.main.blocks.magicblocks.BlockRitualContainmentCornerstone;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ContainSpell extends BasicSpell{

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player) {
        super.beginSpell(world, x, y, z, player);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {
        for (int xx = x-7; xx < x + 7;xx++) {
            for (int yy = y-7; yy < y + 7; yy++) {
                for (int zz = z-7;zz < z + 7; zz++) {
                    if (world.getBlock(xx,yy,zz) instanceof BlockRitualContainmentCornerstone) {
                        TileEntityContainmentCornerstone te = (TileEntityContainmentCornerstone) world.getTileEntity(xx,yy,zz);
                        if (te != null) {
                            if (te.containmentReady(xx,yy-8,zz,world,player)) {
                                te.createField(world, player, xx, yy, zz);
                                super.performEffect(world, x, y, z, player);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
