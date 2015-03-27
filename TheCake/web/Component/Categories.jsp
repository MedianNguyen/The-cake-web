<%-- 
    Document   : Categories
    Created on : May 1, 2014, 9:16:27 AM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Category> list = (ArrayList) session.getAttribute("listCatalog");
    if(list==null){
        response.sendRedirect("Home");
    }
%>
<div class="templatemo_content_left_section">
    <div class="main_menu" style="font-size: larger;font-weight: bolder; margin-bottom: 4px;">
        <b>Categories</b></div> 
    <div id="menu">         
        <ul>

            <%for (Category p : list) {%>
            <li><a href="Product?id=<%=p.getId()%>&page=1"><%=p.getName()%></a></li>
                <%}%>                          
        </ul>
    </div>
</div>