package cliffracerx.mods.cliffiesdecor.src;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityDude extends EntityCreature
{
        //private String color="";
        private int colorInt=0;
        private int battalionID = 0;
        //public boolean selected = false;
        public final EntityAITasks tasks;
        public final EntityAITasks targetTasks;
        private String[] colors = {"Red", "Orange", "Yellow", "Lime", "Green", "Cyan", "Blue", "Purple"};
        public EntityDude(World world)
        {
                super(world);
                System.out.println("Reporting for duty!");
                this.tasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
                this.targetTasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
                this.tasks.addTask(1, new EntityAILookIdle(this));
                this.tasks.addTask(1, new EntityAISwimming(this));
        }
        
        public EntityDude(World world, int color, int bat)
        {
            super(world);
            this.setColor(color);
            this.setBatInt(bat);
            this.colorInt=color;
            this.battalionID=bat;
            this.tasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
            this.targetTasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
        }
        
        public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readEntityFromNBT(par1NBTTagCompound);
            this.setColor(par1NBTTagCompound.getInteger("Color"));
            this.setBatInt(par1NBTTagCompound.getInteger("Battalion"));
        }

        /**
         * (abstract) Protected helper method to write subclass entity data to NBT.
         */
        public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeEntityToNBT(par1NBTTagCompound);
            par1NBTTagCompound.setInteger("Color", this.getColor());
            par1NBTTagCompound.setInteger("Battalion", this.getBat());
        }


        protected int getDropItemId()
        {
                return 0;
        }
        
        protected void dropFewItems(boolean par1, int par2)
        {
        }
        
        private AxisAlignedBB getTargetArea(double rad)
        {
            double radius = rad;
            return AxisAlignedBB.getBoundingBox(this.posX - radius, this.posY
                    - radius, this.posZ - radius, this.posX + radius, this.posY
                    + radius, this.posZ + radius);
        }
        
        public void onUpdate()
        {
            super.onUpdate();
            List<EntityDude> dudes =
                    (List<EntityDude>) this.worldObj
                            .getEntitiesWithinAABB(EntityDude.class,
                                    this.getTargetArea(16.0D));
            for (EntityDude dude : dudes)
            {
                if (dude.getColor() == this.getColor())
                    continue;
                if (dude.isDead)
                    continue;
                if (!this.canEntityBeSeen(dude))
                    continue;
                if (rand.nextInt(4) != 0)
                    continue;
                
                this.entityToAttack = dude;
                
                break;
            }
            List<EntityFlag> flags =
                    (List<EntityFlag>) this.worldObj
                            .getEntitiesWithinAABB(EntityFlag.class,
                                    this.getTargetArea(512.0D));
            for (EntityFlag flag : flags)
            {
                if (flag.getColor() != this.getColor())
                    continue;
                if (flag.isDead)
                    continue;
                if (flag.getBat() != this.getBat())
                    continue;
                
                this.entityToAttack = flag;
                
                break;
            }
            /*EntityDude var1 = (EntityDude) this.worldObj.findNearestEntityWithinAABB(EntityDude.class, this.boundingBox.expand(16.0D*16, 8.0D*16, 16.0D*16), this);
            if(var1!=null)
            {
            if(var1.getColor()!=this.getColor())
            this.entityToAttack=var1;
            }
            EntityFlag var2 = (EntityFlag) this.worldObj.findNearestEntityWithinAABB(EntityFlag.class, this.boundingBox.expand(256.0D*12, 128.0D*12, 256.0D*12), this);
            if(var2!=null)
            {
            if(var2.getColor()==this.getColor() && var2.getBat()==this.getBat())
            this.entityToAttack=var2;
            }*/
        }
        
        public String getTexture()
        {           
            return "cliffiesdecor:textures/entities/soldiers/r"+this.colors[this.dataWatcher.getWatchableObjectInt(18)]+".png";
        }
        
        private void doClientStuff()
        {
            //System.out.println("My color is:"+this.getColor());
        }

        protected void attackEntity(Entity par1Entity, float par2)
        {
            if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
            {
                this.attackTime = 20;
                this.attackEntityAsMob(par1Entity);
            }
        }
        
        public boolean attackEntityAsMob(Entity par1Entity)
        {
            this.setLastAttacker(par1Entity);
            par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength(par1Entity));
            this.swingItem();
            return false;
        }
        
        private int getArmSwingAnimationEnd()
        {
            return this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6)*2;
        }
        
        public void swingItem()
        {
            //System.out.println("SwingItem()");
            if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0)
            {
                //System.out.println("SWINGING HAND");
                this.swingProgressInt = -2;
                this.isSwingInProgress = true;

                if (this.worldObj instanceof WorldServer)
                {
                    //System.out.println("SWINGING HAND-2");
                    ((WorldServer)this.worldObj).getEntityTracker().sendPacketToAllPlayersTrackingEntity(this, new Packet18Animation(this, 1));
                }
            }
        }
        
        protected void updateArmSwingProgress()
        {
            //System.out.println("Updating armSwingProgress");
            int var1 = this.getArmSwingAnimationEnd();

            if (this.isSwingInProgress)
            {
                ++this.swingProgressInt;

                if (this.swingProgressInt >= var1)
                {
                    this.swingProgressInt = 0;
                    this.isSwingInProgress = false;
                    //System.out.println("Swing finished.");
                }
            }
            else
            {
                this.swingProgressInt = 0;
            }

            this.swingProgress = (float)this.swingProgressInt / (float)var1;
        }
        
        public boolean interact(EntityPlayer par1EntityPlayer)
        {
            if(par1EntityPlayer.getHeldItem()!=null)
            {
                if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemMover)
                {
                    ItemMover mov = (ItemMover)par1EntityPlayer.getHeldItem().getItem();
                    mov.batInt=this.getBat();
                    mov.color=this.getColor();
                }
            }
            ItemStack[] lastItems = this.getLastActiveItems();
            //if(this.armortypeHead==0)
            {
                if(par1EntityPlayer.getHeldItem()!= null)
                {
                if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
                {
                    ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
                    if(armoritem.armorType==0)
                    {
                    //this.armortypeHead=par1EntityPlayer.getHeldItem().itemID;
                    this.setCurrentItemOrArmor(4, par1EntityPlayer.getHeldItem());
                    this.removeItem(par1EntityPlayer);
                    return true;
                    }
                }
                }
            }
            //else
            {
                if(par1EntityPlayer.getHeldItem()==null)
                {
                this.dropItem(lastItems[4], 1);
                //this.armortypeHead=0;
                this.setCurrentItemOrArmor(4, null);
                }
            }
            //if(this.armortypeChest==0)
            {
                if(par1EntityPlayer.getHeldItem()!= null)
                {
                if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
                {
                    ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
                    if(armoritem.armorType==1)
                    {
                    //this.armortypeChest=par1EntityPlayer.getHeldItem().itemID;
                    this.setCurrentItemOrArmor(3, par1EntityPlayer.getHeldItem());
                    this.removeItem(par1EntityPlayer);
                    return true;
                    }
                }
                }
            }
            //else
            {
                if(par1EntityPlayer.getHeldItem()==null)
                {
                this.dropItem(lastItems[3], 1);
                //this.armortypeChest=0;
                this.setCurrentItemOrArmor(3, par1EntityPlayer.getHeldItem());
                }
            }
            //if(this.armortypeLegs==0)
            {
                if(par1EntityPlayer.getHeldItem()!= null)
                {
                if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
                {
                    ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
                    if(armoritem.armorType==2)
                    {
                    //this.armortypeLegs=par1EntityPlayer.getHeldItem().itemID;
                    this.setCurrentItemOrArmor(2, par1EntityPlayer.getHeldItem());
                    this.removeItem(par1EntityPlayer);
                    return true;
                    }
                }
                }
            }
            //else
            {
                if(par1EntityPlayer.getHeldItem()==null)
                {
                this.dropItem(lastItems[2], 1);
                //this.armortypeLegs=0;
                this.setCurrentItemOrArmor(2, null);
                }
            }
            //if(this.armortypeBoots==0)
            {
                if(par1EntityPlayer.getHeldItem()!= null)
                {
                if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
                {
                    ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
                    if(armoritem.armorType==3)
                    {
                    //this.armortypeBoots=par1EntityPlayer.getHeldItem().itemID;
                    this.setCurrentItemOrArmor(1, par1EntityPlayer.getHeldItem());
                    this.removeItem(par1EntityPlayer);
                    return true;
                    }
                }
                }
            }
            //else
            {
                if(par1EntityPlayer.getHeldItem()==null)
                {
                this.dropItem(lastItems[1], 1);
                //this.armortypeBoots=0;
                this.setCurrentItemOrArmor(1, null);
                }
            }
            //if(this.stickStuff==0)
            {
            if(par1EntityPlayer.getHeldItem()!=null)
            {
                //this.stickStuff=par1EntityPlayer.getHeldItem().itemID;
                if(!(par1EntityPlayer.getHeldItem().getItem() instanceof ItemMover))
                {
                this.setCurrentItemOrArmor(0, par1EntityPlayer.getHeldItem());
                this.removeItem(par1EntityPlayer);
                }
                return true;
            }
            }
            //else
            {
            if(par1EntityPlayer.getHeldItem()==null)
            {
                this.dropItem(lastItems[0], 1);
                //this.stickStuff=0;
                this.setCurrentItemOrArmor(0, null);
            }
            }
            return true;
        }
        
        /**
         * Returns the amount of damage a mob should deal.
         */
        public int getAttackStrength(Entity par1Entity)
        {
            if(par1Entity instanceof EntityFlag)
                return 5;
            else if(par1Entity instanceof EntityDude)
            {
            ItemStack thisHeldItem = this.getLastActiveItems()[0];
            Multimap mods = null;
            int damage = 1;
            Collection temp = null;
            if(thisHeldItem!=null)
                mods = thisHeldItem.getItem().getItemAttributeModifiers();
            if(mods!=null)
                if(!(mods.isEmpty()))
                    temp=mods.get(0);
            if(temp!=null && temp.toArray().length>0)
                damage=(Integer) temp.toArray()[0];
            if(thisHeldItem!=null)
                return (int) damage;
            else
                return 1;
            }
            else
                return 1;
        }

        public int getColor() {
            return this.dataWatcher.getWatchableObjectInt(18);
        }
        
        public void setColorInt(int clr)
        {
            this.colorInt=clr;
            this.dataWatcher.updateObject(18, clr);
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
            this.dataWatcher.updateObject(18, color);
        }
        
        public float getAIMoveSpeed()
        {
            if(this.entityToAttack!=null)
                return 0.5F;
            else
                return 0;
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
            this.updateArmSwingProgress();
        }
        
        public void removeItem(EntityPlayer par1EntityPlayer)
        {
            /*if(par1EntityPlayer.capabilities.isCreativeMode==false)
            {
            if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
            par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
            else
                par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
            }*/
            //Don't lose items any more,should making equipping battalions of dudes in survival less of a pain.
        }
        
        /**
         * Drops an item stack at the entity's position. Args: itemID, count
         */
        public EntityItem dropItem(ItemStack par1, int par2)
        {
            /*if(par1!=null && !this.worldObj.isRemote)
            return this.dropItemWithOffset(par1, par2, 0.0F);
            else*/
            return null;
        }
        
        public EntityItem dropItemWithOffset(ItemStack par1, int par2, float par3)
        {
            return this.entityDropItem(par1, par3);
        }
}