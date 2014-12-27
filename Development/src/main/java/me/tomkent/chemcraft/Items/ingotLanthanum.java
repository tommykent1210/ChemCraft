package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotLanthanum extends Item {

	private static String itemName = "Lanthanum ingot";
	private static String itemTexture = "ingotLanthanum";
	private static String itemNameSafe = "ingotLanthanum";
	
        public ingotLanthanum() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}