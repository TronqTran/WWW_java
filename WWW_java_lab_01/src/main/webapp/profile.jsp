<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/14/2023
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<style>
    body {
        background-color: #f8f9fa;
        font-family: 'Arial', sans-serif;
        margin: 0;
    }

    header {
        padding: 20px;
        background-color: #343a40;
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .wrapper {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .profile {
        width: 500px;
        background: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
    }

    .profile-row {
        display: flex;
        justify-content: space-between;
        margin-bottom: 15px;
    }

    .profile-row p {
        font-size: 16px;
        color: #555;
    }

    ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    ul li {
        font-size: 16px;
        color: #555;
    }

    button {
        padding: 10px;
        font-size: 16px;
        background-color: #dc3545;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #c82333;
    }
</style>
<body>
<header>
    <div> <p>Hi, ${account.fullName}</p></div>
    <div>
        <form method="post" action="controllerServlet">
            <input type="hidden" name="action" value="logout"/>
            <input type="hidden" name="logId" value="${log.id}"/>
            <button type="submit">Logout</button>
        </form>
    </div>
</header>

<div class="wrapper">
    <div class="profile">
        <h1>Profile</h1>
        <div class="profile-row">
            <p>Account Id</p>
            <p>${account.accountId}</p>
        </div>
        <div class="profile-row">
            <p>Full Name</p>
            <p>${account.fullName}</p>
        </div>
        <div class="profile-row">
            <p>Password</p>
            <p>${account.password}</p>
        </div>
        <div class="profile-row">
            <p>Email</p>
            <p>${account.email}</p>
        </div>
        <div class="profile-row">
            <p>Phone</p>
            <p>${account.phone}</p>
        </div>
        <div class="profile-row">
            <p>Status</p>
            <p>${account.status}</p>
        </div>
        <div class="profile-row">
            <p>Roles: </p>
            <ul>
                <c:forEach items="${account.roles}" var="role">
                    <li>${role.roleName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
