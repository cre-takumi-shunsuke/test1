<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.CustomerBean,java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧</title>
</head>
<body>

	<%
		List<CustomerBean> customerList = (List<CustomerBean>) request.getAttribute("customerList");

		if (customerList.size() != 0) {
	%>
	<h3>ユーザ一覧</h3>

	<table>
		<tr>
			<th>顧客ID</th>
			<th>年度</th>
			<th>顧客コード</th>
			<th>購入ポイント</th>
			<th>所持ポイント</th>
		</tr>
	<%
			for (CustomerBean user : customerList) {
	%>
		<tr>
			<td><%=user.getCustomerId()%></td>

			<td><%=user.getCustomer_code()%></td>

			<td><%=user.getNendo()%></td>

			<td><%=user.getBuy_point()%></td>

			<td><%=user.getUserId()%></td>
		</tr>

	<%
			}
	%>
		</table>
	<%
		} else {
	%>
	ユーザー情報がありません。<br>
	<%
		}
	%>
	
</body>
</html>