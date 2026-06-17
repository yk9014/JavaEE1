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

<h1>↓表示エリア</h1>

<%--メッセージは毎回全部出し--%>
<% 
    if(session.getAttribute("outputMessage")!=null){
%>
<%= session.getAttribute("outputMessage") %>
<%
    }
%>








</body>



</html>
