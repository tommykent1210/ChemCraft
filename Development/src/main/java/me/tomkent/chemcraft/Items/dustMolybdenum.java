package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustMolybdenum extends Item {

	private static String itemName = "Molybdenum dust";
	private static String itemTexture = "dustMolybdenum";
	private static String itemNameSafe = "dustMolybdenum";
	
        public dustMolybdenum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}