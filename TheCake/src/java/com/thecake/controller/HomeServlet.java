/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thecake.db.CakeDB;
import com.thecake.model.BestSeller;
import com.thecake.model.CartItem;
import com.thecake.model.Category;
import com.thecake.model.Product;

/**
 *
 * @author Du
 */
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CakeDB db = new CakeDB();
        ArrayList<Category> listCategorys = db.getCategories();
        ArrayList<Product> listProductNews = db.getProductNew();
        ArrayList<Product> listFeatured = db.getFeatured();
        ArrayList<BestSeller> listBestSelling = db.getBestSelling();
        ArrayList<Product> listProductBestSeller = new ArrayList<>();
        Product product = new Product();
        float totalMoney = 0;
        int size = 0;
        HttpSession session = request.getSession();
        ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
        if (list != null) {
            size = list.size();
            for (CartItem list1 : list) {
                totalMoney += list1.getTotal();
            }
        }
        if (listBestSelling != null) {
            for (int i=0;i<listBestSelling.size();i++) {
                    int id_product= listBestSelling.get(i).getId_product();
                    product = db.getProductFromID(id_product);
                    listProductBestSeller.add(product);
                }
        }
        request.getSession().setAttribute("ContentShow", "home");
        request.getSession().setAttribute("Title", "Home");
        session.setAttribute("productSize", size);
        session.setAttribute("listCatalog", listCategorys);
        session.setAttribute("listFeatrued", listFeatured);
        session.setAttribute("listProductNew", listProductNews);
        session.setAttribute("listBestSelling", listProductBestSeller);
        response.sendRedirect("home.jsp");

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
