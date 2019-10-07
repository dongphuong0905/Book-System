/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Dao.DBSInterface.DBSDriver;
import static Dao.DBSInterface.DBSID;
import static Dao.DBSInterface.DBSName;
import static Dao.DBSInterface.DBSPass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tran Phuong
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);

            String sql = "Select password from User where username = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            String email = "higeki@gmail.com";
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getString("password"));
            
        } catch (Exception e) {
        };
    }
}

