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
    <title>Add role</title>
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
        <input type="hidden" name="action" value="addRole"/>

        <h1>Add role</h1>
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
            <button type="submit">Add role</button>
        </div>
    </form>
</div>
</body>
</html>
