<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>All Items</title>
</head>
<body>

	<div class="container">

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="row">ID</th>
					<th>NAME</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${requestScope.items}">
					<tr>
						<th scope="row">${item.id}</th>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.price}</td>
						<td>${item.quantity}</td>
						<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/items/delete/${item.id}">Delete</a> / <a class="btn btn-info" href="${pageContext.request.contextPath}/items/update/${item.id}">Update</a></td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan="6"><a href="${pageContext.request.contextPath}/create-or-update-item.jsp" class="btn btn-block btn-primary">Add New Item</a></td>
				</tr>
			</tbody>
		</table>








	</div>
</body>
</html>