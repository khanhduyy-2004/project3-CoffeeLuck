<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Danh sách User</title>
</head>
<body>
    <h2>Danh sách User</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>
                    <a href="editemp/${user.id}">Edit</a> |
                    <a href="deleteemp/${user.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
