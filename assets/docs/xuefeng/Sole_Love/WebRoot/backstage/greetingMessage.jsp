<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'greetingMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="<%=path%>/artDialog4.1.7/artDialog.js?skin=default"></script>

  </head>
  
  <body>
    <table border="1px" >
    	<tr>
    		<td>所属用户</td>
    		<td>头像</td>
    		<td>背景</td>
    		<td>语音</td>
    		<td>祝福代码</td>
    		<td>修改定制</td>
    	</tr>
    	<c:forEach items="${list}" var="o">
    		<tr>
    			<td style="display: none;">${o[0].id}</td>
    			<td>${o[1].nickname}</td>
	    		<td>
	    			<img style="width: 100px"  src="greetingInfo/${o[2].charactor}">
	    		</td>
	    		<td>
	    			<img style="width: 100px"  src="greetingInfo/${o[2].background}">
	    		</td>
	    		<td>
	    			<audio alt="" src="greetingInfo/${o[2].sound}" controls="controls"></audio>
	    		</td>
	    		<td>
	    			${o[2].code}
	    		</td>
	    		<td>
	    			<input type="button" value="修改" onclick="update(this)">
	    		</td>
    		</tr>
    	</c:forEach>
    </table>
    <br>  <br>  <br>  <br>  
<a href="backstage/addGreeting.jsp">添加定制</a>

<div style="display: none;" id="updateGreeting">
	<form action="updateGreeting.action" method="post" enctype="multipart/form-data">  
		<input style="display: none;" type="text" name="id" id="id"/>
		头像<input type="File" accept="image/gif, image/jpeg,image/x-png" name="upload"/><br>  
		背景<input type="File" accept="image/gif, image/jpeg,image/x-png" name="upload"/><br>  
		语音<input type="File" accept="audio/x-mpeg" name="upload"/><br>  
		祝福代码<input type="text" name="code"/><br>  
		<input type="submit" value="提交" />   
	</form>  
</div>
    
    <script type="text/javascript">
	function update(obj) {
		$("#id").val(obj.parentNode.parentNode.cells[0].innerHTML);
			art.dialog({
						title : '修改定制信息',
						content : document.getElementById("updateGreeting"),
						width : '400px',
					});
		}
    </script>
  </body>
</html>
