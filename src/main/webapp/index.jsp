<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Danh sách Người Dùng</title>
</head>
<body>
    <h2>Danh sách Người Dùng</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Họ Tên</th>
            <th>Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
