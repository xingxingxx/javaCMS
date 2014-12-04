<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>技术服务</title>
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
            	<h2>技术服务</h2>
            	<%@ include  file="left.jsp" %>
            </ul>
        </div>
        <!--右侧内容栏-->
        <div id="right">
        	<h3>当前位置:<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span>技术服务
        	<span style="color:#999;">&gt;</span>在线问答</h3>
        	<ul style="margin:30px;">
        		<s:iterator value="uq">
        			<s:set name="str" value="questionId">
        			</s:set>
        			<li style="border-bottom:1px solid #ccc; margin-top:50px;">
        			<div>
        				<div><img src="../image/icon/icon4.gif"/><span style="margin-left:5px;margin-right:20px;color:#000;font-weight:bold;"><s:property value="userName"/></span>
        					[<s:property value="ctime"/>]
        				</div>
        				<div style="margin:10px;line-height:25px;">
        				<s:property value="content"/>
        				</div>
        			</div>
        			<s:iterator value="list">
        				<s:if test="#str==questionId">
        				<div>
        				<div><img src="../image/icon/xiao.gif"/><span style="margin-left:5px;margin-right:20px;color:#000;font-weight:bold;">客服</span>
        				回复于&nbsp; &nbsp;[<s:property value="ctime"/>]
        				</div>
        				<div style="margin:10px;line-height:25px;">
        				<s:property value="adminName"/>：<br/>
        				<s:property value="content"/>
        				</div>
        				</div>
        				</s:if>
        			</s:iterator>
        		</li>
        		</s:iterator>
        	</ul>
        	 <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="userQuestion?id=${request.id}&relationId=${request.relationId }"  class_name="onPage"/>
            </div>
            <div style="margin-left:40px;margin-top:10px;margin-bottom:40px;">
            	 <div style="line-height:50px; font-size:16px;color:#000;font-weight:bold;">留言</div>
            	 <div>
            	 	<table>
            	 		<form id="fm">
            	 		<tr>
            	 			<td style="height:30px;">姓名：</td>
            	 			<td><input id="name" name="name" size="40" /></td>
            	 			<td></td>
            	 		</tr>
            	 		<tr>
            	 			<td style="height:30px;">Email：</td>
            	 			<td><input id="email" name="email" size="40" /></td>
            	 			<td></td>
            	 		</tr>
            	 		<tr>
            	 			<td style="height:30px;">留言：</td>
            	 			<td>
								<textarea name="content" rows="5" cols="80"></textarea>
							</td>
							<td></td>
            	 		</tr>
            	 		<tr>
            	 			<td style="height:30px;">验证码：</td>
            	 			<td><input id="code"  name="code" size="20" /><img id="code" onclick="this.src='../login/createImage?' + new Date().getTime();"style="display:inline-block;margin-left:10px;margin-top:10px;height:20px"  src="../login/createImage"  /></td>
            	 		   <td></td>
            	 		</tr>
            	 		<tr>
            	 			<td style="height:30px;"></td>
            	 			<td><input id="btn" type="button" value="提交"/>
            	 				<input type="reset" value="取消"/>
            	 			</td>
            	 			<td></td>
            	 		</tr>
            	 		</form>
            	 	</table>
            	 </div>
            </div>
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
		if($("#name").val().length<=0 || $("#email").val().length<=0 || $("#code").val().length<=0 || $("textarea").val().length<=0  ){
		flag=false;
		 alert("请将输入框信息填写完整！");
  		}else{
  			if(!/^([a-zA-Z0-9_.-]+)@([\da-zA-Z.-]+).([a-zA-Z.]{2,6})$/.test($("#email").val())){
  					flag=false;
                   alert("请输入正确的邮箱地址！");
                }
  		}
  		if(flag){
  			$.post("toQuestion",$("#fm").serialize(),function(data){
                if(data=="success"){
                  window.location.href="userQuestion?id=${request.id}&relationId=${request.relationId }";
                    alert("你的留言已成功发送！");
                }else if(data=="VerificationCodeError"){
                    $("#code").trigger("click");
                 	alert("验证码错误");
                }else{
                 $("#code").trigger("click");
                   alert("发送失败！");
                }
            });
  		 }
  		
  		 
  		});
  	});
  </script>
 </body>
</html>
