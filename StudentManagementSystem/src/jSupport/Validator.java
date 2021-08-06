/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jSupport;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DaiAustinYersin
 */
public class Validator {

    public static boolean checkNull(JTextField txt, String mes, StringBuilder sb) {
        if (txt.getText().equals("")) {
            sb.append(mes).append("\n");
            txt.setBackground(Color.yellow);
            return true;
        } else {
            txt.setBackground(Color.white);
            return false;
        }
    }
    
    public static boolean checkNull(JPasswordField pass, String mes, StringBuilder sb) {
        if (new String(pass.getPassword()).equals("")) {
            sb.append(mes).append("\n");
            pass.setBackground(Color.yellow);
            return true;
        } else {
            pass.setBackground(Color.white);
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt, StringBuilder sb) {
        if (checkNull(txt, "Email chưa nhập", sb)) {
            return false;
        }

        Pattern p = Pattern.compile("\\w+@\\w+\\.\\w+");

        Matcher m = p.matcher(txt.getText());

        if (!m.find()) {
            sb.append("Email không hợp lệ\n");
            txt.setBackground(Color.yellow);
            return false;
        }

        txt.setBackground(Color.white);
        return true;
    }

    public static boolean checkSDT(JTextField txt, StringBuilder sb) {
        if (checkNull(txt, "Số điện thoại chưa nhập", sb)) {
            return false;
        }

        if (!txt.getText().startsWith("0") || !(txt.getText().length() == 10)) {
            txt.setBackground(Color.yellow);
            sb.append("Số điện thoại phải có 10 số và bắt đầu với 0\n");
            return false;
        }

        txt.setBackground(Color.white);

        return true;
    }
    
    public static boolean checkDiem (JTextField txt, StringBuilder sb, String mes1, String mes2, String mes3){
        boolean ok = true;
        if (checkNull(txt, mes3, sb)) {
            return false;
        }
        
        try {
            double diem = Double.parseDouble(txt.getText());
            if (diem < 0 || diem > 10) {
                sb.append(mes1).append("\n");
                txt.setBackground(Color.yellow);
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append(mes2).append("\n");
            txt.setBackground(Color.yellow);
            ok = false;
        }
        
        if (ok) {
            txt.setBackground(Color.white);
        }
        
        return ok;
    }
}
