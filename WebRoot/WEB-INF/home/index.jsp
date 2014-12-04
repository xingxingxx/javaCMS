<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>鼎信通达</title>
	<link href="../css/base.css" rel="stylesheet" type="text/css" />
    <link href="../css/index.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
   <%@ include  file="header.jsp" %>
      <!--幻灯片-->
    <div id="slide">
    	<ul class="adv">
    		<s:iterator value="partnersList" status="st">
    			<li><a href="<s:property value="url"/>" target="_blank"><img src="../upload/partners/<s:property value="imageUrl"/>" width="960" height="320" /></a></li>
    		</s:iterator>
        </ul>
    	<ul class="num">
    		<s:iterator value="partnersList">
    		<li></li>
    		</s:iterator>
        </ul>
    </div>
    
     <!--主体内容-->
    <div id="content">
    	<div class="list">
        	<div class="title">
            	产品中心
            </div>
            <div class="tl">
            	<div class="image">
                	<img src="../image/theme/img001.png" width="222" height="100"/>
                </div>
             		
                <ul>
                	<s:iterator value="pc"  status="st">
                		<s:if test="#st.count<=4">
                		<li><a href="productCenter?id=<s:property value="categoryId"/>"><s:property value="categoryName"/></a></li>
                		</s:if>
                    </s:iterator>
                </ul>
                <div class="more"><a href="productCenter">更多详情<img src="../image/icon/icon2.gif" style="margin-left:5px;"></a></div>
            </div>
        </div>
    	<div class="list">
        	<div class="title">
            	解决方案
            </div>
            <div class="tl">
            	<div class="image">
                	<img src="../image/theme/img002.png" width="222" height="100"/>
                </div>
             		
                <ul>
            		<s:iterator value="listJ">
            			<li><a href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>">
	             		<s:if test="columnName.length()>11">    
	     					 <s:property value="columnName.substring(0,11)+'...'" />    
	 					</s:if>    
						<s:else>    
						         <s:property value="columnName" />    
						</s:else>   
	             		</a></li>
            		</s:iterator>
                </ul>
                <div class="more"><a href="">更多详情<img src="../image/icon/icon2.gif" style="margin-left:5px;"></a></div>
            </div>
        </div><div class="list">
        	<div class="title">
            	新闻中心
            </div>
            <div class="tl">
            	<div class="image">
                	<img src="../image/theme/img003.png" width="222" height="100"/>
                </div>
             		
                <ul>
                	<s:iterator value="textList2">
	                	<li><a href="textMore?id=<s:property value="textId"/>&relationId=<s:property value="newId"/>">
	                	<s:if test="title.length()>11">    
     					    <s:property value="title.substring(0,11)+'...'" />    
	 					</s:if>    
						<s:else>    
						    <s:property value="title" />    
						</s:else>   
	                	<img src="../image/icon/new.gif"/>
	                	</a></li>
                	</s:iterator>
                </ul>
                <div class="more2"><a href="news?id=11&relationId=7">更多详情<img src="../image/icon/icon2.gif" style="margin-left:5px;"></a></div>
            </div>
        </div><div class="list" style="margin-right:0px;">
        	<div class="title">
            	文档中心
            </div>
            <div class="tl">
            	<div class="image">
                	<img src="../image/theme/img004.png" width="222" height="100"/>
                </div>
             	<ul>
                	<s:iterator value="listDoc">
	                	<li>
	                		<a href="docCenter?id=6&relationId=6">
		                	<s:if test="title.length()>11">    
	     					    <s:property value="title.substring(0,11)+'...'" />    
		 					</s:if>    
							<s:else>    
							    <s:property value="title" />    
							</s:else>   
	                		</a>
	                	</li>
                	</s:iterator>
                </ul>
                <div class="more"><a href="">更多详情<img src="../image/icon/icon2.gif" style="margin-left:5px;"></a></div>
            </div>
        </div>
        <div class="cb"></div>
    </div>
    <!--合作伙伴-->
    <div id="partners">
    	<div class="title2">合作伙伴</div>
        <div class="arrow_left"></div>
        <div class="partners_slide">
        	<ul>  
        		<s:iterator value="slideList" status="st">
    			<li><a href="<s:property value="url"/>" target="_blank"><img title="<s:property value="description"/>" src="../upload/slide/<s:property value="imageUrl"/>"/></a></li>
    	     	</s:iterator> 
        	</ul>
        </div>
        <div class="arrow_right"></div>
        <div class="cb"></div>
    
    </div>
    <%@ include  file="footer.jsp"%>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/base.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  $(".tl").each(function(){
		 var $this=$(this);
		 var href=$this.find(">ul>li:eq(0)").find("a").attr("href");
		 $this.find(".more>a").attr("href",href);
		 
	 });
  
  	viewImage(0);
	function viewImage(id){
		$(".adv>li").css("display","none");
		$(".num>li").removeClass("on");
		$(".adv>li:eq("+id+")").fadeIn("slow");
		$(".num>li:eq("+id+")").addClass("on");
	}
	$(".num li").each(function(i){	
		$(this).mouseover(function(){
			viewImage(i);
		});
	});
	var i = 1;
	var taskId;
	var count=$(".num>li").size();
	$('#slide').hover(function(){
		clearInterval(taskId);
	},function(){
		taskId = setInterval(function(){
			viewImage(i);
			i++;
			if(i == count){
				i = 0;
			}
		},3000);
	}).mouseout();
	
	
	function moveImage(p){
		$('.partners_slide ul').css('left',-p);
		if(p==160*count2-400){
			j=0;
			$('.partners_slide ul').css('left',0);
		}
	}
		
		
	var j=0;
	var taskId2;
	var count2=$(".partners_slide ul>li").size();
	$('.partners_slide').hover(function(){
		clearInterval(taskId2);
	},function(){
		taskId2 = setInterval(function(){
			j++;
			if(j>=160*count2-400){
				j=0;
			}
			if(j<0){
				j=160*count2-800;
			}
			$('.partners_slide ul').css('left',-j);
		},60);
	}).mouseout();	
		$(".arrow_left").click(function(){
			j=j+400;
			});
		$(".arrow_right").click(function(){
			j=j-400;
			});
	});
	
    </script>
  </body>
</html>
