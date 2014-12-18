package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class platePalladium extends Item {

	private static String itemName = "Palladium plate";
	private static String itemTexture = "platePalladium";
	private static String itemNameSafe = "platePalladium";
	
        public platePalladium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}