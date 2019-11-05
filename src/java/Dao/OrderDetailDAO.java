/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OrderDetail;
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
public class OrderDetailDAO {
    public List<OrderDetail> getAll(int OrderId){
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, OrderID, BookID, PromID, Price, "
                    + "Amount, Total FROM OrderDetail WHERE OrderID = " + OrderId);
            while(rs.next()){
                listOrderDetail.add(new OrderDetail(rs.getInt("ID"), rs.getInt("OrderID"), rs.getInt("BookID"), rs.getInt("PromID"), 
                                                    rs.getBigDecimal("Price"), rs.getInt("Amount"), rs.getBigDecimal("Total")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOrderDetail;
    }
    
    public void add(int orderId, int bookId, int promId, BigDecimal price, int amount){
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            String sql = "INSERT INTO Order_Detail VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderId);
            stmt.setInt(2, bookId);
            stmt.setInt(3, promId);
            stmt.setDouble(4, price.doubleValue());
            stmt.setInt(5, amount);
            stmt.setDouble(6, price.doubleValue() * amount);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(int bookId, int promId, BigDecimal price, int amount){
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            String sql = "UPDATE Order_Detail SET PromIdD = ?, Amount = ?, Total = ? WHERE OrderID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, promId);
            stmt.setInt(2, amount);
            stmt.setDouble(3, amount * price.doubleValue());
            stmt.setInt(4, bookId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
