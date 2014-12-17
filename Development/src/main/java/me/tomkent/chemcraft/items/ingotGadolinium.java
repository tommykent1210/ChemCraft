package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotGadolinium extends Item {

	private static String itemName = "Gadolinium ingot";
	private static String itemTexture = "ingotGadolinium";
	private static String itemNameSafe = "ingotGadolinium";
	
        public ingotGadolinium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}