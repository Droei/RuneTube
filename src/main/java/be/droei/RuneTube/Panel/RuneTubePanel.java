package be.droei.RuneTube.Panel;

import be.droei.RuneTube.Api.ApiProcessor;
import be.droei.RuneTube.Api.RuneTubeApi;
import be.droei.RuneTube.classes.VideoData;
import com.google.inject.Inject;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.List;

import static be.droei.RuneTube.PanelManager.HTMLStringCreator.*;

public class RuneTubePanel extends PluginPanel
{
    @Inject
    private EventBus eventBus;
    private static ImageIcon TEST_ICON;
    private static final Dimension ICON_SIZE = new Dimension(32, 175);

    private final ApiProcessor apiProcessor = new ApiProcessor();

    public void init() throws FileNotFoundException {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        JPanel versionPanel = new JPanel();
        versionPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
        versionPanel.setLayout(new GridLayout(0, 1));

        final Font smallFont = FontManager.getRunescapeSmallFont();

        JLabel version = new JLabel(htmlLabel("Made by: ", "Droei"));
        JLabel version2 = new JLabel(htmlLabel("Version: ", "Alpha 0.0.1"));
        version.setFont(smallFont);

        versionPanel.add(version);
        versionPanel.add(version2);

        add(versionPanel, BorderLayout.SOUTH);
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel(htmlTitle());
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);


        JPanel capyPanel = new JPanel();
        capyPanel.setBackground(ColorScheme.BORDER_COLOR);
        capyPanel.setLayout(new GridLayout(0, 1));


        for(VideoData videoData : apiProcessor.GetAllVideos()){

//            JLabel vidTitle = new JLabel(videoData.title);
//            capyPanel.add(vidTitle);

            JLabel html = new JLabel(htmlImage(videoData));
            html.setBorder(new EmptyBorder(1, 0, 1, 0));

            Runnable callback = () -> LinkBrowser.browse("https://www.youtube.com/watch?v="+videoData.id);
            html.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseReleased(MouseEvent e)
                {
                    callback.run();
                }
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    html.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    html.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
            capyPanel.add(html);
        }
        add(capyPanel);
        eventBus.register(this);
    }

    public void deInit() {
        eventBus.unregister(this);
    }
}