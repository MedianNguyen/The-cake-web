/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import com.thecake.db.CakeDB;
import com.thecake.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Du
 */
@WebServlet(name = "GetOrderServlet", urlPatterns = {"/GetOrder"})
public class GetOrderServlet extends HttpServlet {

    private HttpSession session;
    private CakeDB db;
    private String values;
    private String query;
    private ArrayList<Order> list;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            session = request.getSession();
            db = new CakeDB();
            values = request.getParameter("values");
            if (values != null) {
                if (values.matches("lastWeek")) {
                    query = "{call getOrderWeek()}";
                    list = db.getOrderDay(query);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                } else if (values.matches("lastMount")) {
                    query = "{call getOrderMount()}";
                    list = db.getOrderDay(query);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                }else if(values.matches("money1-200")){
                    list=db.getOrderMoney(1, 200);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                
                }else if(values.matches("money201-500")){
                    list=db.getOrderMoney(200, 500);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                
                }else if(values.matches("money500-1000")){
                    list=db.getOrderMoney(500, 1000);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                
                }else if(values.matches("money1000-2000")){
                    list=db.getOrderMoney(1000, 2000);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                }else if(values.matches("money>2000")){
                    list=db.getOrderMoney(2000, 100000);
                    session.setAttribute("SellerShow", "search");
                    session.setAttribute("list", list);
                    response.sendRedirect("Seller.jsp");
                } else {
                    response.sendRedirect("Seller.jsp");
                }
            } else {
                response.sendRedirect("Seller.jsp");
            }
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
