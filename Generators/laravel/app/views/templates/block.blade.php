package me.tomkent.chemcraft.Blocks;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
@if ($Radioactive == "TRUE")
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import java.util.List;
import java.util.Random;
import net.minecraft.util.AxisAlignedBB;
@endif

public class {{ $OreID }} extends Block{

	private static String blockName = "{{ $OreName }}";
	private static String blockTexture = "{{ $OreTexture }}";
	private static String blockNameSafe = "{{ $OreID }}";
	
	public {{ $OreID }}()
	{
		super(Material.rock);
		setBlockName(ChemCraft.MODID + "_" + blockNameSafe);
		setCreativeTab(ChemCraft.tabChemcraft);
		setBlockTextureName("chemcraft:" + blockTexture);
		setHarvestLevel("{{ $ToolClass }}", {{ $ToolTier }});
		setHardness({{ $Hardness }}F);
	}

	@if($Radioactive == "TRUE")
// update the block on tick and if player is within range, make them
	// poisoned
	public void updateTick(World world, int x, int y, int z, Random rand) {
		System.out.println("X:" + x + ", Y:" + y + ", Z:" + z);
		List playerList = world.getEntitiesWithinAABB(EntityPlayer.class,
				AxisAlignedBB.getBoundingBox(x - {{$RadioactiveRange}}, y - {{$RadioactiveRange}}, z - {{$RadioactiveRange}}, x + {{$RadioactiveRange}}, y + {{$RadioactiveRange}},
						z + {{$RadioactiveRange}}));
		if (playerList.size() > 0) {
			System.out.println("Player near uranium!");
			System.out.println(playerList);
			for (int i = 0; i < playerList.size(); i++) {
				EntityPlayer p = (EntityPlayer)playerList.get(i);
				p.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 10));
			}
			//((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 10));
		}

	}

	// when player adds block to the world, make it radioactive ^_^
	public void onBlockAdded(World world, int x, int y, int z) {
		Block b = world.getBlock(x, y, z);
		b.setTickRandomly(true);
	}
	@endif
	
	
}
