<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Create or Update Item</title>
</head>
<body>

	<div class="container">
		<form action="items" method="post">

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Name</label> <input type="text"
						class="form-control" id="inputEmail4" name="name"
						placeholder="Enter item name">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Description</label> <input type="text"
						class="form-control" id="inputPassword4" name="description"
						placeholder="Enter item description">
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Price</label> <input type="number"
						class="form-control" id="inputEmail4" name="price"
						placeholder="Enter item price">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Quantity</label> <input type="number"
						class="form-control" id="inputPassword4" name="quantity"
						placeholder="Enter item quanitity">
				</div>
			</div>
			<div class="form-group">
				<label for="inputAddress">Image URL</label> <input type="text"
					class="form-control" id="inputAddress" name="imageUrl"
					placeholder="Enter item image URL">
			</div>
			<input type="submit" class="btn btn-block btn-primary" value="Create Item" />
		</form>
	</div>
</body>
</html>