package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotRuthenium extends Item {

	private static String itemName = "Ruthenium ingot";
	private static String itemTexture = "ingotRuthenium";
	private static String itemNameSafe = "ingotRuthenium";
	
        public ingotRuthenium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}