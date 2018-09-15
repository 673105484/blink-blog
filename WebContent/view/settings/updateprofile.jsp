<%@page import="com.ljn.blog.po.UserInformation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<title>个人简档案</title>
<link rel="stylesheet" href="../../public/css/bootstrap.css">
</head>

<body>
		<%    
		   UserInformation uif=(UserInformation)session.getAttribute("uif"); 
		%>
	<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.jsp"> <img width="90px"
				src="../../public/img/logo3.png" alt="">
			</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<%
					if (session.getAttribute("userName") != null) {
				%>
				<a class="btn btn-default navbar-btn" href="./topic/new.jsp">发起</a>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><img width="20" height="20"
						src="../../upload/${uif.headImg }" alt=""> <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-current-user">当前登录用户: ${userName}</li>
						<li role="separator" class="divider"></li>
						<li><a href="./profile.jsp">个人主页</a></li>
						<li><a href="./admin.jsp">设置</a></li>
						<li><a href="../../loginoutAction">退出</a></li>
					</ul></li>
				<%
					} else {
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
	<!-- /.container-fluid --> </nav>
	<section class="container">
	<div class="col-md-3 list-group">
		<a href="#" class="list-group-item disabled">用户设置</a> <a
			href="./profile.jsp" class="list-group-item active">基本信息</a> <a
			href="./admin.jsp" class="list-group-item">账户设置</a>
	</div>
	<div class="col-md-5">

			<div class="form-group">
				<label for="exampleInputEmail1">账号</label>
				<p class="form-control-static">${userName}</p>
			</div>
			

			<form action="../../updateUserInformation" method="post">
			<div class="form-group">
				<label for="exampleInputPassword1">昵称</label> 
				<input type="text" class="form-control" id="exampleInputPassword1"  name="uif.nname" value="<%=uif.getNname() %>">
					
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">介绍</label>    
				<textarea class="form-control" rows="3" name="uif.introduction"><%=uif.getIntroduction() %></textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">性别</label>
				<div>
					<label class="radio-inline"> <input type="radio"
						name="uif.sex" id="inlineRadio1" value="男"> 男
					</label> <label class="radio-inline"> <input type="radio"
						name="uif.sex" id="inlineRadio2" value="女"> 女
					</label> <label class="radio-inline"> <input type="radio"
						name="uif.sex" id="inlineRadio3" value="保密"> 保密
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">生日</label> <input type="text"
					class="form-control" name="uif.birthday" id="exampleInputPassword1" value="<%=uif.getBirthday()%>">
			</div>
			<input type="hidden" name="uif.uid" value="${uid}">
			<button type="submit" class="btn btn-success">保存</button>
		</form>
	</div>
	<div class="col-md-2 profile-avatar">
		<dl>
			<dt>头像设置</dt>
			<dd>
				<img class="avatar" width="150" height="150" src="../../upload/<%=uif.getHeadImg()%>" alt="">
				<div>
					<form action="../../fileUpload" method="post"
						enctype="multipart/form-data">
						<table>
							<tr>
							
								<td><input type="file" name="headImg" /></td>
								<td><input type="submit" value="提交"></td>
							</tr>
						</table>
					</form>
				</div>
			</dd>
		</dl>
	</div>
	</section>
	<footer class="container">
	<p>Copyright © 2018</p>
	</footer>

	<script src="../../public/js/jquery.js"></script>
	<script src="../../public/js/bootstrap.js"></script>
</body>

</html>





