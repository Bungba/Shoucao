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


</head>

<body>


	<a href="mobileAndEmail.jsp">手机邮箱验证 </a>
	<br />
	<a href="register.jsp">用户注册 </a>
	<br />
	<a href="login.jsp">登陆</a>
	<br />
	
	<a href="products.jsp">产品列表 </a>
	<br />
	<!-- <a href="submit_order.jsp">添加（提交）订单 </a>
	<br /> -->
	<a href="addresses.jsp">当前用户的配送地址列表 </a>
	<br />
	<a href="all_order.jsp">用户所用订单 </a>
	<br />
	<a href="expresses.jsp">配送方式列表 </a>
	<br />
	<a href="greetings.jsp">当前user使用过的祝福列表 </a>
	<br />
	<!-- <a href="create_greeting.jsp">创建祝福 </a>
	<br /> -->
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
	<br /><br /><br /><br />
	<a href="order.action">订单管理 </a>
	<br />
	<a href="usermess.action">用户管理 </a>
	<br />
	<a href="productsmess.action">品牌信息管理 </a>
	<br />
	<a href="greetingMess.action">定制管理</a>
	<br />
	<a href="news.action">新闻查看</a>
	<br />
	<hr>
	<a href="xinsc/register01.html">注册</a><br />
	<a href="xinsc/user_details.html">用户信息</a><br>
	<a href="xinsc/apply.html">首草使者申请</a><br>
	<a href="xinsc/account.html">我的账号</a><br>
	<a href="xinsc/ranking.html">排行榜</a><br>
	<a href="xinsc/rebate.html">积分</a><br>
	<a href="xinsc/sales_manage.html">积分详细</a><br>
	<a href="xinsc/confirm_shop.html">购买</a><br>
</body> 
</html>
