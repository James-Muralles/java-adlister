<%--
  Created by IntelliJ IDEA.
  User: smurfkat
  Date: 4/22/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="Product show page"/>
  </jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<div class="container"></div>

<h1>Current product: ${product.title}</h1>

<p>Price: $${product.priceInCents/100}</p>

<h3>${product.description}</h3>

</body>
</html>
