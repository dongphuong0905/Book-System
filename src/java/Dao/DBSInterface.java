/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author trong
 */
public interface DBSInterface {
    public String DBSDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public String DBSName = "jdbc:sqlserver://LENOVO\\SQLEXPRESS:1433;databaseName=BookSystem;";
    public String DBSID = "sa";
    public String DBSPass = "123";
}
