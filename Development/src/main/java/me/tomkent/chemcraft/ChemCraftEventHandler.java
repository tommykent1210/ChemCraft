package me.tomkent.chemcraft;

import me.tomkent.chemcraft.utilities.NetworkUtilities;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ChemCraftEventHandler {

	private static NetworkUtilities network;
	
	public ChemCraftEventHandler() {
		network = new NetworkUtilities();
	}
	
	public void init(FMLInitializationEvent event) {

	}
	
	@SubscribeEvent
	public void notifyOpUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		network.notifyOpUpdate(event);
	}
	
		
}
