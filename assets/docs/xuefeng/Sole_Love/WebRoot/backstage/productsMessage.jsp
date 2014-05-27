<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'productsMessage.jsp' starting page</title>
    
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
    		<td>id</td>
    		<td>产品名称</td>
    		<td>产品描述</td>
    		<td>产品图片</td>
    		<td>产品价格</td>
    		<td>库存数量</td>
    		<td>下架／上架</td>
    		<td>修改库存</td>
    	</tr>
    	
    	<s:iterator value="list" id="l">
    		<tr onclick="checkdate(this)">
	    		<td><s:property value="#l.id"/></td>
	    		<td><s:property value="#l.title"/></td>
	    		<td><s:property value="#l.des"/></td>
	    		<td>
	    			<img src="<s:property value="#l.thumbnail"/>">
	    		</td>
	    		<td><s:property value="#l.price"/></td>
	    		<td><s:property value="#l.count"/></td>
    		</tr>
    	</s:iterator>
    </table>
    <input type="button" value="修改" onclick="update()"><!--改为 添加  -->
    <input type="button" value="删除" onclick="del()">
    <s:debug></s:debug>
    
    <script type="text/javascript">
    	function checkdate(obj){
			obj.style.background="#CCC";
			$("#id").val(obj.cells[0].innerHTML.trim());
			$("#title").val(obj.cells[1].innerHTML.trim());
			$("#des").val(obj.cells[2].innerHTML.trim());
			$("#thumbnail").val(obj.cells[3].innerHTML.trim());
			$("#price").val(obj.cells[4].innerHTML.trim());
			$("#count").val(obj.cells[5].innerHTML.trim());
		}
		
		function update() {
			art.dialog({
						title : '修改产品信息',
						content : document.getElementById("updateProducts"),
						width : '400px',
						button : [
								{
									name : '确定',
									focus : true,
									callback : function() {
											$.post(
															"updateproduct.action",
															{
																"id" : $("#id").val(),
																"title" : $("#title").val(),
																"des" : $("#des").val(),
																"thumbnail" : $("#thumbnail").val(),
																"price" : $("#price").val(),
																"count" : $("#count").val()
															},
															function(json) {
																if (json) {
																	//window.location.href = 'findnode.action?id=-1';
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改成功！</span>");
																	setTimeout("window.location.href = 'productsmess.action'",1500);
																} else {
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改失败！</span>");
																	setTimeout("window.location.href = 'productsmess.action'",1500);
																}
															}, "json");
										}
									}
								, {
									name : '取消',
								} ]
					});
		}
		function del() {
			art.dialog({
						title : '删除产品',
						content : "此操作不可恢复！确定要删除吗？",
						width : '400px',
						button : [
								{
									name : '确定删除',
									focus : true,
									callback : function() {
											$.post(
															"delProduct.action",
															{
																"id" : $("#id").val()
															},
															function(json) {
																if (json) {
																	//window.location.href = 'findnode.action?id=-1';
																	art.dialog("<span style='color:red;font-weight:bolder;'>删除成功！</span>");
																	setTimeout("window.location.href = 'productsmess.action'",1500);
																} else {
																	art.dialog("<span style='color:red;font-weight:bolder;'>删除失败！</span>");
																	setTimeout("window.location.href = 'productsmess.action'",1500);
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
    <div id="updateProducts" style="display: none;">
			<input type="text" id="id" style="display: none;">
			产品名称:<input type="text" id="title"><br>
			产品描述:<input type="text" id="des"><br>
			产品图片:<input type="text" id="thumbnail"><br>
			产品价格:<input type="text" id="price"><br>
			库存数量:<input type="text" id="count" >
	</div>
  </body>
</html>
