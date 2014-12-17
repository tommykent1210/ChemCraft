package me.tomkent.chemcraft.Blocks;

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

public class orePolonium extends Block{

	private static String blockName = "Polonium Ore";
	private static String blockTexture = "missing";
	private static String blockNameSafe = "orePolonium";
	
	public orePolonium()
	{
		super(Material.rock);
		setBlockName(ChemCraft.MODID + "_" + blockNameSafe);
		setCreativeTab(ChemCraft.tabChemcraft);
		setBlockTextureName("chemcraft:" + blockTexture);
		setHarvestLevel("pickaxe", 1);
		setHardness(5F);
	}

	public void onEntityWalking(World world, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity entity)
    {
		System.out.println("Player Stepped on Radioactive Block!!");
        if (entity instanceof EntityLiving) {
        	((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 10));
        }
        if (entity instanceof EntityPlayer) {
        	((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 10));
        }
    }
		
	
}
