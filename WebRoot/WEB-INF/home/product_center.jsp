<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="page" uri="http://www.tarena.com.cn/page_tag"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>产品中心</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
	<link href="../css/product_center.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  	 <%@ include  file="header.jsp" %>
     <div id="image">
    	<img src="../image/theme/banner02.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<!--左侧导航栏-->
		<div id="left">
			<ul>
		   		<h2>产品中心</h2>
		   			<s:iterator value="pc">
                   	 <s:if test="categoryId==#request.id">
			   			<s:set name="str" value="categoryName"></s:set>
			   			<li style="background-color:rgb(226,226,226);"><a href="productCenter?id=<s:property value="categoryId"/>" ><s:property value="categoryName"/></a></li>
			   		</s:if>
			   		<s:else>
			   			<li><a href="productCenter?id=<s:property value="categoryId"/>" ><s:property value="categoryName"/></a></li>
			   		</s:else>
                   	</s:iterator>
		    </ul>    
		</div>
		
        <!--右侧内容栏-->
        <div id="right" >
        	<h3>当前位置：<a href="index" style="color:#fff;">首页</a>
        	<span style="color:#999;">&gt;</span>产品中心
        	<span style="color:#999;">&gt;</span><s:property value="str"/>
        	</h3>
        	<div style="height:25px;"></div>
        	 <s:iterator value="list">        
	          <div class="product">
	          	<div class="product_img">
		          	<img src="../upload/minImage/<s:property value="minImage"/>" />
                </div>
                <div class="product_des">
                	<div class="title">
                		<a href="more?id=<s:property value="productId"/>">
                		<s:property value="productName"/>
                		</a>
                	</div>
                	<s:if test="summary.length()>60">    
     					 <s:property value="summary.substring(0,60)+'...'" />    
 					</s:if>    
					<s:else>    
					         <s:property value="summary" />    
					</s:else>   
                <br/>
                 	<a href="more?id=<s:property value="productId"/>" class="more"><img alt="" src="../image/icon/icon2.gif">&nbsp;了解更多信息</a>             
                </div>
                 <div class="cb"></div>
    		</div>
            </s:iterator>          
            <div class="cb"></div>
            <div class="pageClass">
            <page:paging totalPage="${total}" page="${page}"  href="productCenter?id=${request.id}"  class_name="onPage"/>
            </div>
           
        </div>
        <div class="cb"></div>
    </div>
    <%@ include  file="footer.jsp"%>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
</body>
</html>
