/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thecake.db.CakeDB;
import com.thecake.model.User;

/**
 *
 * @author Link Larkin
 */
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu = request.getParameter("menu");
        User u = (User) request.getSession().getAttribute("User");
        CakeDB cake = new CakeDB();
        if (request.getParameter("changePass") != null) {
            if (u.getPASSWORD() == null ? request.getParameter("currentPass") == null : u.getPASSWORD().equals(request.getParameter("currentPass"))) {
                if (request.getParameter("newPass") == null ? request.getParameter("confirmPass") == null : request.getParameter("newPass").equals(request.getParameter("confirmPass"))) {
                    if (cake.changePass(request.getParameter("newPass"), u.getID())) {
                        request.getSession().setAttribute("message", "Success");
                    } else {
                        request.getSession().setAttribute("message", "Your new password must match confirm pass");
                    }
                } else {
                    request.getSession().setAttribute("message", "Your current password is not correct!");
                }
            }else{
                request.getSession().setAttribute("message", "Enter your current password and then new password");
            }
        }
        if ("2".equals(menu)) {
            request.getSession().setAttribute("ContentShow", "changePass");
        }
        if ("1".equals(menu)) {
//            request.getSession().setAttribute("Order", cake.getUserOrder(u.getID()));
            request.getSession().setAttribute("ContentShow", "CheckUserOrder");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
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
