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
import Model.Address;
import Model.Book;
import Model.City;
import Model.Promotion;
import Model.Publisher;
import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trong
 */
public class UserDAO implements DBSInterface {

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

    public static List<Book> getListBook() {
        List<Book> listBook = new ArrayList<Book>();
        PromotionDAO promotionDao = new PromotionDAO();
        PublisherDAO pdao = new PublisherDAO();
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from Book";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Promotion promotion = promotionDao.getPromotion(rs.getInt("PromID"));
                Publisher pub = pdao.getPublisher(rs.getInt("PublID"));
                Book book = new Book(rs.getInt("id"), rs.getInt("BookID"), pub, rs.getString("Author"), rs.getString("Title"), rs.getString("Description"),
                        rs.getDate("Publish_Date"), rs.getBigDecimal("Price"), rs.getInt("Amount"), promotion);
                listBook.add(book);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public static City getCity(int cityId) {
        City city = null;
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from City where ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cityId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                city = new City(rs.getInt("ID"), rs.getString("Name"));
            }
        } catch (Exception e) {

        }
        return city;
    }

    public static Address getAddress(int userId) {
        Address address = null;
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select * from Address where userid = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                City city = getCity(rs.getInt("City"));
                address = new Address(rs.getInt("ID"), userId, city, rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    public static boolean passTrue(int userId, String curPass) {
        int id = -1;
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Select ID from [User] where [Password] = ? and ID = ?" ;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, curPass);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
            }
        } catch (Exception e) {
            return false;
        }
        if(id>0){
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean changePass(String newPass, int userId){
        try {
            Class.forName(DBSDriver);
            Connection con = DriverManager.getConnection(DBSName, DBSID, DBSPass);
            String sql = "Update [User] set [Password] = ? where ID = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, newPass);
            stmt.setInt(2, userId);
            return  stmt.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean validateChangePass(String curPass, String newPass, String confPass, int userId){
           if(passTrue(userId, curPass)){
               if(newPass.equals(confPass)){
                    return changePass(newPass, userId);
               }
           }
           return false;
    }
}
