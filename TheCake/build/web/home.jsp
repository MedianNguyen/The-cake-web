<%-- 
    Document   : Home
    Created on : Apr 18, 2014, 6:55:54 PM
    Author     : Du
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>THE CAKE</title>
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" /> 
        <link href="rateit/breakcrumb.css" rel="stylesheet" type="text/css" /> 
        <link href="rateit/rateit.css" rel="stylesheet" type="text/css" /> 
        <link  href="rateit/style.css" rel="stylesheet"type="text/css">
        <link  href="css/jquery.simple-dtpicker.css" rel="stylesheet"type="text/css">


    </head>
    <body>
        <div style="display: none; position: absolute; z-index: 110; left: 100; top: 100; width: 15; height: 15" 
             id="preview_div"></div>
        <!--  Free CSS Templates from www.templatemo.com -->
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="Home" class="current">Home</a></li>
                    <li><a href="About.jsp">About</a></li>
                    <li><a href="StoreServlet">Contact</a></li>
                </ul>
            </div> <!-- end of menu -->
            <div id="templatemo_header">
                <div style="padding-top: 5px;padding-left: 5px;" >
                    <a href="Home" style="font-family: monospace; font-size: 20px; color: #ff9999"> The cake bakery - Food for human.</a>
                </div> </div>
            <div id="templatemo_content">
                <div id="templatemo_content_left" style="padding: 15px">
                    <jsp:include page="/Component/Categories.jsp"/>
                    <jsp:include page="/Component/LoginForm.jsp"/>
                    <div class="templatemo_content_left_section">

                        <div class="main_menu_click" style="font-size: larger;font-weight: bolder; margin-bottom:4px;">
                            <a style="text-decoration: none; text-decoration-line: none;color: #26370A;" href="ShoppingCart"> <b>Shopping cart</b><a/></div>



                        <ul>
                            <li><a class="current">Total Product: <%=session.getAttribute("productSize")%> </a></li>
                            <li style="margin-top: 10px"><a class="current">Total Money: ${money}$</a></li>
                        </ul>
                    </div>
                    <jsp:include page="/Component/BestSelling.jsp"/>                   

                </div> <!-- end of content left -->


                <div id="templatemo_content_right">
                    <%if (session.getAttribute("ContentShow") == null || session.getAttribute("ContentShow") == "home") {%>
                    <jsp:include page="Component/HomeContent.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "store") {
                    %><jsp:include page="Component/Store.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "order") {
                    %><jsp:include page="Component/Order.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "featured") {
                    %><jsp:include page="Component/Featured.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "CatalogProduct") {
                    %><jsp:include page="Component/Product.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "cake") {
                    %><jsp:include page="Component/CakeDetail.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "newProduct") {
                    %><jsp:include page="Component/NewProduct.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "changePass") {
                    %><jsp:include page="Component/ChangePass.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "CheckUserOrder") {
                    %><jsp:include page="Component/User/CheckOrder.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "EmployeeShowOrder") {
                    %><jsp:include page="Component/Employee/Order.jsp"/><%}
                        if (session.getAttribute("ContentShow") == "order_success") {
                    %><jsp:include page="Component/OrderSuccess.jsp"/><%}
                    %>

                </div> 
                <div id="templatemo_footer">
                    <a href="/EprojectTheCake/Home">Home</a> | <a href="StoreServlet">Contact Us</a><br />
                    Copyright © 2014 <a href="#"><strong>Group 3</strong></a> | <a href="http://www.iwebsitetemplate.com" target="_parent">The Cake</a> by <a href="http://www.templatemo.com" target="_parent" title="free css templates">Free Style</a>	
                </div> 
            </div>
        </div>
        <script src="rateit/jquery.rateit.min.js" language="JavaScript" type="text/javascript"></script>
        <script src="rateit/mouseover_popup.js" language="JavaScript" type="text/javascript"></script>
        <script src="rateit/prefixfree-1.0.7.js" language="JavaScript" type="text/javascript"></script>
<!--        <script src="rateit/jquery-1.8.2.js" language="JavaScript"  type="text/javascript"></script>-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
        <script src="rateit/jquery-ui-1.10.4.js" language="JavaScript" type="text/javascript"></script>
        <script src="js/jquery.simple-dtpicker.js" language="JavaScript" type="text/javascript"></script>
    </body>
</html>
