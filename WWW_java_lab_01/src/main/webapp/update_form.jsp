<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/14/2023
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Account</title>
</head>
<style>
    body {
        background-color: #f5f5f5;
        font-family: 'Arial', sans-serif;
        margin: 0;
    }

    .wrapper {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        padding: 30px;
        width: 600px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
    }

    .form-group {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    label {
        font-size: 16px;
        color: #555;
    }

    input {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        padding: 10px;
        font-size: 18px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

    input[type="checkbox"] {
        margin-top: 5px;
    }
</style>
<body>
<div class="wrapper">
    <form method="post" action="controllerServlet">
        <input type="hidden" name="action" value="updateAccount"/>

        <input type="hidden" name="logId" value="${logId}"/>
        <h1>Update Account</h1>
        <div class="form-group">
            <label>Account Id</label>
            <input type="text" name="accountId" value="${account.accountId}"/>
        </div>
        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="fullName" value="${account.fullName}"/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" value="${account.password}"/>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" value="${account.email}"/>
        </div>
        <div class="form-group">
            <label>Phone</label>
            <input type="text" name="phone" value="${account.phone}"/>
        </div>
        <div class="form-group">
            <c:forEach items="${roles}" var="role">
                <div>
                    <label>${role.roleName}</label>
                    <input type="checkbox" value="${role.roleId}" name="roles"/>
                </div>
            </c:forEach>
        </div>
        <div class="form-group">
            <button type="submit">Update Account</button>
        </div>
    </form>
</div>
</body>
</html>
