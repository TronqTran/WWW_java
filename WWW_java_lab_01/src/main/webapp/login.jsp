<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/14/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<style>
    body {
        background-color: #f4f4f4;
        font-family: Arial, sans-serif;
    }

    .wrapper {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    form {
        background: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        font-size: 24px;
        color: #333;
    }

    .form-group {
        margin-bottom: 20px;
    }

    label {
        display: block;
        font-size: 16px;
        color: #555;
        margin-bottom: 5px;
    }

    input {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        width: 100%;
        padding: 10px;
        font-size: 18px;
        background-color: #3498db;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #2980b9;
    }

    .error-message {
        color: #e74c3c;
        text-align: center;
    }
</style>
<body>
<div class="wrapper">
    <form method="post" action="controllerServlet">
        <input type="hidden" name="action" value="login"/>
        <h1>Login</h1>
        <div class="form-group">
            <label>Email: </label>
            <input type="email" name="email" required/>
        </div>
        <div class="form-group">
            <label>Password: </label>
            <input type="password" name="password" required/>
        </div>
        <div class="form-group">
            <button type="submit">Login</button>
        </div>
        <div class="form-group">
            <p class="error-message">${error}</p>
        </div>
    </form>
</div>
</body>
</html>
