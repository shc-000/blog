<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String hpath = request.getContextPath();
String hbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+hpath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=hbasePath%>/image/shc.ico" media="screen" />
<link href="<%=hbasePath%>css/header.css" rel="stylesheet">
<script type="text/javascript" src="<%=hbasePath%>js/jquery-1.4.4.min.js"></script>
<script>
//js部分
$(document).ready(function(){
    $(".top_li").click(function(){
    	 var typeId = $(this).attr("value");
    	 var url = "<%=hbasePath%>article/showType/"+typeId;
    	 alert(url);
    	 alert(typeId);
    	 $.ajax({
    		  url: url,
    		  type: "GET"
    	 });
    });
});
</script>
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
			<ul class="top_ul"><!-- 将这几个li的链接统一 -->
				<li class="top_li" value="0">首页</li>
				<li class="top_li" value="1">Java技术</li>
				<li class="top_li" value="2">数据库</li>
				<li class="top_li" value="3">Linux</li>
				<li class="top_li" value="4">服务器</li>
			</ul>
	</div>
</body>
</html>