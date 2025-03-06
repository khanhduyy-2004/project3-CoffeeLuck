<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản Lý CoffeeLuck</title>
    <style>
        /* Reset mặc định */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        /* Thanh menu */
        .navbar {
            background-color: #6f4e37; /* Màu nâu cà phê */
            display: flex;
            justify-content: center;
            padding: 12px 0;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        .navbar ul {
            list-style: none;
            display: flex;
            gap: 20px;
        }

        .navbar li {
            position: relative;
        }

        .navbar a {
            text-decoration: none;
            color: #fff;
            padding: 12px 20px;
            font-size: 16px;
            font-weight: bold;
            transition: all 0.3s ease-in-out;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .navbar a:hover, .navbar a.active {
            background-color: #d2691e; /* Màu cam cà phê */
            border-radius: 6px;
            transform: scale(1.05);
        }

        /* Icon */
        .navbar i {
            font-size: 18px;
        }

    </style>
    <!-- Import Font Awesome cho icon -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>

    <nav class="navbar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/"><i class="fas fa-home"></i> Trang Chu</a></li>
            <li><a href="${pageContext.request.contextPath}/danhmuc/list"><i class="fas fa-list"></i> Quan Ly Danh Muc</a></li>
            <li><a href="${pageContext.request.contextPath}/sanpham/list"><i class="fas fa-coffee"></i> Quan Ly San Pham</a></li>
            <li><a href="${pageContext.request.contextPath}/nguoidung/list"><i class="fas fa-user"></i> Quan Ly Nguoi Dung</a></li>
            <li><a href="${pageContext.request.contextPath}/donhang/list"><i class="fas fa-shopping-cart"></i> Quan Ly Don Hang</a></li>
            <li><a href="${pageContext.request.contextPath}/chitietdonhang/list"><i class="fas fa-file-invoice"></i> Chi Tiet Don Hang</a></li>
            <li><a href="${pageContext.request.contextPath}/nhanvien/list"><i class="fas fa-users"></i> Quan Ly Nhan Vien</a></li>
        </ul>
    </nav>

</body>
</html>
