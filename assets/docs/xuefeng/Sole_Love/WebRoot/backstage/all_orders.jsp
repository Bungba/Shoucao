<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<title>My JSP 'all_order.jsp' starting page</title>

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
<script type="text/javascript">
	function select1(obj) {
		var oid=obj.parentNode.parentNode.cells[0].innerHTML;
		var tableObj = document.getElementById("os1");
		var tableInfo = "<table border='1px'><tr><td>产品名称</td><td>产品价格</td><td>产品数量</td><td>金额</td></tr>";
		for ( var i = 1; i < tableObj.rows.length; i++) { //遍历Table的所有Row
			tableInfo+="<tr>";
			if(tableObj.rows[i].cells[0].innerText==oid){
				for ( var j = 1; j < tableObj.rows[i].cells.length; j++) { //遍历Row中的每一列
					tableInfo +="<td>"+ tableObj.rows[i].cells[j].innerText; //获取Table中单元格的内容
					tableInfo += "</td>";
				}
			}
			tableInfo+="</tr>";
		}
		tableInfo +="</table>";
	document.getElementById("os").innerHTML=tableInfo;
		 art.dialog({
					title : '详细订单信息',
					content : document.getElementById("os"),
					width : '500px',
					button : [
							{
								name : '关闭',
								focus : true,
								}
							]
				}); 
		 
	}
	function updateFlag(obj){
		var oid=obj.parentNode.parentNode.cells[0].innerHTML;
		window.location.href="updateFlag?id="+oid;
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
			<td>用户姓名</td>
			<td>城市</td>
			<td>收件人</td>
			<td>折扣</td>
			<td>快递公司</td>
			<td>是否付款</td>
			<td>配送地址</td>
			
			<td>用户手机号码</td>
			<td>订单原始总金额</td>
			<td>打折后的订单金额</td>
			<td>定制信息</td>
			<td>详细</td>
			<td>订单状态</td>
		</tr>
		<c:forEach items="${order}" var="o">
			<tr>
				<td style="display: none;" id="orderId">${o[0]}</td>
				<td>${o[17]}</td>
				<td>${o[1]}</td>
				<td>${o[4]}</td>
				<td>${o[6]}</td>
				<td>${o[8]}</td>
				<td><c:choose>
						<c:when test="${o[10]=='0'}">
								没
							</c:when>
						<c:otherwise>
								已付
							</c:otherwise>
					</c:choose>
				</td>
				<td>${o[3]}</td>
				<td>${o[23]}</td>
				<td>￥<fmt:formatNumber pattern="#,#00.0#">${o[15]*o[16]}</fmt:formatNumber>元</td>
				<td>￥<fmt:formatNumber pattern="#,#00.0#">${o[15]*o[16]*o[6]}</fmt:formatNumber>元</td>
				<td><a href="selectGreeting?id=${o[24]}">查看</a></td>
				<td><input type="button" onclick="select1(this)" value="详细" />
				</td>
				<td>
					<c:choose>
						<c:when test="${o[12]==false}">
								<input type="button" value="正常" onclick="updateFlag(this)">
							</c:when>
						<c:otherwise>
								<input type="button" value="无效" onclick="updateFlag(this)">
							</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div id="os" style="display: none;">
		
	</div>


	<div style="display: none;">
		<table border="1px" id="os1">
			<tr>
				<td>产品名称</td>
				<td>产品价格</td>
				<td>产品数量</td>
				<td>金额</td>
			</tr>
			<c:forEach items="${os}" var="s">
				<tr>
					<td style="display: none;">${s[0].oid}</td>
					<td>${s[1].title}</td>
					<td>${s[1].des}</td>
					<td>${s[1].count}</td>
					<td>${s[1].price}</td>
				</tr>
			</c:forEach>
		</table>
	</div>












</body>
</html>
