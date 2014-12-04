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
  			<div style="line-height:50px;font-weight:bold;">${uq.userName}:&nbsp;&nbsp;&nbsp;于&nbsp;&nbsp;&nbsp;[${uq.ctime }]</div>
  			<div style="line-height:30px;width：600px">
  				${uq.content }
  				<s:set name="str" value="uq.questionId">
        			</s:set>
  				<s:iterator value="list">
        				<s:if test="#str==questionId">
        				<div style="margin:10px;line-height:25px;">
        				<s:property value="adminName"/>	回复于&nbsp; &nbsp;[<s:property value="ctime"/>]：<br/>
        				<s:property value="content"/>
        				</div>
        				</s:if>
        			</s:iterator>
  			</div>
  			<form action="answer" method="post">
  				<input type="hidden"  name="questionId" value="${uq.questionId}" >
  				<div style="line-height:50px;font-weight:bold;">回复：</div>
  				<div >
  					<textarea id="answer" style="width:600px;height:300px;" name="content"></textarea>
  				</div>
  				<div style="margin-top:20px;">
  						<input class="btn-ok" type="button" value="提交" onclick="showResult();" />
  						<input class="btn-cancel" type="reset" value="重置"/>
  				</div>
  			</form>
  		</div>
  <script type="text/javascript" >
 	
 	function showResult(){
 		var val=document.getElementById("answer").value;
 	
 		if(val!=""){
 		document.forms[0].submit();
 		}else{
 			alert("您没有回复任何信息！");
 		}
 	}	
 </script>
 </body>
</html>
