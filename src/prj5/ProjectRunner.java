package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * Initializes a file reader to create an output file for social media
 * influencer engagement rates. Creates a GUI to display the social media
 * influencer analytics dashboard.
 * 
 * @author bradl
 * @version Nov 21, 2024
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Initializes a file reader based on passed runtime arguments or a default
     * file.
     * 
     * @param args
     *            the provided array of runtime arguments
     * @throws IOException
     * @throws SocialMediaException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    // ~Public Methods ........................................................
    public static void main(String[] args)
        throws IOException,
        ParseException
    {
        InputFileReader filer;
        boolean showGUI = true;
        boolean showConsole = false;
        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        if (showConsole)
        {
            /*
             * TODO: For intermediate Submission - Should print the data on the
             * console
             */
            System.out.println(filer.printAnalyticsFile());
        }
        if (showGUI)
        {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
            GUIAnalyticsWindow window = new GUIAnalyticsWindow();
        }
    }
}
