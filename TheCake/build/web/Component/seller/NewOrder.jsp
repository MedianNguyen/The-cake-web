<%-- 
    Document   : Request
    Created on : May 11, 2014, 1:13:49 AM
    Author     : Du
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Order"%>
<%
    ArrayList<Order> listOrder = (ArrayList) session.getAttribute("list");

%>


<div>
    <%        if (session.getAttribute("userName") == null) {
            response.sendRedirect("Home");
        } else if (listOrder == null) {
            response.sendRedirect("Seller");
        }
    %>
    <table cellspacing="0">
        <tr><th colspan="8">New Order</th></tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Total Money</th>
            <th>Order Date</th>
            <th>View</th>
        </tr>
        <%for (Order o : listOrder) {%>
        <tr>
            <td><%=o.getId()%></td>
            <td><%=o.getName()%></td>
            <td><%=o.getEmail()%></td>
            <td>$<%=o.getTotal_money()%></td>
            <td><%=o.getOrder_date()%></td>
            <td><a href="OrderDetails?id=<%=o.getId()%>"><img src="images/day_view.png"/></a></td>
        </tr>
        <%}%>
    </table>
</div>



