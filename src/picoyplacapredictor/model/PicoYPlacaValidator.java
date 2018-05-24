/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.model;

import java.util.List;
import picoyplacapredictor.dto.DayRestrictionsDto;
import picoyplacapredictor.dto.HourRestrictionDto;
import picoyplacapredictor.dto.UserInformationDto;
import picoyplacapredictor.utils.Utils;

/**
 *
 * @author Esteban Ibarra
 */
public abstract class PicoYPlacaValidator {

    private final List<DayRestrictionsDto> restrictions;
    private final UserInformationDto userInformationDto;
    private Integer dayOfTheWeek;

    public PicoYPlacaValidator(List<DayRestrictionsDto> restrictions, UserInformationDto userInformationDto) {
        this.restrictions = restrictions;
        this.userInformationDto = userInformationDto;
    }

    public UserInformationDto getUserInformationDto() {
        return userInformationDto;
    }

    public Boolean restricted() {
        for (DayRestrictionsDto restriction : restrictions) {
            if (restrictionFitsInUserInfo(restriction)) {
                for (HourRestrictionDto hourRestriction : restriction.getHourRestrictions()) {
                    if (isOnRestrictedHourRange(hourRestriction)) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    public void generateRequestedDayOfTheWeek() {
        userInformationDto.generateRequestedDateTime();
        this.dayOfTheWeek = Utils.getDayOfTheWeekFromCalendar(userInformationDto.getRequestedDateTime());
    }

    private Boolean restrictionFitsInUserInfo(DayRestrictionsDto restriction) {
        if (hasDigitsRestriction(restriction)) {
            return isOnRestrictedDay(restriction) && isDigitRestricted(restriction);
        }
        return isOnRestrictedDay(restriction);
    }

    private Boolean hasDigitsRestriction(DayRestrictionsDto restriction) {
        return !Utils.emptyList(restriction.getDigits());
    }

    private Boolean isDigitRestricted(DayRestrictionsDto restriction) {
        return restriction.getDigits().contains(userInformationDto.getLicensePlateLastDigit());
    }

    private Boolean isOnRestrictedDay(DayRestrictionsDto restriction) {
        return dayOfTheWeek.equals(restriction.getDayOftheWeek());
    }

    private Boolean isOnRestrictedHourRange(HourRestrictionDto hourRestriction) {
        return hourRestriction.isBetweenRestrictedTimes(userInformationDto.getRequestedDateTime());
    }

}
