<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>文章预览</title>
  </head>
  
  <body>
  		<div style="margin:20px;width:760px;">
  			<h2><s:property value="text.title"/></h2>
  			<div>
  				<s:property value="text.content"  escape="false"/>
  			</div>
  		</div>
  </body>
  </html>