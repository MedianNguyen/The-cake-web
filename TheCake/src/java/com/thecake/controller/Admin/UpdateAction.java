/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.controller.Admin;

import com.thecake.db.CakeDB;
import com.thecake.model.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Link Larkin
 */
@WebServlet(name = "UpdateAction", urlPatterns = {"/UpdateAction"})
@MultipartConfig
public class UpdateAction extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddNewPro</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Success</h1>");
//            out.println("<h1><a href='/EprojectTheCake/Component/Admin/Admin.jsp'>Back</a></h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        Product p = (Product) request.getSession().getAttribute("productDetail");
        p.setName(request.getParameter("NameDetail"));
        p.setEgg(request.getParameter("EggDetail"));
        p.setPrice(Float.parseFloat(request.getParameter("PriceDetail")));
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + "images";

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = null;
        Part part;
        part = request.getPart("file");

        fileName = extractFileName(part);
        if (!"".equals(fileName.trim())) {
            InputStream filecontent = null;
            OutputStream out = null;
            filecontent = part.getInputStream();
            final PrintWriter writer = response.getWriter();
            out = new FileOutputStream(new File(savePath + File.separator
                    + fileName));
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            // out.flush();
            out.close();
            //writer.flush();
            filecontent.close();
            //writer.close();
            //part =null;
            p.setImg_description("images" + "/" + fileName);
            //response.reset();
        }

        CakeDB db = new CakeDB();
        db.updateProduct(p);
        request.getSession().setAttribute("message","success");
        //request.getSession().setAttribute("AdminContent", "productDettail");

        response.sendRedirect("/EprojectTheCake/Component/Admin/AddNewPro.jsp");

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
        //request.getSession().setAttribute("AdminContent", "productDettail");
        //response.sendRedirect("/EprojectTheCake/Component/Admin/Admin.jsp");
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

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
