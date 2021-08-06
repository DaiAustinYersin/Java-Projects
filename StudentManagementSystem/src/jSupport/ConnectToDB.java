/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DaiAustinYersin
 */
public class ConnectToDB {
    public static Connection openConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost\\sqlexpress:1433;databaseName=FPL_DaoTao";
        Connection con = DriverManager.getConnection(url, "admin", "123");
        return con;
    }
}
