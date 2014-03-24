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

<title>My JSP 'index.jsp' starting page</title>
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

			var url = 'login.action';

			alert("===");

			//获取表单值，并以json的数据形式保存到params中  
			var params = {
				mobile : $("#mobile").val(),
				password : $("#password").val(),
			}
			//使用$.post方式      
			$.post(

			url, //服务器要接受的url  

			params, //传递的参数       

			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  

				//alert(data);  
				var member = eval("(" + data + ")"); //包数据解析为json 格式    

				$('#result').html("欢迎您：  " + User.name);

			},

			'json' //数据传递的类型  json  

			);

		});

	});
</script>

</head>

<body>
	<img src="identifie.action" />
	<span>用户名：</span>
	<input type="text" id="mobile" name="mobile">
	<br />

	<span>密码：</span>
	<input type="password" name="password" id="password">
	<br />

	<input type="button" id="btn_login" value="Login" />
	<br />
	<a href="mobileAndEmail.jsp">手机邮箱验证 </a>
	<br />
	<a href="products.jsp">产品列表 </a>
	<br />
	<a href="register.jsp">用户注册 </a>
	<br />
	<a href="addresses.jsp">当前用户的配送地址列表 </a>
	<br />
	<a href="all_order.jsp">用户所用订单 </a>
	<br />
	<a href="expresses.jsp">配送方式列表 </a>
	<br />
	<a href="greetings.jsp">当前user使用过的祝福列表 </a>
	<br />
	<a href="create_greeting.jsp">创建祝福 </a>
	<br />
	<a href="salerInfo.jsp">首草使者信息 </a>
	<br />
	<a href="checkInvcodes.jsp">查询邀请码是否使用</a>
	<br />
	<a href="message.jsp">站内信</a>
	<br />
	<a href="rankings.jsp">使者排行榜 </a>
	<br />
	<a href="verify_saler_code.jsp">优惠代码验证 </a>
	<br />
	<a href="discounts.jsp">返点记录 </a>
	<br />
</body>
</html>
