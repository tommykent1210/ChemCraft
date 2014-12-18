package me.tomkent.chemcraft.Armor;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ChemCraftArmor extends ItemArmor{
	public String textureName;

	public ChemCraftArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
	    super(material, 0, type);
	    this.textureName = textureName;
	    this.setUnlocalizedName(ChemCraft.MODID + "_" + unlocalizedName);
	    this.setTextureName(ChemCraft.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(ChemCraft.tabChemcraftItems);
	    
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return ChemCraft.MODID + ":armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
