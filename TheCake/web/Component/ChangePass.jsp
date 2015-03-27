<%-- 
    Document   : ChangePass
    Created on : May 2, 2014, 1:29:33 PM
    Author     : Link Larkin
--%>

<form action="UserServlet" method="post">
    <div class="title_content">
        <h1>Change password</h1>
    </div>
    <div>
        Your current password: <input type="password" name="currentPass"/></br>
        Your new password: <input type="password" name="newPass"/></br>
        Confirm new password: <input type="password" name="confirmPass"/></br>
        <input type="submit" name="changePass" value="submit"/>
        <%if(session.getAttribute("message")!=null){%>
            <%=session.getAttribute("message")%>
        <%}%>
    </div>
</form>
