<%-- 
    Document   : ProductDetail
    Created on : May 14, 2014, 12:49:40 AM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.Product"%>
<%
    Product p = (Product) session.getAttribute("productDetail");
%>
<form action="/EprojectTheCake/UpdateAction" method="post" enctype="multipart/form-data">
    <div>
        Name: <input type="text" name="NameDetail" value="<%=p.getName()%>"/>
        Egg: <input type="text" name="EggDetail" value="<%=p.getEgg()%>"/>
        Price: <input type="text" name="PriceDetail" value="<%=p.getPrice()%>"/>
        Image: <input type="file" name="file"/>
        <input type="submit" value="Update"/>
    </div>
</form>
<%if (session.getAttribute("message") != null) {%>
<h3>Success</h3>
<%}%>