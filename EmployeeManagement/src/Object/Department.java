/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Admin
 */
public enum Department {
    KT_CN,TC_KT,NS,MAR;
    
    public static String getKT_CN() {
        return "Kỹ thuật - Công nghệ";
    }

    public static String getTC_KT() {
        return "Tài chính - Kế toán";
    }

    public static String getNS() {
        return "Nhân sự";
    }

    public static String getMAR() {
        return "Marketing";
    }
}
