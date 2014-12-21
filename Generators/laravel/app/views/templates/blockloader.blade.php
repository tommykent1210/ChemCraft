package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import me.tomkent.chemcraft.Blocks.*;
import net.minecraftforge.oredict.OreDictionary;


public class BlockLoader {

	@foreach($blocks as $b)
	public static Block {{$b}};
	@endforeach

	public static void initBlocks() {

		@foreach($blocks as $b)
		{{$b}} = new {{$b}}();
		//OreDictionary.registerOre("{{$b}}", new ItemStack({{$b}}, 1, 0));
    	GameRegistry.registerBlock({{$b}}, "{{$b}}");
    	
		@endforeach
		
	}
}
