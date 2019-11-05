/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trong
 */
public class Database implements DBSInterface{
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DBSDriver);
        return DriverManager.getConnection(DBSName, DBSID, DBSPass);
    }
}
