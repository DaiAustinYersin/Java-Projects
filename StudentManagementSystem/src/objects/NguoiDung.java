/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author DaiAustinYersin
 */
public class NguoiDung {
    
    String hoten,matkhau,role;

    public NguoiDung() {
    }

    public NguoiDung(String hoten, String matkhau, String role) {
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.role = role;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
