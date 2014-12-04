<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="one">
    	<ul>
    		<li><a href="http://www.dinstar.com/index/index.aspx">ENGLISH</a></li>
        	<li>|</li>
            <li><a href="page?id=19&relationId=9">联系我们</a></li>
            <li>|</li>
            <li><a href="index">首页</a></li>
            <li>|</li>
            <li><a href="../login/toLogin" target="_blank">登录</a></li>
            <div class="cb"></div>
		</ul>
</div>
  
  	<div style="border-bottom:1px solid #ccc;">
        <div id="two">
            <div id="logo">
                 <a href="index"><img src="../image/logo/dinstar.png" width="291" height="72" alt=""/></a>
            </div>
            <div id="link">
                <ul>
                   	<s:iterator value="listOne">
	  		        	<s:set name="str" value="columnsId"></s:set>
	  		        	<s:if test="#request.relationId==columnsId">
	  		        		<s:set name="headName" value="columnName"></s:set> 
	  		        	</s:if>
	  		            <li><a href=""><s:property value="columnName"/></a>
	  		          
                        <ul class="menu">
	  		             	<s:iterator value="listt">
                        	<s:if test="#str==relationId">
                        		<s:if test="columnName=='在线问答'">
                        			<li><a href="userQuestion?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
                        		</s:if>
                        		<s:elseif test="columnName=='文档中心'">
                        			<li><a href="docCenter?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
                        		</s:elseif>
                        		<s:elseif test="columnName=='合作伙伴申请'">
                        			<li><a href="coop?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
                        		</s:elseif>
                        		<s:else>
                        		
	                        	<s:if test="columnClass==1">
	                        		  <li><a href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
	                        	</s:if>
	                        	<s:if test="columnClass==2">
	                        		  <li><a href="page?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
	                        	</s:if>
	                        	<s:if test="columnClass==3">
	                        		  <li><a href="document?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
	                        	</s:if>
	                        	<s:if test="columnClass==4">
	                        		  <li><a href="program?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
	                        	</s:if>
	                          	<s:if test="columnClass==5">
	                        		  <li><a href="news?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
	                        	</s:if>
	                        	</s:else>
	                        	
                            </s:if>
                            </s:iterator>
                        </ul>
                        </li>
                     
                    <li class="line">|</li>
  			        </s:iterator>
                    
                    <li><a href="">产品中心</a>
                        <ul class="menu">
                         	<s:iterator value="pc">
                         	 <li><a href="productCenter?id=<s:property value="categoryId"/>"><s:property value="categoryName"/></a></li>
                         	</s:iterator>
                        </ul>
                    </li>
                    <li class="line">|</li>
                    <li><a href="index">首页</a>
                    </li> 
                    <div class="cb"></div>     
                </ul>
                
            </div>
            <div class="cb"></div>
        </div>
    </div>
