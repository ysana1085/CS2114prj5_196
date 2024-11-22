import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import cs1705.IOHelper;

/**
 * 
 */

public class InputFileReader {

    public static final int VALUES = 10;
    private DLinkedList<Influencer> influencers;

    public InputFileReader(String arg) {
        this.readAnalyticsFile(arg);
        influencers = new DLinkedList<Influencer>();
    }


    private int toInt(String str) {
        try {
            return Integer.parseInt(str);
        }
        catch (Exception e) {
            return 0;
        }
    }


    public DLinkedList<Influencer> readAnalyticsFile(String file)
        throws ParseException,
        FileNotFoundException {

        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine()) {

            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (month.equals("January") || month.equals("February") || month
                .equals("March")) {
                if (isValidMonth(month)) {
                    Influencer influencer = new Influencer(username, channel,
                        country, mainTopic);
                    influencers.add(influencer);

                }

            } // end while
            inStream.close();
        }
    }


    private boolean isValidMonth(String month) {
        String[] valid = { "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December" };
        return Arrays.asList(valid).contains(month);
    }

}
