<%-- 
    Document   : NewProduct
    Created on : May 1, 2014, 10:17:49 PM
    Author     : Link Larkin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Product"%>
<%
    ArrayList<Product> listProduct = (ArrayList) session.getAttribute("listProduct");
    if(listProduct==null){
        response.sendRedirect("Home");
    }
%>
<div class="breadcrumb_wrapper" style="background-color: white"  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>
        <a class="active" href="ShoppingCart">Newest cakes</a>
        <a > </a>
    </div>
</div>
<div  style="padding-top: 20px">
    <%for (Product p : listProduct) {%>
    <div class="cake_box" style="float: left;padding: 10px">
        <div><a href="Cake?id=<%=p.getId()%>" >
                <img style="width: 140px;height: 160px"  src="<%=p.getImg_description()%>" 
                     onmouseover="showtrail('<%=p.getImg_description()%>', '<%=p.getName()%>', 433, 650)" 
                     onmouseout="hidetrail()">
            </a></div>
        <div><a href="Cake?id=<%=p.getId()%>" style="font-size: medium"><%=p.getName()%></a></div>
        <div class="cake_box_bottom">
            <div style="margin-bottom: 5px;margin-top: 5px">Price:<span style="color: #FFFF00"><%=p.getPrice()%>$</span></div>
            <div style="float: left">
                <a href="ShoppingCart?id=<%=p.getId()%>"><img style="width: 60px;height:25px" src="images/bynow.png"/></a>
                <a href="Cake?id=<%=p.getId()%>"><img  style="width: 60px;height:25px" src="images/details.png"/> </a>
            </div>
        </div>
    </div>
    <%}%>
</div> 