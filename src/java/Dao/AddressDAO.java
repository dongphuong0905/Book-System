/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Address;
import Model.City;
import Model.User;
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
public class AddressDAO implements DBSInterface{    
    public static Address getAddress(int userID){
        try {
            Connection con = new Database().getConnection();

            String sql = "Select ID, City, [Address] from User_Address where UserID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return new Address(rs.getInt("ID"), userID, CityDAO.getCity(rs.getInt("City")), rs.getString("Address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void updateAddress(int userId, int cityId, String address) {
        try {
            Connection con = new Database().getConnection();
            String sql = "UPDATE User_Address SET City = ?, [Address] = ? where UserID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cityId);
            stmt.setString(2, address);
            stmt.setInt(3, userId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
