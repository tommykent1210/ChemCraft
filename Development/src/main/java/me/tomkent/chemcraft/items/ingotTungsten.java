package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotTungsten extends Item {

	private static String itemName = "Tungsten ingot";
	private static String itemTexture = "ingotTungsten";
	private static String itemNameSafe = "ingotTungsten";
	
        public ingotTungsten() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}