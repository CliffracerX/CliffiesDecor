// Date: 2/21/2014 2:50:54 Pm o'clock.
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package cliffracerx.mods.cliffiesdecor.src;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDude extends ModelBiped
{
  //fields
    ModelRenderer SelectBack;
    ModelRenderer SelectFront;
    ModelRenderer SelectLeft;
    ModelRenderer SelectRight;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ModelDude()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      SelectBack = new ModelRenderer(this, 24, 0);
      SelectBack.addBox(-8F, 0F, -1F, 16, 2, 2);
      SelectBack.setRotationPoint(0F, 22F, 8F);
      SelectBack.setTextureSize(64, 32);
      SelectBack.mirror = true;
      setRotation(SelectBack, 0F, 0F, 0F);
      SelectFront = new ModelRenderer(this, 24, 0);
      SelectFront.addBox(-8F, 0F, -1F, 16, 2, 2);
      SelectFront.setRotationPoint(0F, 22F, -9F);
      SelectFront.setTextureSize(64, 32);
      SelectFront.mirror = true;
      setRotation(SelectFront, 0F, 0F, 0F);
      SelectLeft = new ModelRenderer(this, 24, 0);
      SelectLeft.addBox(-8F, 0F, -1F, 16, 2, 2);
      SelectLeft.setRotationPoint(9F, 22F, 0F);
      SelectLeft.setTextureSize(64, 32);
      SelectLeft.mirror = true;
      setRotation(SelectLeft, 0F, 1.570796F, 0F);
      SelectRight = new ModelRenderer(this, 24, 0);
      SelectRight.addBox(-8F, 0F, -1F, 16, 2, 2);
      SelectRight.setRotationPoint(-9F, 22F, 0F);
      SelectRight.setTextureSize(64, 32);
      SelectRight.mirror = true;
      setRotation(SelectRight, 0F, 1.570796F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -0.4089647F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0.5576792F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0.4833219F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, -0.2230717F, 0F, 0F);
  }
  
  public void render(EntityDude entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    SelectBack.render(f5);
    SelectFront.render(f5);
    SelectLeft.render(f5);
    SelectRight.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
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
