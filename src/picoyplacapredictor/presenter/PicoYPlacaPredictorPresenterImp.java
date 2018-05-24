/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.presenter;

import picoyplacapredictor.constants.Constants;
import picoyplacapredictor.dto.DateTimeDto;
import picoyplacapredictor.dto.UserInformationDto;
import picoyplacapredictor.model.PicoYPlacaValidator;
import picoyplacapredictor.utils.Utils;
import picoyplacapredictor.view.PicoYPlacaPredictorView;

/**
 *
 * @author Esteban Ibarra
 */
public class PicoYPlacaPredictorPresenterImp implements PicoYPlacaPredictorPresenter {
    
    private final PicoYPlacaPredictorView picoYPlacaPredictorView;
    
    public PicoYPlacaPredictorPresenterImp(PicoYPlacaPredictorView picoYPlacaPredictorView) {
        this.picoYPlacaPredictorView = picoYPlacaPredictorView;
    }
    
    @Override
    public void checkRestriction(PicoYPlacaValidator picoYPlacaValidator) {
        if (emptyUserInput(picoYPlacaValidator.getUserInformationDto())) {
            return;
        }
        if (incorrectUserInputFormat(picoYPlacaValidator.getUserInformationDto())) {
            return;
        }
        picoYPlacaValidator.generateRequestedDayOfTheWeek();
        if (picoYPlacaValidator.restricted()) {
            picoYPlacaPredictorView.showCanNotBeOnRoadMessage();
        } else {
            picoYPlacaPredictorView.showCanBeOnRoadMessage();
        }
    }
    
    private Boolean emptyUserInput(UserInformationDto userInformationDto) {
        if (emptyLicensePlate(userInformationDto.getLicensePlate())) {
            picoYPlacaPredictorView.showBlankLicensePlateError();
            return Boolean.TRUE;
        }
        if (emptyDate(userInformationDto.getDateTimeDto().getDate())) {
            picoYPlacaPredictorView.showBlankDateError();
            return Boolean.TRUE;
        }
        if (emptyTime(userInformationDto.getDateTimeDto().getTime())) {
            picoYPlacaPredictorView.showBlankTimeError();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    private Boolean emptyLicensePlate(String licensePlate) {
        return Utils.emptyText(licensePlate);
    }
    
    private Boolean emptyDate(String date) {
        return Utils.emptyText(date);
    }
    
    private Boolean emptyTime(String time) {
        return Utils.emptyText(time);
    }
    
    private Boolean incorrectUserInputFormat(UserInformationDto userInformationDto) {
        if (userInformationDto.invalidLicensePlate()) {
            picoYPlacaPredictorView.showInvalidLicensePlateMessage();
            return Boolean.TRUE;
        }
        if (incorrectDateFormat(userInformationDto.getDateTimeDto())) {
            picoYPlacaPredictorView.showDateFormatError();
            return Boolean.TRUE;
        }
        if (incorrectTimeFormat(userInformationDto.getDateTimeDto())) {
            picoYPlacaPredictorView.showTimeFormatError();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    private Boolean incorrectDateFormat(DateTimeDto dateTimeDto) {
        return Utils.containsPattern(dateTimeDto.getDate(), Constants.CHARACTER_PATTERN) || dateTimeDto.invalidDate();
    }
    
    private Boolean incorrectTimeFormat(DateTimeDto dateTimeDto) {
        return Utils.containsPattern(dateTimeDto.getTime(), Constants.CHARACTER_PATTERN) || dateTimeDto.invalidTime();
    }
}
