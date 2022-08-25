<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String url = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" rel="stylesheet" href="<%=url%>/resources/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="kindeditor/kindeditor.js" ></script>
<script language="JavaScript" type="text/javascript">
	KE.show({
		id : 'remark'
	})

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
	<form action="/selectingcourses/AdminController" id="fom" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="<%=url%>/resources/images/nav04.gif"
								class="style10"></td>
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
												cellspacing="1" class="CContent">
												<tr>
													<th class="tablestyle_title">管理员信息录入</th>
												</tr>

												<tr>
													<td class="font42">

														<table border="0" cellpadding="0" cellspacing="0"
															style="width: 100%">
															<TR>
																<TD width="100%">
																	<fieldset style="height: 100%;">
																		<legend>管理员信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1"
																			style="width: 100%">

																			<tr>
																				<td>管理员名称 :</td>
																				<td><input type="text" class="text"
																					style="width: 154px" value="" name="name" /></td>
																			</tr>
																			<tr>
																				<td>管理员账号:</td>
																				<td><input type="text" class="text"
																					style="width: 154px" value="" name="adminUsername" /></td>
																			</tr>
																			<tr>
																				<td>管理员密码:</td>
																				<td><input type="password" class="text"
																					style="width: 154px" value="" name="adminPassword" /></td>
																			</tr>

																			<tr>
																				<td>联系方式:</td>
																				<td><input class="text" style="width: 154px"
																					value="" name="tel" /></td>
																			</tr>
																			<tr>
																				<td>电子邮箱:</td>
																				<td><input class="text" style="width: 154px"
																					value="" name="email" /></td>
																			</tr>
																			<tr>
																				<td>性别:</td>
																				<td><input type="radio" class="text"
																					style="width: 50px" name="sex" value="男" />男 <input
																					type="radio" class="text" style="width: 50px"
																					name="sex" value="女" />女</td>
																			</tr>
																			<tr>
																				<td>描述:</td>
																				<td colspan="3"><textarea name="remark"
																						id="remark" cols="100" rows="8" name="info"></textarea></td>
																			</tr>
																		</table>
																		<br />
																	</fieldset>
																</td>
															</tr>
														</table>
													</td>
												<tr>
													<td colspan="2" align="center" height="50px"><input
														type="submit" name="Submit" value="保存" class="button" />
														<input type="reset" name="Submit" value="重置"
														class="button" /></td>

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
