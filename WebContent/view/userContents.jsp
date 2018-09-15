<%@page import="com.ljn.blog.po.Contents"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<title>多人博客 - 首页</title>
<link rel="stylesheet" href="./public/css/bootstrap.css">
<link
	href="https://cdn.bootcss.com/bootstrap/2.3.1/css/bootstrap-responsive.css"
	rel="stylesheet">
</head>

<body>

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
			<a class="navbar-brand" href="./view/index.jsp"> <img width="90px"
				src="./public/img/logo3.png" alt="">
			</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<%
					if (session.getAttribute("userName") != null) {
				%>
				<a class="btn btn-default navbar-btn" href="./view/topic/new.jsp">发起</a>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><img width="20" height="20"
						src="./upload/${uif.headImg }" alt=""> <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-current-user">当前登录用户: ${userName}</li>
						<li role="separator" class="divider"></li>
						<li><a href="./view/settings/profile.jsp">个人主页</a></li>
						<li><a href="./view/settings/admin.jsp">设置</a></li>
						<li><a href="./loginoutAction">退出</a></li>
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
	<ul class="media-list">
	 <s:iterator value="conlist">
		<li class="media">
			<div class="media-left">
				<a href="#"> <img width="40" height="40" class="media-object"
					src="./upload/${uif.headImg }" alt="...">
				</a>
			</div> 


        <div class="media-body">
					<h4 class="media-heading">
						<s:property value="title" />
						<a href="./showContent?contentid=<s:property value="cid"/>&author=<s:property value="author"/>">查看详细内容</a>
					</h4>
					<p>
						<s:property value="replies" />
						个回复
					</p>
					<p>
						<s:property value="views" />
						次浏览
					</p>
					<p>
						<s:property value="created" />
					</p>
					<p>
					<a href="./view/topic/update.jsp?contentid=<s:property value="cid"/>&title=<s:property value="title"/>&content=<s:property value="content"/>">更新</a>
					
			        <a href="./deleteContent?contentid=<s:property value="cid"/>">删除</a>
					</p>
				</div>
			  
		</li>
		</s:iterator> 
	</ul>
	<%
	 int total=(int) request.getAttribute("total");
	 int index=(int) request.getAttribute("index");
	%>
	<nav aria-label="Page navigation">
	<ul class="pagination">
		<%
			if (index > 1) {
		%>
		<li><a href="userContents?index2=<%=index - 1%>"
			aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>
		<%
			} else {
		%>
		<li><a href="javascript:;" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%
			}
		%>
		<% 
		  if(total>=5){
		%>
		<li class="active"><a href="userContents?index2=<%=index%>"><%=index%></a></li>
		<li><a href="userContents?index2=<%=index+1%>"><%=index+1%></a></li>
		<li><a href="userContents?index2=<%=index+2%>"><%=index+2%></a></li>
		<li><a href="userContents?index2=<%=index+3%>"><%=index+3%></a></li>
		<li><a href="userContents?index2=<%=index+4%>"><%=index+4%></a></li>
		<% 
		  }
		else{
		    for(int i=1;i<=total;i++){
		    
		%>
		<li><a href="userContents?index2=<%=i%>"><%=i%></a></li>
		<%
		    }
		    }
			if (index < total) {
		%>
		<li><a href="userContents?index2=<%=index + 1%>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a>
		</li>
		<%
			} else {
		%>
		<li><a href="javascript:;" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a>
		</li>
		<%
			}
		%>
		第<%=index%>页 &nbsp 共<%=total%>页
	</ul>
	</nav> </section>
	<footer class="container">
	<p>Copyright © 2018</p>
	</footer>
	<script src="./public/js/jquery.js"></script>
	<script src="./public/js/bootstrap.js"></script>
</body>

</html>