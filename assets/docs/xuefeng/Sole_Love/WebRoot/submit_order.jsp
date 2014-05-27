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

<title>My JSP 'submit_order.jsp' starting page</title>

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
			
			pid=document.getElementsByName('pid');
			count=document.getElementsByName('count');
			for(var i=0;i<pid.length;i++){
				 pid[i].value;
			} 
 			
 			//var params = 'pArray ='+$.toJSON(convertArray); 
			var url = 'submit_order.action';
			//获取表单值，并以json的数据形式保存到params中  
			var params = {
			products:$('form').serialize()
				/* city : $("#city").val(),
				zip : $("#zip").val(),
				address : $("#address").val(),
				name : $("#name").val(),
				code : $("#code").val(),
				message : $("#message").val(),
				express : $("#express").val(),
				express_fee : $("#express_fee").val(), */
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
	function pObject(id, count) {
		this.id = id;
		this.count = count;
	}
</script>
</head>
<body>
	<form>
		<span>产品ID：</span>
	<input type="text" id="pid" name="pid">
	<input type="text" id="pid" name="pid">
	<br />
	<span>产品数量：</span>
	<input type="text" name="count" id="count">
	<input type="text" name="count" id="count">
	<br />
	<span>配送城市：</span>
	<input type="text" name="city" id="city">
	<br />
	<span>邮政编码：</span>
	<input type="text" name="zip" id="zip">
	<br />
	<span>配送地址：</span>
	<input type="text" name="address" id="address">
	<br />
	<span>收件人姓名：</span>
	<input type="text" name="name" id="name">
	<br />
	<span>优惠代码：</span>
	<input type="text" name="code" id="code">
	<br />
	<span>留言：</span>
	<input type="text" name="message" id="message">
	<br />
	<span>快递公司名称：</span>
	<input type="text" name="express" id="express">
	<br />
	<span>快递费：</span>
	<input type="text" name="express_fee" id="express_fee">
	<br />
	<input type="button" id="login" value="测试提交" />
	<br />
	</form>
	<span id="result"></span>
</body>
</html>
