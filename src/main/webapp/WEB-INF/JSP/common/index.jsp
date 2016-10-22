<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.shc.blog.bean.ArticleIntroduct"%>
<%@ include file ="../common/commonBasePath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>模范青蛙的首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>css/base.css" rel="stylesheet">
<link href="<%=basePath%>css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(function(){
	//用于页面跳转时判断文本框输入的信息是否符合相应的格式
	$("#pageNo").change(function(){
		var val = $(this).val();
		val = $.trim(val);
		//1. 校验 val 是否为数字 1, 2, 而不是 a12, b
		var flag = false;
		var reg = /^\d+$/g;
		var pageNo = 0;
		if(reg.test(val)){
			//2. 校验 val 在一个合法的范围内： 1-totalPageNumber
			pageNo = parseInt(val);
			if(pageNo >= 1 && pageNo <= parseInt("${articleList.totalPageNumber }")){
				flag = true;
			}
		}
		if(!flag){
			alert("输入的不是合法的页码.");
			$(this).val("");
			return;
		}
		//3.页面跳转
		var href = "<%=basePath%>article/show?pageNo=" + pageNo;
		window.location.href = href;
	});
});
</script>
</head>
<body>
<%@ include file ="header.jsp"%>
<article>
  <div class="l_box f_l">
    <div class="topnews">
    <c:forEach items="${articleList.list}" var="ArticleIntroduct">
      <div class="blogs">
        <ul>
          <h3><a href="<%=basePath%>article/check/${ArticleIntroduct.articleId}">${ArticleIntroduct.title}</a></h3>
          <p>${ArticleIntroduct.note}</p>
          <p class="autor"><span class="lm f_l"><a href="/">个人博客</a></span><span class="dtime f_l">${ArticleIntroduct.faTime}</span><span class="viewnum f_r">浏览（<a href="/">${ArticleIntroduct.faEye}</a>）</span><span class="pingl f_r">喜欢（<a href="/">${ArticleIntroduct.addLikeCount}</a>）</span></p>
        </ul>
      </div>
      </c:forEach>
    </div>
    <center>
		共 ${articleList.totalPageNumber } 页
		&nbsp;&nbsp;
		当前第 ${articleList.pageNo } 页		
		&nbsp;&nbsp;
		<c:if test="${articleList.hasPrev }">
			<a href="<%=basePath%>article/show?pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a href="<%=basePath%>article/show?pageNo=${articleList.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;
		<c:if test="${articleList.hasNext }">
			<a href="<%=basePath%>article/show?pageNo=${articleList.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a href="<%=basePath%>article/show?pageNo=${articleList.totalPageNumber }">末页</a>
		</c:if>
		&nbsp;&nbsp;
		转到 <input type="text" size="1" id="pageNo"/> 页		
	<br><br>
	</center>
  </div>
  <div class="r_box f_r">
    <div class="tit01">
      <h3>关注我</h3>
      <div class="gzwm">
        <ul>
          <li><a class="xlwb" href="#" target="_blank" onMouseOver="toolTip('<img src=<%=basePath%>images/QQ1.png>')" onMouseOut="toolTip()">QQ群</a></li>
          <li><a class="txwb" href="#" target='_blank' onMouseOver="toolTip('<img src=<%=basePath%>images/wx1.png>')" onMouseOut="toolTip()">公众号</a></li>
          <li><a class="rss" href="#" target="_blank" onMouseOver="toolTip('<img src=<%=basePath%>images/csdn1.png>')" onMouseOut="toolTip()">CSDN</a></li>
          <li><a class="wx" href="#" target="_blank" onMouseOver="toolTip('<img src=<%=basePath%>images/oc1.png>')" onMouseOut="toolTip()">开源中国</a></li>
        </ul>
      </div>
    </div>
  <div class="cloud">
   <h3>程序猿众筹</h3>
   <div class="ad"> <img src="<%=basePath%>images/help.png"> </div>
   <div class="ad"> <img src="<%=basePath%>images/money.png"> </div>
   </div>
   </div> 
</article>

<%@ include file ="footer.jsp"%>
</body>
<script language="javascript" src="<%=basePath%>js/ToolTip.js"></script>
</html>