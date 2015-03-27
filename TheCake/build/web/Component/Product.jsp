<%-- 
    Document   : Product
    Created on : May 1, 2014, 9:09:43 PM
    Author     : Link Larkin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Product"%>
<%
    ArrayList<Product> listProduct = (ArrayList) session.getAttribute("listProduct");
    ArrayList<Integer> listPage = (ArrayList) session.getAttribute("record");
    ArrayList<Integer> id_category = (ArrayList) session.getAttribute("idCategory");
    if(listProduct==null){
        response.sendRedirect("Home");
    }

%>


<div class="breadcrumb_wrapper" style="background-color: white; "  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>
        <a class="active" href="Product?id=${idCategory}&page=1"><%=session.getAttribute("title")%></a>
        <a class="active" style="background-color: #9EEB62 "> </a>    
    </div>
    <div style="float:right;padding-right: 10px; ">
        <ul style="display: inline; ">
            <%  for (Integer i : listPage) {%>            
            <li style="display: inline; line-height: 32px; height: 32px" >
                <a  href="Product?id=${idCategory}&page=<%=i + 1%>" style="font-size: medium; color: black; "><%=i + 1%></a>
            </li>
            <%}%>
        </ul>
    </div>    
</div>
<div style="">
    <%for (Product p : listProduct) {%>
    <div class="cake_box" style="float: left;padding: 10px">
        <div><a href="Cake?id=<%=p.getId()%>">
                <img style="width: 140px;height: 160px"  src="<%=p.getImg_description()%>"
                     onmouseover="showtrail('<%=p.getImg_description()%>', '<%=p.getName()%>', 433, 650)" 
                     onmouseout="hidetrail()">
            </a>
        </div>
        <div><a style="font-size: medium" href=Cake?id=<%=p.getId()%>" ><%=p.getName()%></a></div>
        <div class="cake_box_bottom">
            <div style="margin-bottom: 5px;margin-top: 5px">
                Price: <span style="color: #FFFF00">$<%=p.getPrice()%> </span></div>
            <div style="float: left">
                <a href="ShoppingCart?id=<%=p.getId()%>"><img style="width: 60px;height:25px" src="images/bynow.png"/></a>
                <a href="Cake?id=<%=p.getId()%>"><img  style="width: 60px;height:25px" src="images/details.png"/> </a>
            </div>
        </div>
    </div>
    <%}%>
</div> 
<div class="cleaner"></div>
<div class="breadcrumb_wrapper" style="background-color: white;"   >
    <div class="breadcrumb flat">
        <a  href="Home" >Home</a>           
        <a  > </a>    
    </div>
    <div style="float:right;padding-right: 10px; ">
        <ul style="display: inline; ">
            <%
                for (Integer i : listPage) {%>


            <li style="display: inline; line-height: 32px; height: 32px" >
                <a  href="Product?id=${idCategory}&page=<%=i + 1%>" style="font-size: medium; color: black; "><%=i + 1%></a>
            </li>


            <%}%>
        </ul>
    </div>    
</div>
