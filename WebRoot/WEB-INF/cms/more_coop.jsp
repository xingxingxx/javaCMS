<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>文章预览</title>
  </head>
  
  <body>
  		<div style="margin:20px;width:760px;">
  			<h2>详细信息页面</h2>
  			<p>
  				ID:<s:property value="coop.coopId"/>
  			</p>
  			<p>
  				姓名：<s:property value="coop.name"/>
  			</p>
  			<p>
  				国家：<s:property value="coop.country"/>
  			</p>
  			<p>
  				省份：<s:property value="coop.province"/>
  			</p>
  			<p>
  				城市：<s:property value="coop.city"/>
  			</p>
  			<p>
  				电话：<s:property value="coop.phone"/>
  			</p>
  			<p>
  				邮箱：<s:property value="coop.email"/>
  			</p>
  			<p>
  				公司名称：<s:property value="coop.company"/>
  			</p>
  			<p>
  				公司网址：<s:property value="coop.url"/>
  			</p>
  			<p>
  				更多信息：<s:property value="coop.content"/>
  			</p>
  		</div>
  </body>
  </html>