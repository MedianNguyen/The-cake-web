/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import com.thecake.db.CakeDB;
import com.thecake.model.CartItem;
import com.thecake.model.Category;
import com.thecake.model.EmailUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "OrderSuccessServlet", urlPatterns = {"/OrderSuccess"})

public class OrderSuccessServlet extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            System.out.println("Name =" + name);
            HttpSession session = request.getSession();
            float totalMoney = 0;
            CakeDB db = new CakeDB();
            EmailUtility email_object = new EmailUtility();
            ArrayList<CartItem> list = (ArrayList<CartItem>) session.getAttribute("cart");
            if (list == null) {
                list = new ArrayList<>();
            }
            session.setAttribute("cart", list);
            if (list.isEmpty()) {
                totalMoney = 0;
            } else {
                for (CartItem list1 : list) {
                    totalMoney += list1.getTotal();
                }
            }
            DecimalFormat formater = new DecimalFormat();
            formater.setDecimalSeparatorAlwaysShown(false);
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("mobile", mobile);
            request.setAttribute("email", email);
            request.getSession().setAttribute("ContentShow", "order_success");
            request.getSession().setAttribute("listCart", list);
            request.getSession().setAttribute("money", formater.format(totalMoney));
            String content = "Name :" + name + "";
            content += "\n";
            content += "Address :" + address + "";
            content += "\n";
            content += "Mobile :" + mobile + "";
            content += "\n";
            content += "Email :" + email + "";
            content += "\n";
            content += "Money :" + formater.format(totalMoney) + "";
            content += "\n";
            content += "Thank you for using our service !";
            email_object.sendEmail(host, port, user, pass, email, "My Order",
                    content);
            response.sendRedirect("home.jsp");
            session.removeValue("cart");
        } catch (MessagingException ex) {
            Logger.getLogger(OrderSuccessServlet.class.getName()).log(Level.SEVERE, null, ex);
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
