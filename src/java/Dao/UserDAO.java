/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.DBSInterface.DBSDriver;
import static Dao.DBSInterface.DBSID;
import static Dao.DBSInterface.DBSName;
import static Dao.DBSInterface.DBSPass;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author PC
 */
public class UserDAO {

    public User user;

    public UserDAO() {
    }

    public UserDAO(User user) {
        this.user = user;
    }

    public boolean changePassword(String oldPass, String newPass, String newPassAuth) {
        if (oldPass.equals(this.user.getPassword())) {
            if (newPass.equals(newPassAuth)) {
                try {
                    Class.forName(DBSDriver);
                    Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
                    String sql = "Update [User] set [Password] = ? where Email = ? ";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, newPass);
                    stmt.setString(2, this.user.getEmail());
                    stmt.executeUpdate();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean changeInformation(String userId, String phoneNumber, int gender, String birthday, String address) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Update [User] set phoneNumber = ?, gender = ?, birthday = ?, address = ? where userId = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            stmt.setInt(2, gender);
            stmt.setString(3, birthday);
            stmt.setString(4, address);
            stmt.setString(4, userId);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
