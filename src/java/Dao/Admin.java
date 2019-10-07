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
             String sql = "Select ID, [Role], UserName, [Password], Telephone, Email, Gender, Birthdate, [Address] from [User] where [Role] = 1  ";
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                 list.add( new User(rs.getString("ID"),rs.getInt("Role"),rs.getString("UserName"),rs.getString("Password"),rs.getString("Telephone"),
                         rs.getString("Email"),rs.getInt("Gender"),rs.getString("Birthdate"),rs.getString("Address")));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Book> getBook() {
        List<Book> list = new ArrayList<>();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
             String sql = "";
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                 list.add( new Book(rs.getString("a"),rs.getString("Author"),rs.getString("Title"),rs.getDate("Publish_Date"),rs.getInt("Amount")));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
