package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotPhosphorus extends Item {

	private static String itemName = "Phosphorus ingot";
	private static String itemTexture = "ingotPhosphorus";
	private static String itemNameSafe = "ingotPhosphorus";
	
        public ingotPhosphorus() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}