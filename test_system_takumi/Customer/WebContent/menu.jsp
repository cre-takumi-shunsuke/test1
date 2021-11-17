<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
<form action="add-list.jsp" method="POST">
		<input type="submit" value="新規">
	</form>
	<form action="customer-list-servlet" method="post">
		<input type="submit" value="一覧表示">
	</form>

</body>
</html>