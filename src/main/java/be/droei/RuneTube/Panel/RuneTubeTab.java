package be.droei.RuneTube.Panel;

import be.droei.RuneTube.Api.ApiProcessor;
import be.droei.RuneTube.PanelManager.HTMLStringCreator;
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
    @Inject
    RuneTubeTab(List<VideoData> videoData, String type)
    {
        System.out.println("test " + videoData);

        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        setLayout(layout);
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel(HTMLStringCreator.htmlTitle(type));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

}
