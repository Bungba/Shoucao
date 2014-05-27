<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectGreeting.jsp' starting page</title>
    
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
    <table border="1px">
    	<tr>
    		<td>头像</td>
    		<td>背景</td>
    		<td>语音</td>
    		<td>祝福代码</td>
    		
    	</tr>
    	<s:iterator value="glist" id="l">
    		<tr>
	    		<td>
	    			<img alt="" src="greetingInfo/<s:property value="#l.charactor"/>">
	    		</td>
	    		<td>
	    			<img alt="" src="greetingInfo/<s:property value="#l.background"/>" style="width: 50px;">
	    		</td>
	    		<td>
	    			<audio alt="" src="greetingInfo/<s:property value="#l.sound"/>" controls="controls"></audio>
	    		</td>
	    		<td>
	    			<s:property value="#l.code"/>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>

  </body>
</html>
