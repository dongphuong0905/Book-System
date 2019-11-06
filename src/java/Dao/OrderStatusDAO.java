/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OrderStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trong
 */
public class OrderStatusDAO {
    public static String getStatus(int id){
        try {
            Connection con = new Database().getConnection();

            String sql = "Select Description from Order_Status where ID = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("Description");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
