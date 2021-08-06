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
public class BangDiem {
    private int ID;
    private String MaSinhVien, HoTen;
    private double TiengAnh,TinHoc,GDTC;

    public BangDiem() {
    }

    public BangDiem(int ID, String MaSinhVien, String HoTen, double TiengAnh, double TinHoc, double GDTC) {
        this.ID = ID;
        this.MaSinhVien = MaSinhVien;
        this.HoTen = HoTen;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public double getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(double TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public double getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(double TinHoc) {
        this.TinHoc = TinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }
}
