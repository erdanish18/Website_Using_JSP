/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.maven.webapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danish
 */
public class Fetch {

    CallableStatement statement = null;
    ResultSet results = null;
    String Query = null;

    //select query to get all the details
    public void selectAll() {
        Connection con = connect.connectDB();
        String Query = "SELECT * FROM employee";
        try {

            statement = con.prepareCall(Query);
            results = statement.executeQuery();
            int count = 1;
            while (results.next()) {

                System.out.println("DATA OF " + count + " STUDENT");
                String data = results.getString(1);
                System.out.println("ID " + results.getRow() + " : " + data);

                data = results.getString(2);
                System.out.println("Name " + results.getRow() + " : " + data);
                
                data = results.getString(3);
                System.out.println("RollNo " + results.getRow() + " : " + data);

                data = results.getString(3);
                System.out.println("Age " + results.getRow() + " : " + data);

                data = results.getString(4);
                System.out.println("Gender " + results.getRow() + " : " + data);

                data = results.getString(5);
                System.out.println("PhoNo " + results.getRow() + " : " + data);

                data = results.getString(6);
                System.out.println("Email_id " + results.getRow() + " : " + data);

                data = results.getString(7);
                System.out.println("Address " + results.getRow() + " : " + data);

                System.out.println("ID =" + results.getInt("ID"));
                System.out.println("Name =" + results.getString("Name"));
                System.out.println("RollNo =" + results.getString("RollNo"));
                System.out.println("Age =" + results.getString("Age"));
                System.out.println("Gender =" + results.getString("Gender"));
                System.out.println("Dob =" + results.getString("Dob"));
                System.out.println("PhoNo =" + results.getString("PhoNo"));
                System.out.println("Email_id =" + results.getString("Email_id"));
                System.out.println("Address =" + results.getString("Address"));
                count++;
            }

        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    // insert query in the db
    public void InsertRecord() {
        Connection con = connect.connectDB();

        String Query = "INSERT INTO TblStudents (Name ,RollNo, Age , Gender ,Dob, PhoNo , Email_id , Address) VALUES (?,?,?,?,?,?,?,?)";

        try {
            statement = con.prepareCall(Query);
            statement.setString(1, "abc");
            statement.setInt(3, 19);
            statement.setInt(4, 19);
            statement.setString(5, "male");
            statement.setString(6, "123456789");
            statement.setString(7, "abc@gmail.com");
            statement.setString(8, "yoyoyoyoy");

            int result = statement.executeUpdate();
            if (result >= 1) {
                System.out.println("Value inserted");

            }
        } catch (SQLException e) {

            System.out.println("Unable to insert data " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    // deleting the record in db
    public void DeleteRecord() {
        Connection con = connect.connectDB();

        String Query = "DELETE FROM tblstudents WHERE Id = ?";

        try {
            statement = con.prepareCall(Query);
            statement.setInt(1, 3);

            int result = statement.executeUpdate();
            if (result >= 1) {
                System.out.println("Value deleted");

            }
        } catch (SQLException e) {

            System.out.println("Unable to delete data " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void UpdateRecord() {
        Connection con = connect.connectDB();

        String Query = "UPDATE tblstudents SET Name = ? , RollNo=?,Age = ?,Gender=?,Dob=?,PhoNo=?,Email_id=?, Address = ? WHERE Id=?";

        try {
            statement = con.prepareCall(Query);
            statement.setString(1, "Kamil");
            statement.setInt(2, 30);
            statement.setInt(3, 30);
            statement.setString(4,"dlslf");
            statement.setString(5,"yoyyoedsfsd");
            statement.setString(6,"fksdjnfjak");
            statement.setString(7, "0000@yo.com");
            statement.setString(8, "0000yocomfdssda");
            statement.setInt(9, 2);

            int result = statement.executeUpdate();
            if (result >= 1) {
                System.out.println("Value updated");

            }
        } catch (SQLException e) {

            System.out.println("Unable to update data " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        Fetch t = new Fetch();
        // t.selectAll();
        // t.InsertRecord();

        // t.DeleteRecord();
        t.UpdateRecord();
    }
}
