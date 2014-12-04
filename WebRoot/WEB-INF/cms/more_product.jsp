<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>产品预览</title>
  </head>
  
  <body>
  		<div style="margin:20px;width:760px;">
  			<h2><s:property value="p.productName"/></h2>
  			<div>
  				<h3>产品图片：</h3>
  				<div>
  					<img src="../upload/minImage/<s:property value="p.minImage"/>" />
  				</div>
  			</div>
  			<div>
  				<h3>产品简介：</h3>
  				<div>
  					<s:property value="p.description" escape="false"/>
  				</div>
  			</div>
  			<div>
  				<h3>产品特性：</h3>
  				<div>
  					<s:property value="p.function" escape="false"/>
  				</div>
  			</div>
  			<div>
  				<h3>产品规格：</h3>
  				<div>
  					<s:property value="p.model" escape="false"/>
  				</div>
  			</div>
  		</div>
  </body>
  </html>