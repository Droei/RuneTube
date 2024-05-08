package net.runelite.client.plugins.RuneTube.src.test.java.be.droei.RuneTube;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.RuneTube.src.main.java.be.droei.RuneTube.RuneTubePlugin;

public class RuneTubePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(RuneTubePlugin.class);
		RuneLite.main(args);
	}
}