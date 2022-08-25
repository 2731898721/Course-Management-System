<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="/selectingcourses/resources/css/style.css"
	type="text/css" media="all" />

<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该学生基本信息，您可以修改或保留该信息。');
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
	<form action="/selectingcourses/StudentController?flag=add"
		method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0">
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
					<table id="subtree1" style="DISPLAY: '';" width="100%" border="0"
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
													<th class="tablestyle_title">学生信息录入</th>
												</tr>
												<tr>
													<td class="CPanel">
														<table border="0" cellpadding="0" cellspacing="0"
															style="width: 100%">
															<tr>
																<td width="100%">
																	<fieldset style="height: 100%;">
																		<legend>学生信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1"
																			style="width: 100%">
																			<tr>
																				<td>学生名称:</td>
																				<td><input name="name" type="text" class="text"
																					style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>学生学号:</td>
																				<td><input class="text" type="password"
																					name="pwd" style="width: 154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>联系方式:</td>
																				<td><input class="text" name='tel'
																					style="width: 154px" value="" /></td>
																			</tr>
																			<tr style="width: '10px'">
																				<td>性别:</td>
																				<td><input type="radio" name='sex' value="男" />男
																					<input type="radio" name='sex' value="女" />女</td>
																			</tr>
																			<tr>
																				<td>出生日期:</td>
																				<td><input type="date" name='birthday' /></td>
																			</tr>
																			<tr>
																				<td>教师:</td>
																				<td><select name="teacher" class="text">
																						<option selected="selected">==请选择==</option>
																						<optgroup label="---JavaSE---"></optgroup>
																						<option value="丁玉婷">丁玉婷</option>
																						<optgroup label="---JavaEE---"></optgroup>
																						<option value="李晃合">李晃合</option>
																						<optgroup label="---Oracle---"></optgroup>
																						<option value="顾佳雨">顾佳雨</option>
																						<optgroup label="---Android---"></optgroup>
																						<option value="张梅梅">张梅梅</option>
																				</select></td>
																			</tr>
																			<tr>
																				<td>班级:</td>
																				<td><select name="class" class="text">
																						<option selected="selected">==请选择==</option>
																						<option value="一班">一班</option>
																						<option value="二班">二班</option>
																						<option value="三班">三班</option>
																				</select></td>
																			</tr>

																			<tr>
																				<td>课程:</td>
																				<td><select name="kecheng" class="text">
																						<option selected="selected">==请选择==</option>
																						<option value="JavaSE">JavaSE</option>
																						<option value="JavaEE">JavaEE</option>
																						<option value="Oracle">Oracle</option>
																						<option value="Android">Android</option>
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
											</table>
									<tr>
										<td colspan="2" align="center" height="50px"><input
											type="submit" name="Submit" value="保存" class="button" /></td>
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
