package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotMagnesium extends Item {

	private static String itemName = "Magnesium ingot";
	private static String itemTexture = "ingotMagnesium";
	private static String itemNameSafe = "ingotMagnesium";
	
        public ingotMagnesium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}