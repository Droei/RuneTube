package be.droei.RuneTube.Panel;

import be.droei.RuneTube.RuneTubePlugin;
import be.droei.RuneTube.classes.VideoData;
import net.runelite.client.ui.ColorScheme;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.util.List;

class RuneTubeTab extends JPanel
{
    RuneTubePlugin runeTubePlugin;
    @Inject
    RuneTubeTab(String name, RuneTubePlugin runeTubePlugin)
    {

        this.runeTubePlugin = runeTubePlugin;

        System.out.println(name);
        System.out.println(runeTubePlugin.getVideoData());

        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        setLayout(layout);
        setToolTipText(name);
        setBackground(ColorScheme.DARKER_GRAY_COLOR);
    }
}
