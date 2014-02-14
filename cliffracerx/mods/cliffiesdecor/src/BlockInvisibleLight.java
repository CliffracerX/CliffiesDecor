package cliffracerx.mods.cliffiesdecor.src;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockInvisibleLight extends Block
{
    public BlockInvisibleLight(int var1)
    {
        super(var1, Material.air);
        this.setLightValue(1.0F);
        this.setHardness(0.1F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setTickRandomly(true);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var1.getBlockId(var2, var3, var4) == this.blockID)
        {
            var1.setBlock(var2, var3, var4, 0);
        }
    }

    public boolean isAirBlock(World var1, int var2, int var3, int var4)
    {
        return var1.getBlockId(var2, var3, var4) == this.blockID;
    }
}
