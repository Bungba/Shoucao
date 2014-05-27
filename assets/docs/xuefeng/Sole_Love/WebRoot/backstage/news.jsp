<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

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
		<link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
		<script charset="utf-8" src="../kindeditor/kindeditor-all.js"></script>
		<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
		<script type="text/javascript" src="../jquery-1.7.2.js"></script>
		<script>
			KindEditor.ready(function(K) {
			var editor = K.create('textarea[name="content"]', {
				cssPath : '../kindeditor/plugins/code/prettify.css',
				uploadJson : '../kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '../kindeditor/jsp/file_manager_json.jsp',
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
				
		</script>
	</head>
	

<body id="dd">
	<form action="addNews.action" method="post">
	标题：<input type="text" name="title">
	活动时间:<input type="date" name="date">
	创建时间:<input type="date" name="createDate">
		<textarea name="content" style="width:700px;height:300px;visibility:hidden;"></textarea>
		<input type="submit" name="save" value="SAVE"  />
	</form>
	
	
	<br />
	
</body>
</html>
