<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parameter Map</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>parameter Map</h1>
<c:forEach var="out" items="${map}" >
	<c:forEach var="array" items="${out}" >

</c:forEach>
</c:forEach>



</body>
</html>