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
		<li><a href="manage">首页</a></li>
		<li style="background-color: #eee;"><a href="columns">导航栏</a></li>
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
  			<a href="toAddOneColumns"><span class="add-icon"></span>新增栏目</a><br/><br/>
	  		<table style="width:100%;" class="tab">
	  			<tr class="title">
	  				<td>序号</td>
	  				<td>栏目名称</td>
	  				<td>显示/隐藏</td>
	  				<td>操作</td>
	  				<td>二级菜单</td>
	  			</tr>
	  			<s:iterator value="list">
	  			<s:set name="str" value="columnsId">
        		</s:set>
	  			<tr>
	  				<td><s:property value="columnPosition"/></td>
	  				<td>
	  				<s:property value="columnName"/>
	  				</td>
	  				<td>
	  					<s:if test="isDisplay==1">显示</s:if>
	  					<s:if test="isDisplay==0">隐藏</s:if>
	  				</td>
	  				<td >
	  					<a href="toAddTwoColumns?id=<s:property value="columnsId"/>"><span class="add-icon"></span>新增二级菜单</a><br/>
	  				    <a href="delOneColumns?id=<s:property value="columnsId"/>" onclick="return checkOne(<s:property value="columnsId"/>);"><span class="del-icon"></span>删除</a><br/>
		  				<a href="toUpdateOneColumns?id=<s:property value="columnsId"/>"><span class="editor-icon"></span>编辑</a>
	  				</td>
	  				<td style="padding:0;">	
	  				  	<table width="100%" class="tab2" style="margin-bottom: 10px;">
	  				  		<tr class="title">
				  				<td>序号</td>
				  				<td style="width:160px;">栏目名称</td>
				  				<td style="width:100px;">内容类别</td>
				  				<td>操作</td>
				  			</tr>
				  			<s:iterator value="listt">
	  					 	<s:if test="#str==relationId">
	  					 	<input type="hidden" id="hid<s:property value="#str"/>"/>
				  			<tr>
				  				<td><s:property value="columnPosition"/></td>
				  				<td><s:property value="columnName"/></td>
				  				<td>
				  					<s:if test="columnClass==1">
				  				          文章
				  					</s:if>
				  					<s:if test="columnClass==2">
				  				         单个页面
				  					</s:if>
				  					<s:if test="columnClass==3">
				  				         技术 文档
				  					</s:if>
				  					<s:if test="columnClass==4">
				  				        下载资源
				  					</s:if>
				  					<s:if test="columnClass==5">
				  				          新闻
				  					</s:if>
				  				</td>
				  				<td>
				  					
				  					 <a href="delTwoColumns?id=<s:property value="columnsId"/>" ><span class="del-icon"></span>删除</a>
		  				    		 <a style="margin-left:10px;" href="toUpdateTwoColumns?id=<s:property value="columnsId"/>"><span class="editor-icon"></span>编辑</a>
				  				</td>
				  			</tr>
				  			</s:if>
				  			</s:iterator>
	  				  	</table>
	  				<!--  </div> -->
	  				</td>
	  			</tr>
	  			</s:iterator>
	  		</table>
  		</div>
   <script type="text/javascript">

    function checkOne(id){
    	var obj=document.getElementById("hid"+id);
    	if(obj){
    		alert("该栏目包含子菜单，无法删除，如果您确实需要删除，请先将该栏目下的子菜单删除！");
    		return false;
    	}
    	return ture;
    }
   
   </script>
   </body>
</html>
