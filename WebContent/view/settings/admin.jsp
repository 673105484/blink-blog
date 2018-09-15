<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>admin</title>
  <link rel="stylesheet" href="../../public/css/bootstrap.css">
</head>

<body>
  <nav class="navbar navbar-default">
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="../index.jsp">
          <img width="90px" src="../../public/img/logo3.png" alt="">
        </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <form class="navbar-form navbar-left">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
               <%
          if(session.getAttribute("userName")!=null){
          %>
          <a class="btn btn-default navbar-btn" href="./topic/new.jsp">发起</a>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img width="20" height="20" src="../../upload/${uif.headImg }" alt=""> <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li class="dropdown-current-user">
                当前登录用户: ${userName}
              </li>
              <li role="separator" class="divider"></li>
              <li><a href="./profile.jsp">个人主页</a></li>
              <li><a href="./settings/admin.jsp">设置</a></li>
              <li><a href="../../loginoutAction">退出</a></li>
            </ul>
          </li>
          <%}else {
          %>
          <a class="btn btn-primary navbar-btn" href="./login.jsp">登录</a>
          <a class="btn btn-success navbar-btn" href="./register.jsp">注册</a>
         <%
          } 
         %>
        </ul>
      </div>
      <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
  </nav>
  <section class="container">
    <div class="col-md-3 list-group">
      <a href="#" class="list-group-item disabled">用户设置</a>
      <a href="./profile.jsp" class="list-group-item active">基本信息</a>
      <a href="./admin.jsp" class="list-group-item">账户设置</a>
    </div>
    
    <div class="col-md-5">
      <div class="subhead">
        <h2>修改密码</h2>
      </div>
      <hr>
      <form action="../../updatePassword" method="post">
        <div class="form-group">
          <label for="exampleInputPassword1">当前密码</label>
          <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">新的密码</label>                             
          <input type="password" class="form-control" id="exampleInputPassword1" name="updatepassword1" placeholder="">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">确认密码</label>
          <input type="password" class="form-control" id="exampleInputPassword1" name="updatepassword2" placeholder="">
        </div>
        <button type="submit" class="btn btn-success">保存</button>
      </form>
      <div class="subhead">
        <h2>注销账号</h2>
        <hr>
      </div>
      <div>
        <p>一旦注销，不可找回，请谨慎操作</p>
        <button class="btn btn-danger">删除</button>
      </div>
      <hr>
    </div>
  </section>
  <footer class="container">
    <p>Copyright © 2018</p>
  </footer>
  
  <script src="../../public/js/jquery.js"></script>
  <script src="../../public/js/bootstrap.js"></script>

</body>

</html>

