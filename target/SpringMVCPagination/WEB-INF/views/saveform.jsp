<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Người Dùng</title>
</head>
<body>
    <h2>Thêm Người Dùng Mới</h2>
    <form action="save" method="post">
        <table>
            <tr>
                <td>Họ Tên:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Lưu</button>
                    <a href="/">Hủy</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
