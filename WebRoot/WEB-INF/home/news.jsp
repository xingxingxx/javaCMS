<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
    <link href="../css/news.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <%@ include  file="header.jsp" %>
     <div id="image">
    	<img src="../image/theme/banner06.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<div id="left">
        	<ul>
            	<h2><s:property value="headName"/></h2>
            	<%@ include  file="left.jsp" %>
            </ul>
            
        </div>
        <!--右侧内容栏-->
        <div id="right" style="background-color:#eee;">
        	<h3>当前位置：<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span><s:property value="headName"/>
        	<span style="color:#999;">&gt;</span><s:property value="str"/></h3>
        	<ul class="news">
        		<s:iterator value="list" status='st' > 
        			<s:if test="#st.index<3">
        				<li><img alt="" src="../image/icon/icon4.gif">&nbsp;&nbsp;<a href="textMore?id=<s:property value="textId"/>&relationId=${request.relationId }"><s:property value="title"/></a><span style="color:#999;">&nbsp;&nbsp;<img src="../image/icon/new.gif"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<s:property value="ctime"/>]</span></li>
        			</s:if>
        			<s:else>
        				<li><img alt="" src="../image/icon/icon4.gif">&nbsp;&nbsp;<a href="textMore?id=<s:property value="textId"/>&relationId=${request.relationId }"><s:property value="title"/></a><span style="color:#999;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<s:property value="ctime"/>]</span></li>
        			</s:else>
        		 </s:iterator>   
            </ul>
           
            <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="news?id=${request.id}&relationId=${request.relationId }"  class_name="onPage"/>
            </div>
        </div>
        <div class="cb"></div>
    </div>
<%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
</body>
</html>
