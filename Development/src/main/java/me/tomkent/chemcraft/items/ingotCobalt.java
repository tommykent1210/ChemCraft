package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotCobalt extends Item {

	private static String itemName = "Cobalt ingot";
	private static String itemTexture = "ingotCobalt";
	private static String itemNameSafe = "ingotCobalt";
	
        public ingotCobalt() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}