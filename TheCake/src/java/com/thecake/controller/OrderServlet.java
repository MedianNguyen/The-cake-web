/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thecake.db.CakeDB;
import com.thecake.model.CartItem;
import com.thecake.model.Order;
import com.thecake.model.OrderDetail;
import java.text.DecimalFormat;

/**
 *
 * @author Du
 */
public class OrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CakeDB db = new CakeDB();
        int id_order = 0;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String total_money = request.getParameter("total_money");
        String delivery_date=request.getParameter("date");
        String hour=request.getParameter("hour");
        String m=request.getParameter("minuted");
        String messager = "";
        Matcher matcher = null;
        if (name == null && address == null && mobile == null && email == null && total_money == null) {
             RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
                dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
            boolean checkEmail = isEmailValid(email);
            if (mobile != null) {
                Pattern pattern = Pattern.compile("[0-9]*");
                matcher = pattern.matcher(mobile);
            }
            
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            String order_date = dateFormat.format(date);
            
            float money= Float.parseFloat(total_money);
            
            String de_date= delivery_date+" "+hour+":"+m;
            Order order = new Order(name, address, mobile, email, money, order_date,de_date);
            id_order = db.insertOrder(order);
            if (id_order == 0) {
                messager = "Insert DB Error!";
            } else {
                for (CartItem list1 : list) {
                    int id_product = list1.getP().getId();
                    int quantity_product = list1.getQuantity();
                    OrderDetail orderDetail = new OrderDetail(id_product, quantity_product, id_order);
                    db.insertOrderDetails(orderDetail);
                }
                request.setAttribute("name", name);
                request.setAttribute("address", address);
                request.setAttribute("mobile", mobile);
                request.setAttribute("emial", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("OrderSuccess");
                dispatcher.forward(request, response);
            }
        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
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
