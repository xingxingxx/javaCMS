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
		<li><a href="columns">导航栏</a></li>
		<li><a href="partners">幻灯片</a></li>
		<li><a href="slide">友情链接</a></li>
		<li style="background-color: #eee;"><a href="category">产品类别</a></li>
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
  		<form action="updateCategory" method="post">
  			<table class="tab-fm"> 
  				<tr>
  					<td>
  						类别名称:
  					</td>
  					<td>
  						<input type="hidden" name="p.categoryId" value="${p.categoryId}"/>
  						 <input id="name" type="text" value="${p.categoryName}" name="p.categoryName" onblur="checkName()"/>
  					</td>
  					<td id="msgName"></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td>
  						<input class="btn-ok" type="button" value="提交" onclick="showResult();" />
  						<input class="btn-cancel" type="reset" value="重置"/>
  					</td>
  					<td></td>
  				</tr>
  			</table>
  		</form>		
  		</div>
  </body>
  <script type="text/javascript">
 	var flagName=false;
 	function checkName(){
 		var val=document.getElementById("name").value;
 		var msgName=document.getElementById("msgName");
 		if(val.length<=0){
 			msgName.innerHTML="<span style='color:red;margin-left:10px;'>请填写栏目名称！</span>";
 			return;
 		}else{
 			msgName.innerHTML="";
 			flagName=true;
 		}	
 	}
 	function showResult(){
 	    checkName();
 		if(flagName){
 		document.forms[0].submit();
 		}
 	}	
 
 </script>
</html>
