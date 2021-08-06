/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jSupport;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author DaiAustinYersin
 */
public class ShowDialog {

    public static void showMes(Component parent, String mes) {
        JOptionPane.showMessageDialog(parent, mes);
    }

    public static void showMessage(Component parent, String title, String mes) {
        JOptionPane.showMessageDialog(parent, mes, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showError(Component parent, String title, String mes){
        JOptionPane.showMessageDialog(parent, mes, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showConfirm(Component parent, String title, String mes) {
        int confirm = JOptionPane.showConfirmDialog(parent, mes, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return confirm;
    }
}
