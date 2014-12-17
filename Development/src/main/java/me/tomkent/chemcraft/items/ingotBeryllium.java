package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotBeryllium extends Item {

	private static String itemName = "Beryllium ingot";
	private static String itemTexture = "ingotBeryllium";
	private static String itemNameSafe = "ingotBeryllium";
	
        public ingotBeryllium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}