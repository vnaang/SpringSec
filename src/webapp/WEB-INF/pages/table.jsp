<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>User Manager</h2>
    <h3>
        <a href="${pageContext.request.contextPath}/new">New User</a>
    </h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${users}" >
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.city}</td>
                <td>${user.age}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${user.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>