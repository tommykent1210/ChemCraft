package me.tomkent.chemcraft;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item {

	private static String itemName = "Actinium dust";
	private static String itemTexture = "dustActinium";
	private static String itemNameSafe = "dustActinium";
	
        public GenericItem(String iName, String iTexture, String iNameSafe, int maxStack) {
        		itemName = iName;
        		itemTexture = iTexture;
        		itemNameSafe = iNameSafe;
        		
                maxStackSize = maxStack;
                
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}