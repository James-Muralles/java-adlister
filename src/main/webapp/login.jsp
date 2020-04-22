<%--
  Created by IntelliJ IDEA.
  User: smurfkat
  Date: 4/21/20
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<html>
<head>
<body>
<h3>Login Form</h3>
<form action="login.jsp" method="post">
    Username:<input type="text" id="username" name="username"/><br/><br/>
    Password:<input type="password" id="password" name="password"/><br/><br/>
    <input type="submit" name="button" value="login"/>

</form>
<%
    String profileHTML = "http://localhost:8080/profile.jsp";
    String loginHTML = "http://localhost:8080/login.jsp";
    if(request.getParameter("button") != null) {
        if (request.getParameter("password").equals("password") && request.getParameter("username").equals("admin")) {
            response.sendRedirect(profileHTML);
        }
        else{
            response.sendRedirect(loginHTML);
        }
    }
%>
</body>
</head>
</html>


