/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Book;
import Model.Promotion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trong
 */
public class BookDAO {

    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        PromotionDAO promotionDao = new PromotionDAO();
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT ID, BookID, PublID, Author, Title, Description,"
                    + " Publish_Date, Price, Amount, PromID FROM Book";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = promotionDao.getPromotion(rs.getInt("PromID"));
                bookList.add(new Book(rs.getInt("ID"), rs.getInt("BookID"), rs.getInt("PublID"), rs.getString("Author"),
                        rs.getString("Title"), rs.getString("Description"), rs.getDate("Publish_Date"),
                        rs.getBigDecimal("Price"), rs.getInt("Amount"), promotion));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book get(int bookId) {
        Book book = null;
        PromotionDAO promotionDao = new PromotionDAO();
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT ID, BookID, PublID, Author, Title, Description,"
                    + " Publish_Date, Price, Amount, PromID FROM Book WHERE BookID = ?");
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Promotion promotion = promotionDao.getPromotion(rs.getInt("PromID"));
                book = new Book(rs.getInt("ID"), rs.getInt("BookID"), rs.getInt("PublID"), rs.getString("Author"),
                        rs.getString("Title"), rs.getString("Description"), rs.getDate("Publish_Date"),
                        rs.getBigDecimal("Price"), rs.getInt("Amount"), promotion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> search(String title) {
        List<Book> bookList = new ArrayList<>();
        PromotionDAO promotionDao = new PromotionDAO();
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT ID, BookID, PublID, Author, Title, [Description],"
                    + " Publish_Date, Price, Amount, PromID FROM Book WHERE Title LIKE ?");
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Promotion promotion = promotionDao.getPromotion(rs.getInt("PromID"));
                bookList.add(new Book(rs.getInt("ID"), rs.getInt("BookID"), rs.getInt("PublID"), rs.getString("Author"),
                        rs.getString("Title"), rs.getString("Description"), rs.getDate("Publish_Date"),
                        rs.getBigDecimal("Price"), rs.getInt("Amount"), promotion));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
