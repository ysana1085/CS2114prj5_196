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

    private AList<Shape> influencerShapes;
    private DLinkedList<Influencer> influencers;

    private static final int RECT_WIDTH = 50;

    private static final int HEIGHT_FACTOR_TRAD = 10;

    private static final int HEIGHT_FACTOR_REACH = 10;

    private static final int WINDOW_HEIGHT = 600;

    private static final int WINDOW_WIDTH = 1000;

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
        timePeriod.setText("Showing January");
    }


    /**
     * Displays the engagement rates of each influencer for the February month
     * 
     * @param button
     *            the February button used to activate this method when clicked
     */
    public void clickedFebButton(Button button)
    {
        timePeriod.setText("Showing February");
    }


    /**
     * Displays the engagement rates of each influencer for the March month
     * 
     * @param button
     *            the March button used to activate this method when clicked
     */
    public void clickedMarchButton(Button button)
    {
        timePeriod.setText("Showing March");
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
    }


    private TextShape addTextShape(int x, int y, String text)
    {
        if (text != null)
        {
            TextShape shape = new TextShape(x, y, text, Color.black);
            shape.setBackgroundColor(Color.white);
            window.addShape(shape);
            return shape;
        }
        return null;
    }


    /**
     * Updates the window to match the users input
     */
    public void update()
    {
        // check in for office hours about this
    }


    /**
     * Ends the graphic display by removing all shapes and displaying a message
     */
    public void endGraphics()
    {
        window.removeAllShapes();
        addTextShape(400, 400, "All users processed!");
    }

}
