<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'create_greeting.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//使用 Ajax 的方式 判断登录  
		$("#create").click(function() {
			var url = 'create_greeting.action';
			//获取表单值，并以json的数据形式保存到params中  
			var params = {
				char_id : $("#char_id").val(),
				bg_id : $("#bg_id").val(),
				sound : $("#sound").val(),
			}
			//使用$.post方式      
			$.post(url, //服务器要接受的url  
			params, //传递的参数       
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				$('#result').html(member.name);
			}, 'json' //数据传递的类型  json  
			);
		});
	});
</script>
  </head>
  
  <body>
    动画：<input type="text" id="char_id" name="char_id"><br />
    背景：<input type="text" id="bg_id" name="bg_id"><br />
    声音：<input type="text" id="sound" name="sound"><br />
    <input type="button" id="create" value="create">
  </body>
</html>
