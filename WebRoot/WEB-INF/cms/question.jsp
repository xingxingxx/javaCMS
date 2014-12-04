<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
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
		<li><a href="manage">首页</a></li>
		<li><a href="columns">导航栏</a></li>
		<li><a href="partners">幻灯片</a></li>
		<li><a href="slide">友情链接</a></li>
		<li><a href="category">产品类别</a></li>
		<li><a href="product">产品</a></li>
		<li><a href="text">文章</a></li>
		<li><a href="docCategory">文档中心类别</a></li>
		<li><a href="document">文档中心</a></li>
		<li style="background-color: #eee;"><a href="question">在线问答</a></li>
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
  			<table style="width:100%" class="tab">
	  			<tr class="title">
	  				<td>
	  					ID
	  				</td>
	  				<td>
	  					用户名
	  				</td>
	  				<td>
	  					时间
	  				</td>
	  				<td>
	  					Email
	  				</td>
	  				
	  				<td>
	  					操作
	  				</td>
	  			</tr>
	  			<s:iterator value="list"> 
	  				<tr>
	  					<td>
	  					<s:property value="questionId"/>
	  					</td>
	  					<td>
	  					<s:property value="userName"/>
	  					</td>
	  					<td>    
	  					<s:property value="ctime"/>
	  					</td>
	  					<td>
	  					<s:property value="email"/>
	  					</td>
	  					
	  					<td>
	  					<a href="delQuestion?id=<s:property value="questionId"/>" ><span class="del-icon"></span>删除</a>
		  				<a style="margin-left:10px;" href="toAnswer?id=<s:property value="questionId"/>"><span class="editor-icon"></span>回复</a>
	  					</td>
	  				</tr>
	  			</s:iterator>
	  			</table>
	  		<div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="product"  class_name="onPage"/>
            </div>
  		</div>
  </body>
</html>
