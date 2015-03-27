/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thecake.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thecake.db.CakeDB;
import com.thecake.model.CartItem;
import com.thecake.model.Category;
import com.thecake.model.Product;

/**
 *
 * @author Du
 */
@WebServlet(name = "NewProductServlet", urlPatterns = {"/NewProduct"})
public class NewProductServlet extends HttpServlet {

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
         CakeDB db= new CakeDB();
        ArrayList<Product> listProduct= db.getProductNew();
        ArrayList<Category> listCategorys= db.getCategories();
        request.setAttribute("list", listCategorys);
        request.getSession().setAttribute("listProduct", listProduct); 
        float totalMoney = 0;
        int size=0;
        HttpSession session = request.getSession();
        ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
        if (list!=null) {
            size= list.size();
            for (int i = 0; i < list.size(); i++) {
                totalMoney += list.get(i).getTotal();
            }
        }
        request.setAttribute("productSize", size);
        request.setAttribute("totalMoney", totalMoney);
        request.getSession().setAttribute("ContentShow","newProduct");
        RequestDispatcher dispatcher= request.getRequestDispatcher("home.jsp");
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
