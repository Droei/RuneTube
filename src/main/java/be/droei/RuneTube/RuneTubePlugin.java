package be.droei.RuneTube;

import be.droei.RuneTube.Config.RuneTubeConfig;
import be.droei.RuneTube.Panel.RuneTubePanel;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "RuneTube"
)
public class RuneTubePlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	//	private MyAwesomePluginPanel tabTestPanel;
	private RuneTubePanel runeTubePanel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		runeTubePanel = injector.getInstance(RuneTubePanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "/youtube.png");

		navButton = NavigationButton.builder()
				.tooltip("Test")
				.icon(icon)
				.priority(0)
				.panel(runeTubePanel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
		runeTubePanel = null;
		navButton = null;
	}


	@Provides
	RuneTubeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RuneTubeConfig.class);
	}
}
