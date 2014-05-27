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
<title>当前用户的配送地址列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_login").click(function() {
			var url = 'addresses.action';
			$.post(url, //服务器要接受的url  
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				
				data=data.replace("[", "").replace("]", "");
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式  
				$('#id1').val(member.id);  
				$('#id2').val(member.id);  
				$('#name1').val(member.name);
				$('#address1').val(member.address);
				$('#city1').val(member.city);
				$('#zip1').val(member.zip);
				$('#tel1').val(member.tel);
				$('#count1').val(member.usecount);
				$('#flag1').val(member.delFlag);
			}, 'json' //数据传递的类型  json  
			);
		});
	});
	
	$(document).ready(function() {
		$("#btn_add").click(function() {
			var url = 'add_address.action';
			var params = {
				name : $("#name").val(),
				address : $("#address").val(),
				city : $("#city").val(),
				zip : $("#zip").val(),
				tel : $("#tel").val(),
			}
			$.post(url, //服务器要接受的url  
			params,
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				$('#result').html("欢迎您：  " + member.name);
			}, 'json' //数据传递的类型  json  
			);
		});
	});
	$(document).ready(function() {
		$("#btn_up").click(function() {
			var url = 'update_address.action';
			var params = {
				id : $("#id1").val(),
				name : $("#name1").val(),
				address : $("#address1").val(),
				city : $("#city1").val(),
				zip : $("#zip1").val(),
				tel : $("#tel1").val(),
				count : $("#count1").val(),
				flag : $("#flag1").val(),
			}
			$.post(url, //服务器要接受的url  
			params,
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				$('#result').html("欢迎您：  " + member.city);
			}, 'json' //数据传递的类型  json  
			);
		});
	});
	
	$(document).ready(function() {
		$("#btn_del").click(function() {
			var url = 'del_address.action';
			var params = {
				id : $("#id2").val(),
			}
			$.post(url, //服务器要接受的url  
			params,
			function cbf(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				alert(data);
				var member = eval("(" + data + ")"); //包数据解析为json 格式    
				$('#result').html("欢迎您：  " + member.city);
			}, 'json' //数据传递的类型  json  
			);
		});
	});
</script>
</head>

<body>
	<input type="button" id="btn_login" value="测试" />
	<br />
	<span id="result"></span>

	<hr />
	<h3>添加配送地址</h3>
	收货人姓名<input type="text" name="name" id="name"><br />
	收货人城市<input type="text" name="city" id="city"><br />
	收货人地址<input type="text" name="address" id="address"><br />
	收货人联系电话<input type="text" name="tel" id="tel"><br />
	收货人邮政编码<input type="text" name="zip" id="zip"><br />
	<input type="button" id="btn_add" value="add" />
<hr />
	<h3>修改配送地址</h3>
	id<input type="text" name="id" id="id1"><br />
	收货人姓名<input type="text" name="name" id="name1"><br />
	收货人城市<input type="text" name="city" id="city1"><br />
	收货人地址<input type="text" name="address" id="address1"><br />
	收货人联系电话<input type="text" name="tel" id="tel1"><br />
	收货人邮政编码<input type="text" name="zip" id="zip1"><br />
	使用次数<input type="text" name="count" id="count1"><br />
	是否删除<input type="text" name="flag" id="flag1"><br />
	<input type="button" id="btn_up" value="up" />
	<hr />
	<h3>删除配送地址</h3>
	id<input type="text" name="id" id="id2"><br />
	<input type="button" id="btn_del" value="del" />
</body>
</html>
