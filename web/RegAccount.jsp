<%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2018-12-31
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "">
<html>
<head>
    <title> Registration Form</title>
</head>
<body>
<h1>Register account</h1>
<form action="Web.MVC.Controller.Servlet.ServletReg" method="GET">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Mail</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Contact No</td>
            <td><input type="text" name="contact" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</html>