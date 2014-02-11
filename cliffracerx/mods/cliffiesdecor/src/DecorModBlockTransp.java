package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DecorModBlockTransp extends Block
{
    private String tex;
    
    public DecorModBlockTransp(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("CliffiesDecor:" + texture);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
}
