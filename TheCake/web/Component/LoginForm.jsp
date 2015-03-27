<%-- 
    Document   : LoginForm
    Created on : Apr 30, 2014, 2:59:02 PM
    Author     : Link Larkin
--%>
<%@page import="com.thecake.model.User"%>
<script>
    function valiLoginForm() {
        var user = document.forms["form_login"]["userName"].value;
        var pw = document.forms["form_login"]["passWord"].value;
        if (user == "") {
            alert("Enter UserName!");
            document.form_login.userName.focus();
            return false;
        } else if (user.length > 20) {
            alert("Invalid values Name Max 20 character!");
            document.form_login.userName.focus();
            return false;
        } else if (pw = "") {
            alert("Enter PassWord!");
            document.form_login.passWord.focus();
            return false;
        } else if (pw.length > 20) {
            alert("Invalid values Pass Max 20 character!");
            document.form_login.passWord.focus();
            return false;
        } else {
            return  true;
        }
    }

</script>
<div class="main_menu" style="font-size: larger;font-weight: bolder; margin-bottom:4px;">
    <b>Login</b></div>
<form action="LoginServlet" method="post" name="form_login" onsubmit="return valiLoginForm()">
    <div id="LoginForm" class="templatemo_content_left_section">
        Username: <input name="userName" type="text"/>
        Password: <input name="passWord" type="password"/>
        <input type="submit" value="Login"/>
        <%if (session.getAttribute("vali_login") != null) {%>
        <p style="color: red"><%=session.getAttribute("vali_login")%></p>
        <%}%>

    </div>
</form>