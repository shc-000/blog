<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="common/commonBasePath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章编辑</title>
<link rel="stylesheet" href="<%=basePath%>css/ui.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=basePath%>css/common.css" type="text/css" media="screen"/>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/zh-cn.js"></script>
</head>
<body>
<center>
<form method="post" action="<%=basePath%>article/add">
	<h3>欢迎</h3>
	1,xheditor(编辑):<br/>
	<textarea id="elm1" name="articleContent" class="xheditor" rows="60" cols="120" style="width: 80%">
	来了
	</textarea><br /><br />
	<br/><br />
	<input type="submit" name="save" value="Submit" />
	<input type="reset" name="reset" value="Reset" />
</form>
</center>
</body>
</html>