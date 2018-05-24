/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.constants;

/**
 *
 * @author Esteban Ibarra
 */
public class Constants {

    /**
     * Messages
     */
    public static final String ERROR_TITTLE = "Error";
    public static final String INFORMATION_TITTLE = "Information";
    public static final String EMPTY_LICENSE_PLATE = "Dear user, the license plate can not be blank.";
    public static final String EMPTY_DATE = "Dear user, the date can not be blank.";
    public static final String EMPTY_TIME = "Dear user, the time can not be blank.";
    public static final String INVALID_LICENSE_PLATE = "Dear user, the license plate you entered is incorrect.";
    public static final String INVALID_DATE = "Dear user, the date you entered is incorrect.";
    public static final String INVALID_TIME = "Dear user, the time you entered is incorrect.";
    public static final String RESTRICTED_DATE = "Dear user, you can not be on road at the requested date and time.";
    public static final String VALID_DATE = "Dear user, you can be on road at the requested date and time.";

    /**
     * Formats and patterns
     */
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String WHITE_SPACE = " ";
    public static final String DATE_TIME_FORMAT = DATE_FORMAT + WHITE_SPACE + TIME_FORMAT;
    public static final String CHARACTER_PATTERN = "[aA-zZ]";

    /**
     * Application's logic
     */
    public static final String MORNING_INITIAL_TIME = "07:00";
    public static final String MORNING_ENDING_TIME = "09:30";
    public static final String EVENING_INITIAL_TIME = "16:00";
    public static final String EVENING_ENDING_TIME = "19:30";
    public static final Integer[] MONDAY_DIGITS = new Integer[]{0, 1};
    public static final Integer[] TUESDAY_DIGITS = new Integer[]{2, 3};
    public static final Integer[] WEDNESDAY_DIGITS = new Integer[]{4, 5};
    public static final Integer[] THURSDAY_DIGITS = new Integer[]{6, 7};
    public static final Integer[] FRIDAY_DIGITS = new Integer[]{8, 9};

}
