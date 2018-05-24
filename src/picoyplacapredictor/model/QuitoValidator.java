/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import picoyplacapredictor.constants.Constants;
import picoyplacapredictor.dto.DayRestrictionsDto;
import picoyplacapredictor.dto.HourRestrictionDto;
import picoyplacapredictor.dto.UserInformationDto;

/**
 *
 * @author Esteban Ibarra
 */
public class QuitoValidator extends PicoYPlacaValidator {

    private static List<HourRestrictionDto> hourRestrictionsForQuito;
    private static List<DayRestrictionsDto> daysAndTimeRestrictionsForQuito;

    public QuitoValidator(List<DayRestrictionsDto> restrictions, UserInformationDto userInformationDto) {
        super(restrictions, userInformationDto);
    }

    /**
     * Data generated for "Pico Y Placa" restrictions in Quito - Ecuador
     *
     * @return
     */
    public static List<DayRestrictionsDto> getDaysAndTimesRestrictions() {
        generateRestrictedHourRanges();
        generateDaysAndTimeRestrictions();
        return daysAndTimeRestrictionsForQuito;
    }

    private static void generateRestrictedHourRanges() {
        hourRestrictionsForQuito = new ArrayList<>();
        hourRestrictionsForQuito.add(generateMorningHourRestrictions());
        hourRestrictionsForQuito.add(generateEveningHoursRestrictions());
    }

    private static HourRestrictionDto generateMorningHourRestrictions() {
        return new HourRestrictionDto(Constants.MORNING_INITIAL_TIME, Constants.MORNING_ENDING_TIME);
    }

    private static HourRestrictionDto generateEveningHoursRestrictions() {
        return new HourRestrictionDto(Constants.EVENING_INITIAL_TIME, Constants.EVENING_ENDING_TIME);
    }

    private static void generateDaysAndTimeRestrictions() {
        daysAndTimeRestrictionsForQuito = new ArrayList<>();
        daysAndTimeRestrictionsForQuito.add(generateMondayRestrictions());
        daysAndTimeRestrictionsForQuito.add(generateTuesdayRestrictions());
        daysAndTimeRestrictionsForQuito.add(generateWednesdayRestrictions());
        daysAndTimeRestrictionsForQuito.add(generateThursdayRestrictions());
        daysAndTimeRestrictionsForQuito.add(generateFridayRestrictions());
    }

    private static DayRestrictionsDto generateMondayRestrictions() {
        return new DayRestrictionsDto(Calendar.MONDAY, Arrays.asList(Constants.MONDAY_DIGITS), hourRestrictionsForQuito);
    }

    private static DayRestrictionsDto generateTuesdayRestrictions() {
        return new DayRestrictionsDto(Calendar.TUESDAY, Arrays.asList(Constants.TUESDAY_DIGITS), hourRestrictionsForQuito);
    }

    private static DayRestrictionsDto generateWednesdayRestrictions() {
        return new DayRestrictionsDto(Calendar.WEDNESDAY, Arrays.asList(Constants.WEDNESDAY_DIGITS), hourRestrictionsForQuito);
    }

    private static DayRestrictionsDto generateThursdayRestrictions() {
        return new DayRestrictionsDto(Calendar.THURSDAY, Arrays.asList(Constants.THURSDAY_DIGITS), hourRestrictionsForQuito);
    }

    private static DayRestrictionsDto generateFridayRestrictions() {
        return new DayRestrictionsDto(Calendar.FRIDAY, Arrays.asList(Constants.FRIDAY_DIGITS), hourRestrictionsForQuito);
    }
}
