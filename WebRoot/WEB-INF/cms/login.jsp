<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>后台管理系统登录页</title>
  </head>
  <body style="font-size:13px;color:#fafafa;background-color: #0a7ac4;">
        <form action="login" method="post">
                <table border="0" style="margin:200px auto;">
                 	<tr>
                 		<td style="height:30px;">用户名：</td>
                 		<td><input name="name" size="30"/></td>
                 	</tr>
                 	<tr>
                 		<td style="height:30px;">密码：</td>
                 		<td><input type="password" name="password" size="30"/></td>
                 	</tr>
                 	<tr>
                 		<td style="height:30px;">验证码：</td>
                 		<td><input style="vertical-align: middle;" name="code" size="15"/>
                 		<img src="createImage"  onClick="this.src='createImage?' + new Date().getTime();" style="vertical-align:middle;width:80px;height: 22px;margin-left:10px;"/></td>
                 	</tr>
                 	<tr>
                 		<td></td>
                 		<td><s:property value="msg"/></td>
                 	</tr>
                 	<tr>
                 		<td style="height:40px;"></td>
                 		<td><input type="submit" value="登录"/><input type="reset" value="取消"/></td>
                 	</tr>
                </table>
        </form>
  </body>
</html>
