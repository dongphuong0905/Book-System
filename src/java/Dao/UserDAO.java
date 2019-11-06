/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author trong
 */
public class UserDAO implements DBSInterface{

    public static User getCurrentUser(String email) {
        try {
            Connection con = new Database().getConnection();

            String sql = "Select Id, [Role], UserAccount, FirstName, LastName, [Password], Telephone, Gender, Birthdate from [User] where Email = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"), email,
                        rs.getInt("Gender"), rs.getDate("Birthdate"), AddressDAO.getAddress(rs.getInt("ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getCurrentUser(int UserID) {
        try {
            Connection con = new Database().getConnection();

            String sql = "Select Id, [Role], UserAccount, FirstName, LastName, [Password], Telephone, Email, Gender, Birthdate from [User] where ID = " + UserID;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"), rs.getString("Email"),
                        rs.getInt("Gender"), rs.getDate("Birthdate"), AddressDAO.getAddress(rs.getInt("ID")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean changeInformation(int userId, String firstname, String lastname, String phoneNumber, int gender, Date birthday) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Update [User] set telephone = ?, gender = ?, Birthdate = ?, firstname = ?, lastname = ? where ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            stmt.setInt(2, gender);
            stmt.setDate(3, birthday);
            stmt.setString(4, firstname);
            stmt.setString(5, lastname);
            stmt.setInt(6, userId);
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean changePassword(User user, String oldPass, String newPass, String newPassAuth) {
        if (oldPass.equals(user.getPassword())) {
            if (newPass.equals(newPassAuth)) {
                try {
                    Class.forName(DBSDriver);
                    Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
                    String sql = "Update [User] set [Password] = ? where Email = ? ";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, newPass);
                    stmt.setString(2, user.getEmail());
                    stmt.executeUpdate();
                    con.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
