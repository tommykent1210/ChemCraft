package me.tomkent.chemcraft.Blocks;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class orePlatinum extends Block{

	private static String blockName = "Platinum Ore";
	private static String blockTexture = "missing";
	private static String blockNameSafe = "orePlatinum";
	
	public orePlatinum()
	{
		super(Material.rock);
		setBlockName(ChemCraft.MODID + "_" + blockNameSafe);
		setCreativeTab(ChemCraft.tabChemcraft);
		setBlockTextureName("chemcraft:" + blockTexture);
		setHarvestLevel("pickaxe", 1);
		setHardness(5F);
	}

		
	
}
