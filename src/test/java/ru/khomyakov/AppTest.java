package ru.khomyakov;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void if_current_before_birthday() {
        Calendar current = Calendar.getInstance();
        current.set(2021, Calendar.MAY, 25);

        Calendar birthday = Calendar.getInstance();
        birthday.set(1980, Calendar.AUGUST, 16);

        int days = App.executeDays(current, birthday);
        int result = 83;

        assertEquals(days, result);

    }

    @Test
    public void if_current_after_birthday() {
        Calendar current = Calendar.getInstance();
        current.set(2021, Calendar.AUGUST, 16);

        Calendar birthday = Calendar.getInstance();
        birthday.set(1980, Calendar.MAY, 25);

        int days = App.executeDays(current, birthday);
        int result = 282;

        assertEquals(days, result);

    }

    @Test
    public void if_current_equal_birthday() {
        Calendar current = Calendar.getInstance();
        current.set(2021, Calendar.AUGUST, 16);

        Calendar birthday = Calendar.getInstance();
        birthday.set(1980, Calendar.AUGUST, 16);

        int days = App.executeDays(current, birthday);
        int result = 0;

        assertEquals(days, result);

    }

    @Test
    public void if_current_before_birthday_29feb() {
        Calendar current = Calendar.getInstance();
        current.set(2021, Calendar.FEBRUARY, 25);

        Calendar birthday = Calendar.getInstance();
        birthday.set(1980, Calendar.FEBRUARY, 29);

        int days = App.executeDays(current, birthday);
        int result = 4;

        assertEquals(days, result);

    }

    @Test
    public void if_current_after_birthday_29feb() {
        Calendar current = Calendar.getInstance();
        current.set(2021, Calendar.DECEMBER, 31);

        Calendar birthday = Calendar.getInstance();
        birthday.set(1980, Calendar.FEBRUARY, 29);

        int days = App.executeDays(current, birthday);
        int result = 60;

        assertEquals(days, result);

    }

}
