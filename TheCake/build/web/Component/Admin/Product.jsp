<%-- 
    Document   : Product
    Created on : May 13, 2014, 10:24:08 PM
    Author     : Link Larkin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Product"%>
<%
        ArrayList<Product> list = (ArrayList) session.getAttribute("product");
%>

<form action="/EprojectTheCake/AdminAction" method="post">
    <div>
        <a href="/EprojectTheCake/ProductAction?action=add">Add new</a>
        <table>
            <tr>
                <th>Image</th>
                <th>Name</th>
                <th>ID</th>
                <th>Egg</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <tr>
                <th></th>
                <th><input type="text" name="Name"></th>
                <th><input type="text" name="ID"></th>
                <th><input type="text" name="Egg"></th>
                <th><input type="text" name="Price1" style="width: 50px"/> < price < <input type="text" name="Price2" style="width: 50px"/></th>
                <th><input type="submit" name="submit" value="Filter"></th>
            </tr>
            <%for (Product p : list) {%>
            <tr>
                <th><img src="../../<%=p.getImg_description()%>" style="height: 40px;width: 40px"/></th>
                <th><%=p.getName()%></th>
                <th><%=p.getId()%></th>
                <th><%=p.getEgg()%></th>
                <th><%=p.getPrice()%></th>
                <th><a href="/EprojectTheCake/ProductAction?ID=<%=p.getId()%>">Edit</a></th>
            </tr>
            <%}%>
        </table>
    </div>
</form>