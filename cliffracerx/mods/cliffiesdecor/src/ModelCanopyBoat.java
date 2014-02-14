package cliffracerx.mods.cliffiesdecor.src;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCanopyBoat extends ModelBase
{
    ModelRenderer Main_Hull;
    ModelRenderer Right_Wall;
    ModelRenderer Right_Canopy;
    ModelRenderer Left_Wall;
    ModelRenderer Left_Canopy;
    ModelRenderer Back;
    ModelRenderer Back_Canopy;
    ModelRenderer Top_Canopy;
    ModelRenderer Front;
    ModelRenderer Front_Canopy;
    ModelRenderer Front_Tip;
    ModelRenderer Mast;
    ModelRenderer Boom;
    ModelRenderer Sail_01;
    ModelRenderer Sail_02;
    ModelRenderer Sail_03;
    ModelRenderer Sail_04;

    public ModelCanopyBoat()
    {
        this( 0.0f );
    }

    public ModelCanopyBoat( float par1 )
    {
        Main_Hull = new ModelRenderer( this, 0*2, 0*2 );
        Main_Hull.setTextureSize( 256, 256 );
        Main_Hull.addBox( -8F*2, -1F*2, -16F*2, 16*2, 2*2, 32*2);
        Main_Hull.setRotationPoint( 0F, 20F, 16F );
        Right_Wall = new ModelRenderer( this, 0*2, 40*2 );
        Right_Wall.setTextureSize( 256, 256 );
        Right_Wall.addBox( -1F*2, -2F*2, -16F*2, 2*2, 4*2, 32*2);
        Right_Wall.setRotationPoint( -18F, 14F, 16F );
        Right_Canopy = new ModelRenderer( this, 0*2, 76*2 );
        Right_Canopy.setTextureSize( 256, 256 );
        Right_Canopy.addBox( -1F*2, -2F*2, -12F*2, 2*2, 4*2, 24*2);
        Right_Canopy.setRotationPoint( -18F, 6F, 24F );
        Left_Wall = new ModelRenderer( this, 0*2, 40*2 );
        Left_Wall.setTextureSize( 256, 256 );
        Left_Wall.addBox( -1F*2, -2F*2, -16F*2, 2*2, 4*2, 32*2);
        Left_Wall.setRotationPoint( 18F, 14F, 16F );
        Left_Canopy = new ModelRenderer( this, 20*2, 76*2 );
        Left_Canopy.setTextureSize( 256, 256 );
        Left_Canopy.addBox( -1F*2, -2F*2, -16F*2, 2*2, 4*2, 32*2);
        Left_Canopy.setRotationPoint( 18F, 6F, 16F );
        Back = new ModelRenderer( this, 0*2, 34*2 );
        Back.setTextureSize( 256, 256 );
        Back.addBox( -8F*2, -2F*2, -1F*2, 16*2, 4*2, 2*2);
        Back.setRotationPoint( 0F, 14F, 50F );
        Back_Canopy = new ModelRenderer( this, 36*2, 34*2 );
        Back_Canopy.setTextureSize( 256, 256 );
        Back_Canopy.addBox( -8F*2, -2F*2, -1F*2, 16*2, 4*2, 2*2);
        Back_Canopy.setRotationPoint( 0F, 6F, 50F );
        Top_Canopy = new ModelRenderer( this, 60*2, 85*2 );
        Top_Canopy.setTextureSize( 256, 256 );
        Top_Canopy.addBox( -5.5F*2, -0.5F*10, -31.5F*2+10, 11*2, 1*2, 15*2);
        Top_Canopy.setRotationPoint( 0F, 3F, 49F );
        Front = new ModelRenderer( this, 0*2, 34*2 );
        Front.setTextureSize( 256, 256 );
        Front.addBox( -8F*2, -2F*2, -1F*2, 16*2, 4*2, 2*2);
        Front.setRotationPoint( 0F, 14F, -18F );
        Front_Canopy = new ModelRenderer( this, 36*2, 40*2 );
        Front_Canopy.setTextureSize( 256, 256 );
        Front_Canopy.addBox( -8F*2, -2F*2, -1F*2, 16*2, 4*2, 2*2);
        Front_Canopy.setRotationPoint( 0F, 6F, -18F );
        Front_Tip = new ModelRenderer( this, 64*2, 8*2 );
        Front_Tip.setTextureSize( 256, 256 );
        Front_Tip.addBox( -4F*2, -4F*2, -15F*2, 8*2, 8*2, 16*2);
        Front_Tip.setRotationPoint( 0F, 11F, -20F );
        Mast = new ModelRenderer( this, 72*2, 35*2 );
        Mast.setTextureSize( 256, 256 );
        Mast.addBox( -9F, -45F*1.25F, -3F, 2*2, 32*2, 2*2);
        Mast.setRotationPoint( 6F, 14F, -6F );
        Boom = new ModelRenderer( this, 76*2, 77*2 );
        Boom.setTextureSize( 256, 256 );
        Boom.addBox( -35F*1.25F+6F, -1F*10F, -1F*1.25F-9F, 24*2, 2*2, 2*2);
        Boom.setRotationPoint( 7F, 0F, -6F );
        Sail_01 = new ModelRenderer( this, 78*2, 2*2 );
        Sail_01.setTextureSize( 256, 256 );
        Sail_01.addBox( -10F*1.8F+6F, -7.5F*1.8F, -0.5F*1.8F-9F, 20*2, 5*2, 1*2);
        Sail_01.setRotationPoint( 18F, -2F, 13.05256F );
        Sail_02 = new ModelRenderer( this, 89*2, 35*2 );
        Sail_02.setTextureSize( 256, 256 );
        Sail_02.addBox( -14.5F*1.8F+6F, -6F*1.8F, -0.5F*1.8F-9F, 17*2, 4*2, 1*2);
        Sail_02.setRotationPoint( 13.5F, -12F, 5.25833F );
        Sail_03 = new ModelRenderer( this, 2*2, 2*2 );
        Sail_03.setTextureSize( 256, 256 );
        Sail_03.addBox( -13F*1.8F+6F, -6F*1.8F, -0.5F*1.8F-9F, 14*2, 4*2, 1*2);
        Sail_03.setRotationPoint( 10.5F, -20F, 0.06217744F );
        Sail_04 = new ModelRenderer( this, 7*2, 9*2 );
        Sail_04.setTextureSize( 256, 256 );
        Sail_04.addBox( -11.5F*1.8F+6F, -8F*1.8F, -0.5F*1.8F-9F, 11*2, 8*2, 1*2);
        Sail_04.setRotationPoint( 9.500001F, -32F, -1.669873F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Main_Hull.rotateAngleX = 0F;
        Main_Hull.rotateAngleY = 0F;
        Main_Hull.rotateAngleZ = 0F;
        Main_Hull.renderWithRotation(par7);

        Right_Wall.rotateAngleX = 0F;
        Right_Wall.rotateAngleY = 0F;
        Right_Wall.rotateAngleZ = 0F;
        Right_Wall.renderWithRotation(par7);
        
        Right_Canopy.rotateAngleX = 0F;
        Right_Canopy.rotateAngleY = 0F;
        Right_Canopy.rotateAngleZ = 0F;
        Right_Canopy.renderWithRotation(par7);

        Left_Wall.rotateAngleX = 0F;
        Left_Wall.rotateAngleY = 0F;
        Left_Wall.rotateAngleZ = 0F;
        Left_Wall.renderWithRotation(par7);
        
        Left_Canopy.rotateAngleX = 0F;
        Left_Canopy.rotateAngleY = 0F;
        Left_Canopy.rotateAngleZ = 0F;
        Left_Canopy.renderWithRotation(par7);

        Back.rotateAngleX = 0F;
        Back.rotateAngleY = 0F;
        Back.rotateAngleZ = 0F;
        Back.renderWithRotation(par7);
        
        Back_Canopy.rotateAngleX = 0F;
        Back_Canopy.rotateAngleY = 0F;
        Back_Canopy.rotateAngleZ = 0F;
        Back_Canopy.renderWithRotation(par7);

        Top_Canopy.rotateAngleX = 0F;
        Top_Canopy.rotateAngleY = 0F;
        Top_Canopy.rotateAngleZ = 0F;
        GL11.glScalef(2, 2, 2);
        Top_Canopy.renderWithRotation(par7);
        GL11.glScalef(0.5f, 0.5f, 0.5f);

        Front.rotateAngleX = 0F;
        Front.rotateAngleY = 0F;
        Front.rotateAngleZ = 0F;
        Front.renderWithRotation(par7);
        
        Front_Canopy.rotateAngleX = 0F;
        Front_Canopy.rotateAngleY = 0F;
        Front_Canopy.rotateAngleZ = 0F;
        Front_Canopy.renderWithRotation(par7);

        Front_Tip.rotateAngleX = -0.1475227F;
        Front_Tip.rotateAngleY = 0F;
        Front_Tip.rotateAngleZ = 0F;
        Front_Tip.renderWithRotation(par7);

        Mast.rotateAngleX = 0F;
        Mast.rotateAngleY = 0F;
        Mast.rotateAngleZ = 0F;
        Mast.renderWithRotation(par7);

        Boom.rotateAngleX = 0F;
        Boom.rotateAngleY = 2.094395F;
        Boom.rotateAngleZ = 0F;
        Boom.renderWithRotation(par7);

        Sail_01.rotateAngleX = 0F;
        Sail_01.rotateAngleY = 2.094395F;
        Sail_01.rotateAngleZ = 0F;
        Sail_01.renderWithRotation(par7);

        Sail_02.rotateAngleX = 0F;
        Sail_02.rotateAngleY = 2.094395F;
        Sail_02.rotateAngleZ = 0F;
        Sail_02.renderWithRotation(par7);

        Sail_03.rotateAngleX = 0F;
        Sail_03.rotateAngleY = 2.094395F;
        Sail_03.rotateAngleZ = 0F;
        Sail_03.renderWithRotation(par7);

        Sail_04.rotateAngleX = 0F;
        Sail_04.rotateAngleY = 2.094395F;
        Sail_04.rotateAngleZ = 0F;
        Sail_04.renderWithRotation(par7);

    }

}
