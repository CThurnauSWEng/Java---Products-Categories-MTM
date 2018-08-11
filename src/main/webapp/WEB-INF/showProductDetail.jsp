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
	<h1>Product: ${product.name }</h1>
	<h1></h1>
	
	<div class="twoPer">
		<h3>Categories:</h3>
		<c:forEach items="${inCategories }" var = "category">
			<ul>
				<li>${category.name }</li>
			</ul>
		</c:forEach>
	</div>
	
	<div class="twoPer">
		<form method="POST" action="/LinkCatToProd">
			<label class="inlineLabel">Add Category</label>
			<select name="category">
				<c:forEach var="category" items="${otherCategories }">
					<option label="${category.name }" value = "${category.id }"></option>
				</c:forEach> 
			</select>
			
			<p></p>
			<input type="hidden" name="product" value="${product.id }">
			<input type="submit" value = "Add" class="linkButton"/>
		</form>
	</div>



</body>
</html>