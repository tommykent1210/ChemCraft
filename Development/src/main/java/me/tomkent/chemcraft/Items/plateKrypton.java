package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateKrypton extends Item {

	private static String itemName = "Krypton plate";
	private static String itemTexture = "plateKrypton";
	private static String itemNameSafe = "plateKrypton";
	
        public plateKrypton() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}