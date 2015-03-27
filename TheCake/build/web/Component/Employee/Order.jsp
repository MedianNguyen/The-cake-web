<%-- 
    Document   : Order
    Created on : May 5, 2014, 11:00:13 AM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.User"%>
<%@page import="com.thecake.db.CakeDB"%>
<%@page import="com.thecake.model.Product"%>
<%@page import="com.thecake.model.OrderDetail"%>
<%@page import="com.thecake.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%
    CakeDB db = new CakeDB();
    ArrayList<Order> listOrder = (ArrayList) session.getAttribute("Order");
    ArrayList<OrderDetail> listOrderDetail;
    Product p;
    Float TotalOrder = 0f;
    User u;
%>
<div>
    <%
        if (listOrder == null) {
    %>
    You don't have any Order! <a href="/EprojectTheCake/Home">Buy some thing?</a>
    <%
    } else {%>
    <table style="width: 100%;margin-top: 10px;border: 1px solid #ffffff;">
        <tr style="background: #1c94c4">
            <th style="height: 30px;border-right: 1px solid #ffffff">Images</th>
            <th style="border-right: 1px solid #ffffff">Name</th>
            <th>Quantity</th>
            <th style="border-right: 1px solid #ffffff">Price</th>
            <th style="border-right: 1px solid #ffffff">Total</th>
        </tr>
        <% for (Order o : listOrder) {%>
        Order code: <%=o.getID()%></br>
        <%listOrderDetail = db.getOrderDetail(o.getID());
            u = db.getUserByID(o.getUSER_ID());%>
            User ID : <%=u.getID()%></br>
            User's Name : <%=u.getNAME()%></br>
            Delivery Address : <%=o.getDELIVERY_ADD()%></br>
            Delivery Phone : <%=o.getDELIVERY_NUM()%></br>
            Order Date: <%=o.getORDER_DATE()%></br>
        <%for (OrderDetail od : listOrderDetail) {
                p = db.getProductFromID(od.getPRODUCT_ID());
        %>
        <tr style="border: 1px solid #ffffff">
            <td style="text-align: center;padding: 5px;">
                <img style="width: 30px;height: 30px;text-align: center" src="<%=p.getImg_description()%>">
            </td>
            <td style="text-align: center"><%=p.getName()%></td>
            <td style="text-align: center"><%=od.getQUANTITY()%></td>
            <td style="text-align: center"><%=p.getPrice()%></td>
            <td style="text-align: center">Total: <%=od.getQUANTITY() * p.getPrice()%></td>
        </tr>
        <%TotalOrder += od.getQUANTITY() * p.getPrice();%>
        <%}%>
    </table>
        <div style="float: right">Total Order : <%=TotalOrder%> $</div></br>
        <%TotalOrder=0f;%>
    <%}
            }%>
</div>