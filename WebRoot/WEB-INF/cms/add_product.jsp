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
  			<form action="addProduct" enctype="multipart/form-data"  method="post">
  			<table class="tab-fm"> 
  				<tr>
  					<td></td>
  					<td>注：带红色星号的选项为必填</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>
  						<span style="color:red;margin-right:5px;">*</span>产品名称:
  					</td>
  					<td>
  						 <input id="productName" type="text" name="productName" onblur="checkNull('productName')"/>
  					</td>
  					<td id="msg_productName"></td>
  				</tr>
  				<tr>
  					<td>
  						<span style="color:red;margin-right:5px;">*</span>产品类别:
  					</td>
  					<td>
  						 <s:select theme="simple" name="categoryId" list="list"  listKey="categoryId" listValue="categoryName" ></s:select>
  					</td>
  					<td></td>
  					</tr>
  				<tr>
  					<td>
  						附件上传:
  					</td>
  					<td>
  						 <input type="file" name="download"/>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>
  						<span style="color:red;margin-right:5px;">*</span>产品缩略图:
  					</td>
  					<td>
  						 <input id="minImage" type="file" name="minImage" onblur="checkNull('minImage')"/>
  					</td>
  					<td id="msg_minImage"></td>
  				</tr>
  				<tr>
  					<td>
  						产品大图:
  					</td>
  					<td>
  						<input type="file" name="imageList" /><br/>
  						<input type="file" name="imageList" /><br/>
  						<input type="file" name="imageList" /><br/>
  						<input type="file" name="imageList" /><br/>
  						<input type="file" name="imageList" />
  					</td>
  					<td></td>
  				</tr>
  				
  				<tr>
  					<td>
  						<span style="color:red;margin-right:5px;">*</span>概述:
  					</td>
  					<td>
  						<textarea id="summary" name="summary" onblur="checkNull('summary')"></textarea>
  					</td>
  					<td id="msg_summary"></td>
  				</tr>
  				<tr>
  					<td>
  						产品简介:
  					</td>
  					<td>
  						<script type="text/plain"  id="editorDescription" name="description" style="width:700px;height:300px;"></script>
  					</td>
  					<td></td>
  				</tr>
  			<tr>
  				<td>产品特性:</td>
 			<td>
 			<script type="text/plain"  id="editor" name="function" style="width:700px;height:300px;"></script>
 			</td>
 			<td></td>
 		</tr>
 		
 		<tr>
 			<td>产品规格:</td>
 			<td>
 			<script type="text/plain"  id="editorMOdel" name="model" style="width:700px;height:300px;"></script>
 			</td>
 			<td></td>
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
  <script type="text/javascript">
    var ue1 = UE.getEditor('editorDescription');
    var ue2 = UE.getEditor('editorMOdel');
    var ue3 = UE.getEditor('editor');
    
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
  		checkNull('productName');
  		checkNull('minImage');
  		checkNull('summary');
  		var msg1=document.getElementById("msg_productName").innerHTML;
  		var msg2=document.getElementById("msg_minImage").innerHTML;
  		var msg3=document.getElementById("msg_summary").innerHTML;
 		if(msg1=="" && msg2=="" && msg3=="" ){
 		document.forms[0].submit();
 		}else{
 			alert("还有必填项没有完成！");
 		}
 	}	
  </script>
  </body>
</html>
