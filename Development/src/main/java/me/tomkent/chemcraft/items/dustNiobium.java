package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustNiobium extends Item {

	private static String itemName = "Niobium dust";
	private static String itemTexture = "dustNiobium";
	private static String itemNameSafe = "dustNiobium";
	
        public dustNiobium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}