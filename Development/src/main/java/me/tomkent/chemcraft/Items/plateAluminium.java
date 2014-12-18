package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateAluminium extends Item {

	private static String itemName = "Aluminium plate";
	private static String itemTexture = "plateAluminium";
	private static String itemNameSafe = "plateAluminium";
	
        public plateAluminium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}