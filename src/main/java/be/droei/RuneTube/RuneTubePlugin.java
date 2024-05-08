package net.runelite.client.plugins.RuneTube.src.main.java.be.droei.RuneTube;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.RuneTube.src.main.java.be.droei.RuneTube.Config.RuneTubeConfig;

@Slf4j
@PluginDescriptor(
	name = "RuneTube"
)
public class RuneTubePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private RuneTubeConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}

	@Provides
	RuneTubeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RuneTubeConfig.class);
	}
}
