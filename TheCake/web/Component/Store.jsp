<%-- 
    Document   : Store
    Created on : May 1, 2014, 10:16:38 AM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.Store"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Store> list = (ArrayList) session.getAttribute("listStore");
    if (list == null) {
        response.sendRedirect("Home");
    }
%>

<div id="templatemo_content_right">
    <div class="breadcrumb_wrapper" style="background-color: white"  >
        <div class="breadcrumb flat">
            <a href="Home" >Home</a>
            <a class="active" href="StoreServlet">Contact us</a>
            <a > </a>
        </div>
 </div>
    <table>
        <%for (Store i : list) {%>
        <tr style="border: solid #660066 1px">
            <td>
                <img style="padding: 10px" src="<%=i.getImage()%>">
            </td>
            <td>
                <a style="font-size: large;padding-bottom: 20px"><%=i.getName()%></a>
                </br>
                </br>
                <a style="color: #269abc;font-size: medium;padding-bottom: 10px">Address: <%=i.getAddress()%></a>
                </br>
                </br>
                <a style="color: #9EEB62;font-size: medium;padding-bottom: 10px">Phone: <%=i.getPhone()%></a>
            </td>
        </tr>
        <%}%>
    </table>   
</div> 
