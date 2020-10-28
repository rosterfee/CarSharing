package ru.itis.javalab.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StringDateGenerator {

    public static String getCurrentStringDate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return format.format(cal.getTime());
    }
}
