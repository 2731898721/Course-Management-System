<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" rev="stylesheet"
	href="/selectingcourses/resources/css/style.css" type="text/css"
	media="all" />

<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该课程基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
</script>
<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
</head>

<body>
	<form action="/selectingcourses/CourseController?flag=add"
		method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62"
								background="/selectingcourses/resources/images/nav04.gif"
								class="style10"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY:;" width="100%" border="0"
						cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" class="CContent">
												<tr>
													<th class="tablestyle_title">课程信息录入</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table border="0" cellpadding="0" cellspacing="0"
															style="width: 100%">
															<tr>
																<td width="100%">
																	<fieldset style="height: 100%;">
																		<legend>课程信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1"
																			style="width: 100%">
																			<tr>
																				<td>课程名称:</td>
																				<td><input type="text" name="classname"
																					class="text" style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>课程编号:</td>
																				<td><input class="text" type="text" name="num"
																					style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>学分:</td>
																				<td><input class="text" type="number" Max="5"
																					Min="1" name="score" style="width: 154px" value="" /></td>
																			</tr>

																			<tr>
																				<td>开课日期:</td>
																				<td><input type="date" name='begintime'
																					style="width: 154px" value="" /></td>
																			</tr>

																			<tr>
																				<td>结课日期:</td>
																				<td><input type="date" name="endtime"
																					style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>任课教师:</td>
																				<td><select name="tea">
																						<option value="0">---请选择任课教师----</option>
																						<c:forEach items="${listclass}" var="var"
																							varStatus="v">
																							<option value="${var.teacher.tid}">${v.count}---${var.teacher.tname}</option>
																						</c:forEach>
																				</select></td>
																			</tr>
																		</table>
																		<br />
																	</fieldset>
																</td>

															</tr>

														</table>
													</td>
												</tr>
												<tr>
													<td colspan="2" align="center" height="50px"><input
														type="submit" value="保存" class="button" /><input
														type="reset" value="重置" class="button" /></td>
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