package sg.edu.nus.team3.shoppingcart.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

// @author: Jared Chua
public class DateUtil {
    // Subtract days to a supplied date object
    public static Date subtractDays(Date startDate, int days) {
        final ZoneId timezone = ZoneId.of("Asia/Singapore");
        LocalDate localDate = startDate.toInstant().atZone(timezone).toLocalDate().minusDays(days);
        Date endDate = Date.from(localDate.atStartOfDay(timezone).toInstant());
        return endDate;
    }

    // Adds days to a supplied date object
    // ? Possibly merge with subtractDays
    public static Date addDays(Date startDate, int days) {
        final ZoneId timezone = ZoneId.of("Asia/Singapore");
        LocalDate localDate = startDate.toInstant().atZone(timezone).toLocalDate().plusDays(days);
        Date endDate = Date.from(localDate.atStartOfDay(timezone).toInstant());
        return endDate;
    }

    // Checks if a date is between 2 separate dates
    public static boolean isDateBetween(Date startDate, Date endDate, Date dateToCheck) {
        if (dateToCheck == null || startDate == null || endDate == null)
            throw new IllegalArgumentException("isDateBetween requires a valid date to check, start date and end date");

        final ZoneId timezone = ZoneId.of("Asia/Singapore");

        LocalDate localCheckDate = dateToCheck.toInstant().atZone(timezone).toLocalDate();
        LocalDate localStartDate = startDate.toInstant().atZone(timezone).toLocalDate();
        LocalDate localEndDate = endDate.toInstant().atZone(timezone).toLocalDate();

        return !localCheckDate.isBefore(localStartDate) && !localCheckDate.isAfter(localEndDate);
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        final ZoneId timezone = ZoneId.of("Asia/Singapore");
        return date.toInstant().atZone(timezone).toLocalDateTime();
    }

    public static Date convertToDate(LocalDateTime date) {
        final ZoneId timezone = ZoneId.of("Asia/Singapore");
        return Date.from(date.atZone(timezone).toInstant());
    }
}
