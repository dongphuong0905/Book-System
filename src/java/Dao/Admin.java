/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DBSInterface.DBSDriver;
import static DAO.DBSInterface.DBSID;
import static DAO.DBSInterface.DBSName;
import static DAO.DBSInterface.DBSPass;
import Model.Book;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Phuong
 */
public class Admin {

    public static List<User> getUser() {
        List<User> list = new ArrayList<>();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select Id, [Role], UserAccount, FirstName, LastName, [Password], Telephone, Gender, Birthdate, [Address] from [User] where Role = 2 ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"),
                        rs.getString("Email"), rs.getInt("Gender"), rs.getDate("Birthdate"), null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
