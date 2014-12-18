package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotPraseodymium extends Item {

	private static String itemName = "Praseodymium ingot";
	private static String itemTexture = "ingotPraseodymium";
	private static String itemNameSafe = "ingotPraseodymium";
	
        public ingotPraseodymium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}