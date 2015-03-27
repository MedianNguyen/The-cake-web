/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller.Admin;

import com.thecake.db.CakeDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Link Larkin
 */
@WebServlet(name = "AdminAction", urlPatterns = {"/AdminAction"})

public class AdminAction extends HttpServlet {

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
        try {
            String name = request.getParameter("Name");
            //String t = request.getParameter("ID");
            String ID = request.getParameter("ID");
            String Egg = request.getParameter("Egg");
            String Price1;
            if (request.getParameter("Price1") == null || request.getParameter("Price1") == "") {
                Price1 = "0";
            } else {
                Price1 = request.getParameter("Price1");
            }
            String Price2;
            String t = request.getParameter("Price2");
            if (request.getParameter("Price2") == null || "".equals(request.getParameter("Price2"))) {
                Price2 = "999999999999999999999999999";
            } else {
                Price2 = request.getParameter("Price2");
            }
            request.getSession().setAttribute("product", new CakeDB().getAllProduct(name, ID, Egg, Price1, Price2));
            request.getSession().setAttribute("AdminContent", "product");
        } catch (Exception e) {

        }
        String menu = "";
        if (request.getParameter("menu") != null) {
            menu = request.getParameter("menu");
        }

        CakeDB db = new CakeDB();
        switch (menu) {
            case "1":
                request.getSession().setAttribute("product", db.getAllProduct());
                request.getSession().setAttribute("AdminContent", "product");
                break;
            default:
                break;
        }

        response.sendRedirect("/EprojectTheCake/Component/Admin/Admin.jsp");
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
