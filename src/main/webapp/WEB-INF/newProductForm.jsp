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

	<div class="navbar">
		<a href="/">Home</a>
	</div>

	<h1>New Product</h1>
	
	<form:form action="/processNewProduct" modelAttribute="product">
	
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <span>______________</span>
	    <form:input path="name"/></form:label>
            
	    <form:label path="description">Description
	    <form:errors path="description"/>
	    <span>__________</span>
	    <form:input path="description"/></form:label>
            
	    <form:label path="price">Price
	    <form:errors path="price"/>
	    <span>_______________</span>
	    <form:input path="price"/></form:label>
            
		<input type="submit" value="Create"/>
		
	</form:form>
</body>
</html>