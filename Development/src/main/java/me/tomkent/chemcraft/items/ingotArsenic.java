package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotArsenic extends Item {

	private static String itemName = "Arsenic ingot";
	private static String itemTexture = "ingotArsenic";
	private static String itemNameSafe = "ingotArsenic";
	
        public ingotArsenic() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}