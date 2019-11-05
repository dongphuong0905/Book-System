/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Promotion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author trong
 */
public class PromotionDAO {
    
    public List<Promotion> getAll(){ 
        return null;
    }
    
    public Promotion getPromotion(int id){
        Promotion promotion = null;
        try {
            Database db = new Database();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, Title, Description, StartDate, EndDate, Discount FROM Promotion WHERE ID = " + id);
            while(rs.next()){
                promotion = new Promotion(rs.getInt("ID"), rs.getString("Title"), rs.getString("Description"), rs.getDate("StartDate"),
                                                rs.getDate("EndDate"), rs.getInt("Discount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }
            
            
}
