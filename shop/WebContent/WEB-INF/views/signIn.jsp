<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	${ansver}<br>
	<form action="SignIn" method="POST">
		<p>Введите логин</p>
		<input type="text" name="login" placeholder="User"><br><br>
		<p>Введите номер телефона</p>
		<input type="text" name="telNamber" placeholder="89123456789"><br><br>		
		<p>Введите пароль</p>
		<input type="password" name="pass" placeholder="Пароль"><br><br>
		<p>Введите пароль еще раз</p>
		<input type="password" name="pass2" placeholder="Пароль"><br><br>
		<input type="submit">
	</form>
	
</body>
</html>