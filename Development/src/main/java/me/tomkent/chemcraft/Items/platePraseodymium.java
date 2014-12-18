package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class platePraseodymium extends Item {

	private static String itemName = "Praseodymium plate";
	private static String itemTexture = "platePraseodymium";
	private static String itemNameSafe = "platePraseodymium";
	
        public platePraseodymium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}