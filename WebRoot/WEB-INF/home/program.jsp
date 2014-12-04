<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
    <link href="../css/theo.css" rel="stylesheet" type="text/css" />
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
            <div class="search">
            	
                <div class="search2">
                	<form id="fm" action="program" method="post">
                	关键字搜索：
                  	<input type="hidden" name="id" value="${request.id}"/>
                	<input type="hidden" name="relationId" value="${request.relationId }"/>
                    <input id="name" type="text" name="name" value="${request.name }"/>
                    <input type="button" class="btn" value="搜索"/>
                    </form>
                </div>
                <div class="cb"></div>
            </div>
        	
            <table class="tab">
            	<tr class="tab_title">
                	<td>标题</td>
                	<s:if test="#str!='培训中心'">
                    <td>版本</td>
                    </s:if>
                    <td>发布时间</td>
                    <td>下载</td>
                </tr>
               
                <s:iterator value="list" >
                 <tr>
                <td>
        			 <s:property value="title"/>
        		</td>
        		<s:if test="#str!='培训中心'">
        		<td>
        			<s:property value="edition"/>
        		</td>
        		</s:if>
        		<td>
        			<s:property value="ctime.substring(0,10)"/>
        		</td>
        		<td>
        			<%-- <form action="downloadFile" method="post">
        				<input type="hidden" value="<s:property value="download"/>" name="fileName" />
        				<input type="submit" style="width:30px;height:25px;border:0;background: url('../image/icon/dowIcon.gif') ;background-repeat: no-repeat;background-position: 5px 5px;" value=""/>
        			</form> --%>
        			<a  href="../upload/program/<s:property value="download"/>" style="display:inline-block;width:30px;height:25px;border:0;background: url('../image/icon/dowIcon.gif') ;background-repeat: no-repeat;background-position: 5px 5px;"></a>
        		</td>
        		  </tr>
        	    </s:iterator>   
            </table>
            <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="program?id=${request.id}&relationId=${request.relationId }&name=${request.name }"  class_name="onPage"/>
            </div>
        </div>
        <div class="cb"></div>
    </div>
    <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$(".btn").click(function(){
	if($("#name").val()!=""){
		$("#fm").submit();
	}else{
		alert("您没有输入任何信息！");
	}
		
	});
});
</script>
</body>
</html>
