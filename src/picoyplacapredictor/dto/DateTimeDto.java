/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.dto;

import java.util.Calendar;
import java.util.Date;
import picoyplacapredictor.constants.Constants;
import picoyplacapredictor.utils.Utils;

/**
 *
 * @author Esteban Ibarra
 */
public class DateTimeDto {

    private String date;
    private String time;

    public DateTimeDto(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean invalidDate() {
        Date convertedDate = Utils.getDateFromString(date, Constants.DATE_FORMAT);
        return Utils.isObjectNull(convertedDate);
    }

    public Boolean invalidTime() {
        Date convertedTime = Utils.getDateFromString(time, Constants.TIME_FORMAT);
        return Utils.isObjectNull(convertedTime);
    }

    public Calendar generateCalendar() {
        StringBuilder sb = new StringBuilder(date);
        sb.append(Constants.WHITE_SPACE);
        sb.append(time);
        return Utils.getCalendarFromDateString(sb.toString(), Constants.DATE_TIME_FORMAT);
    }

}
