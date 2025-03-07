<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý cửa hàng CoffeeLuck</title>
    <style>
        /* Reset styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        body {
            background-color: #f4e1c6;
            color: #4b2e1e;
            line-height: 1.8;
        }

        /* Header */
        .header {
            background: #6f4e37;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            font-size: 24px;
            font-weight: bold;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Content */
        .content {
            max-width: 900px;
            margin: 30px auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        /* Button */
        .btn {
            display: inline-block;
            background: #d2691e;
            color: white;
            padding: 12px 18px;
            margin-top: 15px;
            border-radius: 6px;
            font-weight: bold;
            text-decoration: none;
            transition: 0.3s;
        }
        .btn:hover {
            background: #8b4513;
            transform: scale(1.05);
        }

        /* Footer */
        .footer {
            background: #6f4e37;
            color: #fff;
            text-align: center;
            padding: 15px 0;
            font-size: 14px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="header">
        ☕ Chào mừng đến Quản lý cửa hàng CoffeeLuck ☕
    </div>
    
    <div class="content">
        <p>Quản lý nhân viên, đơn hàng và sản phẩm dễ dàng!</p>
        <a href="menu" class="btn">➡ Đến Menu Chức Năng</a>
    </div>
    
    <div class="footer">
        &copy; 2025 CoffeeLuck. Được phát triển với niềm đam mê cà phê! ☕❤️
    </div>
</body>
</html>
