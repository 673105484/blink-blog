<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>展示</title>
  <link rel="stylesheet" href="./public/css/bootstrap.css">
  <link rel="stylesheet" href="./public/css/markdown-github.css">
  <style>
    .panel .panel-heading .action i {
      margin-right: 10px;
    }
  </style>
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
        <ul class="nav navbar-nav navbar-right">
                 <%
          if(session.getAttribute("userName")!=null){
          %>
          <a class="btn btn-default navbar-btn" href="./topic/new.jsp">发起</a>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img width="20" height="20" src="/blog2/upload/${uif.headImg }" alt=""> <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li class="dropdown-current-user">
                当前登录用户: ${userName}
              </li>
              <li role="separator" class="divider"></li>
              <li><a href="./view/settings/profile.jsp">个人主页</a></li>
              <li><a href="./view/settings/admin.jsp">设置</a></li>
              <li><a href="./loginoutAction">退出</a></li>
            </ul>
          </li>
          <%}else {
          %>
          <a class="btn btn-primary navbar-btn" href="./view/login.jsp">登录</a>
          <a class="btn btn-success navbar-btn" href="./view/register.jsp">注册</a>
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
    <div class="row">
      <div class="col-md-9">
        <article class="markdown-body">
        <h1 id="_1"><a name="user-content-_1" href="#_1" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>测试</h1>
        <blockquote>
          <p><s:property value="contents.title"/></p>
        </blockquote>
        <h2 id="_2"><a name="user-content-_2" href="#_2" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>起步</h2>
        <ul>
          <li><s:property value="contents.content"/></li>
        </ul>
        <h3 id="_3"><a name="user-content-_3" href="#_3" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>哈哈哈</h3>
        <p>然后这里就开始 <code>hello world</code> ，就用可以了。</p>
        <p>下面是一段代码：</p>
        <pre><code class="javascript">var foo = 'bar'
    console.log(foo)
    </code></pre>
        <h3 id="_4"><a name="user-content-_4" href="#_4" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>嘿嘿</h3>
        <h3 id="_5"><a name="user-content-_5" href="#_5" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>呼呼</h3>
        <h2 id="_6"><a name="user-content-_6" href="#_6" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>是什么</h2>
        <h2 id="_7"><a name="user-content-_7" href="#_7" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>为什么</h2>
        <h2 id="_8"><a name="user-content-_8" href="#_8" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>怎么做</h2>
        <h2 id="_9"><a name="user-content-_9" href="#_9" class="headeranchor-link" aria-hidden="true"><span class="headeranchor"></span></a>哈哈哈</h2>
      </article>
      <s:iterator value="commentlist">
        <div class="panel panel-default">
          <div class="panel-heading">
            <span><s:property value="userName"/></span>
            <span><s:property value="time"/></span>
           <span><s:property value="content"/></span>
          </div>
        </div>
   </s:iterator> 
   	<%
	 int total=(int) request.getAttribute("total");
	 int index=(int) request.getAttribute("index");
	 String author=request.getParameter("author");
	 int contentid=Integer.parseInt(request.getParameter("contentid"));
	%>
   	<nav aria-label="Page navigation">
	<ul class="pagination">
		<%
			if (index > 1) {
		%>
		<li><a href="showContent?index2=<%=index - 1%>&author=<%=author%>&contentid=<%=contentid%>"
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
		<li class="active"><a href="userContents?index2=<%=index%>&author=<%=author%>&contentid=<%=contentid%>"><%=index%></a></li>
		<li><a href="showContent?index2=<%=index+1%>&author=<%=author%>&contentid=<%=contentid%>"><%=index+1%></a></li>
		<li><a href="showContent?index2=<%=index+2%>&author=<%=author%>&contentid=<%=contentid%>"><%=index+2%></a></li>
		<li><a href="showContent?index2=<%=index+3%>&author=<%=author%>&contentid=<%=contentid%>"><%=index+3%></a></li>
		<li><a href="showContent?index2=<%=index+4%>&author=<%=author%>&contentid=<%=contentid%>"><%=index+4%></a></li>
		<% 
		  }
		else{
		    for(int i=1;i<=total;i++){
		    
		%>
		<li><a href="showContent?index2=<%=i%>&author=<%=author%>&contentid=<%=contentid%>"><%=i%></a></li>
		<%
		    }
		    }
			if (index < total) {
		%>
		<li><a href="showContent?index2=<%=index + 1%>&author=<%=author%>&contentid=<%=contentid%>" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
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
	</nav>
        <hr>
        <form action="Reply?author=<s:property value="contents.author"/>&contentsid=<s:property value="contents.cid"/>" method="post">
          <div class="form-group">
            <label for="exampleInputPassword1">添加回复</label>
            <textarea class="form-control" name="comment.content"cols="10" rows="10"></textarea>
          </div>
          <button type="submit" class="btn btn-success">回复</button>
        </form>
      </div>
    </div>
  </section>
  <footer class="container">
    <p>Copyright © 2018</p>
  </footer>
  <script src="./public/js/jquery.js"></script>
  <script src="./public/js/bootstrap.js"></script>

</body>

</html>

