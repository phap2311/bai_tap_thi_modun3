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
<form action="/student" method="post">
    <input type="hidden" name="action" value="edit">
    <table>
        <tr>
            <td></td>
            <td><input type="text" name="" readonly value="${}"></td>
        </tr>
        <tr>
            <td>  </td>
            <td><input type="text" name=""  value="${}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" name="" value="${}"></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="text" name="" value="${}"></td>
        </tr>

        <tr>
            <td> </td>
            <td><select id="idClass" name="idClass">
                <c:forEach items="${}" var="">
                    <option value="${}">${}</option>
                </c:forEach>
            </select>
            </td>

        </tr>
        <tr>

            <td><button type="submit"></button></td>
        </tr>
    </table>
</form>
</body>
</html>
