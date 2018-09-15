<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <a href="./index.html">
        <img src="../public/img/logo3.png" alt="">
      </a>
      <h1>用户注册</h1>
    </div>

    <form id="register_form" method="post" action="../registerAction">
      <div class="form-group">
        <label for="email">邮箱</label><span class="text-danger sp1">1</span>
        <input type="email" class="form-control" id="user.email" name="user.email" placeholder="Email" autofocus>
      </div>
      <div class="form-group">
        <label for="nickname">昵称</label><span class="text-danger sp2">2</span>
        <input type="text" class="form-control" id="user.userName" name="user.userName" placeholder="Nickname">
      </div>
      <div class="form-group">
        <label for="password">密码</label><span class="text-danger sp3">3</span>
        <input type="password" class="form-control" id="user.password" name="user.password" placeholder="Password">
      </div>
       <div class="form-group">
        <label for="password">重复密码</label><span class="text-danger sp3">3</span>
       <input type="password" class="form-control" id="user.repassword" name="user.repassword" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-success btn-block">注册</button>
    </form>
    <div class="message">
      <p>已有账号? <a href="./login.jsp">点击登录</a>.</p>
    </div>
  </div>
  <script src="../public/js/jquery.js"></script>

</body>

</html>