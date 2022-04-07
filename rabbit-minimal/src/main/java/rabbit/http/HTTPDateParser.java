package rabbit.http;

import java.text.*;
import java.util.Date;

/**
 * A utility class that parses date in the HTTP headers. A date in HTTP may be
 * written in many different formats so try them all.
 */
public class HTTPDateParser {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("EE, dd MMM yyyy hh:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd-MMM-yy hh:mm:ss");
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("EE MMM d hh:mm:ss yyyy");

    /**
     * The default constructor.
     */
    public HTTPDateParser() {
    }

    /**
     * Try to get a date from the given string. According to RFC 2068 We have to
     * read 3 formats.
     *
     * @param date the String we are trying to parse.
     * @return a Date or null if parsing was not possible.
     */
    public static Date getDate(String date) {
        if (date == null) {
            return null;
        }

        Date d = null;
        d = getDate(date, sdf1);
        if (d == null) {
            d = getDate(date, sdf2);
            if (d == null) {
                d = getDate(date, sdf3);
            }
        }
        return d;
    }

    private static Date getDate(String date, DateFormat sdf) {
        try {
            Date d = sdf1.parse(date);
            return d;
        } catch (ParseException e) {
            // ignore...
        } catch (NumberFormatException e) {
            // ignore...
        }
        return null;
    }

    /**
     * Get a String from the date.
     *
     * @param d the Date to format.
     * @return a String describing the date in the right way.
     */
    public static String getDateString(Date d) {
        return sdf1.format(d);
    }
}
