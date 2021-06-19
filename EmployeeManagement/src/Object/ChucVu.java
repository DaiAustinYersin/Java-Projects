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
public enum ChucVu {
    TP,NV;
    
    public static String getTP() {    
        return "Trưởng phòng";
    }

    public static String getNV() {
        return "Nhân viên";
    }
}