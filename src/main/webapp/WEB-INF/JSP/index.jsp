<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.shc.blog.bean.ArticleIntroduct"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>模范青蛙的首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>css/base.css" rel="stylesheet">
<link href="<%=basePath%>css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
</head>
<body>
<%@ include file ="header.jsp"%>
<article>
  <div class="l_box f_l">
   
    <div class="topnews">
    <c:forEach items="${articleList}" var="ArticleIntroduct">
      <div class="blogs">
        <ul>
          <h3><a href="<%=basePath%>article/check/${ArticleIntroduct.articleId}">${ArticleIntroduct.title}</a></h3>
          <p>${ArticleIntroduct.note}</p>
          <p class="autor"><span class="lm f_l"><a href="/">个人博客</a></span><span class="dtime f_l">${ArticleIntroduct.faTime}</span><span class="viewnum f_r">浏览（<a href="/">${ArticleIntroduct.faEye}</a>）</span><span class="pingl f_r">喜欢（<a href="/">${ArticleIntroduct.addLikeCount}</a>）</span></p>
        </ul>
      </div>
      </c:forEach>
    </div>
  </div>
  <div class="r_box f_r">
    <div class="tit01">
      <h3>关注我</h3>
      <div class="gzwm">
        <ul>
          <li><a class="xlwb" href="#" target="_blank">QQ在线</a></li>
          <!--  <li><a class="txwb" href="#" target="_blank">公众号</a></li>-->
          <li><a class="txwb" href="#" target='_blank' onMouseOver="toolTip('<img src=<%=basePath%>images/wx1.png>')" onMouseOut="toolTip()">公众号</a></li>
          <li><a class="rss" href="portal.php?mod=rss" target="_blank">CSDN</a></li>
          <li><a class="wx" href="mailto:admin@admin.com">开源中国</a></li>
        </ul>
      </div>
    </div>
  <div class="cloud">
   <h3>程序猿众筹</h3>
   <div class="ad"> <img src="<%=basePath%>images/help.png"> </div>
   <div class="ad"> <img src="<%=basePath%>images/money.png"> </div>
   </div> 
</article>
<%@ include file ="footer.jsp"%>
</body>
<script language="javascript" src="<%=basePath%>js/ToolTip.js"></script>
</html>