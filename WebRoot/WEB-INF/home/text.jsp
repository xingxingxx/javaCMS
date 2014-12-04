<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
    <link href="../css/solution.css" rel="stylesheet" type="text/css" />
  </head>
<body>
   <%@ include  file="header.jsp" %>
    <div id="image">
    	<img src="../image/theme/banner04.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<div id="left">
        	<ul>
            	<h2>
            		<s:property value="headName"/>
            	</h2>
            	<%@ include  file="left.jsp" %>
            </ul>
        </div>
        <!--右侧内容栏-->
        <div id="right">
        	<h3>当前位置：<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span><s:property value="headName"/>
        	<span style="color:#999;">&gt;</span><s:property value="str"/>
        	</h3>
        	 <s:iterator value="list"> 
	        	<div class="solution">
	        		<div class="text_img">
	        			<img src="../upload/textImage/<s:property value="minImage"/>"/>
	        		</div>
	        		<div class="text">
	        			<div class="title"><s:property value="title"/></div>
		        		<div class="solution_content">
		        		    <s:property value="summary"/>...
		        			<br/>
		        			时间：<s:property value="ctime"/>
		        		<br/>
		        		<a href="textMore?id=<s:property value="textId"/>&relationId=${request.relationId }" class="more"><img src="../image/icon/icon2.gif">&nbsp;了解更多信息</a>             
		        		</div>
	        		</div>
	        		<div class="cb"></div>
	            </div>
            </s:iterator>
            <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="text?id=${request.id}&relationId=${request.relationId }"  class_name="onPage"/>
            </div>
        </div>
        <div class="cb"></div>
    </div>
 <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
</body>
</html>
