// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

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
     * Initializes a file reader based on passed runtime arguments or a default file.
     * @param args the provided array of runtime arguments
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public static void main(String[] args)
    {
        InputFileReader filer;
        boolean showGUI = false;
        boolean showConsole = true;
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
            
        }
        if (showGUI)
        {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
            return;
        }
    }
}
