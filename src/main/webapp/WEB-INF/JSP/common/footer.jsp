<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String fpath = request.getContextPath();
String fbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+fpath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=fbasePath%>css/base.css" rel="stylesheet">
</head>
<body>
<footer>
  <p class="ft-copyright">模范青蛙的博客&nbsp;&nbsp;&nbsp;京ICP备16047055号</p>
</footer>
</body>
</html>