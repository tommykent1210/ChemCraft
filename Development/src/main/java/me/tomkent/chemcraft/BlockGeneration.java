package me.tomkent.chemcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BlockGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}

	}

	public void generateNether(World world, Random rand, int x, int z) {

	}

	public void generateOverworld(World world, Random rand, int x, int z) {
				generateOre(BlockLoader.oreActinium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreAluminium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreAntimony, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreArsenic, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreBarium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreBeryllium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreBismuth, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreBoron, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCadmium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCaesium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCarbon, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCerium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreChromium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCobalt, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreCopper, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreDysprosium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreErbium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreEuropium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreGadolinium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreGallium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreGermanium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreHafnium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreHolmium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreIndium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreIodine, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreIridium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreKrypton, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreLanthanum, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreLead, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreLithium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreLutetium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreMagnesium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreManganese, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreMercury, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreMolybdenum, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreNeodymium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreNickel, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreNiobium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreOsmium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePalladium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePhosphorus, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePlatinum, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePolonium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePotassium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.orePraseodymium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreProtactinium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreRadium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreRhenium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreRhodium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreRubidium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreRuthenium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSamarium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreScandium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSelenium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSilicon, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSilver, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSodium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreStrontium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreSulfur, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTantalum, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTellurium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTerbium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreThallium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreThorium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreThulium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTin, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTitanium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreTungsten, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreUranium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreVanadium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreYtterbium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreYttrium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreZinc, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
				generateOre(BlockLoader.oreZirconium, world, rand, x, z, 1, 10, 20, 0, 60, Blocks.stone);
			}

	public void generateEnd(World world, Random rand, int x, int z) {

	}

	public void generateOre(Block block, World world, Random rand, int chunkX,
			int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY,
			int maxY, Block blockIn) {
		int veinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, blockIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(heightRange + minY);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			gen.generate(world, rand, xRand, yRand, zRand);
		}

	}
}
