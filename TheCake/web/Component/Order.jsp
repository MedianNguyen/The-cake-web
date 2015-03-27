<%-- 
    Document   : Order
    Created on : May 1, 2014, 11:36:33 AM
    Author     : Link Larkin
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.thecake.model.CartItem"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<%
    ArrayList<CartItem> list = (ArrayList) session.getAttribute("listCart");
    if (list == null) {
        response.sendRedirect("Home");
    }
%>
<div class="breadcrumb_wrapper" style="background-color: white"  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>
        <a class="active" href="ShoppingCart">Shopping cart</a>
        <a > </a>    
    </div>
</div>

<div  style="padding-bottom: 20px">   
    <table style="width: 100%;margin-top: 10px; border: 1px solid #ffffff;">
        <tr style="background: #1c94c4">
            <th style="height: 30px;border-right: 1px solid #ffffff">Images</th>
            <th style="border-right: 1px solid #ffffff">Name</th>
            <th>Quantity</th>
            <th>Control</th>
            <th style="border-right: 1px solid #ffffff">Price</th>
            <th style="border-right: 1px solid #ffffff" width="100px">Total</th>
        </tr>
        <%for (CartItem p : list) {%>
        <tr style="border: 1px solid #ffffff">
            <td style="text-align: center;padding: 5px;">
                <img style="width: 30px;height: 30px;text-align: center" src="<%=p.getP().getImg_description()%>">
            </td>
            <td style="text-align: center">
                <%=p.getP().getName()%>
            </td>

        <form name="form" action="UpdateCart" method="post" onsubmit="return validQuantity();">

            <td style="text-align: center">
                <input  type="text" value="<%=p.getQuantity()%>" name="quantity" size="5" />
                </br>

            </td>
            <td style="text-align: center">
                <input name="id" hidden="" type="text" value="<%=p.getP().getId()%>"/>
                <input type="submit" name="update" value="Update"/>
                <input type="submit" value="Remove" name="remove"/>
            </td>
        </form>
        <td style="text-align: center">
            <%=p.getP().getPrice()%>$
        </td>
        <td style="text-align: center">

            <%=p.getTotal()%>$
        </td>
        </tr>
        <%}%>
    </table>
</form>
<p></p>
<div class="total_money" style="float: right; margin-bottom: 10px; font-size: 20px;">
    <b>Total Money: $<%=session.getAttribute("money")%> </b></div>
</div> 

<div class="breadcrumb_wrapper" style="background-color: white;"  >
    <div class="breadcrumb flat">
        <a href="Home" >Home</a>
        <a  href="ShoppingCart">Shopping cart</a>
        <a class="active"> Order information </a>   
        <a></a>
    </div>
</div>

<div style="margin-top: 20px" id="form_oder">

    <form class="basic-grey" action="Order" method="post" name="formOder" onSubmit="return validOrder();">
        <h1 id="h1">Order Form
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>Your Name :</span>
            <input type="text" name="name" placeholder="Your Full Name" />
        </label>

        <label>
            <span>Your Address :</span>
            <input type="text" name="address" placeholder="Address which the cakes will be sent to." />
            <span hidden="true"><input type="text" name="total_money" value="<%=session.getAttribute("money")%>" /></span>
        </label>
        <label>
            <span>Your phone number :</span>
            <input type="text" name="mobile" placeholder="Your mobile number so we can call you to deliver." />
        </label>

        <label>
            <span>Your Email :</span>
            <input type="email" name="email" placeholder="Valid Email Address" />
        </label>
        <label>
            <div style="float: left">

                <span>Delivery date  :</span>
                <input id="date" type="text" name="date" placeholder="The date you need your cake" style="width: 25%;" />

                <select style="width: 60px" name="hour">
                    <option value="8AM">hour</option>
                    <option value="8AM">8 AM</option>
                    <option value="9AM">9 AM</option>
                    <option value="10AM">10 AM</option>
                    <option value="11AM">11 AM</option>
                    <option value="12AM">12 AM</option>
                    <option value="1PM">1 PM</option>
                    <option value="2PM">2 PM</option>
                    <option value="3PM">3 PM</option>
                    <option value="4PM">4 PM</option>
                    <option value="5PM">5 PM</option>
                    <option value="6Pm">6 PM</option>
                    <option value="7PM">7 PM</option>
                    <option value="8PM">8 PM</option>
                    <option value="9PM">9 PM</option>
                </select>

                <select style="width: 60px" name="minuted">
                    <option value="00">Minuted</option>
                    <option value="00">00</option>
                    <option value="15">15</option>
                    <option value="30">30</option>
                    <option value="45">45</option>
                </select>
            </div>
        </label>
        <label>
            <span>Message :</span>
            <textarea id="message" name="message" placeholder="Your Message to Us"></textarea>
        </label>          
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="Order" />
        </label>
    </form>
</div>

<script>
    function validQuantity() {
        var quantity = document.forms["form"]["quantity"].value;
        var checkQuantity = isNaN(document.form.quantity.value);
        if (quantity == "") {
            alert("Invalid values Quantity");
            document.form.quantity.focus();
            return false;
        } else if (checkQuantity == true) {
            alert("Invalid values Quantity");
            document.form.quantity.focus();
            return false;
        } else if (quantity < 0) {
            alert("Invalid values Quantity");
            document.form.quantity.focus();
            return false;
        }
        else if (quantity == 0) {
            alert("Invalid values Quantity");
            document.form.quantity.focus();
            return false;
        } else if (quantity > 50) {
            alert("Invalid values Quantity");
            document.form.quantity.focus();
            return false;
        } else if (quantity.indexOf("<") != -1 || quantity.indexOf("/>") != -1) {
            alert("Invalid values Name contain character!")
            document.form.quantity.focus();
            return  false;
        } else {
            return true;
        }
    }
    function validOrder() {
        var name = document.forms["formOder"]["name"].value;
        var currentdate = new Date(); 
        var date = document.forms["formOder"]["date"].value;
        var address = document.forms["formOder"]["address"].value;
        var mobile = document.forms["formOder"]["mobile"].value;
        var email = document.forms["formOder"]["email"].value;
        var date_ac=currentdate.getYear()+"/"+currentdate.getMonth()+"/"+currentdate.getDay();
        
        
        if (name == "") {
            alert("Enter Name!")
            document.formOder.name.focus();
            return false;
        } else if (name.length > 20) {
            alert("Invalid values Name!")
            document.formOder.name.focus();
            return  false;
        } else if (name.indexOf("<") != -1 || name.indexOf("/>") != -1) {
            alert("Invalid values Name contain character!")
            document.formOder.name.focus();
            return  false;
        } else if (address == "") {
            alert("Enter Address!")
            document.formOder.address.focus();
            return false;
        } else if (address.length > 200) {
            alert("Invalid values Address")
            document.formOder.address.focus();
            return false;
        } else if (address.indexOf("<") != -1 || address.indexOf("/>") != -1) {
            alert("Invalid values Address contain character!")
            document.formOder.name.focus();
            return  false;
        } else if (mobile == "") {
            alert("Enter Mobile!")
            document.formOder.mobile.focus();
            return false;
        } else if (isNaN(mobile) == true) {
            alert("Invalid values Mobile!")
            document.formOder.mobile.focus();
            return false;
        } else if (mobile.length > 15) {
            alert("Invalid values Mobile!")
            document.formOder.mobile.focus();
            return false;
        } else if (email == "") {
            alert("Enter Email!")
            document.formOder.email.focus();
            return false;
        } else if (email.length > 50) {
            alert("Invalid values Email!")
            document.formOder.email.focus();
            return false;
        } else if (email.indexOf("<") != -1 || email.indexOf("/>") != -1) {
            alert("Invalid values email contain character!")
            document.formOder.name.focus();
            return  false;
        } else if (date == "") {
            alert("Enter Date!")
            return  false;
        }else {
            return true;
        }
    }


</script>
<script>
    $(function() {
        $("#date").datepicker();
    });
</script>