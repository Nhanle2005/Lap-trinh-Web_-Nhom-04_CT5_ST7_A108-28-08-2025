<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
<form action="login" method="post">
    <h2>Đăng nhập</h2>

    <c:if test="${alert != null}">
        <h3 style="color:red">${alert}</h3>
    </c:if>

    <label>Tài khoản:</label>
    <input type="text" name="username" placeholder="Nhập tài khoản" />

    <br><br>
    <label>Mật khẩu:</label>
    <input type="password" name="password" placeholder="Nhập mật khẩu" />

    <br><br>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>
