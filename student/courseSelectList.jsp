<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="/selectingcourses/resources/css/css.css" rel="stylesheet"
	type="text/css" />
<script type="text/JavaScript">
	
</script>
<link href="/selectingcourses/resources/css/style.css" rel="stylesheet"
	type="text/css" />
<script language="JavaScript">
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "yuangong.htm";
		document.getElementById("fom").submit();
	}
	function alter(id) {
		var flag = window.confirm("确定要提交选中的课程吗！！")
		if (flag) {
			window.location.href = "/selectingcourses/StudentController?flag=selected&id="
					+ id
		}
	}
</script>
</head>
<body>
	<form
		action="/selectingcourses/StudentController?flag=selected&id= ${student.id}"
		name="fom" id="fom" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62"
								style="background: url(/selectingcourses/resources/images/nav04.gif)"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY:" width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">

												<tr>
													<td height="20" colspan="15" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title"
														style="text-align: center;">以下课程可选</td>
												</tr>
												<tr>
													<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="9%" height="20" align="center" bgcolor="#EEEEEE">课程编号</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">课程名称</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">学分</td>
													<td width="8%" align="center" bgcolor="#EEEEEE">开课时间</td>
													<td width="8%" align="center" bgcolor="#EEEEEE">结课时间</td>
													<td width="7%" align="center" bgcolor="#EEEEEE">任课老师</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">联系电话${listclass}</td>
												</tr>
												<c:forEach items="${info}" var="info">
													<tr>
														<td bgcolor="#FFFFFF"><input type="checkbox"
															name="checked" value="${info.cid}" /></td>
														<td height="20" bgcolor="#FFFFFF">${info.num}</td>
														<td bgcolor="#FFFFFF">${info.className}</td>
														<td bgcolor="#FFFFFF">${info.score}</td>
														<td bgcolor="#FFFFFF">${info.begintime}</td>
														<td bgcolor="#FFFFFF">${info.endtime}</td>
														<td height="20" bgcolor="#FFFFFF">${info.teacher.tname}</td>
														<td height="20" bgcolor="#FFFFFF">${info.teacher.tel}</td>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center" height="40px"><input type="submit"
					value="提交选中课程" class="button" /></td>
			</tr>

		</table>
	</form>
</body>

</html>