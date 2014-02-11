package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DecorModLampOff extends Block
{
    private String tex;
    
    public DecorModLampOff(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("CliffiesDecor:" + texture);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3,
            int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
            float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par1World.setBlock(par2, par3, par4, this.blockID - 1);
            return true;
        }
    }
}
