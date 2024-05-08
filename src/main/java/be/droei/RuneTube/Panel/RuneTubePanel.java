package be.droei.RuneTube.Panel;

import be.droei.RuneTube.Api.ApiProcessor;
import be.droei.RuneTube.Api.RuneTubeApi;
import be.droei.RuneTube.classes.VideoData;
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
    private final MaterialTab testTab;

    @Getter
    private final RuneTubeTab runeTubeTab;
    @Getter
    private final ApiProcessor apiProcessor;

    @Inject
    private RuneTubePanel(RuneTubeTab runeTubeTab, ApiProcessor apiProcessor)
    {
        super(false);

        this.apiProcessor = apiProcessor;
        this.runeTubeTab = runeTubeTab;

        apiProcessor.GetAllVideos();

        setLayout(new BorderLayout());
        setBackground(ColorScheme.PROGRESS_INPROGRESS_COLOR);
//
        MaterialTab allTab = new MaterialTab("All", tabGroup, runeTubeTab);
        testTab = new MaterialTab("Progress", tabGroup, runeTubeTab);
//        searchTab2 = new MaterialTab("Variety", tabGroup, testNewPanel);
//        searchTab3 = new MaterialTab("Pvp", tabGroup, testNewPanel);
//
//        tabGroup.setBorder(new EmptyBorder(5, 0, 0, 0));
        tabGroup.addTab(allTab);
        tabGroup.addTab(testTab);
//        tabGroup.addTab(searchTab2);
//        tabGroup.addTab(searchTab3);
        tabGroup.select(allTab);
//
        add(tabGroup, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
    }
}
