/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.dto;

import java.util.Calendar;

/**
 *
 * @author Esteban Ibarra
 */
public class UserInformationDto {

    private final String licensePlate;
    private Integer licensePlateLastDigit;
    private final DateTimeDto dateTimeDto;
    private Calendar requestedDateTime;

    public UserInformationDto(String licensePlate, DateTimeDto dateTimeDto) {
        this.licensePlate = licensePlate;
        this.dateTimeDto = dateTimeDto;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Integer getLicensePlateLastDigit() {
        return licensePlateLastDigit;
    }

    public Calendar getRequestedDateTime() {
        return requestedDateTime;
    }

    public DateTimeDto getDateTimeDto() {
        return dateTimeDto;
    }

    public void generateRequestedDateTime() {
        requestedDateTime = dateTimeDto.generateCalendar();
    }

    public Boolean invalidLicensePlate() {
        Integer licensePlateLenght = licensePlate.length();
        Integer lastCharacterIndex = licensePlateLenght - 1;
        String licensePlateLastCharacter = licensePlate.substring(lastCharacterIndex);
        try {
            licensePlateLastDigit = Integer.valueOf(licensePlateLastCharacter);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
