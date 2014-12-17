package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotNeodymium extends Item {

	private static String itemName = "Neodymium ingot";
	private static String itemTexture = "ingotNeodymium";
	private static String itemNameSafe = "ingotNeodymium";
	
        public ingotNeodymium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}