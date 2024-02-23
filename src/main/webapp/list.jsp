<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/2/2024
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
<h2>Danh sách học sinh</h2>
<p><a href="/student?action=create">Tạo mới</a></p>

<form method="post" action="/student">
    <input type="hidden" name="action" value="search">
    <input type="text" name="nameStudent">
    <button type="submit">Tìm kiếm</button>
</form>
<form method="post">
    <table border="1">
        <tr>
            <td>stt</td>
            <td>Tên</td>
            <td>email</td>
            <td>ngày sinh</td>
            <td>địa chỉ</td>
            <td>số điện thoại</td>
            <td>Lớp</td>
            <td>sửa</td>
            <td>xóa</td>

        </tr>

        <c:forEach items="${student}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.nameStudent}</td>
                <td>${student.email}</td>
                <td>${student.dateBirth}</td>
                <td>${student.address}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.classes.nameClass}</td>
                <td><a href="/student?action=edit&id=${student.getId()}">Sửa</a></td>
                <td><a href="/student?action=delete&id=${student.getId()}">Xóa</a></td>

            </tr>
        </c:forEach>
    </table>

</form>
</body>
</html>
