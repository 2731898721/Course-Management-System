<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
String url = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<frameset rows="59,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="<%=url%>/common/top.jsp" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="213,*" frameborder="no" border="0" framespacing="0">
		<frame src="<%=url%>/common/left.jsp" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="<%=url%>/common/right.html" name="mainFrame"
			id="mainFrame" title="mainFrame" />
	</frameset>
</frameset>
<noframes>

	<body>
	</body>
</noframes>

</html>
