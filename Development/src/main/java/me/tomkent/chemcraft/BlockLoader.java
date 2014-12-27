package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import me.tomkent.chemcraft.Blocks.*;
import net.minecraftforge.oredict.OreDictionary;


public class BlockLoader {

		public static Block oreActinium;
		public static Block oreAluminium;
		public static Block oreAntimony;
		public static Block oreArsenic;
		public static Block oreBarium;
		public static Block oreBeryllium;
		public static Block oreBismuth;
		public static Block oreBoron;
		public static Block oreCadmium;
		public static Block oreCaesium;
		public static Block oreCarbon;
		public static Block oreCerium;
		public static Block oreChromium;
		public static Block oreCobalt;
		public static Block oreCopper;
		public static Block oreDysprosium;
		public static Block oreErbium;
		public static Block oreEuropium;
		public static Block oreGadolinium;
		public static Block oreGallium;
		public static Block oreGermanium;
		public static Block oreHafnium;
		public static Block oreHolmium;
		public static Block oreIndium;
		public static Block oreIodine;
		public static Block oreIridium;
		public static Block oreKrypton;
		public static Block oreLanthanum;
		public static Block oreLead;
		public static Block oreLithium;
		public static Block oreLutetium;
		public static Block oreMagnesium;
		public static Block oreManganese;
		public static Block oreMercury;
		public static Block oreMolybdenum;
		public static Block oreNeodymium;
		public static Block oreNickel;
		public static Block oreNiobium;
		public static Block oreOsmium;
		public static Block orePalladium;
		public static Block orePhosphorus;
		public static Block orePlatinum;
		public static Block orePolonium;
		public static Block orePotassium;
		public static Block orePraseodymium;
		public static Block oreProtactinium;
		public static Block oreRadium;
		public static Block oreRhenium;
		public static Block oreRhodium;
		public static Block oreRubidium;
		public static Block oreRuthenium;
		public static Block oreSamarium;
		public static Block oreScandium;
		public static Block oreSelenium;
		public static Block oreSilicon;
		public static Block oreSilver;
		public static Block oreSodium;
		public static Block oreStrontium;
		public static Block oreSulfur;
		public static Block oreTantalum;
		public static Block oreTellurium;
		public static Block oreTerbium;
		public static Block oreThallium;
		public static Block oreThorium;
		public static Block oreThulium;
		public static Block oreTin;
		public static Block oreTitanium;
		public static Block oreTungsten;
		public static Block oreUranium;
		public static Block oreVanadium;
		public static Block oreYtterbium;
		public static Block oreYttrium;
		public static Block oreZinc;
		public static Block oreZirconium;
	
	public static void initBlocks() {

						oreActinium = new GenericBlockRadioactive("Actinium Ore", "missing", "oreActinium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Actinium Ore", new ItemStack(oreActinium, 1, 0));
    	GameRegistry.registerBlock(oreActinium, "Actinium Ore");
    	
						oreAluminium = new GenericBlock("Aluminium Ore", "missing", "oreAluminium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Aluminium Ore", new ItemStack(oreAluminium, 1, 0));
    	GameRegistry.registerBlock(oreAluminium, "Aluminium Ore");
    	
						oreAntimony = new GenericBlock("Antimony Ore", "missing", "oreAntimony", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Antimony Ore", new ItemStack(oreAntimony, 1, 0));
    	GameRegistry.registerBlock(oreAntimony, "Antimony Ore");
    	
						oreArsenic = new GenericBlock("Arsenic Ore", "missing", "oreArsenic", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Arsenic Ore", new ItemStack(oreArsenic, 1, 0));
    	GameRegistry.registerBlock(oreArsenic, "Arsenic Ore");
    	
						oreBarium = new GenericBlock("Barium Ore", "missing", "oreBarium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Barium Ore", new ItemStack(oreBarium, 1, 0));
    	GameRegistry.registerBlock(oreBarium, "Barium Ore");
    	
						oreBeryllium = new GenericBlock("Bertrandite", "OreBeryllium", "oreBeryllium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Bertrandite", new ItemStack(oreBeryllium, 1, 0));
    	GameRegistry.registerBlock(oreBeryllium, "Bertrandite");
    	
						oreBismuth = new GenericBlock("Bismuth Ore", "missing", "oreBismuth", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Bismuth Ore", new ItemStack(oreBismuth, 1, 0));
    	GameRegistry.registerBlock(oreBismuth, "Bismuth Ore");
    	
						oreBoron = new GenericBlock("Boron Ore", "missing", "oreBoron", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Boron Ore", new ItemStack(oreBoron, 1, 0));
    	GameRegistry.registerBlock(oreBoron, "Boron Ore");
    	
						oreCadmium = new GenericBlock("Cadmium Ore", "missing", "oreCadmium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Cadmium Ore", new ItemStack(oreCadmium, 1, 0));
    	GameRegistry.registerBlock(oreCadmium, "Cadmium Ore");
    	
						oreCaesium = new GenericBlock("Caesium Ore", "missing", "oreCaesium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Caesium Ore", new ItemStack(oreCaesium, 1, 0));
    	GameRegistry.registerBlock(oreCaesium, "Caesium Ore");
    	
						oreCarbon = new GenericBlock("Carbon Ore", "OreCarbon", "oreCarbon", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Carbon Ore", new ItemStack(oreCarbon, 1, 0));
    	GameRegistry.registerBlock(oreCarbon, "Carbon Ore");
    	
						oreCerium = new GenericBlock("Cerium Ore", "missing", "oreCerium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Cerium Ore", new ItemStack(oreCerium, 1, 0));
    	GameRegistry.registerBlock(oreCerium, "Cerium Ore");
    	
						oreChromium = new GenericBlock("Chromium Ore", "missing", "oreChromium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Chromium Ore", new ItemStack(oreChromium, 1, 0));
    	GameRegistry.registerBlock(oreChromium, "Chromium Ore");
    	
						oreCobalt = new GenericBlock("Cobalt Ore", "missing", "oreCobalt", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Cobalt Ore", new ItemStack(oreCobalt, 1, 0));
    	GameRegistry.registerBlock(oreCobalt, "Cobalt Ore");
    	
						oreCopper = new GenericBlock("Copper Ore", "missing", "oreCopper", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Copper Ore", new ItemStack(oreCopper, 1, 0));
    	GameRegistry.registerBlock(oreCopper, "Copper Ore");
    	
						oreDysprosium = new GenericBlock("Dysprosium Ore", "missing", "oreDysprosium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Dysprosium Ore", new ItemStack(oreDysprosium, 1, 0));
    	GameRegistry.registerBlock(oreDysprosium, "Dysprosium Ore");
    	
						oreErbium = new GenericBlock("Erbium Ore", "missing", "oreErbium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Erbium Ore", new ItemStack(oreErbium, 1, 0));
    	GameRegistry.registerBlock(oreErbium, "Erbium Ore");
    	
						oreEuropium = new GenericBlock("Europium Ore", "missing", "oreEuropium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Europium Ore", new ItemStack(oreEuropium, 1, 0));
    	GameRegistry.registerBlock(oreEuropium, "Europium Ore");
    	
						oreGadolinium = new GenericBlock("Gadolinium Ore", "missing", "oreGadolinium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Gadolinium Ore", new ItemStack(oreGadolinium, 1, 0));
    	GameRegistry.registerBlock(oreGadolinium, "Gadolinium Ore");
    	
						oreGallium = new GenericBlock("Gallium Ore", "missing", "oreGallium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Gallium Ore", new ItemStack(oreGallium, 1, 0));
    	GameRegistry.registerBlock(oreGallium, "Gallium Ore");
    	
						oreGermanium = new GenericBlock("Germanium Ore", "missing", "oreGermanium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Germanium Ore", new ItemStack(oreGermanium, 1, 0));
    	GameRegistry.registerBlock(oreGermanium, "Germanium Ore");
    	
						oreHafnium = new GenericBlock("Hafnium Ore", "missing", "oreHafnium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Hafnium Ore", new ItemStack(oreHafnium, 1, 0));
    	GameRegistry.registerBlock(oreHafnium, "Hafnium Ore");
    	
						oreHolmium = new GenericBlock("Holmium Ore", "missing", "oreHolmium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Holmium Ore", new ItemStack(oreHolmium, 1, 0));
    	GameRegistry.registerBlock(oreHolmium, "Holmium Ore");
    	
						oreIndium = new GenericBlock("Indium Ore", "missing", "oreIndium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Indium Ore", new ItemStack(oreIndium, 1, 0));
    	GameRegistry.registerBlock(oreIndium, "Indium Ore");
    	
						oreIodine = new GenericBlock("Iodine Ore", "missing", "oreIodine", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Iodine Ore", new ItemStack(oreIodine, 1, 0));
    	GameRegistry.registerBlock(oreIodine, "Iodine Ore");
    	
						oreIridium = new GenericBlock("Iridium Ore", "missing", "oreIridium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Iridium Ore", new ItemStack(oreIridium, 1, 0));
    	GameRegistry.registerBlock(oreIridium, "Iridium Ore");
    	
						oreKrypton = new GenericBlock("Krypton Ore", "missing", "oreKrypton", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Krypton Ore", new ItemStack(oreKrypton, 1, 0));
    	GameRegistry.registerBlock(oreKrypton, "Krypton Ore");
    	
						oreLanthanum = new GenericBlock("Lanthanum Ore", "missing", "oreLanthanum", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Lanthanum Ore", new ItemStack(oreLanthanum, 1, 0));
    	GameRegistry.registerBlock(oreLanthanum, "Lanthanum Ore");
    	
						oreLead = new GenericBlock("Lead Ore", "missing", "oreLead", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Lead Ore", new ItemStack(oreLead, 1, 0));
    	GameRegistry.registerBlock(oreLead, "Lead Ore");
    	
						oreLithium = new GenericBlock("Lithium Ore", "missing", "oreLithium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Lithium Ore", new ItemStack(oreLithium, 1, 0));
    	GameRegistry.registerBlock(oreLithium, "Lithium Ore");
    	
						oreLutetium = new GenericBlock("Lutetium Ore", "missing", "oreLutetium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Lutetium Ore", new ItemStack(oreLutetium, 1, 0));
    	GameRegistry.registerBlock(oreLutetium, "Lutetium Ore");
    	
						oreMagnesium = new GenericBlock("Magnesium Ore", "OreMagnesium", "oreMagnesium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Magnesium Ore", new ItemStack(oreMagnesium, 1, 0));
    	GameRegistry.registerBlock(oreMagnesium, "Magnesium Ore");
    	
						oreManganese = new GenericBlock("Manganese Ore", "missing", "oreManganese", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Manganese Ore", new ItemStack(oreManganese, 1, 0));
    	GameRegistry.registerBlock(oreManganese, "Manganese Ore");
    	
						oreMercury = new GenericBlock("Mercury Ore", "missing", "oreMercury", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Mercury Ore", new ItemStack(oreMercury, 1, 0));
    	GameRegistry.registerBlock(oreMercury, "Mercury Ore");
    	
						oreMolybdenum = new GenericBlock("Molybdenum Ore", "missing", "oreMolybdenum", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Molybdenum Ore", new ItemStack(oreMolybdenum, 1, 0));
    	GameRegistry.registerBlock(oreMolybdenum, "Molybdenum Ore");
    	
						oreNeodymium = new GenericBlock("Neodymium Ore", "missing", "oreNeodymium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Neodymium Ore", new ItemStack(oreNeodymium, 1, 0));
    	GameRegistry.registerBlock(oreNeodymium, "Neodymium Ore");
    	
						oreNickel = new GenericBlock("Nickel Ore", "missing", "oreNickel", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Nickel Ore", new ItemStack(oreNickel, 1, 0));
    	GameRegistry.registerBlock(oreNickel, "Nickel Ore");
    	
						oreNiobium = new GenericBlock("Niobium Ore", "missing", "oreNiobium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Niobium Ore", new ItemStack(oreNiobium, 1, 0));
    	GameRegistry.registerBlock(oreNiobium, "Niobium Ore");
    	
						oreOsmium = new GenericBlock("Osmium Ore", "missing", "oreOsmium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Osmium Ore", new ItemStack(oreOsmium, 1, 0));
    	GameRegistry.registerBlock(oreOsmium, "Osmium Ore");
    	
						orePalladium = new GenericBlock("Palladium Ore", "missing", "orePalladium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Palladium Ore", new ItemStack(orePalladium, 1, 0));
    	GameRegistry.registerBlock(orePalladium, "Palladium Ore");
    	
						orePhosphorus = new GenericBlock("Phosphorus Ore", "OrePhosphorus", "orePhosphorus", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Phosphorus Ore", new ItemStack(orePhosphorus, 1, 0));
    	GameRegistry.registerBlock(orePhosphorus, "Phosphorus Ore");
    	
						orePlatinum = new GenericBlock("Platinum Ore", "missing", "orePlatinum", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Platinum Ore", new ItemStack(orePlatinum, 1, 0));
    	GameRegistry.registerBlock(orePlatinum, "Platinum Ore");
    	
						orePolonium = new GenericBlockRadioactive("Polonium Ore", "missing", "orePolonium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Polonium Ore", new ItemStack(orePolonium, 1, 0));
    	GameRegistry.registerBlock(orePolonium, "Polonium Ore");
    	
						orePotassium = new GenericBlock("Potassium Ore", "OrePotassium", "orePotassium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Potassium Ore", new ItemStack(orePotassium, 1, 0));
    	GameRegistry.registerBlock(orePotassium, "Potassium Ore");
    	
						orePraseodymium = new GenericBlock("Praseodymium Ore", "missing", "orePraseodymium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Praseodymium Ore", new ItemStack(orePraseodymium, 1, 0));
    	GameRegistry.registerBlock(orePraseodymium, "Praseodymium Ore");
    	
						oreProtactinium = new GenericBlockRadioactive("Protactinium Ore", "missing", "oreProtactinium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Protactinium Ore", new ItemStack(oreProtactinium, 1, 0));
    	GameRegistry.registerBlock(oreProtactinium, "Protactinium Ore");
    	
						oreRadium = new GenericBlockRadioactive("Radium Ore", "missing", "oreRadium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Radium Ore", new ItemStack(oreRadium, 1, 0));
    	GameRegistry.registerBlock(oreRadium, "Radium Ore");
    	
						oreRhenium = new GenericBlock("Rhenium Ore", "missing", "oreRhenium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Rhenium Ore", new ItemStack(oreRhenium, 1, 0));
    	GameRegistry.registerBlock(oreRhenium, "Rhenium Ore");
    	
						oreRhodium = new GenericBlock("Rhodium Ore", "missing", "oreRhodium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Rhodium Ore", new ItemStack(oreRhodium, 1, 0));
    	GameRegistry.registerBlock(oreRhodium, "Rhodium Ore");
    	
						oreRubidium = new GenericBlock("Rubidium Ore", "missing", "oreRubidium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Rubidium Ore", new ItemStack(oreRubidium, 1, 0));
    	GameRegistry.registerBlock(oreRubidium, "Rubidium Ore");
    	
						oreRuthenium = new GenericBlock("Ruthenium Ore", "missing", "oreRuthenium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Ruthenium Ore", new ItemStack(oreRuthenium, 1, 0));
    	GameRegistry.registerBlock(oreRuthenium, "Ruthenium Ore");
    	
						oreSamarium = new GenericBlock("Samarium Ore", "missing", "oreSamarium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Samarium Ore", new ItemStack(oreSamarium, 1, 0));
    	GameRegistry.registerBlock(oreSamarium, "Samarium Ore");
    	
						oreScandium = new GenericBlock("Scandium Ore", "OreScandium", "oreScandium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Scandium Ore", new ItemStack(oreScandium, 1, 0));
    	GameRegistry.registerBlock(oreScandium, "Scandium Ore");
    	
						oreSelenium = new GenericBlock("Selenium Ore", "missing", "oreSelenium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Selenium Ore", new ItemStack(oreSelenium, 1, 0));
    	GameRegistry.registerBlock(oreSelenium, "Selenium Ore");
    	
						oreSilicon = new GenericBlock("Silicon Ore", "OreSilicon", "oreSilicon", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Silicon Ore", new ItemStack(oreSilicon, 1, 0));
    	GameRegistry.registerBlock(oreSilicon, "Silicon Ore");
    	
						oreSilver = new GenericBlock("Silver Ore", "missing", "oreSilver", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Silver Ore", new ItemStack(oreSilver, 1, 0));
    	GameRegistry.registerBlock(oreSilver, "Silver Ore");
    	
						oreSodium = new GenericBlock("Sodium Ore", "OreSodium", "oreSodium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Sodium Ore", new ItemStack(oreSodium, 1, 0));
    	GameRegistry.registerBlock(oreSodium, "Sodium Ore");
    	
						oreStrontium = new GenericBlock("Strontium Ore", "missing", "oreStrontium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Strontium Ore", new ItemStack(oreStrontium, 1, 0));
    	GameRegistry.registerBlock(oreStrontium, "Strontium Ore");
    	
						oreSulfur = new GenericBlock("Sulfur Ore", "OreSulphur", "oreSulfur", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Sulfur Ore", new ItemStack(oreSulfur, 1, 0));
    	GameRegistry.registerBlock(oreSulfur, "Sulfur Ore");
    	
						oreTantalum = new GenericBlock("Tantalum Ore", "missing", "oreTantalum", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Tantalum Ore", new ItemStack(oreTantalum, 1, 0));
    	GameRegistry.registerBlock(oreTantalum, "Tantalum Ore");
    	
						oreTellurium = new GenericBlock("Tellurium Ore", "missing", "oreTellurium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Tellurium Ore", new ItemStack(oreTellurium, 1, 0));
    	GameRegistry.registerBlock(oreTellurium, "Tellurium Ore");
    	
						oreTerbium = new GenericBlock("Terbium Ore", "missing", "oreTerbium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Terbium Ore", new ItemStack(oreTerbium, 1, 0));
    	GameRegistry.registerBlock(oreTerbium, "Terbium Ore");
    	
						oreThallium = new GenericBlock("Thallium Ore", "missing", "oreThallium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Thallium Ore", new ItemStack(oreThallium, 1, 0));
    	GameRegistry.registerBlock(oreThallium, "Thallium Ore");
    	
						oreThorium = new GenericBlockRadioactive("Thorium Ore", "missing", "oreThorium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Thorium Ore", new ItemStack(oreThorium, 1, 0));
    	GameRegistry.registerBlock(oreThorium, "Thorium Ore");
    	
						oreThulium = new GenericBlock("Thulium Ore", "missing", "oreThulium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Thulium Ore", new ItemStack(oreThulium, 1, 0));
    	GameRegistry.registerBlock(oreThulium, "Thulium Ore");
    	
						oreTin = new GenericBlock("Tin Ore", "missing", "oreTin", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Tin Ore", new ItemStack(oreTin, 1, 0));
    	GameRegistry.registerBlock(oreTin, "Tin Ore");
    	
						oreTitanium = new GenericBlock("Titanium Ore", "OreTitanium", "oreTitanium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Titanium Ore", new ItemStack(oreTitanium, 1, 0));
    	GameRegistry.registerBlock(oreTitanium, "Titanium Ore");
    	
						oreTungsten = new GenericBlock("Tungsten Ore", "missing", "oreTungsten", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Tungsten Ore", new ItemStack(oreTungsten, 1, 0));
    	GameRegistry.registerBlock(oreTungsten, "Tungsten Ore");
    	
						oreUranium = new GenericBlockRadioactive("Uranium Ore", "missing", "oreUranium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Uranium Ore", new ItemStack(oreUranium, 1, 0));
    	GameRegistry.registerBlock(oreUranium, "Uranium Ore");
    	
						oreVanadium = new GenericBlock("Vanadium Ore", "missing", "oreVanadium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Vanadium Ore", new ItemStack(oreVanadium, 1, 0));
    	GameRegistry.registerBlock(oreVanadium, "Vanadium Ore");
    	
						oreYtterbium = new GenericBlock("Ytterbium Ore", "missing", "oreYtterbium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Ytterbium Ore", new ItemStack(oreYtterbium, 1, 0));
    	GameRegistry.registerBlock(oreYtterbium, "Ytterbium Ore");
    	
						oreYttrium = new GenericBlock("Yttrium Ore", "missing", "oreYttrium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Yttrium Ore", new ItemStack(oreYttrium, 1, 0));
    	GameRegistry.registerBlock(oreYttrium, "Yttrium Ore");
    	
						oreZinc = new GenericBlock("Zinc Ore", "missing", "oreZinc", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Zinc Ore", new ItemStack(oreZinc, 1, 0));
    	GameRegistry.registerBlock(oreZinc, "Zinc Ore");
    	
						oreZirconium = new GenericBlock("Zirconium Ore", "missing", "oreZirconium", "pickaxe", 1, 5F);
				//OreDictionary.registerOre("Zirconium Ore", new ItemStack(oreZirconium, 1, 0));
    	GameRegistry.registerBlock(oreZirconium, "Zirconium Ore");
    	
				
	}
}
