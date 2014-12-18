package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotDysprosium extends Item {

	private static String itemName = "Dysprosium ingot";
	private static String itemTexture = "ingotDysprosium";
	private static String itemNameSafe = "ingotDysprosium";
	
        public ingotDysprosium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}