/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.*;
import java.util.*;

/**
 *
 * @author DaiAustinYersin
 */
public class QuanLySinhVien {

    public List<SinhVien> selectAll() throws SQLException {
        String sql = "SELECT * FROM dbo.STUDENTS";

        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                Statement s = con.createStatement();) {
            try (
                    ResultSet rs = s.executeQuery(sql);) {
                List<SinhVien> list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = createSinhVien(rs);
                    list.add(sv);
                }
                return list;
            }
        }
    }
    
    public SinhVien selectByMaSV(String maSV) throws SQLException {
        String sql = "SELECT * FROM dbo.STUDENTS"
                + " where masv like ?";

        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maSV);
            try(
                ResultSet rs = ps.executeQuery();
                ){
                if (rs.next()) {
                    SinhVien sv = createSinhVien(rs);
                    return sv;
                }
            }
        }
        return null;
    }

    private SinhVien createSinhVien(final ResultSet rs) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSinhVien(rs.getString("masv"));
        sv.setHoTen(rs.getString("hoten"));
        sv.setEmail(rs.getString("email"));
        sv.setSoDT(rs.getString("sodt"));
        sv.setDiaChi(rs.getString("diachi"));
        sv.setGioiTinh(rs.getBoolean("gioitinh"));
        sv.setHinh(rs.getString("hinh"));
        return sv;
    }

    public boolean delete(String maSV) throws Exception {
        String sql = "delete from GRADE\n" +
                    "where MaSV in (select MaSV from STUDENTS where MaSV like ?)\n" +
                    "delete from STUDENTS\n" +
                    "where MaSV in (select MaSV from STUDENTS where MaSV like ?)";

        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maSV);
            ps.setString(2, maSV);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(SinhVien sv) throws Exception {
        String sql = "UPDATE dbo.STUDENTS\n"
                + " SET HoTen = ?,Email = ?,SoDT = ?,GioiTinh = ?,DiaChi = ?,Hinh = ?\n"
                + " WHERE MaSV = ?";

        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(7, sv.getMaSinhVien());
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getSoDT());
            ps.setBoolean(4, sv.getGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getHinh());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean insert(SinhVien sv) throws Exception {
        String sql = "INSERT INTO [dbo].[STUDENTS]([MaSV],[HoTen],[Email],[SoDT],[GioiTinh],[DiaChi],[Hinh])\n"
                + " VALUES (?,?,?,?,?,?,?)";

        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sv.getMaSinhVien());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getSoDT());
            ps.setBoolean(5, sv.getGioiTinh());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getHinh());
            return ps.executeUpdate() > 0;
        }
    }
}
