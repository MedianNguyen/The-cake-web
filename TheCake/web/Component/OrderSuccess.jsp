<%-- 
    Document   : OrderSuccess
    Created on : May 10, 2014, 7:08:04 PM
    Author     : Du
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.CartItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<CartItem> list = (ArrayList) session.getAttribute("listCart");

%>
<!DOCTYPE html>
<div class="breadcrumb_wrapper" style="background-color: white; margin-bottom: 15px;"  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>s
        <a class="active" >Your order information</a>
        <a > </a>    
    </div>
</div>
<div style="font-size: 14px; margin-bottom: 15px;" >
<p style="font-size: 18px; color: #269abc"> Your cakes will be delivered to:</p>
<p>Mr/Ms: <span style="color: #1c94c4">  ${name} </span></p> 
</br>

<p>Address: ${address}</p>

<p>At address: <span style="color: #1c94c4">${address}</span></p>

</br>
<p> With mobile number is:<span style="color: #1c94c4"> ${mobile}</span></p>
</br>
<p>And the email address:<span style="color: #1c94c4"> ${email}</span></p>
</div>
<p style="font-size: 18px; color: #269abc"> The cakes you ordered:</p>
<div>
<table style="width: 100%;margin-top: 10px;border: 1px solid #ffffff;">
    <tr>
            <th style="height: 30px;border-right: 1px solid #ffffff;border-bottom: 1px solid #ffffff">Images</th>
            <th style="border-right: 1px solid #ffffff;border-bottom: 1px solid #ffffff">Name</th>
            <th style="border-right: 1px solid #ffffff;border-bottom: 1px solid #ffffff">Quantity</th>
            <th style="border-right: 1px solid #ffffff;border-bottom: 1px solid #ffffff">Price</th>
            <th style="border-bottom: 1px solid #ffffff">Total</th>
        </tr>
        <%for (CartItem p : list) {%>
        <tr style="border: 1px solid #ffffff">
            <td style="text-align: center;padding: 5px;">
                <img style="width: 30px;height: 30px;text-align: center" src="<%=p.getP().getImg_description()%>">
            </td>
            <td style="text-align: center">
                <%=p.getP().getName()%>
            </td>
        
            <td style="text-align: center">
                <%=p.getQuantity()%>
            </td>
            <td style="text-align: center">
                <%=p.getP().getPrice()%>$
            </td>
        <td style="text-align: center">
            
            <%=p.getTotal()%>$
        </td>
        </tr>
        <%}%>
    </table>
</br>
<a style="float: right; margin-top: 20px">Total Money: <%=session.getAttribute("money")%>$</a>
</br>
<p style="font-size: 18px; color: #269abc">orders will be sent to you in the shortest time</p>
</br>

</div> 

<div class="breadcrumb_wrapper" style="background-color: white; margin-top: 15px;"  >
    <div class="breadcrumb flat">
        <a href="Home" >Continue shopping</a>
        <a class="active" href="Home">Thank you for your truth! We will not betray it! Click to buy more!</a>
        <a > </a>    
    </div>
</div>