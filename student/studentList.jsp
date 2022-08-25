<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.List"
	import="com.changke.selectclasssystem.model.Student"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href="/selectingcourses/resources/css/style.css" rel="stylesheet"
	type="text/css" />

<script language="javascript">
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
	function confirmDelete(sno) {
		var flag = window.confirm("您确认要删除该学生吗");
		if (flag) {
			window.location.href = "servlet/DeleteStudentServlet?sno=" + sno;
		}
	}
	function chick(id) {
		var flag = window.confirm("确定要删除吗！！")
		if (flag) {
			window.location.href = "/selectingcourses/StudentController?flag=del&id="
					+ id
		}
	}

	function update(id) {
		var flag = window.confirm("确定要修改信息吗！！")
		if (flag) {
			window.location.href = "/selectingcourses/StudentController?flag=update&id="
					+ id
		}
	}

	function clean() {
		document.getElementById("banji").value = "-1";
		document.getElementById("clazz").value = "";
		document.getElementById("name").value = "";
	}
</script>
</head>
<body>
	<form action="/selectingcourses/StudentController" name="fom" id="fom"
		method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62"
								style="background: url(/selectingcourses/resources/images/nav04.gif)">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="24"><img
											src="/selectingcourses/resources/images/ico07.gif" width="20"
											height="18" /></td>
										<td><select name="banji" id="banji">
												<option value="-1">--请选择班级--</option>
												<c:forEach items="${queryClass}" var="clazz">
													<option value="${clazz.cid} ">${clazz.cname}
														<c:if test="${clazz.cid == cid }">selected</c:if>
													</option>
												</c:forEach>
										</select>&emsp; <span class="newfont06">姓名 : </span><input name="name"
											id="name" type="text" size="12" value="${name}" /> <span
											class="newfont06">课程 : </span><input name="clazz" type="text"
											size="12" id="clazz" value="${kecheng}" /> <input
											name="Submit" type="submit" class="right-button02"
											value="查 询" /> <input type="button" class="right-button02"
											onclick="clean()" value="清 空" /></td>
									</tr>
								</table>
							</td>
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
														style="text-align: center;">学生列表</td>
												</tr>
												<tr>
													<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="9%" height="20" align="center" bgcolor="#EEEEEE">序号</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">姓名</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">学号</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">性别</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">出生年月</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">班级</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">课程</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">教师</td>
													<td width="19%" align="center" bgcolor="#EEEEEE">操作</td>
												</tr>
												<c:set var="count" value="0"></c:set>
												<c:set var="manCount" value="0"></c:set>
												<c:if test="${empty listAll}">
													<tr bgcolor="gainsboro">
														<td colspan="10" align="center">数据库学生为空！！！</td>
													</tr>
												</c:if>
												<c:if test="${not empty listAll}">
													<c:forEach items="${listAll}" var="student" varStatus="var">
														<c:if test="${var.index % 2 == 0 }">
															<tr bgcolor="#FFFFFF">
														</c:if>
														<c:if test="${var.index % 2 != 0 }">
															<tr bgcolor="gainsboro">
														</c:if>
														<td><input type="checkbox" name="delid" /></td>
														<td height="20">${var.count}</td>
														<td>${student.name}</td>
														<td>${student.number}</td>
														<td>${student.sex}</td>
														<td>${student.birthday}</td>
														<td>${student.grade}</td>
														<td>${student.course}</td>
														<td height="20">${student["tname"]}</td>
														<td><a href="javascript:chick(${student.id})">删除</a>
															&nbsp;|&nbsp;<a href='javascript:;'
															onclick="update(${student.id})">修改</a></td>
														</tr>
														<c:set var="count" value="${count+1}"></c:set>
														<c:if test="${student.sex eq '男'}">
															<c:set var="manCount" value="${manCount+1}"></c:set>
														</c:if>
													</c:forEach>
													<td colspan="10" bgcolor="#FFFFFF">总人数：${count}
														&nbsp;&nbsp; 男生人数：${manCount}&nbsp;&nbsp;女生人数：${count - manCount}</td>
												</c:if>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="6"><img
								src="/selectingcourses/resources/images/spacer.gif" width="1"
								height="1" /></td>
						</tr>
						<tr>
							<td height="33">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0" class="right-font08">
									<tr>
										<td width="50%">共 <span class="right-text09">5</span> 页 |
											第 <span class="right-text09">1</span> 页
										</td>
										<td width="49%" align="right">[<a href="#"
											class="right-font08">首页</a> | <a href="#"
											class="right-font08">上一页</a> | <a href="#"
											class="right-font08">下一页</a> | <a href="#"
											class="right-font08">末页</a>] 转至：
										</td>
										<td width="1%">
											<table width="20" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="1%"><input name="textfield3" type="text"
														class="right-textfield03" size="1" /></td>
													<td width="87%"><input name="Submit23222"
														type="submit" class="right-button06" value=" " /></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
