package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotPolonium extends Item {

	private static String itemName = "Polonium ingot";
	private static String itemTexture = "ingotPolonium";
	private static String itemNameSafe = "ingotPolonium";
	
        public ingotPolonium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}