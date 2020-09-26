/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.maven.webapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danish
 */
public class connect {
       
    private static final String L_USER = "root";
    private static final String DB_NAME = "jdbc:mysql://localhost:3306/anjumandb?useSSL=false";
    private static final String L_PASS = "12345";

    public static Connection connectDB() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_NAME, L_USER, L_PASS);
             System.out.println("Successfully Connected to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Not connected" + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args){
        connectDB();
    }
}
    

