    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.danish.models;

import com.qt.danish.beans.TblStudents;
import com.qt.maven.webapp.connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Students {

    Connection con = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    String query = null;
    String message = null;
//Inserting the data in db

    public String insert(TblStudents student) {
        Connection con = connect.connectDB();
        query = "INSERT INTO TblStudents (Name ,RollNo, Age,Gender,Dob ,PhoNo , Email_id , Address) VALUES (?,?,?,?,?,?,?,?)";

        try {
            cs = con.prepareCall(query);
            cs.setString(1, student.getName());
            cs.setInt(2,student.getRollNo());
            cs.setInt(3, student.getAge());
            cs.setString(4,student.getGender());
            cs.setString(5,student.getDob());
            cs.setString(6, student.getPhoNo());
            cs.setString(7, student.getEmail_id());
            cs.setString(8, student.getAddress());

            int rows = cs.executeUpdate();

            if (rows >= 1) {
                message = "Value Inserted";
            }
        } catch (SQLException e) {
            message = "Value Not Inserted" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return message;
    }

    //How to get the data from the db
    public ArrayList<TblStudents> select() {
        con = connect.connectDB();
        ArrayList<TblStudents> arrayList = new ArrayList<>();
        try {
            query = "select * from tblstudents";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                arrayList.add(new TblStudents(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getInt("RollNo"),
                        rs.getInt("Age"),
                        rs.getString("Gender"),
                        rs.getString("Dob"),
                        rs.getString("Address"),
                        rs.getString("Email_id"),
                        rs.getString("PhoNo")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println("com.qt.danish.models.Students.select()" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = e.getMessage();
            }
        }
        return arrayList;
    }

    public String deleteARecord(TblStudents students) {
        con = connect.connectDB();
        query = "delete from tblStudents where Id =?";

        try {
            cs = con.prepareCall(query);
            cs.setInt(1, students.getId());
            int rows = cs.executeUpdate();
            if (rows >= 1) {
                message = "Value Deleted";
            }
        } catch (SQLException e) {
            message = "Value Not Delete because of" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return message;
    }
    
     public String updateARecord(TblStudents students) {
        con = connect.connectDB();
       query = "update  TblStudents set Name=? , RollNo=?,Age=? ,Gender=?,Dob=?,PhoNo=? , Email_id=? , Address=? where id=?";
        try {
            cs = con.prepareCall(query);           
            cs.setString(1, students.getName());
            cs.setInt(2,students.getRollNo());
            cs.setInt(3, students.getAge());            
            cs.setString(4, students.getGender());            
            cs.setString(5, students.getDob());            
            cs.setString(6, students.getPhoNo());
            cs.setString(7, students.getEmail_id());
            cs.setString(8, students.getAddress());            
            cs.setInt(9, students.getId());
            int rows = cs.executeUpdate();
            if (rows >= 1) {
                message = "Value Updated";
            }
        } catch (SQLException e) {
            message = "Value Not Updated because of" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return message;
    }

}
