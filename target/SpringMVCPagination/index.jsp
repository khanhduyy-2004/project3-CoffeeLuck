<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý CoffeeLuck</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f8f9fa;
            text-align: center;
        }
        h2 {
            color: #6c4f3d;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #6c4f3d;
            color: white;
        }
        a {
            text-decoration: none;
            color: #6c4f3d;
            font-weight: bold;
        }
        .btn {
            padding: 8px 15px;
            background: #6c4f3d;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background: #563d2d;
        }
    </style>
</head>
<body>
    <h2>Danh Sách Nhân Viên CoffeeLuck</h2>
    <a href="viewform" class="btn">Thêm Nhân Viên</a>
    <table>
        <tr><th>ID</th><th>Họ Tên</th><th>Email</th><th>Chức Vụ</th><th>Hành Động</th></tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td>
                    <a href="edit/${user.id}" class="btn">Sửa</a>
                    <a href="delete/${user.id}" class="btn" style="background: red;">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
