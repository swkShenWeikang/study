<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		<table border="1" align="center">
			<caption>用户登录</caption>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>