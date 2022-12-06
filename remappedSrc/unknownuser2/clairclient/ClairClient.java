package unknownuser2.clairclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.loader.language.LanguageAdapter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import net.minecraft.world.tick.WorldTickScheduler;
import unknownuser2.clairclient.command.CommandList;
import unknownuser2.clairclient.module.ModuleList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClairClient implements ClientModInitializer {
	public static MinecraftClient mc;
	public static final String MODID 	          	= "clairclient";
	public static final String VERSION         		= "0.0.1";
	public static final Logger LOGGER          		= LoggerFactory.getLogger(MODID);
	public static final ModuleList MODULE_LIST		= new ModuleList();
	public static final CommandList COMMAND_LIST	= new CommandList();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Clair Client v" + VERSION + " has started initialization!");

		mc = MinecraftClient.getInstance();
		LOGGER.info("Clair Client initialized!");
	}
}
