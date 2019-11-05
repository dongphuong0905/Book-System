/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.City;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trong
 */
public class CityDAO {
    public static List<City> getCities(){
        List<City> list = new ArrayList<>();
        try {
            Connection con = new Database().getConnection();

            String sql = "SELECT * FROM City ORDER BY [Name]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new City(rs.getInt("ID"), rs.getString("Name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static City getCity(int ID){
        try {
            Connection con = new Database().getConnection();

            String sql = "SELECT * FROM City where ID = " + ID;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return new City(rs.getInt("ID"), rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
