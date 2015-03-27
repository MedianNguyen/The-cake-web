<%-- 
    Document   : HomeContent
    Created on : May 1, 2014, 9:57:57 AM
    Author     : Link Larkin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Product"%>
<%
    ArrayList<Product> listProductNews = (ArrayList) session.getAttribute("listProductNew");
    ArrayList<Product> listFeatured = (ArrayList) session.getAttribute("listFeatrued");
    if(listFeatured==null||listProductNews==null){
        response.sendRedirect("Home");
    }
%>
<div id="title_content_productnews" style="margin-top: 20px;">
    <div class="breadcrumb_wrapper" style="background: white" >
        <div class="breadcrumb flat">
            <a href="Featured" class="active" >Featured Cakes</a>
            <a></a>            
        </div>
    </div>
    <!--    <div style="float: left; "><h1>Featured</h1></div>
        <div style="float: right;padding-top: 10px;margin-right:10px;"><a href="Featured" >See More</a></div>-->
</div>

<div >
    <%for (Product p : listFeatured) {%>
    <div class="cake_box" style="float: left;padding: 10px"  >
        <div><a href="Cake?id=<%=p.getId()%>" >
                <img style="width: 140px;height: 160px"  src="<%=p.getImg_description()%>" 
                     onmouseover="showtrail('<%=p.getImg_description()%>', '<%=p.getName()%>', 433, 550)" 
                     onmouseout="hidetrail()">
            </a></div>
        <div><a href="Cake?id=<%=p.getId()%>" style="font-size: medium"><%=p.getName()%></a></div>
        <div class="cake_box_bottom">
            <div style="margin-bottom: 5px;margin-top: 10px">
                Price: <span style="color: #FFFF00">$<%=p.getPrice()%></span></div>
            <div style="float: left;">
                <a href="ShoppingCart?id=<%=p.getId()%>"><img style="float: left; width: 60px;height:25px" src="images/bynow.png"/></a>
                <a href="Cake?id=<%=p.getId()%>"><img  style="float: left; margin-left: 20px; width: 60px;height:25px" src="images/details.png"  /> </a>
            </div>
        </div>
    </div>
    <%}%>
</div>
<div class="cleaner"></div>

<div id="title_content_productnews" style="margin-top:40px;">
    <div class="breadcrumb_wrapper" style="background: white" >
        <div class="breadcrumb flat">
            <a href="NewProduct" class="active" >Newest Cakes</a>
            <a></a>            
        </div>
    </div>
<!--    <div style="float: left;"><h1>Product News</h1></div>
    <div style="float: right; padding-top: 10px;margin-right:10px;"><a href="NewProduct">See More</a></div>-->
</div>

<div  style="padding-top: 20px">
    <%for (Product p : listProductNews) {%>
    <div  class="cake_box" style="float: left;padding: 10px">
        <div><a href="Cake?id=<%=p.getId()%>" >
                <img class="thumbnail" style="width: 140px;height: 160px"  src="<%=p.getImg_description()%>"
                     onmouseover="showtrail('<%=p.getImg_description()%>', '<%=p.getName()%>', 433, 650)" 
                     onmouseout="hidetrail()"    />
            </a></div>
        <div><a href="Cake?id=<%=p.getId()%>" style="font-size: medium"> <%=p.getName()%></a></div>
        
        <div class="cake_box_bottom">
            <div style="margin-bottom: 5px;margin-top: 15px">
                Price: <span style="color: #FFFF00">$<%=p.getPrice()%></span></div>
            <div style="float: left">
                <a href="ShoppingCart?id=<%=p.getId()%>"><img style="width: 60px;height:25px" src="images/bynow.png"/></a>
                <a href="Cake?id=<%=p.getId()%>"><img  style="width: 60px;height:25px" src="images/details.png"/> </a>
            </div>
        </div>
    </div>
    <% }%>
</div>
<div class="cleaner"></div>
