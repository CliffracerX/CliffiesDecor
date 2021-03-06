package cliffracerx.mods.cliffiesdecor.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCanopBoat extends Render
{
    //private static final ResourceLocation boatTextures = new ResourceLocation("textures/entity/boat.png");

    /** instance of ModelCanopyBoat for rendering */
    protected ModelBase ModelCanopyBoat;

    public RenderCanopBoat()
    {
        this.shadowSize = 0.5F;
        this.ModelCanopyBoat = new ModelCanopyBoat();
    }

    /**
     * The render method used in RenderBoat that renders the boat model.
     */
    public void renderBoat(EntityDecorCanopBoat par1EntityDecorCanopBoat, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
        float f2 = (float)par1EntityDecorCanopBoat.getTimeSinceHit() - par9;
        float f3 = par1EntityDecorCanopBoat.getDamageTaken() - par9;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)par1EntityDecorCanopBoat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f4 = 1.25F;
        //GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(par1EntityDecorCanopBoat);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glRotatef(90, 0, 1, 0);
        GL11.glTranslatef(0, -0.9F, 0);
        this.ModelCanopyBoat.render(par1EntityDecorCanopBoat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getBoatTextures(EntityDecorCanopBoat par1EntityDecorCanopBoat)
    {
        return new ResourceLocation("cliffiesdecor:textures/entities/boats/"+par1EntityDecorCanopBoat.colors[par1EntityDecorCanopBoat.getColor()]+"Canopy.png");
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getBoatTextures((EntityDecorCanopBoat)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBoat((EntityDecorCanopBoat)par1Entity, par2, par4, par6, par8, par9);
    }
}
