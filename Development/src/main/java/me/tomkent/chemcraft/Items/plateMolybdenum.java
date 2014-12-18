package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateMolybdenum extends Item {

	private static String itemName = "Molybdenum plate";
	private static String itemTexture = "plateMolybdenum";
	private static String itemNameSafe = "plateMolybdenum";
	
        public plateMolybdenum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}