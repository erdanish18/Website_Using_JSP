/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.danish.beans;

/**
 *
 * @author Danish
 */

// setting up beans to get  and set data
public class TblStudents {

    private int id;
    private String Name;
    private int RollNo;
    private int Age;
    private String Gender;
    private String Dob;
    private String address;
    private String Email_id;
    private String PhoNo;

    public TblStudents() {
    }

    public TblStudents(int id, String Name, int RollNo, int Age, String Gender, String Dob, String address, String Email_id, String PhoNo) {
        this.id = id;
        this.Name = Name;
        this.RollNo = RollNo;
        this.Age = Age;
        this.Gender = Gender;
        this.Dob = Dob;
        this.address = address;
        this.Email_id = Email_id;
        this.PhoNo = PhoNo;
    }
     // Inserted Code of Getters and Setters....
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int RollNo) {
        this.RollNo = RollNo;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

   

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String Email_id) {
        this.Email_id = Email_id;
    }

    public String getPhoNo() {
        return PhoNo;
    }

    public void setPhoNo(String PhoNo) {
        this.PhoNo = PhoNo;
    }

}
