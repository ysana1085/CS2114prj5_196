// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu), Liam O' Donnell (liamod42@vt.edu)

package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import java.util.Comparator;
import list.AList;

// -------------------------------------------------------------------------
/**
 * Initializes a GUI to visualize a dashboard containing a bar chart of
 * analytics data for different social media influencers. This can be sorted by
 * the traditional engagement rate or reach engagement rate.
 * 
 * @author bradl
 * @version Dec 2, 2024
 */

public class GUIAnalyticsWindow
{
    private Window window;
    private Button janButton;
    private Button febButton;
    private Button marchButton;
    private Button firstQuarterButton;
    private Button quitButton;
    private Button sortByChannel;
    private Button sortByEngagementButton;
    private Button traditionalEngagementButton;
    private Button reachEngagementButton;

    private TextShape sortText;
    private TextShape engagementText;
    private TextShape timePeriod;

    private Shape[] influencerShapes;
    private TextShape[] influencerNames;
    private TextShape[] influencerRates;
    private static Color[] SHAPE_COLORS = new Color[4];
    private DLinkedList<Influencer> influencers;

    private int monthIndex;

    private static final int RECT_WIDTH = 50;

    private static final int WINDOW_HEIGHT = 600;

    private static final int WINDOW_WIDTH = 1000;

    private static final int BAR_SPACING = 125;

    private static final int RATE_HEIGHT = 460;

    private static final int NAME_HEIGHT = 440;

    private static final int BAR_BASE_HEIGHT = 400;

    private static final int BAR_MAX_HEIGHT = 300;

    private static final int MAX_CHARS = 12;

    private static final int FONT_SIZE = 12;

    // ----------------------------------------------------------
    /**
     * Create a new GUIAnalyticsWindow object.
     * 
     * @param influencers
     *            a doubly linked list of social media influencers provided from
     *            the runner class
     */
    public GUIAnalyticsWindow(DLinkedList<Influencer> influencers)
    {
        window = new Window("Social Media Vis");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        janButton = new Button("January");
        window.addButton(janButton, WindowSide.SOUTH);
        janButton.onClick(this, "clickedJanButton");

        febButton = new Button("February");
        window.addButton(febButton, WindowSide.SOUTH);
        febButton.onClick(this, "clickedFebButton");

        marchButton = new Button("March");
        window.addButton(marchButton, WindowSide.SOUTH);
        marchButton.onClick(this, "clickedMarchButton");

        firstQuarterButton = new Button("First Quarter(Jan - March)");
        window.addButton(firstQuarterButton, WindowSide.SOUTH);
        firstQuarterButton.onClick(this, "clickedFirstQuarterButton");

        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");

        sortByChannel = new Button("Sort by Channel Name");
        window.addButton(sortByChannel, WindowSide.NORTH);
        sortByChannel.onClick(this, "clickedSortByChannelName");

        sortByEngagementButton = new Button("Sort by Engagement Rate");
        window.addButton(sortByEngagementButton, WindowSide.NORTH);
        sortByEngagementButton.onClick(this, "clickedSortByEngagementRate");

        traditionalEngagementButton = new Button("Traditional Engagement Rate");
        window.addButton(traditionalEngagementButton, WindowSide.WEST);
        traditionalEngagementButton.onClick(this, "clickedTraditional");

        reachEngagementButton = new Button("Reach Engagement Rate");
        window.addButton(reachEngagementButton, WindowSide.WEST);
        reachEngagementButton.onClick(this, "clickedReach");

        sortText = addTextShape(5, 50, "");
        engagementText = addTextShape(5, 30, "");
        timePeriod = addTextShape(5, 10, "");

        this.influencers = influencers;
        influencerShapes = new Shape[influencers.getLength()];
        influencerNames = new TextShape[influencers.getLength()];
        influencerRates = new TextShape[influencers.getLength()];

        SHAPE_COLORS[0] = new Color(255, 156, 68);
        SHAPE_COLORS[1] = new Color(72, 188, 140);
        SHAPE_COLORS[2] = new Color(16, 84, 108);
        SHAPE_COLORS[3] = new Color(88, 132, 212);
    }


    /**
     * Closes out of the window when the quit button is clicked
     * 
     * @param button
     *            the Quit button used to activate this button when clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * Displays the engagement rates of each influencer for the January month
     * 
     * @param button
     *            the January button used to activate this method when clicked
     */
    public void clickedJanButton(Button button)
    {
        monthIndex = 0;
        timePeriod.setText("Showing January");
        updateShapes(monthIndex);
    }


    /**
     * Displays the engagement rates of each influencer for the February month
     * 
     * @param button
     *            the February button used to activate this method when clicked
     */
    public void clickedFebButton(Button button)
    {
        monthIndex = 1;
        timePeriod.setText("Showing February");
        updateShapes(monthIndex);
    }


    /**
     * Displays the engagement rates of each influencer for the March month
     * 
     * @param button
     *            the March button used to activate this method when clicked
     */
    public void clickedMarchButton(Button button)
    {
        monthIndex = 2;
        timePeriod.setText("Showing March");
        updateShapes(monthIndex);
    }


    /**
     * Displays the engagement rates of each influencer for the first quarter
     * (Jan - March)
     * 
     * @param button
     *            the First Quarter button used to activate this method when
     *            clicked
     */
    public void clickedFirstQuarterButton(Button button)
    {
        timePeriod.setText("Showing First Quarter (Jan-March)");
        if (influencerShapes[0] != null)
        {
            for (int i = 0; i < influencers.getLength(); i++)
            {
                window.removeShape(influencerShapes[i]);
                window.removeShape(influencerNames[i]);
                window.removeShape(influencerRates[i]);
            }
        }
        else
        {
            engagementText.setText("Traditional Engagement Rate");
            sortText.setText("Sorting by Channel Name");
        }
        if (sortText.getText().equals("Sorting by Engagement Rate"))
        {
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                influencers.insertionSort(new CompareByReach());
            }
            else
            {
                influencers.insertionSort(new CompareByTraditional());
            }
        }
        else
        {
            influencers.insertionSort(new CompareByName());
        }
        double max = 0;
        for (int i = 0; i < influencers.getLength(); i++)
        {
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                if (toDouble(
                    influencers.getEntry(i)
                        .firstQuarterReachEngagementRate()) > max)
                {
                    max = toDouble(
                        influencers.getEntry(i)
                            .firstQuarterReachEngagementRate());
                }
            }
            else
            {
                if (toDouble(
                    influencers.getEntry(i)
                        .firstQuarterTraditionalEngagementRate()) > max)
                {
                    max = toDouble(
                        influencers.getEntry(i)
                            .firstQuarterTraditionalEngagementRate());
                }
            }
        }
        double factor = BAR_MAX_HEIGHT / max;
        if (engagementText.getText().equals("Reach Engagement Rate"))
        {
            influencers.insertionSort(new CompareByReach());
        }
        else
        {
            influencers.insertionSort(new CompareByTraditional());
        }
        for (int i = 0; i < influencers.getLength(); i++)
        {
            double engagementRate;
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                engagementRate = toDouble(
                    influencers.getEntry(i).firstQuarterReachEngagementRate());
            }
            else
            {
                engagementRate = toDouble(
                    influencers.getEntry(i)
                        .firstQuarterTraditionalEngagementRate());
            }
            influencerShapes[i] = new Shape(
                (i + 1) * BAR_SPACING,
                BAR_BASE_HEIGHT - (int)(engagementRate * factor),
                RECT_WIDTH,
                (int)(engagementRate * factor),
                SHAPE_COLORS[i]);
            window.addShape(influencerShapes[i]);
            String channelName = influencers.getEntry(i).getChannelName();
            if (channelName.length() > MAX_CHARS)
            {
                influencers.getEntry(i)
                    .setChannelName(channelName.substring(0, MAX_CHARS));
            }
            influencerNames[i] = addTextShape(
                (i + 1) * BAR_SPACING,
                NAME_HEIGHT,
                influencers.getEntry(i).getChannelName());
            influencerRates[i] = addTextShape(
                (i + 1) * BAR_SPACING,
                RATE_HEIGHT,
                "" + engagementRate);
        }
    }


    /**
     * Sorts the social media influencers in ascending order by channel name
     * 
     * @param button
     *            the Sort by Channel Name button used to activate this method
     *            when clicked
     */
    public void clickedSortByChannelName(Button button)
    {
        sortText.setText("Sorting by Channel Name");
        updateShapes(monthIndex);
    }


    /**
     * Sorts the social media influencers by engagement rate in descending order
     * 
     * @param button
     *            the Sort by Engagement Rate button used to activate this
     *            method when clicked
     */
    public void clickedSortByEngagementRate(Button button)
    {
        sortText.setText("Sorting by Engagement Rate");
        updateShapes(monthIndex);
    }


    // ----------------------------------------------------------
    /**
     * Creates rectangles for the bar chart, with the height representing
     * calculated traditional engagement rate of a social media influencer.
     * 
     * @param button
     *            the Traditional Engagement Rate button used to activate this
     *            method when clicked
     */
    public void clickedTraditional(Button button)
    {
        engagementText.setText("Traditional Engagement Rate");
        updateShapes(monthIndex);
    }


    // ----------------------------------------------------------
    /**
     * Creates rectangles for the bar chart, with the height representing
     * calculated reach engagement rate of a social media influencer.
     * 
     * @param button
     *            the Reach Engagement Rate button used to activate this method
     *            when clicked
     */
    public void clickedReach(Button button)
    {
        engagementText.setText("Reach Engagement Rate");
        updateShapes(monthIndex);
    }


    private TextShape addTextShape(int x, int y, String text)
    {
        if (text != null)
        {
            TextShape shape = new TextShape(x, y, text, Color.black, FONT_SIZE);
            shape.setBackgroundColor(Color.white);
            window.addShape(shape);
            return shape;
        }
        return null;
    }


    private double toDouble(String str)
    {
        try
        {
            return Double.parseDouble(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    private void updateShapes(int index)
    {
        if (influencerShapes[0] != null)
        {
            for (int i = 0; i < influencers.getLength(); i++)
            {
                window.removeShape(influencerShapes[i]);
                window.removeShape(influencerNames[i]);
                window.removeShape(influencerRates[i]);
            }
        }
        else
        {
            engagementText.setText("Traditional Engagement Rate");
            sortText.setText("Sorting by Channel Name");
        }
        double factor = getHeightFactor(index);
        if (sortText.getText().equals("Sorting by Engagement Rate"))
        {
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                influencers.insertionSort(new CompareByMonth(false, index));
            }
            else
            {
                influencers.insertionSort(new CompareByMonth(true, index));
            }
        }
        else
        {
            influencers.insertionSort(new CompareByName());
        }
        // create all rectangles and text fields
        for (int i = 0; i < influencers.getLength(); i++)
        {
            double engagementRate;
            // get engagement rate from monthData List at specified index
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                engagementRate = toDouble(
                    influencers.getEntry(i).getMonthData().getEntry(index)
                        .getReachEngagementRate());
            }
            else
            {
                engagementRate = toDouble(
                    influencers.getEntry(i).getMonthData().getEntry(index)
                        .getTraditionalEngagementRate());
            }
            influencerShapes[i] = new Shape(
                (i + 1) * BAR_SPACING,
                BAR_BASE_HEIGHT - (int)(engagementRate * factor),
                RECT_WIDTH,
                (int)(engagementRate * factor),
                SHAPE_COLORS[i]);
            String channelName = influencers.getEntry(i).getChannelName();
            if (channelName.length() > MAX_CHARS)
            {
                influencers.getEntry(i)
                    .setChannelName(channelName.substring(0, MAX_CHARS));
            }
            influencerNames[i] = addTextShape(
                (i + 1) * BAR_SPACING,
                NAME_HEIGHT,
                influencers.getEntry(i).getChannelName());
            window.addShape(influencerShapes[i]);
            influencerRates[i] = addTextShape(
                (i + 1) * BAR_SPACING,
                RATE_HEIGHT,
                "" + engagementRate);
        }
    }


    private double getHeightFactor(int index)
    {
        double max = 0;
        for (int i = 0; i < influencers.getLength(); i++)
        {
            InteractionData data =
                influencers.getEntry(i).getMonthData().getEntry(index);
            if (engagementText.getText().equals("Reach Engagement Rate"))
            {
                if (toDouble(data.getReachEngagementRate()) > max)
                {
                    max = toDouble(data.getReachEngagementRate());
                }
            }
            else
            {
                if (toDouble(data.getTraditionalEngagementRate()) > max)
                {
                    max = toDouble(data.getTraditionalEngagementRate());
                }
            }
        }
        return BAR_MAX_HEIGHT / max;
    }
}
