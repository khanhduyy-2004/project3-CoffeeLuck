<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #6f4e37;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #6f4e37;
            color: white;
        }

        tr:hover {
            background-color: #f1e7d0;
        }

        .action {
            color: red;
            text-decoration: none;
            font-weight: bold;
        }

        .action:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!-- Nhúng menu -->
    <jsp:include page="/WEB-INF/views/menu.jsp" />

    <div class="container">
        <h2>Danh Sách Nhân Viên</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Họ Tên</th>
                <th>Email</th>
                <th>Chức Vụ</th>
                <th>Lương</th>
                <th>Ngày Vào Làm</th>
                <th>Hành động</th>
            </tr>
            <c:forEach var="nv" items="${listnv}">
                <tr>
                    <td>${nv.id}</td>
                    <td>${nv.hoTen}</td>
                    <td>${nv.email}</td>	
                    <td>${nv.chucVu}</td>
                    <td>${nv.luong}</td>
                    <td>${nv.ngayVaoLam}</td>
                    <td>
                        <a href="delete/${nv.id}" class="action">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
