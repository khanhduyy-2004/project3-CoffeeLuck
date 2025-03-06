<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Chỉnh sửa Nhân viên</title>
</head>
<body>
    <h2>Chỉnh sửa Nhân viên</h2>
    <form:form action="${pageContext.request.contextPath}/nhanvien/update" method="post" modelAttribute="nhanVien">
        <input type="hidden" name="id" value="${nhanVien.id}" />
        <label>Tên:</label>
        <form:input path="ten" />
        <br/>
        <label>Tuổi:</label>
        <form:input path="tuoi" />
        <br/>
        <label>Chức vụ:</label>
        <form:input path="chucVu" />
        <br/>
        <input type="submit" value="Cập nhật" />
    </form:form>
</body>
</html>
