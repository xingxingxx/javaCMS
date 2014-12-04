<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
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
            	<h2>
            		<s:property value="headName"/>
            	</h2>
<s:iterator value="tc">
	<s:if test="columnsId==#request.text.categoryId">
	
		<s:set name="str" value="columnName"></s:set>
		<s:if test="columnName=='在线问答'">
        		<li style="background-color: rgb(226, 226, 226);"><a href="userQuestion?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
        		</s:if>
        <s:else>
		<s:if test="columnClass==1">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==2">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="page?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==3">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="document?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==4">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="program?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==5">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="news?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		
		</s:else>
	</s:if>
	<s:else>
		<s:if test="columnName=='在线问答'">
        		<li><a href="userQuestion?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
        		</s:if>
        <s:else>
		<s:if test="columnClass==1">
			<li>
				<a
					href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==2">
			<li>
				<a
					href="page?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==3">
			<li>
				<a
					href="document?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==4">
			<li>
				<a
					href="program?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==5">
			<li>
				<a
					href="news?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		</s:else>
	</s:else>
</s:iterator>
            </ul>
        </div>
        <!--右侧内容栏-->
        <div id="right">
        	<h3>当前位置：<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span><s:property value="headName"/>
        	<span style="color:#999;">&gt;</span><s:property value="str"/>
        	<span style="color:#999;">&gt;</span>内容页
        	</h3>
        	
        	<div style="margin-top:20px;"></div>
        	<div id="text_content" style="margin:20px;"><s:property value="text.content" escape="false"/></div>
        	
        </div>
        <div class="cb"></div>
    </div>
 <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
 </body>
</html>
