package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateMagnesium extends Item {

	private static String itemName = "Magnesium plate";
	private static String itemTexture = "plateMagnesium";
	private static String itemNameSafe = "plateMagnesium";
	
        public plateMagnesium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}