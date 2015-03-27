/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thecake.db.CakeDB;
import com.thecake.model.CartItem;
import com.thecake.model.Category;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Du
 */
public class ShoppingCartServlet extends HttpServlet {

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
        DecimalFormat formater;
        formater = new DecimalFormat(".##");
        formater.setDecimalSeparatorAlwaysShown(false);
        ArrayList<CartItem> list;
        float totalMoney = 0;
        HttpSession session = request.getSession();
        list = (ArrayList<CartItem>) session.getAttribute("cart");
        String id_string = request.getParameter("id");

        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.isEmpty()) {
            totalMoney = 0;
        } else {
            for (CartItem list1 : list) {
                totalMoney += list1.getTotal();
            }
        }
        session.setAttribute("cart", list);
        if (id_string != null) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher id_matcher = pattern.matcher(id_string);

            if (id_matcher.matches()) {
                int id = Integer.parseInt(id_string);
                CakeDB db = new CakeDB();
                boolean newItem = true;
                for (CartItem pro : list) {
                    if (pro.getP().getId() == id) {
                        newItem = false;
                        pro.incrementQuantity();
                    }
                }
                if (newItem) {
                    CartItem items = db.additem(id);
                    list.add(items);
                }
                //ArrayList<Category> listCategorys = db.getCategories();
                if (list.isEmpty()) {
                    totalMoney = 0;
                } else {
                    for (CartItem list1 : list) {
                        totalMoney += list1.getTotal();
                    }
                }

                session.setAttribute("productSize", list.size());
                //session.setAttribute("listCategory", listCategorys);
                request.getSession().setAttribute("ContentShow", "order");
                request.getSession().setAttribute("listCart", list);
                request.getSession().setAttribute("money", formater.format(totalMoney));
                response.sendRedirect("home.jsp");

            } else {
                request.getSession().setAttribute("ContentShow", "order");
                request.getSession().setAttribute("listCart", list);
                session.setAttribute("productSize", list.size());
                request.getSession().setAttribute("money", formater.format(totalMoney));
                response.sendRedirect("home.jsp");
            }
        } else {
            request.getSession().setAttribute("ContentShow", "order");
            request.getSession().setAttribute("listCart", list);
            session.setAttribute("productSize", list.size());
            request.getSession().setAttribute("money", formater.format(totalMoney));
            response.sendRedirect("home.jsp");
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
