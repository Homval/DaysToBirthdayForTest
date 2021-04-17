package ru.khomyakov;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ParseException {
        String birthday = InOutHelper.read();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date birthdayDate = format.parse(birthday);
        Calendar birthdayCalendar = Calendar.getInstance();
        birthdayCalendar.setTime(birthdayDate);

        Date today = new Date();
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(today);

        int daysBeforeBirthday = executeDays(currentCalendar, birthdayCalendar);

        InOutHelper.printResult(daysBeforeBirthday);

    }

    private static boolean isBirthdayInThisYear(Calendar current, Calendar birthday) {
        if (current.get(Calendar.MONTH) < birthday.get(Calendar.MONTH)) {
            return true;
        } else if (current.get(Calendar.MONTH) > birthday.get(Calendar.MONTH)) {
            return false;
        } else {
            return current.get(Calendar.DATE) <= birthday.get(Calendar.DATE);
        }
    }

    public static int executeDays(Calendar currentCalendar, Calendar birthdayCalendar) {
        int daysBeforeBirthday;

        int currentYear = currentCalendar.get(Calendar.YEAR);
        birthdayCalendar.set(Calendar.YEAR, currentYear);

        if (isBirthdayInThisYear(currentCalendar, birthdayCalendar)) {

            daysBeforeBirthday = birthdayCalendar.get(Calendar.DAY_OF_YEAR) - currentCalendar.get(Calendar.DAY_OF_YEAR);
        } else {
            birthdayCalendar.set(Calendar.YEAR, currentYear + 1);

            daysBeforeBirthday = birthdayCalendar.get(Calendar.DAY_OF_YEAR) + currentCalendar.getActualMaximum(Calendar.DAY_OF_YEAR)
                    - currentCalendar.get(Calendar.DAY_OF_YEAR);
        }
        return daysBeforeBirthday;
    }
}
