<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>产品中心</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
	<link href="../css/more.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  	 <%@ include  file="header.jsp" %>
     <div id="image">
    	<img src="../image/theme/banner02.gif" width="960" height="201" alt=""/>
    </div>
    
    <div id="content_center">
    	<div id="left">
        	<ul>
            	<h2>产品中心</h2>	
		        <s:iterator value="pc"> 
			   		<s:if test="categoryId==#request.product.categoryId">
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
        <div id="right">
        	<h3>当前位置：<a href="index" style="color:#fff;">首页</a><span style="color:#999;">&gt;</span>产品中心
        	<span style="color:#999;">&gt;</span><s:property value="str"/>
        	<span style="color:#999;">&gt;</span><s:property value="product.productName"/></h3>
		         <div style="height:80px;line-height:80px;margin-left:20px;font-size:16px;font-weight:bold;"><s:property value="product.productName"/></div>   		
                <ul class="tab">
                	<li style="float:left;background-color:#fafafa; border-bottom:1px solid #ccc; width:40px;height:31px;"></li>
                    <li class="tab1">图片</li>
                    <li class="tab1">产品简介</li>
                    <li class="tab1">产品特性</li>
                    <li class="tab1">产品规格</li>
                    <li class="tab1">相关下载</li>
                    <li style="float:left;background-color:#fafafa;border-left:1px solid #ccc; border-bottom:1px solid #ccc;width:160px;height:31px;"></li>
     				<div class="cb"></div>
                </ul>
                
                <ul class="tab_cell">
                	 <li class="tab_cell1">
                    	<s:iterator value='product.imageList.split("\\\\,")' status="st" var="as">        
						    <s:if test="#st.index>0">
						       <div class="max_image_view"><img src="../upload/imageList/<s:property value="#as"/>"/></div>
						    </s:if>
						</s:iterator> 
		         		<ul class="min_image">
			         		 <s:iterator value='product.imageList.split("\\\\,")' status="st" var="as">        
							    <s:if test="#st.index>0">
							       <div class="min_image_click"><img src="../upload/imageList/<s:property value="#as"/>"/></div>
							    </s:if>
							 </s:iterator> 
							  <div class="cb"></div>
		         		</ul>
                    </li>
                    <li id="description" class="tab_cell1"><s:property value="product.description" escape="false"/></li>
                    <li id="function" class="tab_cell1"><s:property value="product.function" escape="false"/></li>
                    <li id="model" class="tab_cell1" ><s:property value="product.model" escape="false"/></li>
                    <li class="tab_cell1">
                    	<%-- <form action="downloadFileProduct" method="post">
        				<input type="hidden" value="<s:property value="product.download"/>" name="fileName" />
        				<input type="submit" style="height:55px;border:0;background: #fafafa;color:rgb(23,113,173);" value="<s:property value="product.download"/>"/> 
        			</form>--%>
        			<a href="../upload/annex/<s:property value="product.download"/>"><s:property value="product.download"/></a>
                    </li>
                </ul> 
        </div> 
        <div class="cb"></div>
   </div>
    <%@ include  file="footer.jsp"%>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/base.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    viewTab(0);
	viewImage(0);
	function viewImage(id){
		$(".max_image_view").css("display","none");
		
		$(".min_image_click").css("border-color","#ccc");
		
		$(".min_image_click:eq("+id+")").css("border-color","#0a7ac4");
		$(".max_image_view:eq("+id+")").fadeIn("normal");
	}
	$(".min_image_click").each(function(i){	
		$(this).click(function(){
			viewImage(i);
		});
	});
	function viewTab(ix){
		$(".tab1").css({
			'background-color':'#eee',
			'border-bottom':'1px solid #ccc'
		});
		$(".tab_cell1").css("display","none");
		
		$(".tab1:eq("+ix+")").css({
			'background-color':'#fafafa',
			'border-bottom':'0px'
		});
		$(".tab_cell1:eq("+ix+")").css("display","block");
	}
	
	$(".tab1").each(function(i){
		$(this).click(function(){
			viewTab(i);
		});
	});
});
</script>
</body>
</html>
