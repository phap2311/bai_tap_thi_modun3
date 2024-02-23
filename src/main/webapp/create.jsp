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
    <title>Title</title>
</head>
<body>
<form action="/student?action=create" method="post">
    <table>
        <tr>
            <td>Tên</td>
            <td><input type="text" name="nameStudent"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Ngày sinh</td>
            <td><input type="text" name="dateBirth"></td>
        </tr>
        <tr>
            <td>Địa chỉ</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Số điện thoại</td>
            <td><input type="text" name="phoneNumber"></td>
        </tr>

            <td>
                <select id="idClass" name="idClass">
                    <c:forEach items="${classes}" var="c">
                        <option value="${c.idClass}">${c.nameClass}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
