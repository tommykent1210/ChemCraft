package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class dustYtterbium extends Item {

	private static String itemName = "Ytterbium dust";
	private static String itemTexture = "dustYtterbium";
	private static String itemNameSafe = "dustYtterbium";
	
        public dustYtterbium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}