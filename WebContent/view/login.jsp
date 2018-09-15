<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="../public/css/bootstrap.css">
  <link rel="stylesheet" href="../public/css/login.css">
</head>

<body>
  <div class="main">
    <div class="header">
      <a href="./index.jsp">
        <img src="../public/img/logo3.png" alt="">
      </a>
      <h1>用户登录</h1>
    </div>
    <form id="login_form" action="../loginAction" method="post">
      <div class="form-group">
        <label for="">用户名</label>
        <input type="text" class="form-control" id="" name="user.userName" placeholder="username" autofocus>
      </div>
      <div class="form-group">
        <label for="">密码</label>
        <a class="pull-right" href="">忘记密码？</a>
        <input type="password" class="form-control" id="" name="user.password" placeholder="Password">
      </div>
      <div class="checkbox">
        <label>
           <span>${message}</span>
          
        </label>

      </div>
      <button type="submit" class="btn btn-success btn-block">登录</button>
    </form>
    <div class="message">
      <p>没有账号? <a href="./register.jsp">点击创建</a>.</p>
    </div>
  </div>
  <script src="../public/js/jquery.js"></script>
</html>