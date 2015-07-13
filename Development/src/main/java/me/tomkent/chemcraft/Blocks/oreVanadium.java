package me.tomkent.chemcraft.Blocks;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class oreVanadium extends Block{

	private static String blockName = "Vanadium Ore";
	private static String blockTexture = "missing";
	private static String blockNameSafe = "oreVanadium";
	
	public oreVanadium()
	{
		super(Material.rock);
		setBlockName(ChemCraft.MODID + "_" + blockNameSafe);
		setCreativeTab(ChemCraft.tabChemcraft);
		setBlockTextureName("chemcraft:" + blockTexture);
		setHarvestLevel("pickaxe", 1);
		setHardness(5F);
	}

		
	
}
