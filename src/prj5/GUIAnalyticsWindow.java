// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import cs2.Button;
import cs2.Window;
import cs2.Shape;

// -------------------------------------------------------------------------
/**
 * Initializes a GUI to visualize a dashboard containing a bar chart of
 * analytics data for different social media influencers. This can be sorted by
 * the traditional engagement rate or reach engagement rate.
 * 
 * @author bradl
 * @version Dec 2, 2024
 */
public class GUIAnalyticsWindow {
    private Window window;
    private Button janButton;
    private Button febButton;
    private Button marchButton;
    private Button firstQuartButton;
    private Shape[] influencerShapes;
    private Button quitButton;
    private Button sortByChannel;
    private Button sortByEngagement;
    private static final int RECT_WIDTH = ?;
    private static final int BASE_WIDTH = ?;

    /**
     * Constructor for the GUIAnalyticsWindow class
     */
    public GUIAnalyticsWindow() {

    }


    /**
     * Closes down the window when the quit button is clicked
     * 
     * @param button
     *            is the passed in button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Sorts the items by channel name when targetted button is clicked
     * 
     * @param button
     *            is the button we want to complete the action of sorting the
     *            items by channel name
     */
    public void clickedSortByChannelName(Button button) {
        // Code
    }


    /**
     * Sorts the items but engagement rate when targeted button is clicked
     * 
     * @param button
     *            is the button we want to complete the action of sorting the
     *            items by engagement rate
     */
    public void clickedSortByEngagementRate(Button button) {
        // Code
    }


    /**
     * Shows the data displayed for Janurary
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            Janurary's data
     */
    public void clickedJanuaryButton(Button button) {
        // Code
    }


    /**
     * Shows the data displayed for February
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            February's data
     */
    public void clickedFebruaryButton(Button button) {
        // Code
    }


    /**
     * Shows the data displayed for March
     * 
     * @param button
     *            is the button we want to complete the action of showing
     *            March's data
     */
    public void clickedMarchButton(Button button) {
        // Code
    }


    /**
     * Displays the first quarters data
     * 
     * @param button
     *            is the button we want to complete the action of displaying the
     *            first quarters data
     */
    public void clickedFirstQuarter(Button button) {
        // Code
    }


    /**
     * Adds a new text shape to the window
     * 
     * @param textShape The textShape we want to add to the window
     * @param x The location of where we want the textShape on the x axis
     * @param y The location of where we want the textShape on the y axis
     */
    public void addTextShape(String textShape, int x, int y) {
        // Code
    }


    /**
     * Updates the window to match the users input
     */
    public void update() {
        // Code
    }


    /**
     * Ends the graphic display
     */
    public void endGraphics() {
        // Code
    }

}
