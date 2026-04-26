<%@ page pageEncoding="UTF-8"
	 contentType="text/html;charset=UTF-8" %>
<html>
<head><title>セッション情報の表示</title></head>
<body>
	<h1>セッション情報</h1>
	登録されたユーザー名：${sessionScope.name}<br>
	登録されたパスワード：${sessionScope.pass}
	コンテキストのパラメータ：${sessionScope.param}
	
</body>
</html>
