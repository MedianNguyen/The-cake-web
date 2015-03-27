<%-- 
    Document   : CheckOrder
    Created on : May 4, 2014, 12:55:20 PM
    Author     : Link Larkin
--%>
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
%>
<div>
    <%
        if (listOrder == null) {
            %>
            You don't have any Order! <a href="/EprojectTheCake/Home">Buy some thing?</a>
    <%
        } else {
            for (Order o : listOrder) {%>
    Order code: <%=o.getID()%></br>
    <%listOrderDetail = db.getOrderDetail(o.getID());
        for (OrderDetail od : listOrderDetail) {
            p = db.getProductFromID(od.getPRODUCT_ID());
    %>
    <tr style="border: 1px solid #ffffff">
        <td style="text-align: center;padding: 5px;">
            <img style="width: 30px;height: 30px;text-align: center" src="<%=p.getImg_description()%>">
        </td>
        <td style="text-align: center">
            <%=p.getName()%>
        </td>

        <td style="text-align: center">
            <%=od.getQUANTITY()%>
        </td>

        <td style="text-align: center">
            <%=p.getPrice()%>
        </td>
        <td style="text-align: center">
            Total: <%=od.getQUANTITY() * p.getPrice()%>
            <%TotalOrder += od.getQUANTITY() * p.getPrice();%>
        </td>
    </tr>
    <%}%>
    Total Order : <%=TotalOrder%> $
    <%}
        }%>
</div>