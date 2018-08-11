<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Products Categories</title>
  	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
	<h1>Category: ${category.name }</h1>
	<h1></h1>

	<div class="twoPer">
		<h3>Products:</h3>
		<c:forEach items="${curProducts }" var = "product">
			<ul>
				<li>${product.name }
			</ul>
		</c:forEach>
	</div>
	
	<div class="twoPer">
		<form method="POST" action="/LinkProdToCat">
			<label class="inlineLabel">Add Product</label>
			<select name="product">
				<c:forEach var="product" items="${otherProducts }">
					<option label="${product.name }" value="${product.id }"></option>
				</c:forEach>
			</select>
			
			<p></p>
			<input type="hidden" name="category" value="${category.id }">
			<input type="submit" value="Add" class="linkButton"/>
		</form>
	</div>

</body>
</html>