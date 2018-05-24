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
public class HourRestrictionDto {

    private final String initialHour;
    private final String endingHour;
    private Calendar initialDateAndTime;
    private Calendar endingDateAndTime;

    public HourRestrictionDto(String initialHour, String endingHour) {
        this.initialHour = initialHour;
        this.endingHour = endingHour;
    }

    public String getInitialHour() {
        return initialHour;
    }

    public String getEndingHour() {
        return endingHour;
    }

    public Calendar getInitialDateAndTime() {
        return initialDateAndTime;
    }

    public Calendar getEndingDateAndTime() {
        return endingDateAndTime;
    }

    public Boolean isBetweenRestrictedTimes(Calendar date) {
        generateRestrictionDayAndTimes(date);
        return Utils.dateBetween(date, initialDateAndTime, endingDateAndTime);
    }

    private void generateRestrictionDayAndTimes(Calendar requestedDate) {
        generateInitialRestrictionCalendar(requestedDate);
        generateEndingRestrictionCalendar(requestedDate);
    }

    private void generateInitialRestrictionCalendar(Calendar date) {
        initialDateAndTime = generateRestrictionFromCalendarAndTime(date, initialHour);
    }

    private void generateEndingRestrictionCalendar(Calendar date) {
        endingDateAndTime = generateRestrictionFromCalendarAndTime(date, endingHour);
    }

    private Calendar generateRestrictionFromCalendarAndTime(Calendar date, String time) {
        Date restrictionDate = date.getTime();
        String restrictionDateText = Utils.getFormatedDate(restrictionDate, Constants.DATE_FORMAT);
        String formatedRestrictionDate = restrictionDateText + Constants.WHITE_SPACE + time;
        Calendar restrictionCalendar = Calendar.getInstance();
        restrictionCalendar.setTime(Utils.getDateFromString(formatedRestrictionDate, Constants.DATE_TIME_FORMAT));
        restrictionCalendar.getTime();
        return restrictionCalendar;
    }
}
