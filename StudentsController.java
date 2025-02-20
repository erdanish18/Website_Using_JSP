/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.danish.controller;

import com.qt.danish.beans.TblStudents;
import com.qt.danish.models.Students;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danish
 */
@WebServlet(name = "StudentsController", urlPatterns = {"/StudentsController"})
public class StudentsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TblStudents students = new TblStudents();
        String message = null;
        Students studentModel = new Students();
        if (action.equals("insert")) {
            students.setName(request.getParameter("name"));
            students.setRollNo(Integer.parseInt(request.getParameter("rollno")));
            students.setAge(Integer.parseInt(request.getParameter("age")));
            students.setGender(request.getParameter("gender"));
            students.setDob(request.getParameter("dob"));
            students.setPhoNo(request.getParameter("phone"));
            students.setEmail_id(request.getParameter("email"));
            students.setAddress(request.getParameter("address"));

            message = studentModel.insert(students);
            response.sendRedirect("index.jsp?message=" + message);

        } else if (action.equals("delete")) {
            students.setId(Integer.parseInt(request.getParameter("Id")));
            message = studentModel.deleteARecord(students);
            response.sendRedirect("index.jsp?message=" + message);

        } else if (action.equals("update")) {
            students.setId(Integer.parseInt(request.getParameter("Id")));
            students.setName(request.getParameter("name"));
            students.setRollNo(Integer.parseInt(request.getParameter("RollNo")));
            students.setAge(Integer.parseInt(request.getParameter("age")));
            students.setGender(request.getParameter("gender"));
            students.setDob(request.getParameter("Dob"));
            students.setPhoNo(request.getParameter("phone"));
            students.setEmail_id(request.getParameter("email"));
            students.setAddress(request.getParameter("address"));
            response.sendRedirect("index.jsp?message=" + message);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
