<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

		
	<head>
		<meta charset="utf-8" />
		<title>Default Examples</title>
		<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		 <link rel="stylesheet" href="<%=path%>kindeditor/themes/default/default.css" />
		<script charset="utf-8" src="<%=path%>/kindeditor/kindeditor-all.js"></script>
		<script charset="utf-8" src="<%=path%>/kindeditor/lang/zh_CN.js"></script>
		<script type="text/javascript" src="<%=path%>/jquery-1.7.2.js"></script> 
		<script type="text/javascript" src="<%=path%>/artDialog4.1.7/artDialog.js?skin=default"></script>
		<script type="text/javascript">
		
			KindEditor.ready(function(K) {
			var editor = K.create('textarea[name="content"]', {
				cssPath : '<%=path%>/kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=path%>/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '<%=path%>/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					
					
				}
			});
			prettyPrint();
		});
					/* K('input[name=save]').click(function(e) {
						document.getElementById("c").innerHTML=editor.html();
					}); */
				function update() {
			art.dialog({
						title : '修改新闻',
						content : "确认修改吗？",
						width : '400px',
						button : [
								{
									name : '确定',
									focus : true,
									callback : function() {
											$.post(
															"updateHtml.action",
															{
																"id" : $("#id").val(),
																"title" : $("#title").val(),
																"content" : $("#content").val()
															},
															function(json) {
																if (json) {
																	//window.location.href = 'findnode.action?id=-1';
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改成功！</span>");
																	setTimeout("window.location.href = 'findNews.action?id="+$("#id").val()+"'",1500);
																} else {
																	art.dialog("<span style='color:red;font-weight:bolder;'>修改失败！</span>");
																	setTimeout("window.location.href = 'updateNews.action?id="+$("#id").val()+"'",1500);
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
	</head>
  
  <body>
    
	 <s:iterator value="html" id="li">
		<form action="updateHtml.action" method="post">
			<input type="text" style="display: none;" id="id" value="<s:property  value="#li.id"/>">
		标题：<input type="text" name="title" id="title" value="<s:property value="#li.title"/>">
			<textarea name="content" id="content" style="width:700px;height:300px;">
				<s:property escapeHtml="false" value="#li.content"/>
			</textarea>
			<input type="button"onclick="update()" value="update">
		</form>
	</s:iterator> 
  </body>
</html>
