package me.tomkent.chemcraft.Items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotProtactinium extends Item {

	private static String itemName = "Protactinium ingot";
	private static String itemTexture = "ingotProtactinium";
	private static String itemNameSafe = "ingotProtactinium";
	
        public ingotProtactinium() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}