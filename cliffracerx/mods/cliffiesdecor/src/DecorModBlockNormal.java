package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DecorModBlockNormal extends Block
{
    private String tex;
    
    public DecorModBlockNormal(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("CliffiesDecor:" + texture);
    }
}
