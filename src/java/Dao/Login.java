/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User;
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

    public static User checkLogin(String email, String password) {
        int check = -1;
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);

            String sql = "Select Id, [Role], FirstName, LastName [Password], Telephone, Gender, Birthdate, Address from [User] where Email = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("Password").equals(password)) {
                    return new User(rs.getString("ID"), rs.getInt("Role"), rs.getString("FirstName"),
                            rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"), email,
                            rs.getInt("Gender"), rs.getDate("Birthdate"), rs.getString("Address"));
                }
            }
        } catch (Exception e) {

        }
        return null;
    }
}
