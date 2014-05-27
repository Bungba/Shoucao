<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>用户注册</title>

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
		$("#btn_login").click(function() {
			var url = 'register.action';
			//获取表单值，并以json的数据形式保存到params中  
			var params = {
				mobile : $("#mobile").val(),
				email : $("#email").val(),
				nickname : $("#nickname").val(),
				password : $("#password").val(),
				rand : $("#rand").val()
			}
			//使用$.post方式      
			$.post(
			url, //服务器要接受的url  
			params, //传递的参数       
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);  
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				$('#result').html("欢迎您：  " + member.name);
			},
			'json' //数据传递的类型  json  
			);
		});
	});
</script>
</head>

<body>
	<img src="identifie.action" />
	<span>手机：</span>
	<input type="text" id="mobile" name="mobile">
	<br />
	<span>Email：</span>
	<input type="text" id="email" name="email">
	<br />
	<span>名字：</span>
	<input type="text" id="nickname" name="nickname">
	<br />
	<span>密码：</span>
	<input type="password" name="password" id="password">
	<br />
<span>验证码：</span>
	<input type="text" name="rand" id="rand">
	<br />
	<input type="button" id="btn_login" value="注册" />
<a href="index.jsp">首页</a>
</body>
</html>
