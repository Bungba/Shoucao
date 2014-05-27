<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

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
		$("#login").click(function() {
			var url = 'login.action';
			//获取表单值，并以json的数据形式保存到params中  
			var params = {
				mobile : $("#mobile").val(),
				password : $("#password").val(),
			}
			//使用$.post方式      
			$.post(url, //服务器要接受的url  
			params, //传递的参数       
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				for(var i=0;i<member.length;i++){
					$('#result').html(member[i].id);
				}
			}, 'json' //数据传递的类型  json  
			);
		});
	});
	function cc(){
		window.location.href="xinsc/user_details.html?id="+document.getElementById("result").innerHTML;
	}
</script>

</head>

<body>
	<span>用户名：</span>
	<input type="text"  id="mobile" name="mobile" value="15036556579">
	<br />

	<span>密码：</span>
	<input type="password" name="password" id="password">
	<br />

	<input type="button" id="login" value="Login"/>
	<br />
	<span style="display: none;" id="result"></span><a onclick="cc()">用户信息</a><br>
	<a href="index.jsp">11111111111</a>
</body>
</html>
