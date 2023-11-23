<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/23/2023
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add account</title>
</head>

<style>
  body {
    font-family: 'Arial', sans-serif;
    background: #f0f0f0;
    margin: 0;
    padding: 0;
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
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  h1 {
    text-align: center;
    font-size: 24px;
    margin-bottom: 20px;
    color: #333;
  }

  .form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
  }

  label {
    font-size: 14px;
    margin-bottom: 5px;
    color: #555;
  }

  input {
    padding: 10px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  button {
    padding: 10px;
    font-size: 16px;
    background-color: #3498db;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
</style>

<body>
<div class="wrapper">
  <form method="post" action="controllerServlet">
    <input type="hidden" name="action" value="addAccount" />

    <h1>Add Account</h1>
    <div class="form-group">
      <label>Account Id</label>
      <input type="text" name="accountId" />
    </div>
    <div class="form-group">
      <label>Full Name</label>
      <input type="text" name="fullName" />
    </div>
    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" />
    </div>
    <div class="form-group">
      <label>Email</label>
      <input type="email" name="email" />
    </div>
    <div class="form-group">
      <label>Phone</label>
      <input type="text" name="phone" />
    </div>
    <div class="form-group">
      <c:forEach items="${roles}" var="role">
        <div>
          <label>${role.roleName}</label>
          <input type="checkbox" value="${role.roleId}" name="roles" />
        </div>
      </c:forEach>
    </div>
    <div class="form-group">
      <button type="submit">Add Account</button>
    </div>
  </form>
</div>
</body>
</html>

