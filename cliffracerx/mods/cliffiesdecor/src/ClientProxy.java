package cliffracerx.mods.cliffiesdecor.src;

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
    }
}
