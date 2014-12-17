package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustGadolinium extends Item {

	private static String itemName = "Gadolinium dust";
	private static String itemTexture = "dustGadolinium";
	private static String itemNameSafe = "dustGadolinium";
	
        public dustGadolinium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}