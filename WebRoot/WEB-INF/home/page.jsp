<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
   <%@ include  file="header.jsp" %>
    <div id="image">
    	<img src="../image/theme/banner04.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<div id="left">
        	<ul>
            	<h2><s:property value="headName"/></h2>
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
	        	<div style="margin-top:20px;"></div>
        		<div id="text_content" style="margin:20px;"><s:property value="content" escape="false"/></div>
            </s:iterator>
        </div>
        <div class="cb"></div>
    </div>
 <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
 </body>
</html>
