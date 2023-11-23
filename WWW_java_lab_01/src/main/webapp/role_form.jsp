<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/14/2023
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Role</title>
</head>
<style>
    body {
        background-color: #f8f9fa;
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
        background-color: #fff;
        padding: 30px;
        width: 500px;
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
</style>
<body>
<div class="wrapper">
    <form method="post" action="controllerServlet">
        <input type="hidden" name="action" value="addRole"/>

        <h1>Add Role</h1>
        <div class="form-group">
            <label>Role Id</label>
            <input type="text" name="roleId"/>
        </div>
        <div class="form-group">
            <label>Role Name</label>
            <input type="text" name="roleName"/>
        </div>
        <div class="form-group">
            <label>Description</label>
            <input type="text" name="description"/>
        </div>
        <div class="form-group">
            <button type="submit">Add Role</button>
        </div>
    </form>
</div>
</body>
</html>

