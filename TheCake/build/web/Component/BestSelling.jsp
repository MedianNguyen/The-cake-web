<%-- 
    Document   : BestSelling
    Created on : May 1, 2014, 9:47:00 AM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Product> list = (ArrayList) session.getAttribute("listBestSelling");
    if(list==null){
        response.sendRedirect("Home");
    }
%>
<div class="templatemo_content_left_section">
    <div class="main_menu" style="font-size: larger;font-weight: bolder; margin-bottom:4px;">
        <b>BestSellers</b></div>
    <div>
        <%for (Product p : list) {%>
        <div style="float: left;padding: 10px">
            <div><a style="font-size: medium" href="Cake?id=<%=p.getId()%>">
                <img style="width: 140px;height: 160px"  src="<%=p.getImg_description()%>" 
                      onmouseover="showtrail('<%=p.getImg_description()%>', '<%=p.getName()%>', 433, 650)" 
                      onmouseout="hidetrail()"/>
                </a></div>
            <div><a style="font-size: medium" href="Cake?id=<%=p.getId()%>"><%=p.getName()%> </a></div>
            <div style="margin-bottom: 5px;margin-top: 5px">Price: <a style="color: #FFFF00">$<%=p.getPrice()%></a></div>
            <div style="float: left">
                <a href="ShoppingCart?id=<%=p.getId()%>"><img style="width: 60px;height:25px" src="images/bynow.png"/></a>
                <a href="Cake?id=<%=p.getId()%>"   >  <img style="width: 60px;height:25px" src="images/details.png"/> </a>
            </div>
        </div>
        <%}%>
    </div>
</div>