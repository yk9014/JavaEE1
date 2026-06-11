<%@ page pageEncoding="UTF-8"
	 contentType="text/html;charset=UTF-8" %>
<html>
<head><title>HitAndBlow</title></head>
<body>
	<h1>HitAndBlow</h1>
	<form method='post' action='HitAndBlowServlet'>
        あなたの予想は？<input type='text' name='playerinput'><br>
        <input type='submit' value='登録'>
	</form>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>↓表示エリア</h1>

<c:forEach var="out" items="${map}" >
	<c:forEach var="array" items="${out}" >

</c:forEach>
</c:forEach>

<% 
    if(session.getAttribute("outputMessage")!=null){
%>
<%= session.getAttribute("outputMessage") %>
<%
    }
%>








</body>



</html>
