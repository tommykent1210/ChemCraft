package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotErbium extends Item {

	private static String itemName = "Erbium ingot";
	private static String itemTexture = "ingotErbium";
	private static String itemNameSafe = "ingotErbium";
	
        public ingotErbium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}