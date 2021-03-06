// Date: 2/21/2014 3:04:55 Pm o'clock.
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlag extends ModelBase
{
  //fields
    ModelRenderer Handle;
    ModelRenderer Flag;
  
  public ModelFlag()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Handle = new ModelRenderer(this, 0, 0);
      Handle.addBox(-1F, -16F, -1F, 2, 24, 2);
      Handle.setRotationPoint(0F, 16F, 0F);
      Handle.setTextureSize(32, 32);
      Handle.mirror = true;
      setRotation(Handle, 0F, 0F, 0F);
      Flag = new ModelRenderer(this, 8, 0);
      Flag.addBox(-4F, -1F, -0.5F, 8, 12, 1);
      Flag.setRotationPoint(0F, 1F, 0F);
      Flag.setTextureSize(32, 32);
      Flag.mirror = true;
      setRotation(Flag, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Handle.render(f5);
    Flag.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}
