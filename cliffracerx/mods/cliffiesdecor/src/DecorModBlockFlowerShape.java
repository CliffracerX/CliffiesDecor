package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DecorModBlockFlowerShape extends Block 
{
	private String tex;
	public DecorModBlockFlowerShape(int id, Material material, String texture) 
	{
		super(id, material);
		this.tex=texture;
		setTextureName("CliffiesDecor:"+texture);
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
}