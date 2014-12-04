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
            	<div class="search1">
                	分类搜索
                   
                    	<div class="category">请选择分类 &gt;&gt; 
	                        <ul class="search11">
	                        	<s:iterator value="listDoc">
	                        		<li><a href="docCenter?id=${request.id}&relationId=${request.relationId }&categoryId=<s:property value="categoryId"/>">
	                        		 <s:property value="categoryName"/>
	                        		</a></li>
	                        	</s:iterator>
	                        </ul> 	
	                   	</div>
                   
                </div>
            	 
                <div class="search2">
                	<form id="fm" action="docCenter" method="post">
                  	<input type="hidden" name="id" value="${request.id}"/>
                	<input type="hidden" name="relationId" value="${request.relationId }"/>
                    <input id="name" type="text" name="categoryName" value="${request.categoryName }" />
                    <input type="button" class="btn" value="搜索"/>
                    </form>
                </div>
                <div class="cb"></div>
            </div>
        	
            <table class="tab">
            	<tr class="tab_title">
                	<td>标题</td>
                	<td>类别</td>
                    <td>版本</td>
                    <td>发布时间</td>
                    <td>下载</td>
                </tr>
               
                <s:iterator value="list" >
                 <tr>
                <td>
        			 <s:property value="title"/>
        		</td>
        		<td>
        			<s:set name="cateId" value="categoryId"></s:set>
        			<s:iterator value="listDoc">
        				<s:if test="#cateId==categoryId">
        					<s:property value="categoryName"/>
        				</s:if>
        			</s:iterator>
        		</td>
        		<td>
        			<s:property value="edition"/>
        		</td>
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
            <page:paging totalPage="${total}" page="${page}"  href="docCenter?id=${request.id}&relationId=${request.relationId }&categoryId=${request.categoryId }&categoryName=${request.categoryName }"  class_name="onPage"/>
            </div>
        </div>
        <div class="cb"></div>
    </div>
    <%@ include  file="footer.jsp" %>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<script type="text/javascript">
$(document).ready(function(){

$(".category").hover(function(){
			$(this).find("ul").slideDown("fast");
		},function(){
			$(this).find("ul").slideUp("fast");
		});
	
	$(".btn").click(function(){
		
		$("#fm").submit();
	
	});
});
</script>
</body>
</html>
