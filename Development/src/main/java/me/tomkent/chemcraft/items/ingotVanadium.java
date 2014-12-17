package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotVanadium extends Item {

	private static String itemName = "Vanadium ingot";
	private static String itemTexture = "ingotVanadium";
	private static String itemNameSafe = "ingotVanadium";
	
        public ingotVanadium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}