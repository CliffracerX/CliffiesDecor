package cliffracerx.mods.cliffiesdecor.src;

import sanandreasp.mods.ClaySoldiersMod.registry.SoldierTeams;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStationary;
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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "DecorMod", name = "Cliffie's Decorations",
        version = "Alpha 0.01a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DecorMod
{
    public final static CreativeTabs tab = new DecorTab("cDecor");
    public final static Block DMlawnBlock = new DecorModBlockNormal(1000,
            Material.grass, "lawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("DMlawnBlock").setCreativeTab(tab);
    public final static Block DMHedge = new DecorModBlockTransp(1001,
            Material.grass, "hedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("DMHedge").setCreativeTab(tab);
    public final static Block rWood = new DecorModBlockNormal(1002,
            Material.wood, "rWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rWood")
            .setCreativeTab(tab);
    public final static Block rWool = new DecorModBlockNormal(1003,
            Material.cloth, "rWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("rWool")
            .setCreativeTab(tab);
    public final static Block rLantern = new DecorModBlockFlowerShape(1004,
            Material.cloth, "rLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("rLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block rLampOn = new DecorModLampOn(1005,
            Material.circuits, "rLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("rLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block rLampOff = new DecorModLampOff(1006,
            Material.circuits, "rLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("rLampOff").setCreativeTab(tab);
    public final static Block oWood = new DecorModBlockNormal(1007,
            Material.wood, "oWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("oWood")
            .setCreativeTab(tab);
    public final static Block oWool = new DecorModBlockNormal(1008,
            Material.cloth, "oWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("oWool")
            .setCreativeTab(tab);
    public final static Block oLantern = new DecorModBlockFlowerShape(1009,
            Material.cloth, "oLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("oLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block oLampOn = new DecorModLampOn(1010,
            Material.circuits, "oLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("oLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block oLampOff = new DecorModLampOff(1011,
            Material.circuits, "oLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("oLampOff").setCreativeTab(tab);
    public final static Block yWood = new DecorModBlockNormal(1012,
            Material.wood, "yWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("yWood")
            .setCreativeTab(tab);
    public final static Block yWool = new DecorModBlockNormal(1013,
            Material.cloth, "yWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("yWool")
            .setCreativeTab(tab);
    public final static Block yLantern = new DecorModBlockFlowerShape(1014,
            Material.cloth, "yLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("yLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block yLampOn = new DecorModLampOn(1015,
            Material.circuits, "yLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("yLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block yLampOff = new DecorModLampOff(1016,
            Material.circuits, "yLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("yLampOff").setCreativeTab(tab);
    public final static Block lWood = new DecorModBlockNormal(1017,
            Material.wood, "lWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("lWood")
            .setCreativeTab(tab);
    public final static Block lWool = new DecorModBlockNormal(1018,
            Material.cloth, "lWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("lWool")
            .setCreativeTab(tab);
    public final static Block lLantern = new DecorModBlockFlowerShape(1019,
            Material.cloth, "lLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("lLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block lLampOn = new DecorModLampOn(1020,
            Material.circuits, "lLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("lLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block lLampOff = new DecorModLampOff(1021,
            Material.circuits, "lLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("lLampOff").setCreativeTab(tab);
    public final static Block gWood = new DecorModBlockNormal(1022,
            Material.wood, "gWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gWood")
            .setCreativeTab(tab);
    public final static Block gWool = new DecorModBlockNormal(1023,
            Material.cloth, "gWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("gWool")
            .setCreativeTab(tab);
    public final static Block gLantern = new DecorModBlockFlowerShape(1024,
            Material.cloth, "gLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("gLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block gLampOn = new DecorModLampOn(1025,
            Material.circuits, "gLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("gLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block gLampOff = new DecorModLampOff(1026,
            Material.circuits, "gLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("gLampOff").setCreativeTab(tab);
    public final static Block cWood = new DecorModBlockNormal(1027,
            Material.wood, "cWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("cWood")
            .setCreativeTab(tab);
    public final static Block cWool = new DecorModBlockNormal(1028,
            Material.cloth, "cWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("cWool")
            .setCreativeTab(tab);
    public final static Block cLantern = new DecorModBlockFlowerShape(1029,
            Material.cloth, "cLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("cLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block cLampOn = new DecorModLampOn(1030,
            Material.circuits, "cLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("cLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block cLampOff = new DecorModLampOff(1031,
            Material.circuits, "cLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("cLampOff").setCreativeTab(tab);
    public final static Block bWood = new DecorModBlockNormal(1032,
            Material.wood, "bWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("bWood")
            .setCreativeTab(tab);
    public final static Block bWool = new DecorModBlockNormal(1033,
            Material.cloth, "bWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("bWool")
            .setCreativeTab(tab);
    public final static Block bLantern = new DecorModBlockFlowerShape(1034,
            Material.cloth, "bLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("bLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block bLampOn = new DecorModLampOn(1035,
            Material.circuits, "bLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("bLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block bLampOff = new DecorModLampOff(1036,
            Material.circuits, "bLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("bLampOff").setCreativeTab(tab);
    public final static Block pWood = new DecorModBlockNormal(1037,
            Material.wood, "pWood").setHardness(0.5F)
            .setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pWood")
            .setCreativeTab(tab);
    public final static Block pWool = new DecorModBlockNormal(1038,
            Material.cloth, "pWool").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep).setUnlocalizedName("pWool")
            .setCreativeTab(tab);
    public final static Block pLantern = new DecorModBlockFlowerShape(1039,
            Material.cloth, "pLantern").setHardness(0.0F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("pLantern").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block pLampOn = new DecorModLampOn(1040,
            Material.circuits, "pLampOn").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("pLampOn").setCreativeTab(tab)
            .setLightValue(1.0F);
    public final static Block pLampOff = new DecorModLampOff(1041,
            Material.circuits, "pLampOff").setHardness(0.75F)
            .setStepSound(Block.soundMetalFootstep)
            .setUnlocalizedName("pLampOff").setCreativeTab(tab);
    public final static Block rLawn = new DecorModBlockNormal(1042,
            Material.grass, "rLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("rLawn").setCreativeTab(tab);
    public final static Block rHedge = new DecorModBlockTransp(1043,
            Material.grass, "rHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("rHedge").setCreativeTab(tab);
    public final static Block rStone = new DecorModBlockNormal(1044,
            Material.ground, "rStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("rStone").setCreativeTab(tab);
    public final static Block rWater = new DecorModBlockNoclip(1045,
            Material.water, "rWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("rWater").setCreativeTab(tab);
    public final static Block rLava = new DecorModBlockNoclip(1046,
            Material.lava, "rLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("rLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block oLawn = new DecorModBlockNormal(1047,
            Material.grass, "oLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("oLawn").setCreativeTab(tab);
    public final static Block oHedge = new DecorModBlockTransp(1048,
            Material.grass, "oHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("oHedge").setCreativeTab(tab);
    public final static Block oStone = new DecorModBlockNormal(1049,
            Material.ground, "oStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("oStone").setCreativeTab(tab);
    public final static Block oWater = new DecorModBlockNoclip(1050,
            Material.water, "oWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("oWater").setCreativeTab(tab);
    public final static Block oLava = new DecorModBlockNoclip(1051,
            Material.lava, "oLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("oLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block yLawn = new DecorModBlockNormal(1052,
            Material.grass, "yLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("yLawn").setCreativeTab(tab);
    public final static Block yHedge = new DecorModBlockTransp(1053,
            Material.grass, "yHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("yHedge").setCreativeTab(tab);
    public final static Block yStone = new DecorModBlockNormal(1054,
            Material.ground, "yStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("yStone").setCreativeTab(tab);
    public final static Block yWater = new DecorModBlockNoclip(1055,
            Material.water, "yWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("yWater").setCreativeTab(tab);
    public final static Block yLava = new DecorModBlockNoclip(1056,
            Material.lava, "yLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("yLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block lLawn = new DecorModBlockNormal(1057,
            Material.grass, "lLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("lLawn").setCreativeTab(tab);
    public final static Block lHedge = new DecorModBlockTransp(1058,
            Material.grass, "lHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("lHedge").setCreativeTab(tab);
    public final static Block lStone = new DecorModBlockNormal(1059,
            Material.ground, "lStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("lStone").setCreativeTab(tab);
    public final static Block lWater = new DecorModBlockNoclip(1060,
            Material.water, "lWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("lWater").setCreativeTab(tab);
    public final static Block lLava = new DecorModBlockNoclip(1061,
            Material.lava, "lLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("lLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block gLawn = new DecorModBlockNormal(1062,
            Material.grass, "gLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("gLawn").setCreativeTab(tab);
    public final static Block gHedge = new DecorModBlockTransp(1063,
            Material.grass, "gHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("gHedge").setCreativeTab(tab);
    public final static Block gStone = new DecorModBlockNormal(1064,
            Material.ground, "gStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("gStone").setCreativeTab(tab);
    public final static Block gWater = new DecorModBlockNoclip(1065,
            Material.water, "gWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("gWater").setCreativeTab(tab);
    public final static Block gLava = new DecorModBlockNoclip(1066,
            Material.lava, "gLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("gLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block cLawn = new DecorModBlockNormal(1067,
            Material.grass, "cLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("cLawn").setCreativeTab(tab);
    public final static Block cHedge = new DecorModBlockTransp(1068,
            Material.grass, "cHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("cHedge").setCreativeTab(tab);
    public final static Block cStone = new DecorModBlockNormal(1069,
            Material.ground, "cStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("cStone").setCreativeTab(tab);
    public final static Block cWater = new DecorModBlockNoclip(1070,
            Material.water, "cWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("cWater").setCreativeTab(tab);
    public final static Block cLava = new DecorModBlockNoclip(1071,
            Material.lava, "cLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("cLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block bLawn = new DecorModBlockNormal(1072,
            Material.grass, "bLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("bLawn").setCreativeTab(tab);
    public final static Block bHedge = new DecorModBlockTransp(1073,
            Material.grass, "bHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("bHedge").setCreativeTab(tab);
    public final static Block bStone = new DecorModBlockNormal(1074,
            Material.ground, "bStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("bStone").setCreativeTab(tab);
    public final static Block bWater = new DecorModBlockNoclip(1075,
            Material.water, "bWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("bWater").setCreativeTab(tab);
    public final static Block bLava = new DecorModBlockNoclip(1076,
            Material.lava, "bLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("bLava").setCreativeTab(tab).setLightValue(1.0F);
    public final static Block pLawn = new DecorModBlockNormal(1077,
            Material.grass, "pLawn").setHardness(0.5F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("pLawn").setCreativeTab(tab);
    public final static Block pHedge = new DecorModBlockTransp(1078,
            Material.grass, "pHedge").setHardness(0.25F)
            .setStepSound(Block.soundGrassFootstep)
            .setUnlocalizedName("pHedge").setCreativeTab(tab);
    public final static Block pStone = new DecorModBlockNormal(1079,
            Material.ground, "pStone").setHardness(1.5F)
            .setStepSound(Block.soundStoneFootstep)
            .setUnlocalizedName("pStone").setCreativeTab(tab);
    public final static Block pWater = new DecorModBlockNoclip(1080,
            Material.water, "pWater").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("pWater").setCreativeTab(tab);
    public final static Block pLava = new DecorModBlockNoclip(1082,
            Material.lava, "pLava").setHardness(0.25F)
            .setStepSound(Block.soundClothFootstep)
            .setUnlocalizedName("pLava").setCreativeTab(tab).setLightValue(1.0F);
    public static Block lightSource = new BlockInvisibleLight(1083);
    public final static Item rBoat = new ItemNewBoat(5000, 0, "rBoat").setUnlocalizedName("rBoat");
    public final static Item oBoat = new ItemNewBoat(5001, 1, "oBoat").setUnlocalizedName("oBoat");
    public final static Item yBoat = new ItemNewBoat(5002, 2, "yBoat").setUnlocalizedName("yBoat");
    public final static Item lBoat = new ItemNewBoat(5003, 3, "lBoat").setUnlocalizedName("lBoat");
    public final static Item gBoat = new ItemNewBoat(5004, 4, "gBoat").setUnlocalizedName("gBoat");
    public final static Item cBoat = new ItemNewBoat(5005, 5, "cBoat").setUnlocalizedName("cBoat");
    public final static Item bBoat = new ItemNewBoat(5006, 6, "bBoat").setUnlocalizedName("bBoat");
    public final static Item pBoat = new ItemNewBoat(5007, 7, "pBoat").setUnlocalizedName("pBoat");
    public final static Item rCanopBoat = new ItemNewCanopBoat(5008, 0, "rBoat").setUnlocalizedName("rCanopBoat");
    public final static Item oCanopBoat = new ItemNewCanopBoat(5009, 1, "oBoat").setUnlocalizedName("oCanopBoat");
    public final static Item yCanopBoat = new ItemNewCanopBoat(5010, 2, "yBoat").setUnlocalizedName("yCanopBoat");
    public final static Item lCanopBoat = new ItemNewCanopBoat(5011, 3, "lBoat").setUnlocalizedName("lCanopBoat");
    public final static Item gCanopBoat = new ItemNewCanopBoat(5012, 4, "gBoat").setUnlocalizedName("gCanopBoat");
    public final static Item cCanopBoat = new ItemNewCanopBoat(5013, 5, "cBoat").setUnlocalizedName("cCanopBoat");
    public final static Item bCanopBoat = new ItemNewCanopBoat(5014, 6, "bBoat").setUnlocalizedName("bCanopBoat");
    public final static Item pCanopBoat = new ItemNewCanopBoat(5015, 7, "pBoat").setUnlocalizedName("pCanopBoat");
    
    ResourceLocation[][] res = new ResourceLocation[][]
    { // custom clay soldier textures
                    new ResourceLocation[]
                    { // Red team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cRed.png")
                    },
                    new ResourceLocation[]
                    { // Orange team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cOrange.png")
                    }, new ResourceLocation[]
                    { // Yellow team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cYellow.png")
                    }, new ResourceLocation[]
                    { // Lime team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cLime.png")
                    }, new ResourceLocation[]
                    { // Green team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cGreen.png")
                    }, new ResourceLocation[]
                    { // Cyan team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cCyan.png")
                    }, new ResourceLocation[]
                    { // Blue team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cBlue.png")
                    }, new ResourceLocation[]
                    { // Purple team
                        new ResourceLocation("cliffiesdecor",
                                "textures/entities/soldiers/cPurple.png")
                    },
            };
    
    @Instance("DecorMod")
    public static DecorMod instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.cliffiesdecor.src.ClientProxy",
            serverSide = "cliffracerx.mods.cliffiesdecor.src.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //Block naming and registering
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
        LanguageRegistry.addName(rLawn, "Red Lawn");
        GameRegistry.registerBlock(rLawn, "rLawn");
        LanguageRegistry.addName(rHedge, "Red Hedge");
        GameRegistry.registerBlock(rHedge, "rHedge");
        LanguageRegistry.addName(rStone, "Red Stone");
        GameRegistry.registerBlock(rStone, "rStone");
        LanguageRegistry.addName(rWater, "Red Water");
        GameRegistry.registerBlock(rWater, "rWater");
        LanguageRegistry.addName(rLava, "Red Lava");
        GameRegistry.registerBlock(rLava, "rLava");
        LanguageRegistry.addName(oLawn, "Orange Lawn");
        GameRegistry.registerBlock(oLawn, "oLawn");
        LanguageRegistry.addName(oHedge, "Orange Hedge");
        GameRegistry.registerBlock(oHedge, "oHedge");
        LanguageRegistry.addName(oStone, "Orange Stone");
        GameRegistry.registerBlock(oStone, "oStone");
        LanguageRegistry.addName(oWater, "Orange Water");
        GameRegistry.registerBlock(oWater, "oWater");
        LanguageRegistry.addName(oLava, "Orange Lava");
        GameRegistry.registerBlock(oLava, "oLava");
        LanguageRegistry.addName(yLawn, "Yellow Lawn");
        GameRegistry.registerBlock(yLawn, "yLawn");
        LanguageRegistry.addName(yHedge, "Yellow Hedge");
        GameRegistry.registerBlock(yHedge, "yHedge");
        LanguageRegistry.addName(yStone, "Yellow Stone");
        GameRegistry.registerBlock(yStone, "yStone");
        LanguageRegistry.addName(yWater, "Yellow Water");
        GameRegistry.registerBlock(yWater, "yWater");
        LanguageRegistry.addName(yLava, "Yellow Lava");
        GameRegistry.registerBlock(yLava, "yLava");
        LanguageRegistry.addName(lLawn, "Lime Lawn");
        GameRegistry.registerBlock(lLawn, "lLawn");
        LanguageRegistry.addName(lHedge, "Lime Hedge");
        GameRegistry.registerBlock(lHedge, "lHedge");
        LanguageRegistry.addName(lStone, "Lime Stone");
        GameRegistry.registerBlock(lStone, "lStone");
        LanguageRegistry.addName(lWater, "Lime Water");
        GameRegistry.registerBlock(lWater, "lWater");
        LanguageRegistry.addName(lLava, "Lime Lava");
        GameRegistry.registerBlock(lLava, "lLava");
        LanguageRegistry.addName(gLawn, "Green Lawn");
        GameRegistry.registerBlock(gLawn, "gLawn");
        LanguageRegistry.addName(gHedge, "Green Hedge");
        GameRegistry.registerBlock(gHedge, "gHedge");
        LanguageRegistry.addName(gStone, "Green Stone");
        GameRegistry.registerBlock(gStone, "gStone");
        LanguageRegistry.addName(gWater, "Green Water");
        GameRegistry.registerBlock(gWater, "gWater");
        LanguageRegistry.addName(gLava, "Green Lava");
        GameRegistry.registerBlock(gLava, "gLava");
        LanguageRegistry.addName(cLawn, "Cyan Lawn");
        GameRegistry.registerBlock(cLawn, "cLawn");
        LanguageRegistry.addName(cHedge, "Cyan Hedge");
        GameRegistry.registerBlock(cHedge, "cHedge");
        LanguageRegistry.addName(cStone, "Cyan Stone");
        GameRegistry.registerBlock(cStone, "cStone");
        LanguageRegistry.addName(cWater, "Cyan Water");
        GameRegistry.registerBlock(cWater, "cWater");
        LanguageRegistry.addName(cLava, "Cyan Lava");
        GameRegistry.registerBlock(cLava, "cLava");
        LanguageRegistry.addName(bLawn, "Blue Lawn");
        GameRegistry.registerBlock(bLawn, "bLawn");
        LanguageRegistry.addName(bHedge, "Blue Hedge");
        GameRegistry.registerBlock(bHedge, "bHedge");
        LanguageRegistry.addName(bStone, "Blue Stone");
        GameRegistry.registerBlock(bStone, "bStone");
        LanguageRegistry.addName(bWater, "Blue Water");
        GameRegistry.registerBlock(bWater, "bWater");
        LanguageRegistry.addName(bLava, "Blue Lava");
        GameRegistry.registerBlock(bLava, "bLava");
        LanguageRegistry.addName(pLawn, "Purple Lawn");
        GameRegistry.registerBlock(pLawn, "pLawn");
        LanguageRegistry.addName(pHedge, "Purple Hedge");
        GameRegistry.registerBlock(pHedge, "pHedge");
        LanguageRegistry.addName(pStone, "Purple Stone");
        GameRegistry.registerBlock(pStone, "pStone");
        LanguageRegistry.addName(pWater, "Purple Water");
        GameRegistry.registerBlock(pWater, "pWater");
        LanguageRegistry.addName(pLava, "Purple Lava");
        GameRegistry.registerBlock(pLava, "pLava");
        //Item naming
        LanguageRegistry.addName(rBoat, "Red Boat Item");
        LanguageRegistry.addName(oBoat, "Orange Boat Item");
        LanguageRegistry.addName(yBoat, "Yellow Boat Item");
        LanguageRegistry.addName(lBoat, "Lime Boat Item");
        LanguageRegistry.addName(gBoat, "Green Boat Item");
        LanguageRegistry.addName(cBoat, "Cyan Boat Item");
        LanguageRegistry.addName(bBoat, "Blue Boat Item");
        LanguageRegistry.addName(pBoat, "Purple Boat Item");
        LanguageRegistry.addName(rCanopBoat, "Red CanopBoat Item");
        LanguageRegistry.addName(oCanopBoat, "Orange CanopBoat Item");
        LanguageRegistry.addName(yCanopBoat, "Yellow CanopBoat Item");
        LanguageRegistry.addName(lCanopBoat, "Lime CanopBoat Item");
        LanguageRegistry.addName(gCanopBoat, "Green CanopBoat Item");
        LanguageRegistry.addName(cCanopBoat, "Cyan CanopBoat Item");
        LanguageRegistry.addName(bCanopBoat, "Blue CanopBoat Item");
        LanguageRegistry.addName(pCanopBoat, "Purple CanopBoat Item");
        //Custom clay soldiers
        if (Loader.isModLoaded("ClaySoldiersMod"))
        {
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
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }
        //Register entities
        EntityRegistry.registerModEntity(EntityCustomDecorBoat.class,
                "CliffiesDecor_Boat", 0, this, 64, 1, true);
        EntityRegistry.registerModEntity(EntityDecorCanopBoat.class,
                "CliffiesDecor_Boat_Canopy", 1, this, 64, 1, true);
    }
}
