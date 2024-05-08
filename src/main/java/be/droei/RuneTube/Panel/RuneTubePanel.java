package be.droei.RuneTube.Panel;

import be.droei.RuneTube.Api.ApiProcessor;
import be.droei.RuneTube.classes.VideoData;
import be.droei.RuneTube.enums.ChannelTagEnum;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RuneTubePanel extends PluginPanel {

    private final JPanel display = new JPanel();

    private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);

    private List<VideoData> videoData;

    @Getter
    private final ApiProcessor apiProcessor;

    @Inject
    private RuneTubePanel(ApiProcessor apiProcessor)
    {
        super(false);

        this.apiProcessor = apiProcessor;
        this.videoData = apiProcessor.GetAllVideos();

        setLayout(new BorderLayout());
        setBackground(ColorScheme.PROGRESS_INPROGRESS_COLOR);

        String type = "All";
        MaterialTab allTab = new MaterialTab(type, tabGroup,
                new RuneTubeTab(this.videoData, type));
        tabGroup.addTab(allTab);

        type = "Variety";
        MaterialTab varietyTab = new MaterialTab(type, tabGroup,
                new RuneTubeTab(apiProcessor.FilterByTag(videoData, ChannelTagEnum.VARIETY), type));
        tabGroup.addTab(varietyTab);

        type = "Progress";
        MaterialTab progressTab = new MaterialTab(type, tabGroup,
                new RuneTubeTab(apiProcessor.FilterByTag(videoData, ChannelTagEnum.PROGRESS), type));
        tabGroup.addTab(progressTab);

        type = "PvP";
        MaterialTab pvpTab = new MaterialTab(type, tabGroup,
                new RuneTubeTab(apiProcessor.FilterByTag(videoData, ChannelTagEnum.PVP), type));
        tabGroup.addTab(pvpTab);

        tabGroup.select(allTab);

        add(tabGroup, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
    }
}
