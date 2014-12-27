package me.tomkent.chemcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;


public class ItemLoader {
	@foreach($items as $i)
	public static Item {{$i['id']}};
	@endforeach
	
	
	public static void initItems() {
		@foreach($items as $i)
		{{$i['id']}} = new GenericItem("{{$i['id']}}","{{$i['texture']}}","{{$i['name']}}", {{$i['stacksize']}});
		GameRegistry.registerItem({{$i['id']}}, "{{$i['name']}}");
		@endforeach
	}
}
