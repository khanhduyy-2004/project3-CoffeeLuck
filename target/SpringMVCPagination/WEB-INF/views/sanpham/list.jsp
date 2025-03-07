<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
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

    <jsp:include page="/WEB-INF/views/menu.jsp" />

    <div class="container">
        <h2>Danh Sách Sản Phẩm</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>Giá</th>
                <th>Số Lượng</th>
                <th>Danh Mục</th>
                <th>Hành động</th>
            </tr>
            <c:forEach var="sp" items="${listsanpham}">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.tenSanPham}</td>
                    <td>${sp.gia}</td>	
                    <td>${sp.soLuong}</td>
                    <td>${sp.danhMuc.tenDanhMuc}</td>
                    <td>
                        <a href="delete/${sp.id}" class="action">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
