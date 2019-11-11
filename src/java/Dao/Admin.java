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
import Model.Category;
import Model.Promotion;
import Model.Publisher;
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
            String sql = "Select Id, [Role], UserAccount, FirstName, LastName, [Password], Telephone, Email, Gender, Birthdate from [User] where Role = 1 ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getString("Password"), rs.getString("Telephone"), rs.getString("Email"),
                        rs.getInt("Gender"), rs.getDate("Birthdate"), AddressDAO.getAddress(rs.getInt("ID"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void blackList(int userId, int role) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            if (role == 2) {
                String sql1 = "Update [User] set [Role] = 3 where ID = ?";
                PreparedStatement stmt1 = con.prepareStatement(sql1);
                stmt1.setInt(1, userId);
                stmt1.executeUpdate();
            } else {
                String sql2 = "Update [User] set [Role] = 2 where ID = ?";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                stmt2.setInt(1, userId);
                stmt2.executeUpdate();
            }
        } catch (Exception e) {

        }
    }

    public static List<Publisher> getPublisher() {
        List<Publisher> list = new ArrayList<>();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from Publisher";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Publisher(rs.getInt("id"), rs.getString("Publisher_Name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Promotion> getPromotion() {
        List<Promotion> list = new ArrayList<>();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from Promotion";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Promotion(rs.getInt("ID"), rs.getString("Title"), rs.getString("Description"), rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getInt("Discount")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Category> getCategory() {
        List<Category> listCategory = new ArrayList<>();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from Category";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listCategory.add(new Category(rs.getInt("ID"), rs.getString("Description")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCategory;
    }

    public static boolean addCategory(String category) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Insert into Category values(?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, category);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean deleteCategory(String id) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Delete from Category where ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUserById(int userId) {
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from User where ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            User user = new User(rs.getInt("ID"), rs.getInt("Role"), rs.getString("UserAccount"), rs.getString("Password"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Telephone"), rs.getString("Email"), rs.getInt("Gender"), rs.getDate("Birthday"), UserDAO.getAddress(userId));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
