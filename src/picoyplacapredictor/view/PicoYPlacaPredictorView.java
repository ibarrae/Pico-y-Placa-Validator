/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.view;

/**
 *
 * @author Esteban Ibarra
 */
public interface PicoYPlacaPredictorView {

    public void showBlankLicensePlateError();

    public void showInvalidLicensePlateMessage();

    public void showBlankDateError();

    public void showDateFormatError();

    public void showBlankTimeError();

    public void showTimeFormatError();

    public void showCanBeOnRoadMessage();

    public void showCanNotBeOnRoadMessage();

}
