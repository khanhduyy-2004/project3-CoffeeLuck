<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh Sửa Người Dùng</title>
</head>
<body>
    <h2>Chỉnh Sửa Người Dùng</h2>
    <form action="../update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <table>
            <tr>
                <td>Họ Tên:</td>
                <td><input type="text" name="name" value="${user.name}" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${user.email}" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Cập Nhật</button>
                    <a href="/">Hủy</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
