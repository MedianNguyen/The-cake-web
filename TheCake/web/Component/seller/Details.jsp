<%-- 
    Document   : Request
    Created on : May 11, 2014, 1:13:49 AM
    Author     : Du
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.SellerOrder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    ArrayList<SellerOrder> listSellerOrder = (ArrayList) session.getAttribute("list");
    if (listSellerOrder == null) {
        response.sendRedirect("Seller");
    }
%>

<!DOCTYPE html>
<div style="margin-left: 10px;margin-top: 8%">
    <p style="font-size: 20px">Name :<%=session.getAttribute("name")%></p>
    </br>
    <p>Address:<%=session.getAttribute("address")%></p>
    </br>
    <p>Mobile:<%=session.getAttribute("phone")%></p>
    </br>
    <p>Email:<%=session.getAttribute("email")%></p>
    </br>
    <p>Total Money:$<%=session.getAttribute("money")%></p>
    </br>
    </br>

</div>
<div>
    <table style="margin-bottom: 20px" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Images</th>
            <th>Product Name</th>
            <th>Quantity</th>
        </tr>


        <%for (SellerOrder o : listSellerOrder) {%>
        <tr>
            <td><%=o.getProduct().getId()%></td>
            <td><img style="width: 40px;height: 40px" src="<%=o.getProduct().getImg_description()%>"/></td>
            <td><%=o.getProduct().getName()%></td>
            <td><%=o.getQuantity()%></td>
        </tr>
        <%}%>

    </table>
    <div class="center">
        <form action="EmailSend" method="post" name="email">
            <input hidden="true" name="id" value="${id}"/>
            <input hidden="true" name="email" value="${email}"/>
            <select name="status">
                <option value="0">New Order</option>
                <option value="1">Being Transported</option>
                <option value="2">Success</option>
                <option value="3">Refused</option>
            </select>
            <input style="margin-bottom: 50px" type="submit" value="Processing Orders"/>
        </form>
    </div>
</div>

