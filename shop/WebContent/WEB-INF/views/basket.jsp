<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Корзина покупок</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h1>Ваша корзина покупок</h1>
	<table width="50%" height="100%" border="1">
		<tr>
			<th>Номер</th>
			<th>Наименование</th>
			<th>Стоимость</th>		
		</tr>
		<c:forEach items="${basket}" varStatus="num" var="b" >
			
			<tr>
				<td>${num.count}</td>
				<td>${b.title}</td>
				<td>${b.price}</td>				
			</tr>	
		</c:forEach>
	</table>
	<a href="catalog">Перейти в каталог</a>
</body>
</html>