package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class plateLanthanum extends Item {

	private static String itemName = "Lanthanum plate";
	private static String itemTexture = "plateLanthanum";
	private static String itemNameSafe = "plateLanthanum";
	
        public plateLanthanum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}