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

/**
 *
 * @author DaiAustinYersin
 */
public class QuanLyNguoiDung {
    public NguoiDung checkLogin(String user, String pass) throws SQLException{
        String sql = "SELECT [username],[password],[role]\n" +
                    "  FROM [FPL_DaoTao].[dbo].[USERS]\n"
                + "where [username] = ? and [password] = ?";
        try(
                Connection con = jSupport.ConnectToDB.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
            ){
            ps.setString(1, user);
            ps.setString(2, pass);
            
            try(
                    ResultSet rs = ps.executeQuery();
                ){
                if (rs.next()) {
                    NguoiDung nd = new NguoiDung();
                    nd.setHoten(user.trim());
                    nd.setRole(rs.getString("role"));
                    return nd;
                }
            }
        }
        return null;
    }
}
