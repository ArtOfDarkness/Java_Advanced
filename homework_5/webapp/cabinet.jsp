<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Особистий кабінет користувача</title>
</head>

<body>
    <h1>${userFirstName} ${userLastName}, Ви успішно ${userAction} в интернет магазині!</h1>
    <a href="${pageContext.request.contextPath}/index.jsp">На головну</a>
</body>

</html>
