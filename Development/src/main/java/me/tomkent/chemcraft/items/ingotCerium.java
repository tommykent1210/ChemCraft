package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotCerium extends Item {

	private static String itemName = "Cerium ingot";
	private static String itemTexture = "ingotCerium";
	private static String itemNameSafe = "ingotCerium";
	
        public ingotCerium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}