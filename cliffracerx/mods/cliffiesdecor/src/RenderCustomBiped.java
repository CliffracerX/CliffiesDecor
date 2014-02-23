package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCustomBiped extends RenderBiped
{
    
    public RenderCustomBiped(ModelBiped par1ModelBiped, float par2)
    {
        super(par1ModelBiped, par2);
    }

    @Override
    public void doRender(Entity entity, double d0, double d1, double d2,
            float f, float f1)
    {
        super.doRender(entity, d0, d1, d2, f, f1);
        
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        EntityDude dude = (EntityDude)entity;
        return new ResourceLocation(dude.getTexture());
    }
    
}
