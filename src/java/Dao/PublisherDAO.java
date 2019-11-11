/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Publisher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tran Phuong
 */
public class PublisherDAO {

    public PublisherDAO() {
    }

    public Publisher getPublisher(int id) {
        Publisher pub = null;
        try {
            Database db = new Database();
            Connection con = db.getConnection();

            String sql = "Select * from Publisher where ID=" + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pub = new Publisher(rs.getInt("ID"), rs.getString("Publisher_Name"));
            }
        } catch (Exception e) {

        }
        return pub;
    }
}
