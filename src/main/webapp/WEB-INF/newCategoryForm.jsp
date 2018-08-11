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

	<h1>New Category</h1>
	
	<form:form action="/processNewCategory" modelAttribute="category">
	
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <span>______________</span>
	    <form:input path="name"/></form:label>
            
		<input type="submit" value="Create"/>
		
	</form:form>
</body>
</html>