/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DaiAustinYersin
 */
public class QuanLyBangDiem {
    
    BangDiem bd;

    public List<BangDiem> findTop(int top) throws SQLException {
        String sql = "select top " + top + " a.MaSV,HoTen,TiengAnh,TinHoc,GDTC,(TiengAnh+TinHoc+GDTC)/3 as DTB\n" +
                    "from STUDENTS a left outer join GRADE b on a.MaSV = b.MaSV\n" +
                    "order by DTB desc";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);) {
            List<BangDiem> list = new ArrayList<>();
            while (rs.next()) {
                BangDiem bd = createBangDiem(rs);
                list.add(bd);
            }
            return list;
        }
    }

    public List<BangDiem> findAll() throws SQLException {
        String sql = "select a.MaSV,HoTen,TiengAnh,TinHoc,GDTC,(TiengAnh+TinHoc+GDTC)/3 as DTB\n" +
                    "from STUDENTS a join GRADE b on a.MaSV = b.MaSV";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(sql);) {
            List<BangDiem> list = new ArrayList<>();
            while (rs.next()) {
                BangDiem bd = createBangDiem(rs);
                list.add(bd);
            }
            return list;
        }
    }

    public BangDiem findByMaSV(String maSV) throws SQLException {
        String sql = "select a.MaSV,HoTen,TiengAnh,TinHoc,GDTC,(TiengAnh+TinHoc+GDTC)/3 as DTB\n" +
                    "from STUDENTS a join GRADE b on a.MaSV = b.MaSV"
                + " where a.masv like ?";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, maSV);
            try (
                    ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    BangDiem bd = createBangDiem(rs);
                    return bd;
                }
            }
        }
        return null;
    }

    private BangDiem createBangDiem(final ResultSet rs) throws NumberFormatException, SQLException {
        BangDiem bd = new BangDiem();
        bd.setMaSinhVien(rs.getString("masv"));
        bd.setHoTen(rs.getString("hoten"));
        bd.setTiengAnh(rs.getFloat("tienganh"));
        bd.setTinHoc(rs.getFloat("tinhoc"));
        bd.setGDTC(rs.getFloat("gdtc"));
        return bd;
    }

    public boolean deleteByMaSV(BangDiem bd) throws Exception {
        String sql = "DELETE FROM [dbo].[GRADE]"
                + " WHERE [MaSV] = ?";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bd.getMaSinhVien());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(BangDiem bd) throws Exception {
        String sql = "UPDATE [dbo].[GRADE]\n"
                + "   SET [TiengAnh] = ?\n"
                + "      ,[TinHoc] = ?\n"
                + "      ,[GDTC] = ?\n"
                + " WHERE [MaSV] = ?";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(4, bd.getMaSinhVien());
            ps.setDouble(1, bd.getTiengAnh());
            ps.setDouble(2, bd.getTinHoc());
            ps.setDouble(3, bd.getGDTC());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean insert(BangDiem bd) throws Exception {
        String sql = "INSERT INTO [dbo].[GRADE]([MaSV],[TiengAnh],[TinHoc],[GDTC])\n"
                + "VALUES(?,?,?,?)";
        try (
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bd.getMaSinhVien());
            ps.setDouble(2, bd.getTiengAnh());
            ps.setDouble(3, bd.getTinHoc());
            ps.setDouble(4, bd.getGDTC());
            return ps.executeUpdate() > 0;
        }
    }
}
