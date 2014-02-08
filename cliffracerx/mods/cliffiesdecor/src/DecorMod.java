package cliffracerx.mods.cliffiesdecor.src;

import sanandreasp.mods.ClaySoldiersMod.registry.SoldierTeams;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="DecorMod", name="Cliffie's Decorations", version="Alpha 0.01a")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class DecorMod
{
	public final static CreativeTabs tab = new DecorTab("cDecor");
    public final static Block DMlawnBlock = new DecorModBlockNormal(1000, Material.grass, "lawn").setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("DMlawnBlock").setCreativeTab(tab);
    public final static Block DMHedge = new DecorModBlockTransp(1001, Material.grass, "hedge").setHardness(0.25F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("DMHedge").setCreativeTab(tab);
    public final static Block rWood = new DecorModBlockNormal(1002, Material.wood, "rWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rWood").setCreativeTab(tab);
    public final static Block rWool = new DecorModBlockNormal(1003, Material.cloth, "rWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("rWool").setCreativeTab(tab);
    public final static Block rLantern = new DecorModBlockFlowerShape(1004, Material.cloth, "rLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("rLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block rLampOn = new DecorModLampOn(1005, Material.circuits, "rLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("rLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block rLampOff = new DecorModLampOff(1006, Material.circuits, "rLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("rLampOff").setCreativeTab(tab);
    public final static Block oWood = new DecorModBlockNormal(1007, Material.wood, "oWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("oWood").setCreativeTab(tab);
    public final static Block oWool = new DecorModBlockNormal(1008, Material.cloth, "oWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("oWool").setCreativeTab(tab);
    public final static Block oLantern = new DecorModBlockFlowerShape(1009, Material.cloth, "oLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("oLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block oLampOn = new DecorModLampOn(1010, Material.circuits, "oLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("oLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block oLampOff = new DecorModLampOff(1011, Material.circuits, "oLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("oLampOff").setCreativeTab(tab);
    public final static Block yWood = new DecorModBlockNormal(1012, Material.wood, "yWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("yWood").setCreativeTab(tab);
    public final static Block yWool = new DecorModBlockNormal(1013, Material.cloth, "yWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("yWool").setCreativeTab(tab);
    public final static Block yLantern = new DecorModBlockFlowerShape(1014, Material.cloth, "yLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("yLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block yLampOn = new DecorModLampOn(1015, Material.circuits, "yLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("yLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block yLampOff = new DecorModLampOff(1016, Material.circuits, "yLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("yLampOff").setCreativeTab(tab);
    public final static Block lWood = new DecorModBlockNormal(1017, Material.wood, "lWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("lWood").setCreativeTab(tab);
    public final static Block lWool = new DecorModBlockNormal(1018, Material.cloth, "lWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("lWool").setCreativeTab(tab);
    public final static Block lLantern = new DecorModBlockFlowerShape(1019, Material.cloth, "lLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("lLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block lLampOn = new DecorModLampOn(1020, Material.circuits, "lLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("lLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block lLampOff = new DecorModLampOff(1021, Material.circuits, "lLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("lLampOff").setCreativeTab(tab);
    public final static Block gWood = new DecorModBlockNormal(1022, Material.wood, "gWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gWood").setCreativeTab(tab);
    public final static Block gWool = new DecorModBlockNormal(1023, Material.cloth, "gWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("gWool").setCreativeTab(tab);
    public final static Block gLantern = new DecorModBlockFlowerShape(1024, Material.cloth, "gLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("gLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block gLampOn = new DecorModLampOn(1025, Material.circuits, "gLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("gLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block gLampOff = new DecorModLampOff(1026, Material.circuits, "gLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("gLampOff").setCreativeTab(tab);
    public final static Block cWood = new DecorModBlockNormal(1027, Material.wood, "cWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("cWood").setCreativeTab(tab);
    public final static Block cWool = new DecorModBlockNormal(1028, Material.cloth, "cWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("cWool").setCreativeTab(tab);
    public final static Block cLantern = new DecorModBlockFlowerShape(1029, Material.cloth, "cLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("cLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block cLampOn = new DecorModLampOn(1030, Material.circuits, "cLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("cLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block cLampOff = new DecorModLampOff(1031, Material.circuits, "cLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("cLampOff").setCreativeTab(tab);
    public final static Block bWood = new DecorModBlockNormal(1032, Material.wood, "bWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("bWood").setCreativeTab(tab);
    public final static Block bWool = new DecorModBlockNormal(1033, Material.cloth, "bWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("bWool").setCreativeTab(tab);
    public final static Block bLantern = new DecorModBlockFlowerShape(1034, Material.cloth, "bLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("bLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block bLampOn = new DecorModLampOn(1035, Material.circuits, "bLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block bLampOff = new DecorModLampOff(1036, Material.circuits, "bLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bLampOff").setCreativeTab(tab);
    public final static Block pWood = new DecorModBlockNormal(1037, Material.wood, "pWood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pWood").setCreativeTab(tab);
    public final static Block pWool = new DecorModBlockNormal(1038, Material.cloth, "pWool").setHardness(0.25F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("pWool").setCreativeTab(tab);
    public final static Block pLantern = new DecorModBlockFlowerShape(1039, Material.cloth, "pLantern").setHardness(0.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("pLantern").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block pLampOn = new DecorModLampOn(1040, Material.circuits, "pLampOn").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("pLampOn").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block pLampOff = new DecorModLampOff(1041, Material.circuits, "pLampOff").setHardness(0.75F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("pLampOff").setCreativeTab(tab);
    
    ResourceLocation[][] res = new ResourceLocation[][] { // custom clay soldier textures
    		new ResourceLocation[] { // Red team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cRed.png")
                },
    		new ResourceLocation[] { // Orange team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cOrange.png")
                },
    		new ResourceLocation[] { // Yellow team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cYellow.png")
                },
    		new ResourceLocation[] { // Lime team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cLime.png")
                },
                new ResourceLocation[] { // Green team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cGreen.png")
                },
                new ResourceLocation[] { // Cyan team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cCyan.png")
                },
                new ResourceLocation[] { // Blue team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cBlue.png")
                },
                new ResourceLocation[] { // Purple team
                    new ResourceLocation("cliffiesdecor", "textures/entities/soldiers/cPurple.png")
                },
    };
    		
    
    
	@Instance("DecorMod")
	public static DecorMod instance;
	
	@SidedProxy(clientSide="cliffracerx.mods.cliffiesdecor.src.ClientProxy", serverSide="cliffracerx.mods.cliffiesdecor.src.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LanguageRegistry.addName(DMlawnBlock, "Decor Mod Lawn");
		GameRegistry.registerBlock(DMlawnBlock, "DMlawnBlock");
		LanguageRegistry.addName(DMHedge, "Decor Mod Hedge");
		GameRegistry.registerBlock(DMHedge, "DMHedge");
		LanguageRegistry.addName(rWood, "Red Stained Wood");
		GameRegistry.registerBlock(rWood, "rWood");
		LanguageRegistry.addName(rWool, "Red Decor Wool");
		GameRegistry.registerBlock(rWool, "rWool");
		LanguageRegistry.addName(rLantern, "Red Paper Lantern");
		GameRegistry.registerBlock(rLantern, "rLantern");
		LanguageRegistry.addName(rLampOn, "Red Lamp On");
		GameRegistry.registerBlock(rLampOn, "rLampOn");
		LanguageRegistry.addName(rLampOff, "Red Lamp Off");
		GameRegistry.registerBlock(rLampOff, "rLampOff");
		LanguageRegistry.addName(oWood, "Orange Stained Wood");
		GameRegistry.registerBlock(oWood, "oWood");
		LanguageRegistry.addName(oWool, "Orange Decor Wool");
		GameRegistry.registerBlock(oWool, "oWool");
		LanguageRegistry.addName(oLantern, "Orange Paper Lantern");
		GameRegistry.registerBlock(oLantern, "oLantern");
		LanguageRegistry.addName(oLampOn, "Orange Lamp On");
		GameRegistry.registerBlock(oLampOn, "oLampOn");
		LanguageRegistry.addName(oLampOff, "Orange Lamp Off");
		GameRegistry.registerBlock(oLampOff, "oLampOff");
		LanguageRegistry.addName(yWood, "Yellow Stained Wood");
		GameRegistry.registerBlock(yWood, "yWood");
		LanguageRegistry.addName(yWool, "Yellow Decor Wool");
		GameRegistry.registerBlock(yWool, "yWool");
		LanguageRegistry.addName(yLantern, "Yellow Paper Lantern");
		GameRegistry.registerBlock(yLantern, "yLantern");
		LanguageRegistry.addName(yLampOn, "Yellow Lamp On");
		GameRegistry.registerBlock(yLampOn, "yLampOn");
		LanguageRegistry.addName(yLampOff, "Yellow Lamp Off");
		GameRegistry.registerBlock(yLampOff, "yLampOff");
		LanguageRegistry.addName(lWood, "Lime Stained Wood");
		GameRegistry.registerBlock(lWood, "lWood");
		LanguageRegistry.addName(lWool, "Lime Decor Wool");
		GameRegistry.registerBlock(lWool, "lWool");
		LanguageRegistry.addName(lLantern, "Lime Paper Lantern");
		GameRegistry.registerBlock(lLantern, "lLantern");
		LanguageRegistry.addName(lLampOn, "Lime Lamp On");
		GameRegistry.registerBlock(lLampOn, "lLampOn");
		LanguageRegistry.addName(lLampOff, "Lime Lamp Off");
		GameRegistry.registerBlock(lLampOff, "lLampOff");
		LanguageRegistry.addName(gWood, "Green Stained Wood");
		GameRegistry.registerBlock(gWood, "gWood");
		LanguageRegistry.addName(gWool, "Green Decor Wool");
		GameRegistry.registerBlock(gWool, "gWool");
		LanguageRegistry.addName(gLantern, "Green Paper Lantern");
		GameRegistry.registerBlock(gLantern, "gLantern");
		LanguageRegistry.addName(gLampOn, "Green Lamp On");
		GameRegistry.registerBlock(gLampOn, "gLampOn");
		LanguageRegistry.addName(gLampOff, "Green Lamp Off");
		GameRegistry.registerBlock(gLampOff, "gLampOff");
		LanguageRegistry.addName(cWood, "Cyan Stained Wood");
		GameRegistry.registerBlock(cWood, "cWood");
		LanguageRegistry.addName(cWool, "Cyan Decor Wool");
		GameRegistry.registerBlock(cWool, "cWool");
		LanguageRegistry.addName(cLantern, "Cyan Paper Lantern");
		GameRegistry.registerBlock(cLantern, "cLantern");
		LanguageRegistry.addName(cLampOn, "Cyan Lamp On");
		GameRegistry.registerBlock(cLampOn, "cLampOn");
		LanguageRegistry.addName(cLampOff, "Cyan Lamp Off");
		GameRegistry.registerBlock(cLampOff, "cLampOff");
		LanguageRegistry.addName(bWood, "Blue Stained Wood");
		GameRegistry.registerBlock(bWood, "bWood");
		LanguageRegistry.addName(bWool, "Blue Decor Wool");
		GameRegistry.registerBlock(bWool, "bWool");
		LanguageRegistry.addName(bLantern, "Blue Paper Lantern");
		GameRegistry.registerBlock(bLantern, "bLantern");
		LanguageRegistry.addName(bLampOn, "Blue Lamp On");
		GameRegistry.registerBlock(bLampOn, "bLampOn");
		LanguageRegistry.addName(bLampOff, "Blue Lamp Off");
		GameRegistry.registerBlock(bLampOff, "bLampOff");
		LanguageRegistry.addName(pWood, "Purple Stained Wood");
		GameRegistry.registerBlock(pWood, "pWood");
		LanguageRegistry.addName(pWool, "Purple Decor Wool");
		GameRegistry.registerBlock(pWool, "pWool");
		LanguageRegistry.addName(pLantern, "Purple Paper Lantern");
		GameRegistry.registerBlock(pLantern, "pLantern");
		LanguageRegistry.addName(pLampOn, "Purple Lamp On");
		GameRegistry.registerBlock(pLampOn, "pLampOn");
		LanguageRegistry.addName(pLampOff, "Purple Lamp Off");
		GameRegistry.registerBlock(pLampOff, "pLampOff");
		if (Loader.isModLoaded("ClaySoldiersMod")) {
            try
            {
            	SoldierTeams.addCustomTeam(100, "0xd21e1e", "DMRed", res[0]);
            	SoldierTeams.addCustomTeam(101, "0xd2771e", "DMOrange", res[1]);
            	SoldierTeams.addCustomTeam(102, "0xd2d21e", "DMYellow", res[2]);
            	SoldierTeams.addCustomTeam(103, "0x7bd21e", "DMLime", res[3]);
            	SoldierTeams.addCustomTeam(104, "0x1ed21e", "DMGreen", res[4]);
            	SoldierTeams.addCustomTeam(105, "0x1ed2d0", "DMCyan", res[5]);
            	SoldierTeams.addCustomTeam(106, "0x1e1ed2", "DMBlue", res[6]);
            	SoldierTeams.addCustomTeam(107, "0x7b1ed2", "DMPurple", res[7]);
            }
            catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
	}
}