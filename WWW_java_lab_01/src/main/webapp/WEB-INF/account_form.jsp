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
    <title>Add account</title>
</head>
<style>
  *, *::after, *::before{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }

  body{
    height: 100vh;
    position: relative;
    background: orangered;
  }

  .wrapper{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  form{
    background-color: white;
    padding: 20px;
    width: 600px;
  }

  h1{
    text-align: center;
    font-size: 18px;
  }

  .form-group{
    display: flex;
    flex-direction: column;
    gap: 5px;
  }

  .form-group:not(:last-child){
    margin-bottom: 10px;
  }

  input{
    padding: 5px;
  }

  button{
    padding: 5px;
  }
</style>
<body>
<div class="wrapper">
  <form method="post" action="controllerServlet">
    <input type="hidden" name="action" value="addAccount"/>

    <h1>Add account</h1>
    <div class="form-group">
      <label>Account Id</label>
      <input type="text" name="accountId"/>
    </div>
    <div class="form-group">
      <label>Full Name</label>
      <input type="text" name="fullName"/>
    </div>
    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password"/>
    </div>
    <div class="form-group">
      <label>Email</label>
      <input type="email" name="email"/>
    </div>
    <div class="form-group">
      <label>Phone</label>
      <input type="text" name="phone"/>
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
      <button type="submit">Add account</button>
    </div>
  </form>
</div>
</body>
</html>
