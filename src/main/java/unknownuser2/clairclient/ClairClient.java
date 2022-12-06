package unknownuser2.clairclient;

import unknownuser2.clairclient.events.TickEvents;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import unknownuser2.clairclient.command.CommandList;
import unknownuser2.clairclient.module.ModuleList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClairClient implements ClientModInitializer {
	public static MinecraftClient mc;
	public static final String MODID 	          	= "clairclient";
	public static final String VERSION         		= "0.0.1";
	public static final Logger LOGGER          		= LoggerFactory.getLogger(MODID);
	public static final TickEvents TICK_EVENTS      = new TickEvents();
	public static final ModuleList MODULE_LIST		= new ModuleList();
	public static final CommandList COMMAND_LIST	= new CommandList();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Clair Client v" + VERSION + " has started initialization!");
		mc = MinecraftClient.getInstance();
		LOGGER.info("Clair Client initialized!");
	}
}
