// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;

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
    private Shape[] influencerShapes;
    private Button quitButton;
    private Button sortByChannel;
    private Button sortByEngagement;
    private Button traditionalEngagement;
    private Button reachEngagement;

    private TextShape sortText;
    private TextShape engagementText;
    private TextShape timePeriod;

    private static final int RECT_WIDTH = 50;

    private static final int HEIGHT_FACTOR_TRAD = 10;

    private static final int HEIGHT_FACTOR_REACH = 10;

    private static final int WINDOW_HEIGHT = 600;

    private static final int WINDOW_WIDTH = 1000;

    /**
     * Constructor for the GUIAnalyticsWindow class
     */
    public GUIAnalyticsWindow()
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

        sortByEngagement = new Button("Sort by Engagement Rate");
        window.addButton(sortByEngagement, WindowSide.NORTH);
        sortByEngagement.onClick(this, "clickedSortByEngagementRate");

        traditionalEngagement = new Button("Traditional Engagement Rate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        traditionalEngagement.onClick(this, "clickedTraditional");

        reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(reachEngagement, WindowSide.WEST);
        reachEngagement.onClick(this, "clickedReach");

        sortText = addTextShape(5, 50, "");
        engagementText = addTextShape(5, 30, "");
        timePeriod = addTextShape(5, 10, "");
    }


    /**
     * Closes down the window when the quit button is clicked
     * 
     * @param button
     *            is the passed in button
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * Shows the data displayed for Janurary
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            Janurary's data
     */
    public void clickedJanButton(Button button)
    {
        timePeriod.setText("Showing January");
    }


    /**
     * Shows the data displayed for February
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            February's data
     */
    public void clickedFebButton(Button button)
    {
        timePeriod.setText("Showing February");
    }


    /**
     * Shows the data displayed for March
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            March's data
     */
    public void clickedMarchButton(Button button)
    {
        timePeriod.setText("Showing March");
    }


    /**
     * Displays the first quarters data
     * 
     * @param button
     *            is the button we want to complete the action of displaying the
     *            first quarters data
     */
    public void clickedFirstQuarterButton(Button button)
    {
        timePeriod.setText("Showing First Quarter (Jan-March)");
    }


    /**
     * Sorts the items by channel name when targetted button is clicked
     * 
     * @param button
     *            is the button we want to complete the action of sorting the
     *            items by channel name
     */
    public void clickedSortByChannelName(Button button)
    {
<<<<<<< HEAD
        sortText.setText("Sorting by Channel Name");
=======
        TextShape channelText =
            addTextShape(300, 500, "Sorting by Channel Name");
>>>>>>> fb08c874b70065003d6b5572e2d6b7996264b428
    }


    /**
     * Sorts the items but engagement rate when targeted button is clicked
     * 
     * @param button
     *            is the button we want to complete the action of sorting the
     *            items by engagement rate
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
     *            the Traditional Engagement Rate button to activate this method
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
     *            the Reach Engagement Rate button to activate this method
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
     * Ends the graphic display
     */
    public void endGraphics()
    {
        window.removeAllShapes();
        addTextShape(400, 400, "All users processed!");
    }

}
