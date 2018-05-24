/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.presenter;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import picoyplacapredictor.constants.Constants;
import picoyplacapredictor.dto.DateTimeDto;
import picoyplacapredictor.dto.DayRestrictionsDto;
import picoyplacapredictor.dto.UserInformationDto;
import picoyplacapredictor.model.PicoYPlacaValidator;
import picoyplacapredictor.model.QuitoValidator;
import picoyplacapredictor.utils.Utils;
import picoyplacapredictor.view.PicoYPlacaPredictorView;

/**
 *
 * @author Esteban Ibarra
 */
public class PicoYPlacaPredictorPresenterImpTest {

    private PicoYPlacaPredictorPresenter testPresenter;

    @Before
    public void setUp() {
        PicoYPlacaPredictorTestView testView = new PicoYPlacaPredictorTestView();
        testPresenter = new PicoYPlacaPredictorPresenterImp(testView);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRestricted() {
        List<DayRestrictionsDto> testRestrictions = QuitoValidator.getDaysAndTimesRestrictions();
        DateTimeDto testDateAndTime = new DateTimeDto("23-05-2018", "09:00");
        UserInformationDto testUserInformation = new UserInformationDto("PBC-2874", testDateAndTime);
        System.out.println("Testing restriction for license plate:" + testUserInformation.getLicensePlate() + ",at: " + Utils.getFormatedDate(testDateAndTime.generateCalendar().getTime(), Constants.DATE_TIME_FORMAT));
        PicoYPlacaValidator testValidator = new QuitoValidator(testRestrictions, testUserInformation);
        testPresenter.checkRestriction(testValidator);
    }

    @Test
    public void testNotRestricted() {
        List<DayRestrictionsDto> testRestrictions = QuitoValidator.getDaysAndTimesRestrictions();
        DateTimeDto testDateAndTime = new DateTimeDto("26-05-2018", "17:05");
        UserInformationDto testUserInformation = new UserInformationDto("PBC-2874", testDateAndTime);
        System.out.println("Testing restriction for license plate:" + testUserInformation.getLicensePlate() + ",at: " + Utils.getFormatedDate(testDateAndTime.generateCalendar().getTime(), Constants.DATE_TIME_FORMAT));
        PicoYPlacaValidator testValidator = new QuitoValidator(testRestrictions, testUserInformation);
        testPresenter.checkRestriction(testValidator);
    }

    @Test
    public void testWrongLicensePlate() {
        List<DayRestrictionsDto> testRestrictions = QuitoValidator.getDaysAndTimesRestrictions();
        DateTimeDto testDateAndTime = new DateTimeDto("26-05-2018", "17:05");
        UserInformationDto testUserInformation = new UserInformationDto("PBC-287X", testDateAndTime);
        System.out.println("Testing wrong license plate:" + testUserInformation.getLicensePlate());
        PicoYPlacaValidator testValidator = new QuitoValidator(testRestrictions, testUserInformation);
        testPresenter.checkRestriction(testValidator);
    }

    @Test
    public void testWrongDate() {
        List<DayRestrictionsDto> testRestrictions = QuitoValidator.getDaysAndTimesRestrictions();
        DateTimeDto testDateAndTime = new DateTimeDto("26-32-2018", "17:05");
        UserInformationDto testUserInformation = new UserInformationDto("PBC-2874", testDateAndTime);
        System.out.println("Testing wrong date:" + testDateAndTime.getDate());
        PicoYPlacaValidator testValidator = new QuitoValidator(testRestrictions, testUserInformation);
        testPresenter.checkRestriction(testValidator);
    }

    @Test
    public void testWrongTime() {
        List<DayRestrictionsDto> testRestrictions = QuitoValidator.getDaysAndTimesRestrictions();
        DateTimeDto testDateAndTime = new DateTimeDto("26-05-2018", "27:05");
        UserInformationDto testUserInformation = new UserInformationDto("PBC-2874", testDateAndTime);
        System.out.println("Testing wrong time:" + testDateAndTime.getTime());
        PicoYPlacaValidator testValidator = new QuitoValidator(testRestrictions, testUserInformation);
        testPresenter.checkRestriction(testValidator);
    }

    public class PicoYPlacaPredictorTestView implements PicoYPlacaPredictorView {

        public PicoYPlacaPredictorTestView() {
        }

        @Override
        public void showBlankLicensePlateError() {
            System.out.println(Constants.EMPTY_LICENSE_PLATE);
        }

        @Override
        public void showInvalidLicensePlateMessage() {
            System.out.println(Constants.INVALID_LICENSE_PLATE);
        }

        @Override
        public void showBlankDateError() {
            System.out.println(Constants.EMPTY_DATE);
        }

        @Override
        public void showDateFormatError() {
            System.out.println(Constants.INVALID_DATE);
        }

        @Override
        public void showBlankTimeError() {
            System.out.println(Constants.EMPTY_TIME);
        }

        @Override
        public void showTimeFormatError() {
            System.out.println(Constants.INVALID_TIME);
        }

        @Override
        public void showCanBeOnRoadMessage() {
            System.out.println(Constants.VALID_DATE);
        }

        @Override
        public void showCanNotBeOnRoadMessage() {
            System.out.println(Constants.RESTRICTED_DATE);
        }
    }

}
