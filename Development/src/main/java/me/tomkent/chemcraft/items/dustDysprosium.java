package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustDysprosium extends Item {

	private static String itemName = "Dysprosium dust";
	private static String itemTexture = "dustDysprosium";
	private static String itemNameSafe = "dustDysprosium";
	
        public dustDysprosium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}