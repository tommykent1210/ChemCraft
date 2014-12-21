package me.tomkent.chemcraft;


//blocks and items
import java.util.Arrays;

import me.tomkent.chemcraft.utilities.NetworkUtilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.FMLCommonHandler;
//common forge imports
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
//import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

//Creative Tab Imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//mod meta info
import cpw.mods.fml.common.ModMetadata;

 
@Mod(modid = ChemCraft.MODID, version = ChemCraft.VERSION, canBeDeactivated = false)
public class ChemCraft
{
    public static final String MODID = "ChemCraft";
    public static final String VERSION = "1.0";
    public static ModMetadata modMetadata;
 
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//put the modinfo in a variable
    	modMetadata = event.getModMetadata();
    	String buildnum = StatCollector.translateToLocal(ChemCraft.MODID + "_" + "buildnum");
		
    	//mod metainfo
    	modMetadata.modId		=	MODID;
    	modMetadata.name		=	"ChemCraft";
    	modMetadata.version		=	VERSION + "." + buildnum;									
    	modMetadata.description	=	"Adds all elements from the periodic table, and a whole plethora of crafting recipes!";
    	modMetadata.url			=	"https://github.com/tommykent1210/ChemCraft";
    	modMetadata.updateUrl	=	"https://github.com/tommykent1210/ChemCraft";
    	modMetadata.authorList	=	Arrays.asList (new String[] { "Tommykent1210" });
    	modMetadata.credits		=	"Fairywhiz, Dorky106, and Basspro262";
    	modMetadata.logoFile	=	"/assets/chemcraft/logo.png";
    	
    	//let the mod use events
    	ChemCraftEventHandler events = new ChemCraftEventHandler();
    	FMLCommonHandler.instance().bus().register(events);
    	//MinecraftForge.EVENT_BUS.register(events);
    	
    	
    	//initialise blocks and armor
    	BlockLoader.initBlocks();
    	ArmorLoader.init();
    	
    	//finally load items and recipes
    	ItemLoader.initItems();
    	RecipeManager.initRecipes();
    	
    	GameRegistry.registerWorldGenerator(new BlockGeneration(), 0);
    	
    	

    }
    
    
    
    //custom Creative Tabs
    public static CreativeTabs tabChemcraft = new CreativeTabs(ChemCraft.MODID + "_Blocks") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(BlockLoader.oreUranium);
        	//return Item.getItemFromBlock(Blocks.beacon);
        }
    };
    
    public static CreativeTabs tabChemcraftItems = new CreativeTabs(ChemCraft.MODID + "_Items") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ItemLoader.dustUranium;
        	//return Item.getItemFromBlock(Blocks.bedrock);
        }
    };
    
    /*@EventHandler
    public void init(FMLInitializationEvent event)
    {
    	NetworkUtilities n = new NetworkUtilities();
    	
    }*/
    
    
    
    
}