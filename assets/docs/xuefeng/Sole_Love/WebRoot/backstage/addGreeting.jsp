<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addGreeting.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="GreetingsUpload.action" method="post" enctype="multipart/form-data">  
		头像<input type="File" accept="image/gif, image/jpeg,image/x-png" name="upload"/><br>  
		背景<input type="File" accept="image/gif, image/jpeg,image/x-png" name="upload"/><br>  
		语音<input type="File" accept="audio/x-mpeg" name="upload"/><br>  
		祝福代码<input type="text" name="code"/><br>  
		<input type="submit" value="提交"/>  
	</form>  
  </body>
</html>
