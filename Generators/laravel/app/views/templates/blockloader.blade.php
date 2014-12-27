package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import me.tomkent.chemcraft.Blocks.*;
import net.minecraftforge.oredict.OreDictionary;


public class BlockLoader {

	@foreach($blocks as $b)
	public static Block {{$b['OreID']}};
	@endforeach

	public static void initBlocks() {

		@foreach($blocks as $b)
		@if ($b['Radioactive'] == 'TRUE')
		{{$b['OreID']}} = new GenericBlockRadioactive("{{$b['OreName']}}", "{{$b['OreTexture']}}", "{{$b['OreID']}}", "{{$b['ToolClass']}}", {{$b['ToolTier']}}, {{$b['Hardness']}}F);
		@else
		{{$b['OreID']}} = new GenericBlock("{{$b['OreName']}}", "{{$b['OreTexture']}}", "{{$b['OreID']}}", "{{$b['ToolClass']}}", {{$b['ToolTier']}}, {{$b['Hardness']}}F);
		@endif
		//OreDictionary.registerOre("{{$b['OreName']}}", new ItemStack({{$b['OreID']}}, 1, 0));
    	GameRegistry.registerBlock({{$b['OreID']}}, "{{$b['OreName']}}");
    	
		@endforeach
		
	}
}
