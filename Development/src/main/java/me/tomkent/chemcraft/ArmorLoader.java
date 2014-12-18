package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import me.tomkent.chemcraft.Armor.ChemCraftHazmatArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorLoader {

	//armor materials
	public static ArmorMaterial Hazmat = EnumHelper.addArmorMaterial("Hazmat", 5, new int[]{1, 3, 2, 1}, 15);
	
	//armor variables
	public static Item HazmatHelmet;
	public static Item HazmatChestplate;
	public static Item HazmatLeggings;
	public static Item HazmatBoots;
	

	//Initialise the ArmorLoader
	public static void init() {
		GameRegistry.registerItem(HazmatHelmet = new ChemCraftHazmatArmor("hazmat_helmet", Hazmat, "hazmat", 0, 1), "hazmat_helmet"); //0 for helmet
		GameRegistry.registerItem(HazmatChestplate = new ChemCraftHazmatArmor("hazmat_chestplate", Hazmat, "hazmat", 1, 4), "hazmat_chestplate"); // 1 for chestplate
		GameRegistry.registerItem(HazmatLeggings = new ChemCraftHazmatArmor("hazmat_leggings", Hazmat, "hazmat", 2, 3), "hazmat_leggings"); // 2 for leggings
		GameRegistry.registerItem(HazmatBoots = new ChemCraftHazmatArmor("hazmat_boots", Hazmat, "hazmat", 3, 2), "hazmat_boots"); // 3 for boots
	}
}
