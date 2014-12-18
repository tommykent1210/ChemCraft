package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotYtterbium extends Item {

	private static String itemName = "Ytterbium ingot";
	private static String itemTexture = "ingotYtterbium";
	private static String itemNameSafe = "ingotYtterbium";
	
        public ingotYtterbium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}