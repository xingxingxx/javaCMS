<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>后台管理主页</title>
	<link rel="stylesheet" type="text/css" href="../css/cms_base.css">
  </head>
  
  <body>
  		<div id="left">
	<ul class="menu">
		<li class="header">
			后台管理系统
		</li>
		<li style="background-color: #eee;"><a href="manage">首页</a></li>
		<li><a href="columns">导航栏</a></li>
		<li><a href="partners">幻灯片</a></li>
		<li><a href="slide">友情链接</a></li>
		<li><a href="category">产品类别</a></li>
		<li><a href="product">产品</a></li>
		<li><a href="text">文章</a></li>
		<li><a href="docCategory">文档中心类别</a></li>
		<li><a href="document">文档中心</a></li>
		<li><a href="question">在线问答</a></li>
		<li><a href="coop">合作伙伴申请</a></li>
		<s:if test="#session.admin.adminPower==0">
		 <li><a href="admin">管理员</a></li>
		</s:if>
		<li><a href="toUpdatePassword">修改密码</a></li>
		<li><a href="../" target="_blank">进入官网</a></li>
		<li><a href="loginOut">退出系统</a></li>
	</ul>
</div>
  		<div id="right">
  				<div style="width:800px;height:470px;background-color: #eee;line-height:24px;padding:10px;">
  					<p style="font-weight: bold;font-size:16px;line-height:40px;">系统使用说明：</p>
  					<p style="margin:10px;">一、导航栏：<br/>1、可对网站导航进行定制化（产品中心、在线问答模块除外） <br/>2、可在特定的项目下添加内容
  						<br/>定制化的操作包括：增加，删除，修改导航栏和二级菜单（注意：在做删除操作时，必须将其子项目全部删除，否则无法删除）
  					</p>
  					
  					<p style="margin:10px;">
  						二、文章的添加<br/>
  						步骤：<br/>1、选中导航栏，进入导航栏管理页面。<br/>
  						2、找到你要添加文章的栏目，点击‘展开’。<br/>
  						3、展开后页面弹出，栏目下的二级菜单，找到你要添加文章的二级栏目，点击‘添加内容’。<br/>
  						4、弹出添加文章的页面，在上面填入你文章的相应内容。
  					</p>
  					<p style="margin:10px;">
  						三、产品的添加（在产品项目下添加即可）
  					</p>
  					
  				</div>
  		</div>
  </body>
</html>
