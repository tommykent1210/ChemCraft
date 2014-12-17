package me.tomkent.chemcraft.items;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class {{$id}} extends Item {

	private static String itemName = "{{ucfirst($name)}}";
	private static String itemTexture = "{{$texture}}";
	private static String itemNameSafe = "{{$id}}";
	
        public {{$id}}() {
                maxStackSize = 64;
                setCreativeTab(ChemCraft.tabChemcraftItems);
                setUnlocalizedName(ChemCraft.MODID + "_" + itemNameSafe);
                setTextureName(ChemCraft.MODID + ":" + itemTexture);
        }
}