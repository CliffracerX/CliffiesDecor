package cliffracerx.mods.cliffiesdecor.src;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityFlag extends EntityCreature
{
        private String color="";
        private int colorInt=0;
        private int battalionID = 0;
        private String[] colors = {"Red", "Orange", "Yellow", "Lime", "Green", "Cyan", "Blue", "Purple"};
        public EntityFlag(World world)
        {
                super(world);
                System.out.println("Flagimication.");
                while(this.tasks.taskEntries.size()>0)
                {
                    this.tasks.taskEntries.remove(0);
                }
                this.tasks.addTask(1, new EntityAILookIdle(this));
                this.tasks.addTask(1, new EntityAISwimming(this));
        }
        
        public EntityFlag(World world, int color, int bat)
        {
            super(world);
            this.setColor(color);
            this.setBatInt(bat);
            this.colorInt=color;
            this.battalionID=bat;
        }
        
        public float getAIMoveSpeed()
        {
            return 0;
        }
        
        public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readEntityFromNBT(par1NBTTagCompound);
            this.setColor(par1NBTTagCompound.getInteger("Color"));
        }

        /**
         * (abstract) Protected helper method to write subclass entity data to NBT.
         */
        public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeEntityToNBT(par1NBTTagCompound);
            par1NBTTagCompound.setInteger("Color", this.getColor());
        }


        protected int getDropItemId()
        {
                return 0;
        }
        
        protected void dropFewItems(boolean par1, int par2)
        {
        }
        
        public void onUpdate()
        {
            super.onUpdate();
            //Nope.
        }
        
        public String getTexture()
        {           
            return "cliffiesdecor:textures/entities/soldiers/f"+this.colors[this.dataWatcher.getWatchableObjectInt(18)]+".png";
        }

        public int getColor() {
            return this.dataWatcher.getWatchableObjectInt(18);
        }
        
        public void setColorInt(int clr)
        {
            this.colorInt=clr;
        }
        
        public int getBat() {
            return this.battalionID;
        }
        
        public void setBatInt(int i)
        {
            this.battalionID=i;
        }

        public void setColor(int color) {
            this.colorInt = color;
            this.dataWatcher.updateObject(18, this.colorInt);
        }
        
        @Override
        protected boolean canDespawn()
        {
            return false;
        }

        protected void entityInit()
        {
            super.entityInit();
            this.dataWatcher.addObject(18, 0);
        }
        
        @SideOnly(Side.CLIENT)
        public void onEntityUpdate()
        {
            super.onEntityUpdate();
        }
}