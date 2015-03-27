<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Seller</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <!-- Page Specific CSS -->
        <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
        <link  href="css/table_css.css" rel="stylesheet"type="text/css">
        <script>
            function validSearch() {
                var values = document.forms["search"]["query"].value;
                if (values == "") {
                    alert("Enter Values!");
                    document.search.query.focus();
                    return false;
                } else if (values.length > 20) {
                    alert("Values Max 20 character!");
                    document.search.query.focus();
                    return false;
                } else if (values.indexOf("<") != -1 || values.indexOf("/>") != -1) {
                    alert("Values character!");
                    document.search.query.focus();
                    return false;
                }
                else {
                    return true;
                }
            }

        </script>
    </head>

    <body>

        <div id="wrapper">
            <%
                if (session.getAttribute("userName") == null) {
                    response.sendRedirect("Home");
                }
            %>
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">

                    <a class="navbar-brand" href="Seller">New Order</a>

                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li><a href="SellerTransported"><i class="fa fa-bar-chart-o"></i> Transported</a></li>
                        <li><a href="SellerSuccess"><i class="fa fa-table"></i> Success</a></li>
                        <li><a href="SellerRefused"><i class="fa fa-edit"></i> Refused</a></li>
                        <li><a href="GetOrder?values=lastWeek"><i class="fa fa-edit"></i> Week</a></li>
                        <li><a href="GetOrder?values=lastMount"><i class="fa fa-edit"></i> Mouth</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Money <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="GetOrder?values=money1-200">1-200$</a></li>
                                <li><a href="GetOrder?values=money201-500">201-500$</a></li>
                                <li><a href="GetOrder?values=money500-1000">500-1000$</a></li>
                                <li><a href="GetOrder?values=money1000-2000">1000-2000$</a></li>
                                <li><a href="GetOrder?values=money>2000">>2000$</a></li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <!--search-->

                        <li>
                            <form action="SearchOrder" name="search" method="get" onsubmit="return validSearch()">-->
                                <input style="color: black;margin-bottom: 10px" name="query" type="text" placeholder="search"/>
                                <input type="image" style="background-color: transparent;" src="images/ic_search.png"/>
                            </form>
                        </li>


                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Seller <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Logout"><i class="fa fa-power-off"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <%if (session.getAttribute("SellerShow") == null || session.getAttribute("SellerShow") == "neworder") {%>
                <jsp:include page="Component/seller/NewOrder.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "refused") {
                %><jsp:include page="Component/seller/Refused.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "success") {
                %><jsp:include page="Component/seller/Success.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "transported") {
                %><jsp:include page="Component/seller/Transported.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "details") {
                %><jsp:include page="Component/seller/Details.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "mail") {
                %><jsp:include page="Component/seller/Result.jsp"/><%}
                    if (session.getAttribute("SellerShow") == "search") {
                %><jsp:include page="Component/seller/ResultSearch.jsp"/><%}
                %>

            </div><!-- /#page-wrapper -->

        </div><!-- /#wrapper -->

        <!-- JavaScript -->
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.js"></script>

        <!-- Page Specific Plugins -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
        <script src="js/morris/chart-data-morris.js"></script>
        <script src="js/tablesorter/jquery.tablesorter.js"></script>
        <script src="js/tablesorter/tables.js"></script>

    </body>
</html>
