package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateRubidium extends Item {

	private static String itemName = "Rubidium plate";
	private static String itemTexture = "plateRubidium";
	private static String itemNameSafe = "plateRubidium";
	
        public plateRubidium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}