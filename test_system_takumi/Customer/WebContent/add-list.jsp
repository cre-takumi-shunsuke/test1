<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報登録</title>
</head>
<body>

	<h1>顧客情報の入力</h1>
	<form action="add-list-servlet" method="POST">

		年度：<input type="text" name="nendo"><br>
		顧客コード：<input type="text" name="customer_code"><br>
		購入ポイント：<input type="text" name="buy_point"><br>
		所持ポイント	：<input type="text" name="pos_point"><br>

		<input type="submit" value="登録">

	</form>
</body>
</html>