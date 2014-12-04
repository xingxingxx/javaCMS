<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <%@ include  file="header.jsp" %>
    <div id="image">
    	<img src="../image/theme/banner05.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<div id="left">
        	<ul>
            	<h2><s:property value="headName"/></h2>
            	<%@ include  file="left.jsp" %>
            </ul>
        </div>
        <!--右侧内容栏-->
        <div id="right">
        	<h3>当前位置:<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span><s:property value="headName"/>
        	<span style="color:#999;">&gt;</span><s:property value="str"/></h3>
           <div style="font-size:16px;font-weight: bold;text-align: center;line-height:60px;margin-top:15px;">合作伙伴申请</div>
        	<table style="margin-left:60px;font-size:13px;">
        	<form id="fm">
        		<tr>
        			<td></td>
        			<td style="height:30px;">我们承诺不向第三方泄露您的任何信息</td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span>姓名: </td>
        			<td><input id="name" name="coop.name" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span>国家: </td>
        			<td><input id="country" name="coop.country" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span>省份:  </td>
        			<td><input id="province" name="coop.province" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span>城市:  </td>
        			<td><input id="city" name="coop.city" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span>电话: </td>
        			<td><input id="phone" name="coop.phone" type="text" size="40"></td>
        		</tr>
        		
        		<tr>
        			<td style="height:40px;padding-right:10px;"><span style="color:red">*&nbsp;&nbsp;</span> 邮箱:  </td>
        			<td><input id="email" name="coop.email" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:20px;"><span style="color:red">*&nbsp;&nbsp;</span>公司名称:  </td>
        			<td><input id="company" name="coop.company" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:20px;">公司网址:  </td>
        			<td><input id="url" name="coop.url" type="text" size="40"></td>
        		</tr>
        		<tr>
        			<td style="height:40px;padding-right:20px;">更多信息:  </td>
        			<td><textarea id="content" name="coop.content" style="width:350px;height:100px;">
        			
        			</textarea></td>
        		</tr>
        		<tr>
        			<td style="height:80px;padding-right:20px;"></td>
        			<td>
        				<input style="width:80px; height:25px;margin-right:20px;" id="btn" type="button" value="确认" >
        				<input style="width:60px;height:25px;" type="reset" value="取消" >
        			</td>
        		</tr>
        		<tr>
        			<td style="height:50px;padding-right:20px;"></td>
        			<td>
        				
        			</td>
        		</tr>
        		</form>
        	</table>
        </div>
        <div class="cb"></div>
    </div>
    <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/base.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#btn").click(function(){
  		var flag=true;
		if($("#name").val().length<=0|| $("#country").val().length<=0|| $("#province").val().length<=0 
		|| $("#city").val().length<=0|| $("#phone").val().length<=0
		|| $("#email").val().length<=0 || $("#company").val().length<=0   ){
		flag=false;
		alert("请将带*号输入框信息填写完整！");
  		}else{
  			if(!/^([a-zA-Z0-9_.-]+)@([\da-zA-Z.-]+).([a-zA-Z.]{2,6})$/.test($("#email").val())){
  					flag=false;
                   alert("请输入正确的邮箱地址！");
                }
                if(!/^[0-9]*$/.test($("#phone").val())){
  					flag=false;
                   alert("请输入正确的电话号码！");
                }
  		}
  		
  		if(flag){
  			$.post("addCoop",$("#fm").serialize(),function(data){
                if(data=="success"){
                  window.location.href="coop?id=${request.id}&relationId=${request.relationId }";
                    alert("你的申请已成功发送！我们稍后会与您联系！");
                }else{
                   alert("发送失败！");
                }
            });
  		 }
  		
  		});
  	});
  </script>
</body>
</html>
