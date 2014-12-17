package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;

public class RecipeManager {

	public static void initRecipes() {
		<?php $GenHelper = new GenHelper(); ?>
		//AUTO GENERATED SMELTING RECIPES
		@foreach ($smelting as $smelt)
		GameRegistry.addSmelting({{$GenHelper->getItemStack($smelt["SmeltingInputType"].".".$smelt["SmeltingInput"], 1)}}, {{$GenHelper->getItemStack($smelt["OutputItemType"].".".$smelt["OutputItem"], $smelt["OutputAmount"])}}, 0.1F);
		@endforeach

		//AUTO GENERATED SHAPELESS RECIPES
		@foreach ($shapeless as $shape)
		GameRegistry.addShapelessRecipe({{$GenHelper->getItemStack($shape["OutputItemType"].".".$shape["OutputItem"], $shape["OutputAmount"])}}, new Object[]
		{
		    	@if($shape["Items"])
		{{implode(",", $shape["Items"])}} 
		    	@endif
	});
		@endforeach
	}
	
}