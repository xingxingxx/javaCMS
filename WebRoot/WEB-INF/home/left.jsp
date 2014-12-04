<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<s:iterator value="tc">
	<s:if test="columnsId==#request.id">
	
		<s:set name="str" value="columnName"></s:set>
		<s:if test="columnName=='在线问答'">
   		<li style="background-color: rgb(226, 226, 226);"><a href="userQuestion?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
   		</s:if>
   		<s:elseif test="columnName=='文档中心'">
   		<li style="background-color: rgb(226, 226, 226);"><a href="docCenter?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
   		</s:elseif>
   		<s:elseif test="columnName=='合作伙伴申请'">
   		<li style="background-color: rgb(226, 226, 226);"><a href="coop?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property value="columnName"/></a></li>
   		</s:elseif>
        <s:else>
		<s:if test="columnClass==1">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==2">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="page?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==3">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="document?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==4">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="program?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==5">
			<li style="background-color: rgb(226, 226, 226);">
				<a
					href="news?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		
		</s:else>
	</s:if>
	<s:else>
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
			<li>
				<a
					href="text?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==2">
			<li>
				<a
					href="page?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==3">
			<li>
				<a
					href="document?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==4">
			<li>
				<a
					href="program?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		<s:if test="columnClass==5">
			<li>
				<a
					href="news?id=<s:property value="columnsId"/>&relationId=<s:property value="relationId"/>"><s:property
						value="columnName" />
				</a>
			</li>
		</s:if>
		</s:else>
	</s:else>
</s:iterator>