<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
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
	<form action="/selectingcourses/TeacherController?flag=addTeacher"
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
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="CContent">
												<tr>
													<th class="tablestyle_title">教师信息录入</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table border="0" cellpadding="0" cellspacing="0"
															style="width: 100%">
															<tr>
																<td width="100%">
																	<fieldset style="height: 100%;">
																		<legend>教师信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1"
																			style="width: 100%">

																			<tr>
																				<td>教师名称:</td>
																				<td><input name="name" type="text" class="text"
																					style="width: 154px" /></td>
																			</tr>

																			<tr>
																				<td>生日:</td>
																				<td><input class="text" type="date"
																					name="birthday" style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>性别:</td>
																				<td><input type="radio" name="sex" value="男" />男
																					<input name="sex" type="radio" value="女" />女</td>
																			</tr>
																			<tr>
																				<td>联系方式:</td>
																				<td><input class="text" name="phone"
																					style="width: 154px" value="" /></td>
																			</tr>

																			<tr>
																				<td>入职时间:</td>
																				<td><input type="date" name="date"
																					style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td valign="top">教师唯一编号:</td>
																				<td><input type="text" name="num" /></td>
																			</tr>
																			<tr>
																				<td valign="top">描述:</td>
																				<td colspan="3"><textarea name="remark"
																						cols="100" rows="8"></textarea></td>
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
														type="submit" value="保存" class="button" /></td>
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