/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tran Phuong
 */
public class Login implements DBSInterface {

    public static int checkLogin(String email, String password) {
        int check = -1;
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);

            String sql = "Select [Role],[Password] from [User] where Email = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("Password").equals(password)) {
                    check = rs.getInt("Role");
                } else {
                    check = -1;
                }
            }

        } catch (Exception e) {

        }
        return check;
    }
}
