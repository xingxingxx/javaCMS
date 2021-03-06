<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>后台管理主页</title>
	<link rel="stylesheet" type="text/css" href="../css/cms_base.css">
  </head>
  
  <body onload="getId()" >
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
		<li style="background-color: #eee;"><a href="text">文章</a></li>
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
  			<form action="addText" enctype="multipart/form-data"  method="post">
  			<div id="hie"></div>
  			<table class="tab-fm"> 
  				<tr>
  					<td></td>
  					<td>
  					注：带红色星号的选项为必填<br/><br/>
  					当内容类型为单个页面的时候，只能添加一篇文章<br/><br/>
  					当内容类型为文档和软件下载时，则只需要填写标题和上传该文件。
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td><span style="color:red;margin-right:5px;">*</span>标题:</td>
  					<td>
  					 <input id="title" type="text" name="title" onblur="checkNull('title')"/>
  					</td>
  					<td id="msg_title"></td>
  				</tr>
  				<tr>
  					<td>缩略图:</td>
  					<td> 
  					<input type="file" name="minImage"/>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>版本:</td>
  					<td>
  					<input type="text" name="edition" /></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>是否发布:</td>
  					<td>
  						<input type="radio" name="flow" value="1" checked="checked" />
	                    <label>是</label>
	                    <input type="radio" name="flow" value="0"/>
	                    <label>否</label>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>上传文件:</td>
  					<td>
  					<input type="file" name="download"/>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>
  						描述：
  					</td>
  					<td>
  						<textarea name="summary"></textarea>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>
  						内容:
  					</td>
  					<td>
  					<script type="text/plain"  id="editor" name="content" style="width:700px;height:300px;"></script>
  					</td>
  					<td>
  					</td>
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
  <script type="text/javascript" src="../js/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="../js/ueditor/ueditor.all.min.js"></script>
  <script type="text/javascript" >
 	function getId(){
 		var url=document.location.href;
 		var id=url.split("=")[1];
 		document.getElementById("hie").innerHTML="<input type='hidden' name='categoryId' value='"+id+"' />";
 	}
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
 	function showResult(){
 	    checkNull("title");
 	    var msg1=document.getElementById("msg_title").innerHTML;
 		if(msg1==""){
 		document.forms[0].submit();
 		}
 	}	
 	 var ue = UE.getEditor('editor');
 </script>
 </body>
</html>
