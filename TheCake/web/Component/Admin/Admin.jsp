
<%@page import="com.thecake.model.User"%>
<%
    User user = (User) session.getAttribute("User");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/AdminStyle.css" rel="stylesheet" type="text/css"/>
        <title>Admin Page</title>
    </head>
    <body>
        <div id="left">
            <ul>
                <li class="menu"><a href="/EprojectTheCake/AdminAction?menu=1">Product</a></li>
<!--                <li class="menu"><a href="/EprojectTheCake/Admin?menu=2">User</a></li>-->
                <li class="menu"><a href="/EprojectTheCake/Home">Logout</a></li>
            </ul>
        </div>
        <div id="right">
            <%if (session.getAttribute("AdminContent") == "product") {
            %><jsp:include page="../Admin/Product.jsp"/><%
                }
                if (session.getAttribute("AdminContent") == "productDettail") {
            %><jsp:include page="../Admin/ProductDetail.jsp"/><%
                }
                if (session.getAttribute("AdminContent") == "add") {
                    %><jsp:include page="../Admin/AddNewPro.jsp"/><%
                }else{%>
                <div>
                    <h1>Welcome to Admin Page</h1>
                </div>  
                <%}%>
        </div>
    </body>
</html>
