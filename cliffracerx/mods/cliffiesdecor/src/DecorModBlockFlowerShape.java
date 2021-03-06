package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class DecorModBlockFlowerShape extends Block
{
    private String tex;
    
    public DecorModBlockFlowerShape(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("CliffiesDecor:" + texture);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return 1;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
            int par2, int par3, int par4)
    {
        return null;
    }
}
