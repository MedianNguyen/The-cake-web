<%-- 
    Document   : About
    Created on : May 13, 2014, 6:50:24 PM
    Author     : Die4Top
--%>
<%@page import="com.thecake.model.Store"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>THE CAKE</title>
        <title><%=session.getAttribute("Title")%></title>

        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" /> 
        <link href="rateit/breakcrumb.css" rel="stylesheet" type="text/css" /> 
        <link href="rateit/rateit.css" rel="stylesheet" type="text/css" /> 
        <link  href="rateit/style.css" rel="stylesheet"type="text/css">
        <link  href="css/about.css" rel="stylesheet"type="text/css">
    </head>
    <body>
        <div style="display: none; position: absolute; z-index: 110; left: 100; top: 100; width: 15; height: 15" 
             id="preview_div"></div>
        <!--  Free CSS Templates from www.templatemo.com -->
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="Home" class="current">Home</a></li>
                    <li><a href="About.jsp">About</a></li>
                    <li><a href="StoreServlet">Contact</a></li>
                </ul>
            </div> <!-- end of menu -->
            <div id="templatemo_header">
            </div> 
            <div id="templatemo_content">
                <div id="templatemo_content_left" style="padding: 15px">
                    <jsp:include page="/Component/Categories.jsp"/>
                    <jsp:include page="/Component/LoginForm.jsp"/>
                    <div class="templatemo_content_left_section">

                        <div class="main_menu_click" style="font-size: larger;font-weight: bolder; margin-bottom:4px;">
                            <a style="text-decoration: none; text-decoration-line: none;color: #26370A;" href="ShoppingCart"> <b>Shopping cart</b><a/></div>



                        <ul>
                            <li><a class="current">Total Product: <%=session.getAttribute("productSize")%> </a></li>
                            <li style="margin-top: 10px"><a class="current">Total Money: ${money}$</a></li>
                        </ul>
                    </div>
                    <jsp:include page="/Component/BestSelling.jsp"/>                   

                </div> <!-- end of content left -->
                 <div id="templatemo_content_right">
                <div class="breadcrumb_wrapper" style="background-color: white; margin-top: 20px;"  >
                    <div class="breadcrumb flat">
                        <a href="Home" >Home</a>
                        <a class="active" href="About.jsp">About us</a>
                        <a > </a>
                    </div>
                </div>
                <h1 style="padding-top: 0px; margin-left: -10px; font-size: 36px; ">About the Cake</h1>
                <div id="ab">
                    <p id="sp">
                        Immerse yourself in the ancient space of Hanoi, you not only enjoy the poetic feeling of the old town , 
                        but also a taste of France right in the heart of the capital .
                    </p>
                    <p id="sp">
                        Located on a busy street and quaint , French pastries have long been a destination for lovers of French pastries . With a passion for quality French , French pastries brought the flavor of its " pure " to Vietnam with diners .
                    </p>
                    <p id="sp">
                        French pastry is a popular brand for those who love French food culture . Located on the " quality " of Hanoi, ancient city of , the quality of the search for cultural roots , visitors will encounter French pastries at No. 8 , Lane Station , Hanoi . Just learn about the culture of Hanoi Old Quarter , visitors can enjoy a taste of France here , with a very ancient space of Ha Thanh .
                    </p>
                    <p id="sp">
                        Further , visitors can go pedicab , enjoy the elegant Hanoi , visitors can encounter French pastries at 38 Phung Hung , other than shares of Ha Thanh definition , targeting a younger audience to help young people can enjoy and explore the ancient taste of Paris . With space is arranged tastefully with warm colors , spacious and airy French pastries at 78 Lang Ha Hoa is also a choice for customers in Hanoi ...
                    </p>
                    Anh Hoa French pastries are produced on modern lines , with the raw material is imported directly from countries with a long tradition of baking the world . Diners here can enjoy a wide variety of cakes : Birthday Cakes , Wedding Cakes , Valentine Cake , Christmas Cake ... Barkery , French Bread , Pizza , Hotdog , Patechaux , Cookies , and mooncakes ....
                    <p id="sp">
                        All these factors have created a brand anglicized French pastries 
                    </p>
                </div>
                 </div>
                <div id="templatemo_footer">
                    <a href="/EprojectTheCake/Home">Home</a> | <a href="StoreServlet">Contact Us</a><br />
                    Copyright © 2014 <a href="#"><strong>Group 3</strong></a> | <a href="http://www.iwebsitetemplate.com" target="_parent">The Cake</a> by <a href="http://www.templatemo.com" target="_parent" title="free css templates">Free Style</a>	
                </div> 
            </div>
        </div>
        <script src="rateit/jquery.rateit.min.js" language="JavaScript" type="text/javascript"></script>
        <script src="rateit/mouseover_popup.js" language="JavaScript" type="text/javascript"></script>
        <script src="rateit/prefixfree-1.0.7.js" type="text/javascript" type="text/javascript"></script>
        <script src="rateit/jquery-1.8.2.js" type="text/javascript" type="text/javascript"></script>
        <script src="rateit/jquery-ui-1.10.4.js" type="text/javascript" type="text/javascript"></script>
    </body>
</html>
