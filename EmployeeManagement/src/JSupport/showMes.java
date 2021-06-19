/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSupport;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class showMes {
    public static void showMes2(String mes){
        JOptionPane.showMessageDialog(null, mes);
    }
    
    public static void showMes4(String mes){
        JOptionPane.showMessageDialog(null, mes, "Dữ liệu không hợp lệ", JOptionPane.ERROR_MESSAGE);
    }
}
