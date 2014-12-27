package me.tomkent.chemcraft;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import java.util.List;
import java.util.Random;
import net.minecraft.util.AxisAlignedBB;
import me.tomkent.chemcraft.ArmorLoader;
import me.tomkent.chemcraft.Armor.ChemCraftHazmatArmor;

public class GenericBlock extends Block{

	private static String blockName = "Actinium Ore";
	private static String blockTexture = "missing";
	private static String blockNameSafe = "oreActinium";
	
	public GenericBlock(String bName, String bTexture, String bNameSafe, String bHarvestToolClass, int bHarvestToolTier, float bHardness)
	{
		super(Material.rock);
		
		//set the global variables
		blockName = bName;
		blockTexture = bTexture;
		blockNameSafe = bNameSafe;
		
		setBlockName(ChemCraft.MODID + "_" + blockNameSafe);
		setCreativeTab(ChemCraft.tabChemcraft);
		setBlockTextureName("chemcraft:" + blockTexture);
		setHarvestLevel(bHarvestToolClass, bHarvestToolTier);
		setHardness(bHardness);
	}

	
}
