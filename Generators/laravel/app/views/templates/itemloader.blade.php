package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import me.tomkent.chemcraft.items.*;

public class ItemLoader {
	@foreach($items as $i)
	public static Item {{$i}};
	@endforeach
	
	
	public static void initItems() {
		@foreach($items as $i)
		{{$i}} = new {{$i}}();
		GameRegistry.registerItem({{$i}}, "{{$i}}");
		@endforeach
	}
}
