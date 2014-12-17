package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustPraseodymium extends Item {

	private static String itemName = "Praseodymium dust";
	private static String itemTexture = "dustPraseodymium";
	private static String itemNameSafe = "dustPraseodymium";
	
        public dustPraseodymium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}