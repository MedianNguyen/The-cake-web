/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import com.thecake.db.CakeDB;
import com.thecake.model.Order;
import com.thecake.model.OrderDetail;
import com.thecake.model.Product;
import com.thecake.model.SellerOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "OrderDetailsServlet", urlPatterns = {"/OrderDetails"})
public class OrderDetailsServlet extends HttpServlet {

    ArrayList<OrderDetail> listOrderDetails;
    Product product;
    ArrayList<SellerOrder> listSellerOrders;
    CakeDB db;
    Order order;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        db = new CakeDB();
        listSellerOrders = new ArrayList<>();
        session=request.getSession();
        if (id != null) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher matcher = pattern.matcher(id);
            if (!matcher.matches()) {
                response.sendRedirect("Seller.jsp");
            } else {
                int id_order = Integer.parseInt(id);
                order = db.getOrderFromID(id_order);
                listOrderDetails = db.getOrderDetail(id_order);
                for (OrderDetail listOrderDetail : listOrderDetails) {
                    int id_product = listOrderDetail.getPRODUCT_ID();
                    product = db.getProductFromID(id_product);
                    int quantity = listOrderDetail.getQUANTITY();
                    SellerOrder sellerOrder = new SellerOrder(product, quantity);
                    listSellerOrders.add(sellerOrder);
                }
                request.getSession().setAttribute("SellerShow", "details");
                session.setAttribute("list", listSellerOrders);
                session.setAttribute("name", order.getName());
                session.setAttribute("address", order.getAddress());
                session.setAttribute("phone", order.getPhone());
                session.setAttribute("email", order.getEmail());
                session.setAttribute("money", order.getTotal_money());
                session.setAttribute("id", id_order);
                response.sendRedirect("Seller.jsp");
            }
        } else {
            response.sendRedirect("Seller.jsp");
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
