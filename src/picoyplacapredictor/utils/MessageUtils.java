/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplacapredictor.utils;

import javax.swing.JOptionPane;
import picoyplacapredictor.constants.Constants;

/**
 *
 * @author Esteban Ibarra
 */
public class MessageUtils {

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, Constants.ERROR_TITTLE, JOptionPane.ERROR_MESSAGE);
    }

    public static void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, Constants.INFORMATION_TITTLE, JOptionPane.INFORMATION_MESSAGE);
    }
}
