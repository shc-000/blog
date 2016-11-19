<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.shc.blog.bean.Article"%>
<%@ include file ="common/commonBasePath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章鉴赏</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>css/base.css" rel="stylesheet">
<link href="<%=basePath%>css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/zh-cn.js"></script>
<script type="text/javascript">
	$(function(){
		$(".reward").mouseover(function () {
			$(".pay").fadeOut("fast");
			$(".z").fadeIn(1000);
            $(".w").fadeIn(1500); 
        });
        $(".reward").mouseleave(function () {
        	$(".w").fadeOut(1000);
        	$(".z").fadeOut(1000);
        	$(".pay").fadeIn(1500);
        });
	});
</script>
</head>
<body>
<%@ include file ="common/header.jsp"%>
<article>
  <div class="l_box f_l">
    <div class="topnews">
    	${article.articleContent}
    </div>
    <div class="reward">
    	<center>
    		<img alt="支付宝" class="z" style="display:none;" src="<%=basePath%>images/alipay.jpg">
	    	<img alt="打赏" class="pay" src="<%=basePath%>images/reward.png">
	    	<img alt="微信" class="w" style="display:none;" src="<%=basePath%>images/weixin.png">
    	</center>
    </div>
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
  <!--r_box end -->
  <div class="cloud">
   <h3>程序猿众筹</h3>
   <div class="ad"> <img src="<%=basePath%>images/help.png"> </div>
   <div class="ad"> <img src="<%=basePath%>images/money.png"> </div>
   </div> 
   </div>
</article>
<%@ include file ="common/footer.jsp"%>
</body>
<script language="javascript" src="<%=basePath%>js/ToolTip.js"></script>
</html>