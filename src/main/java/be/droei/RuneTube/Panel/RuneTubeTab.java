package be.droei.RuneTube.Panel;

import net.runelite.client.ui.ColorScheme;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

class RuneTubeTab extends JPanel
{
    @Inject
    RuneTubeTab(String name)
    {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        setLayout(layout);
        setToolTipText(name);
        setBackground(ColorScheme.DARKER_GRAY_COLOR);
    }
}
