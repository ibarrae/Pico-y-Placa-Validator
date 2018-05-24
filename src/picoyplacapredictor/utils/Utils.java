/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Esteban Ibarra
 */
public class Utils {

    public static Boolean isObjectNull(Object object) {
        return object == null;
    }

    public static Boolean emptyText(String text) {
        return isObjectNull(text) || text.isEmpty();
    }

    public static Boolean emptyList(List list) {
        return isObjectNull(list) || list.isEmpty();
    }

    public static Boolean containsPattern(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).find();
    }

    public static Integer getDayOfTheWeekFromCalendar(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static Calendar getCalendarFromDateString(String dateString, String format) {
        Date date = getDateFromString(dateString, format);
        if (isObjectNull(date)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date getDateFromString(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(Boolean.FALSE);
            return dateFormat.parse(date);
        } catch (ParseException pe) {
            System.out.println(pe);
            return null;
        }
    }

    public static String getFormatedDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(Boolean.FALSE);
        return dateFormat.format(date);
    }

    public static Boolean minorOrEqualDateTime(Calendar initialDate, Calendar endingDate) {
        return initialDate.compareTo(endingDate) <= 0;
    }

    public static Boolean mayorOrEqualDateTime(Calendar initialDate, Calendar endingDate) {
        return initialDate.compareTo(endingDate) >= 0;
    }

    public static Boolean dateBetween(Calendar dateBetween, Calendar initialDate, Calendar endingDate) {
        return minorOrEqualDateTime(initialDate, dateBetween) && mayorOrEqualDateTime(endingDate, dateBetween);
    }

}
