<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
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

<title>My JSP 'userMessage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript" src="artDialog4.1.7/artDialog.js?skin=default"></script>
</head>

<body>
	<table border="1px">
		<tr>
			<td>ID</td>
			<td>昵称</td>
			<td>性别</td>
			<td>生日</td>
			<td>结婚日期</td>
			<td>联系电话</td>
			<td>QQ号码</td>
			<td>城市</td>
			<td>地址</td>
			<td>手机号码</td>
			<td>email</td>
			<td>修改状态</td><!-- 每个用户添加一个［修改状态］的按钮 并添加一个［编辑用户］的按钮 -->
			<td>编辑用户</td>
		</tr>
		<s:iterator value="list" id="l">
			<tr onclick="checkdate(this)">
				<td><s:property value="#l.id" />
				</td>
				<td><s:property value="#l.nickname" />
				</td>
				<td><s:if test="#l.gender==0">
	    				男
	    			</s:if> <s:else>
	    				女
	    			</s:else>
				</td>
				<td>
					<s:date name="#l.birthday" format="yyyy-MM-dd" />
				</td>
				<td><s:date name="#l.marriageday" format="yyyy-MM-dd" />
				</td>
				<td><s:property value="#l.tel" />
				</td>
				<td><s:property value="#l.qq" />
				</td>
				<td><s:property value="#l.city" />
				</td>
				<td><s:property value="#l.address" />
				</td>
				<td><s:property value="#l.mobile" />
				</td>
				<td><s:property value="#l.email" />
				</td>
				<td ><s:if test="#l.delflag==0">
	    				<input type="button" value="账户锁定" onclick="UserFlag(this)">
	    			</s:if> <s:else>
	    				<input type="button" value="账户可用" onclick="UserFlag(this)">
	    			</s:else></td>
	    			<td style="display: none;">
	    				<s:property value="#l.locked" />
	    			</td>
	    			<td style="display: none;">
	    				<s:property value="#l.gender" />
	    			</td>
	    			<td><input type="button" value="编辑用户" onclick="update()"></td>
			</tr>
		</s:iterator>
	</table>
	<!-- 改为添加  添加用户时表里面新增一个账号属性作为登录账号 -->
	<input type="button" value="新增用户" onclick="add()">
	<s:debug></s:debug>

	<script type="text/javascript">
		function UserFlag(obj){
			var id=obj.parentNode.parentNode.cells[0].innerHTML;
			window.location.href="updateUserFlag?id="+id;
		}
	
	
		function checkdate(obj){
			$("#id").val(obj.cells[0].innerHTML.trim());
			$("#nickname").val(obj.cells[1].innerHTML.trim());
			$("#gender").val(obj.cells[13].innerHTML.trim());
			$("#birthday").val(obj.cells[3].innerHTML.trim());
			$("#marriageday").val(obj.cells[4].innerHTML.trim());
			$("#tel").val(obj.cells[5].innerHTML.trim());
			$("#qq").val(obj.cells[6].innerHTML.trim());
			$("#city").val(obj.cells[7].innerHTML.trim());
			$("#address").val(obj.cells[8].innerHTML.trim());
			$("#mobile").val(obj.cells[9].innerHTML.trim());
			$("#email").val(obj.cells[10].innerHTML.trim());
			if(obj.cells[12].innerHTML.trim()==0){
				$("#locked").val(0);
			}else{
				$("#locked").val(1);
			}
			if(obj.cells[13].innerHTML.trim()==0){
				$("#gender").val(0);
			}else{
				$("#gender").val(1);
			}
			
		}
	
		function update() {
			art.dialog({
						title : '修改用户信息',
						content : document.getElementById("updateUser"),
						width : '400px',
						button : [
								{
									name : '确定',
									focus : true,
									callback : function() {
											$.post(
															"updateUser.action",
															{
																"id" : $("#id").val(),
																"nickname" : $("#nickname").val(),
																"gender" : $("#gender").val(),
																"birthday" : $("#birthday").val(),
																"marriageday" : $("#marriageday").val(),
																"tel" : $("#tel").val(),
																"qq" : $("#qq").val(),
																"city" : $("#city").val(),
																"address" : $("#address").val(),
																"locked" : $("#locked").val()
															},
															function(json) {
																if (json) {
																	//window.location.href = 'findnode.action?id=-1';
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改成功！</span>");
																	setTimeout("window.location.href = 'usermess.action'",1500);
																} else {
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改失败！</span>");
																	setTimeout("window.location.href = 'usermess.action'",1500);
																}
															}, "json");
										}
									}
								, {
									name : '取消',
								} ]
					});
		}
		function add() {
			art.dialog({
						title : '删除用户',
						content : document.getElementById("addUser"),
						width : '400px',
						button : [
								{
									name : '确定',
									focus : true,
									callback : function() {
											$.post(
															"addUser.action",
															{
																"id" : $("#id").val(),
																"nickname" : $("#nickname").val(),
																"password": $("#password").val(),
																"mobile": $("#mobile").val(),
																"email": $("#email").val(),
																"gender" : $("#gender").val(),
																"birthday" : $("#birthday").val(),
																"marriageday" : $("#marriageday").val(),
																"tel" : $("#tel").val(),
																"qq" : $("#qq").val(),
																"city" : $("#city").val(),
																"address" : $("#address").val(),
																"locked" : $("#locked").val()
															},
															function(json) {
																if (json) {
																	//window.location.href = 'findnode.action?id=-1';
																	art.dialog("<span style='color:red;font-weight:bolder;'>添加成功！</span>");
																	setTimeout("window.location.href = 'usermess.action'",1500);
																} else {
																	art.dialog("<span style='color:red;font-weight:bolder;'>添加失败！</span>");
																	setTimeout("window.location.href = 'usermess.action'",1500);
																}
															}, "json");
										}
									}
								, {
									name : '取消',
								} ]
					});
		}
	</script>
	<div id="updateUser" style="display: none;">
			<input type="text" id="id" style="display: none;">
			昵称:<input type="text" id="nickname"><br>
			性别:<select id="gender">
							<option value="0">男</option>
							<option value="1">女</option>
						</select><br>
			生日:<input type="date" id="birthday" onblur="birthday()"><br>
			结婚日期:<input type="date" id="marriageday" onblur="marriageday()"><br>
			联系电话:<input type="text" id="tel"><br>
			QQ号码:<input type="text" id="qq"><br>
			城市:<input type="text" id="city"><br>
			地址:<input type="text" id="address"><br>
			手机号码:<input type="text" id="mobile" readonly><span style="color: red">不可更改</span><br>
			email:<input type="text" id="email" readonly><span style="color: red">不可更改</span><br>
			账户状态:<select id="locked">
							<option value="0">可用</option>
							<option value="1">锁定</option>
						</select>
	</div>
	<div id="addUser" style="display: none;">
			<input type="text" id="id" style="display: none;">
			昵称:<input type="text" id="nickname"><br>
			密码:<input type="text" id="password"><br>
			性别:<select id="gender">
							<option value="0">男</option>
							<option value="1">女</option>
						</select><br>
			生日:<input type="date" id="birthday" onblur="birthday()"><br>
			结婚日期:<input type="date" id="marriageday" onblur="marriageday()"><br>
			联系电话:<input type="text" id="tel"><br>
			QQ号码:<input type="text" id="qq"><br>
			城市:<input type="text" id="city"><br>
			地址:<input type="text" id="address"><br>
			手机号码:<input type="text" id="mobile" ><br>
			email:<input type="text" id="email" ><br>
			账户状态:<select id="locked">
							<option value="0">可用</option>
							<option value="1">锁定</option>
						</select>
	</div>
	<script type="text/javascript">
		function birthday(){
			if($("#birthday").val()==""){
				alert("请选择日期");
			}
		}
		function marriageday(){
			if($("#marriageday").val()==""){
				alert("请选择日期");
			}
		}
	</script>
</body>
</html>
