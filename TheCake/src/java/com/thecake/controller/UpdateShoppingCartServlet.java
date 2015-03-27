/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import java.util.ArrayList;
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
import com.thecake.model.Category;

/**
 *
 * @author Du
 */
public class UpdateShoppingCartServlet extends HttpServlet {

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
        String messager = "";
        int id = 0;
        String remove = request.getParameter("remove");
        String update = request.getParameter("update");
        String quantity = request.getParameter("quantity");
        String id_product = request.getParameter("id");
        if (id_product != null) {
            id = Integer.parseInt(id_product);
            float totalMoney = 0;
            CakeDB db = new CakeDB();
            HttpSession session = request.getSession();

            ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
            if (list != null) {
                if (remove != null) {
                    if (remove.matches("Remove")) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getP().getId() == id) {
                                list.remove(i);
                            }
                        }
                    }
                } else if (update != null) {

                    if (update.matches("Update")) {
                        Pattern pattern = Pattern.compile("[0-9]*");
                        Matcher matcher = pattern.matcher(quantity);

                        if (!matcher.matches()) {
                            messager = "Enter Quantity";
                        } else if (quantity == null) {
                            messager = "Enter Quantity";
                        } else if (quantity.matches("")) {
                            messager = "Enter Quantity";
                        } else if (quantity.length() > 9) {
                            messager = "Enter Quantity";
                        } else {
                            int y = Integer.parseInt(quantity);
                            if (y == 0) {
                                messager = "Invalid values Quantity";
                            } else if (y < 0) {
                                messager = "Invalid values Quantity";
                            } else if (y > 50) {
                                messager = "If you want to buy more than 50 cakes, call us, please!";
                            } else {
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getP().getId() == id) {

                                        list.get(i).setQuantity(y);
                                    }
                                }
                            }
                        }

                    }
                }
            }
            for (CartItem list1 : list) {
                totalMoney += list1.getTotal();
            }
            if (true) {

            }
            DecimalFormat formater = new DecimalFormat();
            formater.setDecimalSeparatorAlwaysShown(false);
            ArrayList<Category> listCategorys = db.getCategories();
            request.getSession().setAttribute("money", formater.format(totalMoney));
            request.getSession().setAttribute("messager", messager);
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
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
