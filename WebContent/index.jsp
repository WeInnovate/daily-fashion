<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dailyfashion.service.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<div class="container">

<a href="create-or-update-item.jsp">Create Item</a>
		<%
			request.setAttribute("items", new ItemServiceImpl().getItems());
		%>
		<div class="card-deck">
<c:forEach var="item" items="${requestScope.items}">
  <div class="card">
    <img class="card-img-top" width="150" height="240" src="${pageContext.request.contextPath}/${item.imageUrl}" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">${item.name}</h5>
      <p class="card-text">${item.description}</p>
      <p class="card-text">${item.price} <a class="btn btn-success" href="#">Buy Now</a></p>
      <p class="card-text"><small class="text-muted"><i>Click here for exciting offers.</i></small></p>
    </div>
  </div>
  </c:forEach>
</div>


</div>

</body>
</html>