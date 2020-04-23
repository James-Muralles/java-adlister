<%--
  Created by IntelliJ IDEA.
  User: smurfkat
  Date: 4/22/20
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--my ads are displayed using this index. Ads are forwarded here from ShowAdsServlet and given an ads attribute
A for each is used to go through the ads and display them--%>
<html>
<head>
    <title>Ads</title>
    <%@ include file="../partials/head.jsp" %>
</head>
<body>
<%@ include file="../partials/navbar.jsp" %>
<h1>Ads</h1>
<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h3><c:out value = "${ad.title}"/></h3>
        <p><c:out value = "${ad.description}"/></p>
    </div>
</c:forEach>
</body>
</html>
