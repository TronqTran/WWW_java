<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/23/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Dashboard</title>
</head>
<style>
    body {
        background-color: #f5f5f5;
        font-family: 'Arial', sans-serif;
        margin: 0;
    }

    header {
        background-color: #ffffff;
        padding: 20px;
        display: flex;
        justify-content: space-between;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    header p {
        margin: 0;
        font-size: 18px;
        color: #333333;
    }

    nav {
        display: flex;
    }

    nav a {
        text-decoration: none;
        color: #3498db;
        font-weight: bold;
        margin-right: 20px;
        transition: color 0.3s;
    }

    nav a:hover {
        color: #217dbb;
    }

    button {
        padding: 10px;
        font-size: 16px;
        background-color: #e74c3c;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    button:hover {
        background-color: #c0392b;
    }

    .accounts {
        background-color: #ffffff;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .error-message {
        color: #e74c3c;
        text-align: center;
    }

    table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
    }

    th, td {
        padding: 15px;
        text-align: left;
    }

    th {
        background-color: #3498db;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #ecf0f1;
    }

    tr:hover {
        background-color: #d4e6f1;
    }

    /* Update and Delete buttons */
    div form {
        display: inline-block;
        margin-right: 5px;
    }

    div form button {
        width: auto;
        padding: 8px;
        font-size: 14px;
    }
</style>
<body>
<header>
    <div> <p>Hi, ${account.fullName}</p></div>
    <div>
        <a href="${pageContext.request.contextPath}/controllerServlet?action=showAddAccount">Add account</a>
        <span>&nbsp;</span>
        <span>&nbsp;</span>
        <span>&nbsp;</span>
        <span>&nbsp;</span>
        <a href="${pageContext.request.contextPath}/controllerServlet?action=showAddRole">Add role</a>
    </div>
    <div>
        <form method="post" action="controllerServlet">
            <input type="hidden" name="action" value="logout"/>
            <input type="hidden" name="logId" value="${log.id}"/>
            <button type="submit">Logout</button>
        </form>
    </div>
</header>

<div class="accounts">
    <p>${error}</p>
    <table border="1">
        <tr>
            <th>Account Id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Roles</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${accounts}" var="account">
            <tr>
                <td>${account.accountId}</td>
                <td>${account.fullName}</td>
                <td>${account.email}</td>
                <td>${account.phone}</td>
                <td>${account.status}</td>
                <td>
                    <c:forEach items="${account.roles}" var="role">
                        <span>${role.roleName}</span>
                        <br/>
                    </c:forEach>
                </td>
                <td>
                    <div>
                        <form method="get" action="controllerServlet">
                            <input type="hidden" name="action" value="showUpdateAccount"/>
                            <input type="hidden" name="accountId" value="${account.accountId}"/>
                            <input type="submit" value="Update"/>
                        </form>
                    </div>

                    <div>
                        <form method="post" action="controllerServlet">
                            <input type="hidden" name="action" value="deleteUser"/>
                            <input type="hidden" name="accountId" value="${account.accountId}"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

