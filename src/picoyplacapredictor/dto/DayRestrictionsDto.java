/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.dto;

import java.util.List;

/**
 *
 * @author Esteban Ibarra
 */
public class DayRestrictionsDto {

    private final Integer dayOftheWeek;
    private final List<Integer> digits;
    private final List<HourRestrictionDto> hourRestrictions;

    public DayRestrictionsDto(Integer dayOftheWeek, List<Integer> digits, List<HourRestrictionDto> hourRestrictions) {
        this.dayOftheWeek = dayOftheWeek;
        this.digits = digits;
        this.hourRestrictions = hourRestrictions;
    }

    public Integer getDayOftheWeek() {
        return dayOftheWeek;
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public List<HourRestrictionDto> getHourRestrictions() {
        return hourRestrictions;
    }

}
