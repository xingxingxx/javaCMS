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
		<li style="background-color: #eee;"><a href="product">产品</a></li>
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
  		<ul style="float:left;width:150px;border: 1px solid #ccc;margin-top:30px;">
  				<li style="line-height:40px;border-bottom:1px solid #ccc;padding-left:10px;font-size:15px;font-weight:bold;
  				background-color: #ccc;">
  					产品分类
  				</li>
  				<s:iterator value="pc">
  					<s:if test="#request.id==categoryId">
  					<li style="line-height:30px;border-bottom: 1px solid #ccc;background-color:#eee;padding-left:10px;">
  					<a href="product?id=<s:property value="categoryId"/>">
  						<s:property value="categoryName"/>
  					</a>
  					</li>
  					</s:if>
  					<s:else>
  					<li style="line-height:30px;border-bottom: 1px solid #ccc;padding-left:10px;">
  					<a href="product?id=<s:property value="categoryId"/>">
  						<s:property value="categoryName"/>
  					</a>
  					</li>
  					</s:else>
  				</s:iterator>
  		</ul>
  		<div style="margin-left:170px;">
  		<a href="toAddProduct"><span class="add-icon"></span>新增产品</a><br/><br/>
	  		<table width="100%" class="tab">
	  			<tr class="title">
	  				<td>ID</td>
	  				<td>图片</td>
	  				<td>产品名称</td>
	  				<td>操作</td>
	  			</tr>
	  			<s:iterator value="list">
	  			<tr>
	  				<td><s:property value="productId"/></td>
	  				<td style="width:140px;">
	  					<img src="../upload/minImage/<s:property value="minImage"/>" style="width:120px;height:60px;margin:10px;"/>
	  				</td>
	  				<td><s:property value="ProductName"/></td>
	  				<td>
	  					<a href="delProduct?id=<s:property value="productId"/>" ><span class="del-icon"></span>删除</a>
		  				<a style="margin-left:10px;" href="toUpdateProduct?id=<s:property value="productId"/>"><span class="editor-icon"></span>编辑</a>
		  				<a style="margin-left:10px;" onclick="window.open('moreProduct?id=<s:property value="productId"/>','','width=800,height=800,top=100,left=200,toolbar=no,scrollbars=yes,location=no');" href="javascript:" ><span class="slide-icon"></span>预览</a>
	  				</td>
	  			</tr>
	  			</s:iterator>
	  		</table>
	  		 <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="product?id=${request.categoryId }"  class_name="onPage"/>
            </div>
            
  		</div>
  		</div>
  </body>
</html>
