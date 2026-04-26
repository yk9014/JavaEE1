<%@ page pageEncoding="UTF-8"
	 contentType="text/html;charset=UTF-8" %>
<html>
<head><title>アクセスカウンタの表示</title></head>
<body>
	<h1>カウンタ</h1>
	<%--式言語で簡単に参照できる--%>
	現在のアクセス数：${applicationScope.counter}
</body>
</html>
