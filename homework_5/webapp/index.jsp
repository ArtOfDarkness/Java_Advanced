<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Інтернет магазин журналів</title>
</head>

<body>
    <jsp:include page="header.jsp"></jsp:include>

    <h1>Вітаємо в інтернет магазині журналів!</h1>

    <form>
        <button type="button" onClick="location.href='register.jsp'">Зареєструватись</button>
        <button type="button" onClick="location.href='login.jsp'">Увійти</button><br>
    </form>

    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
