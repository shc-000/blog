<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String hpath = request.getContextPath();
String hbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=hbasePath%>css/header.css" rel="stylesheet">
<script type="text/javascript" src="<%=hbasePath%>js/jquery-1.4.4.min.js"></script>
</head>
<body>
<div class="top">
			<div class="top_1">
					<div class="top_logo">
						<img  src="<%=hbasePath%>images/wa.png"/>
					</div>
					<div class="top_txt">
						<font>走别人没走过的路，让别人有路可走</font>
					</div>
			</div>
			<ul class="top_ul">
				<a class="top_li" ><li>
					首页
				</li></a>
				<a><li>Java技术</li></a>
				<a><li>数据库</li></a>
				<a><li>Linux</li></a>
				<a><li>服务器</li></a>
			</ul>
	</div>
</body>
</html>