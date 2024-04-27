package helpers;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeHelper {
    public static LocalDate currentDate = LocalDate.now();
    public static LocalTime currentTime = LocalTime.now();
    public static String time;

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        DateTimeHelper.time = time;
    }

    public static String getCurrentTime() {
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        time = String.format("%02d:%02d", hour, minute);
        return time;
    }

    public static String getCurrentDay() {
        int day = currentDate.getDayOfMonth();
        return String.valueOf(day);
    }

    public static String getCurrentMonthAndYear() {
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        return String.valueOf(month) + "-" + String.valueOf(year);
    }
}
