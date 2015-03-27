<%-- 
    Document   : CakeDetail
    Created on : May 1, 2014, 9:23:58 PM
    Author     : Link Larkin
--%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thecake.model.Product"%>

<%
    Product cake = (Product) session.getAttribute("cake");
    String cateName = (String) session.getAttribute("cateName");
    ArrayList <Product> sameCategory = (ArrayList) session.getAttribute("same");
%>

<div class="breadcrumb_wrapper"  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>
        <a href="Product?id=<%=cake.getId_category()%>&page=1"><%=cateName%></a>
        <a class="active" href="Cake?id=<%=cake.getId()%>"><%=cake.getName()%> information</a>    
    </div>
</div>


    <div class="cake_details" >
    <div class="cake_info">
        <div class="cake_image" >
            <img onmouseover="showtrail('<%=cake.getImg_description()%>', '<%=cake.getName()%>', 433, 650)" 
                 onmouseout="hidetrail()"
                 style="width: 200px;height: 270px"  
                 src="<%=cake.getImg_description()%>"
                 />       
        </div>
        <div class="cake_des" >        
            Price: 
            <h3 style="color: #FFFF00"> $
                <%=cake.getPrice()%> </h3>       
            Description: </br>
            <h4 style="color: #FFFF00; font-size: 14px;"><%=cake.getDescription()%> </h4>
        </div>
         <div class="cake_share">
            <span class='st_facebook_hcount' displayText='Facebook'></span>
            <span class='st_twitter_hcount' displayText='Tweet'></span>
            <span class='st_googleplus_hcount' displayText='Google +'></span>
            <span class='st__hcount' displayText=''></span>
            <span class='st__hcount' displayText=''></span>
        </div>
    </div>
    <div class="rate_buy_it">
        <div class="cake_name" > <%=cake.getName()%> </div>
        <div class="rate_button">
            <span id="hover"></span>
            <span id="value"></span>
            <div id="ratecake" class="rateit bigstars" 
                 data-rateit-starwidth="32" data-rateit-starheight="32" 
                 data-rateit-resetable="false" 
                 data-rateit-readonly="false" data-rateit-step="1" 
                 >
            </div>
        </div>      

        <div class="cake_buy">
            <a href="ShoppingCart?id=${cake.getId()}" > <img style="width: 80px;height:35px" src="images/bynow.png"/></a>
        </div>
    </div>
</div>

       
<div  style="background-color:white; height: 32px;margin-top: 20px; "  >
    <div class="breadcrumb flat">        
        <a class="active" href="Product?id=<%=cake.getId_category()%>&page=1" >Other <%=cateName%>s </a>
        <a></a>         
    </div>
</div>
<div style="">
    <%for (Product p : sameCategory) {%>
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
  

<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "b256fcfc-3033-4675-b2a3-69fe42812f36", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>