<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Каталог товаров</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<a href="SignIn">Регистрация</a>
	<a href="Auth">Войти</a>
	<table width="50%" height="100%" border="1">
		<tr>
			<th>Номер</th>
			<th>Наименование</th>
			<th>Стоимость</th>
			<th>Действие</th>
		</tr>
		<c:forEach items="${goods}" varStatus="num" var="good" >
			
			<tr>
				<td>${num.count}</td>
				<td>${good.title}</td>
				<td>${good.price}</td>				
				<td><a href="catalog?id_good=${good.id}">Добавить в корзину</a></td>
			</tr>	
		</c:forEach>
	</table>
	<a href="Basket">Перейти в корзину</a>
</body>
</html>