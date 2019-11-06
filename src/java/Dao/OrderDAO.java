/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Order;
import Model.OrderDetail;
import Model.User;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trong
 */
public class OrderDAO {
    
    public static List<Order> getAll(int userId){
        List<Order> orderList = new ArrayList<>();
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, UserID, OStaID, Order_Date, Total_Price, "
                    + "Payment_Method, Payment_Status FROM [ORDER] WHERE UserID = " + userId);
            while(rs.next()){
                List<OrderDetail> listOrderDetail = new OrderDetailDAO().getAll(rs.getInt("ID"));
                User user = UserDAO.getCurrentUser(rs.getInt("UserID"));
                Order order = new Order(rs.getInt("ID"), user, listOrderDetail, rs.getInt("OStaID"), rs.getDate("Order_Date"), 
                        rs.getBigDecimal("Total_Price"), rs.getString("Payment_Method"), rs.getInt("Payment_Status"));
                order.setPayStatus(OrderStatusDAO.getStatus(order.getId()));
                orderList.add(order);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
    
    public static Order get(int OrderId){
        Order order = null;
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, UserID, OStaID, Order_Date, Total_Price, "
                    + "Payment_Method, Payment_Status FROM [ORDER] WHERE ID = " + OrderId);
            while(rs.next()){
                int userID = rs.getInt("UserID");
                List<OrderDetail> listOrderDetail = new OrderDetailDAO().getAll(OrderId);
                User user = UserDAO.getCurrentUser(userID);
                order = new Order(OrderId, user, listOrderDetail, rs.getInt("OStaID"), rs.getDate("Order_Date"), 
                        rs.getBigDecimal("Total_Price"), rs.getString("Payment_Method"), rs.getInt("Payment_Status"));
                order.setPayStatus(OrderStatusDAO.getStatus(order.getId()));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
    
    public static int getCurrentOrderId(int userId) {
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 ID FROM [ORDER] WHERE UserID = " + userId + " Order By ID DESC");
            while(rs.next()){
                int orderId = rs.getInt("ID");
                return orderId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void add(int userId, int oStaId, BigDecimal totalPrice, String paymentMethod, int paymentStatus, String address){
        try {
            Connection con = new Database().getConnection();
            String sql = "INSERT INTO [Order](UserID, OStaID, Total_Price, Payment_Method, Payment_Status, Order_Address) VALUES "
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, oStaId);
            stmt.setDouble(3, totalPrice.doubleValue());
            stmt.setString(4, paymentMethod);
            stmt.setInt(5, paymentStatus);
            stmt.setString(6, address);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
