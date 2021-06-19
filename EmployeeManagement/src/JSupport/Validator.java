/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSupport;

import static JSupport.showMes.showMes2;
import Object.Employee;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Validator {

    public static boolean checkNull(JTextField txt, String mes, StringBuilder sb) {
        boolean ok = false;
        if (txt.getText().isEmpty()) {
            sb.append(mes).append("\n");
            txt.setBackground(Color.yellow);
            ok = true;
        }
        if (!ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkAge(JTextField txt, StringBuilder sb) {
        boolean ok = true;
//        if (checkNull(txt, "Tuổi không được để trống", sb)) {
//            return false;
//        }
        try {
            int age = Integer.parseInt(txt.getText());
            if (age < 16 || age > 55) {
                sb.append("Tuổi phải trong khoảng 16-55\n");
                txt.setBackground(Color.yellow);
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Tuổi phải là một số tự nhiên\n");
            txt.setBackground(Color.yellow);
            ok = false;
        }
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }
    
    public static boolean checkSalary(JTextField txt, StringBuilder sb){
        boolean ok = true;
//        if (checkNull(txt, "Lương không được để trống", sb)) {
//            return false;
//        }
        try {
            double salary = Double.parseDouble(txt.getText());
            if (salary < 5000000) {
                sb.append("Lương phải lớn hơn 5.000.000\n");
                txt.setBackground(Color.yellow);
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Lương phải là một số thực\n");
            txt.setBackground(Color.yellow);
            ok = false;
        }
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }
    
    public static boolean checkEmail(JTextField txt, StringBuilder sb){
        boolean ok = true;
//        if (checkNull(txt, "Email không được để trống", sb)) {
//            return false;
//        }
        
        Pattern p = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher m = p.matcher(txt.getText());
        
        if (!m.find()) {
            sb.append("Email không hợp lệ\n");
            txt.setBackground(Color.yellow);
            ok = false;
        }
        
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }
}
