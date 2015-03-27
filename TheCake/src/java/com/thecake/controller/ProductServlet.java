/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import java.io.IOException;
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
import com.thecake.model.Product;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Du
 */
public class ProductServlet extends HttpServlet {

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
        String idString = request.getParameter("id");
        String pageStrimg = request.getParameter("page");
        CakeDB db = new CakeDB();
        if (idString != null && pageStrimg != null) {
            if (idString.length() < 3) {
                if (pageStrimg.length() < 3) {
                    Pattern pattern = Pattern.compile("[0-9]*");
                    Matcher id_matcher = pattern.matcher(idString);
                    Matcher page_matcher = pattern.matcher(pageStrimg);
                    if (id_matcher.matches()) {
                        if (page_matcher.matches()) {
                            int id_category = Integer.parseInt(idString);
                            int pageNumber = Integer.parseInt(pageStrimg);
                            Category category = db.getTitle(id_category);
                            ArrayList<Product> listProducts = db.getProduct(id_category, pageNumber);
                            ArrayList<Product> listSizeProducts = db.getProductFromIdCategory(id_category);
                            ArrayList<Category> listCategorys = db.getCategories();
                            float totalMoney = 0;
                            int size = 0;
                            int page = 1;
                            int totalPage = 0;
                            HttpSession session = request.getSession();
                            ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
                            if (list != null) {
                                size = list.size();
                                for (CartItem list1 : list) {
                                    totalMoney += list1.getTotal();
                                }
                            }
                            int recordNumber = listSizeProducts.size();
                            int check = recordNumber % 20;
                            if (recordNumber < 20) {
                                totalPage = 1;
                            } else if (check == 0) {
                                page = recordNumber / 20;
                                totalPage = page;
                            } else {
                                totalPage = page + 1;
                            }
                            ArrayList<Integer> listPager = new ArrayList<>();
                            for (int i = 0; i < totalPage; i++) {

                                listPager.add(i);

                            }
                            System.out.println("Size" + totalPage);
                            request.getSession().setAttribute("record", listPager);
                            request.setAttribute("idCategory", id_category);
                            request.getSession().setAttribute("title", category.getName());
                            request.setAttribute("list", listCategorys);
                            request.getSession().setAttribute("listProduct", listProducts);
                            request.getSession().setAttribute("Title", category.getName());
                            request.getSession().setAttribute("ContentShow", "CatalogProduct");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                            dispatcher.forward(request, response);

                        }

                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                        dispatcher.forward(request, response);
                    }
                }else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                        dispatcher.forward(request, response);
                }
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                        dispatcher.forward(request, response);
            }
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
