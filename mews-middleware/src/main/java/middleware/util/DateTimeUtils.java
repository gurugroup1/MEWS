package middleware.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    // Private constructor to prevent instantiation
    private DateTimeUtils() {
        throw new AssertionError("Cannot instantiate utility class.");
    }

    public static String getTimeNow() {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_DATE);
        return formattedDate;
    }
}
