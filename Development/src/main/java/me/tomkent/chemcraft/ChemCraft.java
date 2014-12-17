package me.tomkent.chemcraft;


//blocks and items
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

//common forge imports
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

//Creative Tab Imports
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
@Mod(modid = ChemCraft.MODID, version = ChemCraft.VERSION)
public class ChemCraft
{
    public static final String MODID = "ChemCraft";
    public static final String VERSION = "1.0";
 
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	BlockLoader.initBlocks();
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
    	//BlockLoader.initBlocks();
    	//ItemLoader.initItems();
    	//GameRegistry.registerWorldGenerator(new BlockGeneration(), 0);
    }*/
    
    
    
    
}