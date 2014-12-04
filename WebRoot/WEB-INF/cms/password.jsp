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
		<li><a href="question">在线问答</a></li>
		<li><a href="coop">合作伙伴申请</a></li>
		<s:if test="#session.admin.adminPower==0">
		 <li><a href="admin">管理员</a></li>
		</s:if>
		<li style="background-color: #eee;"><a href="toUpdatePassword">修改密码</a></li>
		<li><a href="../" target="_blank">进入官网</a></li>
		<li><a href="loginOut">退出系统</a></li>
	</ul>
</div>
  		<div id="right">
  		<form action="updatePassword" method="post">
  			<table class="tab-fm"> 
  				<tr>
  					<td>
  						原始密码:
  					</td>
  					<td>
  						 <input id="oldPassword" type="text" name="oldPassword" onblur="checkNull('oldPassword')"/>
  					</td>
  					<td id="msg_oldPassword" style='color:red;margin-left:10px;'>
  						<s:property value="msg"/>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						新密码:
  					</td>
  					<td>
  						 <input id="newPassword" type="password" name="newPassword" onblur="checkNull('newPassword')"/>
  					</td>
  					<td id="msg_newPassword"></td>
  				</tr>
  				<tr>
  					<td>
  						确认密码:
  					</td>
  					<td>
  						 <input id="checkPassword" type="password"  onblur="checkAgin()"/>
  					</td>
  					<td id="msg_checkPassword"></td>
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
  
  <script type="text/javascript">
  
   function checkNull(id){
  	    var val=document.getElementById(id).value;
 		var msg=document.getElementById("msg_"+id);
 		if(val.length<=0){
 			msg.innerHTML="<span style='color:red;margin-left:10px;'>必填，不能为空！</span>";
 			return;
 		}else{
 			msg.innerHTML="";
 		}	
 	}
 	function checkAgin(){
 		 var val1=document.getElementById("newPassword").value;
 		 var val2=document.getElementById("checkPassword").value;
 		 var msg=document.getElementById("msg_checkPassword");
 		 if(val1!=val2){
 			msg.innerHTML="<span style='color:red;margin-left:10px;'>两次输入的密码不相同！</span>";
 			return;
 		}else{
 			msg.innerHTML="";
 		}	
 		 
 	}
 	function showResult(){
 		checkNull("oldPassword");
 		checkNull('newPassword');
 		checkAgin();
 		var msg1=document.getElementById("msg_oldPassword").innerHTML;
  		var msg2=document.getElementById("msg_newPassword").innerHTML;
  		var msg3=document.getElementById("msg_checkPassword").innerHTML;
 		if(msg1=="" && msg2=="" && msg3==""){
 		document.forms[0].submit();
 		}
 	}	
 
 </script>
 </body>
</html>
