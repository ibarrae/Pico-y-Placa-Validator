/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import picoyplacapredictor.constants.Constants;

/**
 *
 * @author Esteban Ibarra
 */
public class UtilsTest {

    @Test
    public void testIsObjectNull() {
        Object object = null;
        Boolean expectedResult = Boolean.TRUE;
        Boolean result = Utils.isObjectNull(object);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testEmptyText() {
        String text = "";
        Boolean expectedResult = Boolean.TRUE;
        Boolean result = Utils.emptyText(text);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testEmptyList() {
        List list = null;
        Boolean expectedResult = Boolean.TRUE;
        Boolean result = Utils.emptyList(list);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetDayOfTheWeekFromCalendar() {
        Integer expectedResult = -1;
        Integer result = Utils.getDayOfTheWeekFromCalendar(Calendar.getInstance());
        assertNotEquals(expectedResult, result);
    }

    @Test
    public void testGetCalendarFromDateString() {
        String dateString = "23-05-2018";
        String format = Constants.DATE_FORMAT;
        Calendar expectedResult = null;
        Calendar result = Utils.getCalendarFromDateString(dateString, format);
        assertNotEquals(expectedResult, result);
    }

    @Test
    public void testGetDateFromString() {
        String date = "23-05-2018";
        String format = Constants.DATE_FORMAT;
        Date expectedResult = null;
        Date result = Utils.getDateFromString(date, format);
        assertNotEquals(expectedResult, result);
    }

    @Test
    public void testGetFormatedDate() {
        Date date = Utils.getDateFromString("23-05-2018", Constants.DATE_FORMAT);
        String format = Constants.DATE_FORMAT;
        String expectedResult = "23-05-2018";
        String result = Utils.getFormatedDate(date, format);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMinorOrEqualDateTime() {
        Calendar initialDate = Calendar.getInstance();
        Calendar endingDate = Calendar.getInstance();
        endingDate.add(Calendar.DAY_OF_MONTH, 5);
        Boolean expectedResult = Boolean.TRUE;
        Boolean result = Utils.minorOrEqualDateTime(initialDate, endingDate);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMayorOrEqualDateTime() {
        Calendar initialDate = Calendar.getInstance();
        Calendar endingDate = Calendar.getInstance();
        endingDate.add(Calendar.DAY_OF_MONTH, 5);
        Boolean expectedResult = Boolean.FALSE;
        Boolean result = Utils.mayorOrEqualDateTime(initialDate, endingDate);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDateBetween() {
        Calendar dateBetween = Calendar.getInstance();
        Calendar initialDate = Calendar.getInstance();
        initialDate.add(Calendar.DAY_OF_MONTH, -5);
        Calendar endingDate = Calendar.getInstance();
        endingDate.add(Calendar.DAY_OF_MONTH, 5);
        Boolean expectedResult = Boolean.TRUE;
        Boolean result = Utils.dateBetween(dateBetween, initialDate, endingDate);
        assertEquals(expectedResult, result);
    }

}
