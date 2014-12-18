package me.tomkent.chemcraft.Armor;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ChemCraftHazmatArmor extends ItemArmor{
	public String textureName;
	public int RadiationResistance;

	public ChemCraftHazmatArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type, int RadiationResistance) {
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(ChemCraft.MODID + "_" + unlocalizedName);
	    this.setTextureName(ChemCraft.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(ChemCraft.tabChemcraftItems);
	    this.RadiationResistance = RadiationResistance;
	    
	}
	
	public int getRadiationResistance() {
		return RadiationResistance;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return ChemCraft.MODID + ":armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
