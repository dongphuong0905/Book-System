/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class Login implements DAO.DBSInterface {

    public static User checkLogin(String email, String password) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);

            String sql = "Select Id, [Role], UserAccount, FirstName, LastName, [Password], Telephone, Gender, Birthdate from [User] where Email = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("Password").equals(password)) {
                    return new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("FirstName"),
                            rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"), email,
                            rs.getInt("Gender"), rs.getDate("Birthdate"), AddressDAO.getAddress(rs.getInt("ID")));
                }
            }
        } catch (Exception e) {

        }
        return null;
    }
}
