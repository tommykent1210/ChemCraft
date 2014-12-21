package me.tomkent.chemcraft.utilities;

import me.tomkent.chemcraft.ChemCraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class NetworkUtilities {
	
	private String updateCurrentVersion = "";
	private String updateLatestVersion = "";

	public NetworkUtilities() {
		updateCurrentVersion = ChemCraft.modMetadata.version;
		updateLatestVersion = getLatestVersion();
		
		if(checkForUpdates()) {
			System.out.println("["+ChemCraft.MODID + "] Update available! Current version is " + updateCurrentVersion);
		}
	}
	
	public boolean checkForUpdates() {
		if (updateCurrentVersion != updateLatestVersion) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getLatestVersion() {
		return "1.0.140";
	}
	
	public void notifyOpUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		//check if player is opped and notify them if there's an update
		if (checkForUpdates() == true && MinecraftServer.getServer().getConfigurationManager().func_152596_g(event.player.getGameProfile())) {
			System.out.println("ChemCraft needs updating and Player is Op");
			event.player.addChatMessage(new ChatComponentText("["+ChemCraft.MODID + "] Update available! Latest version is " + updateLatestVersion +" while current version is " + updateCurrentVersion).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.AQUA)));
		}
	}
}
