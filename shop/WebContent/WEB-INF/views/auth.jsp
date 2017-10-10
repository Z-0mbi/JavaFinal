<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Auth" method="POST">
		<p>Введите логин</p>
		<input type="text" name="login" placeholder="User"><br><br>				
		<p>Введите пароль</p>
		<input type="password" name="pass" placeholder="Пароль"><br><br>
		<input type="submit">
	</form>
</body>
</html>