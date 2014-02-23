package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    //@Override
    public static void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCustomDecorBoat.class,
                new RenderCustomBoat());
        RenderingRegistry.registerEntityRenderingHandler(EntityDecorCanopBoat.class,
                new RenderCanopBoat());
        RenderingRegistry.registerEntityRenderingHandler(EntityDude.class,
                new RenderCustomBiped(new ModelBiped(), 1));
        RenderingRegistry.registerEntityRenderingHandler(EntityFlag.class,
                new RenderFlag(new ModelFlag()));
    }
}
