<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Products Categories</title>
  	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
		
	<h1><a href="/products/new"/>Add New Product</h1>
	<h1><a href="/categories/new"/>Add New Category</h1>
	
	<h1></h1>
	<h1>Products</h1>
	<c:forEach items="${allProducts}" var = "product">
		<h2><a href="/product/${product.id}">${product.name}</a></h2>
	</c:forEach>
	
	<h1></h1>
	<h1>Categories</h1>
	<c:forEach items="${allCategories }" var = "category">
		<h2><a href="/category/${category.id}">${category.name }</a></h2>
	</c:forEach>

</body>
</html>