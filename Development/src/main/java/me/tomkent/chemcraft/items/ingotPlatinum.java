package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotPlatinum extends Item {

	private static String itemName = "Platinum ingot";
	private static String itemTexture = "ingotPlatinum";
	private static String itemNameSafe = "ingotPlatinum";
	
        public ingotPlatinum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}