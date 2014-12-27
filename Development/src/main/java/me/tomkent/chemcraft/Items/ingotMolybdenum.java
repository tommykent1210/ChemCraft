package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotMolybdenum extends Item {

	private static String itemName = "Molybdenum ingot";
	private static String itemTexture = "ingotMolybdenum";
	private static String itemNameSafe = "ingotMolybdenum";
	
        public ingotMolybdenum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}