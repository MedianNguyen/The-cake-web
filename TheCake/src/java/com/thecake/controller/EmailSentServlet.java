/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller;

import com.thecake.db.CakeDB;
import com.thecake.model.EmailUtility;
import com.thecake.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EmailSendServlet", urlPatterns = {"/EmailSend"})
public class EmailSentServlet extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
    HttpSession session;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String status = request.getParameter("status");
        int id = Integer.parseInt(request.getParameter("id"));
        String email_to = request.getParameter("email");
        EmailUtility email = new EmailUtility();
        CakeDB db = new CakeDB();
        session=request.getSession();
        if (status != null && email_to != null) {
            int status_code = Integer.parseInt(status);
            try {
                if (status_code == 1) {
                    email.sendEmail(host, port, user, pass, email_to, "the cakes",
                            "being transported");

                    Order order = db.getOrderFromID(id);
                    boolean checkUpdate = db.UpdateOrder(id, status_code);
                    
                    response.sendRedirect("Result");

                } else if (status_code == 3) {
                    email.sendEmail(host, port, user, pass, email_to, "the cakes",
                            "Refused");
                    Order order = db.getOrderFromID(id);
                    boolean checkUpdate = db.UpdateOrder(id, status_code);
                    session.setAttribute("SellerShow", "mail");
                    response.sendRedirect("Result");
                }else{
                    Order order = db.getOrderFromID(id);
                    boolean checkUpdate = db.UpdateOrder(id, status_code);
                    response.sendRedirect("Seller");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                
            }
        }
    }

}
