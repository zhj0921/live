<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="favicon.ico">
<link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/style.min.css?v=4.0.0" rel="stylesheet">

<!-- 表单验证 -->
<link rel="stylesheet" href="/validform-5.3.2/css/style.css"
	type="text/css" media="all" />
<link href="/validform-5.3.2/css/demo.css" type="text/css"
	rel="stylesheet" />

<base target="_self">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
				<button type="button" onclick="history.go(-1)"
					class="btn btn-info btn-xs">返回</button>
				<header class="panel-heading"> 编辑管理员 </header>
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/admin/update.do"
						method="post" class="form-horizontal adminex-form registerform"
						onSubmit="return ">
						<input type="hidden" name="id" value="${admin.id}">
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane active" id="home">
									<table
										class="display table table-bordered table-striped dataTable">
										<tr>
											<td class="need" style="width: 290px;">登录帐号</td>
											<td style="width: 505px;"><input type="text"
												id="loginname" onchange="funName();" nullmsg="请设置登录帐号！"
												value="${admin.name}" datatype="*4-18"
												errormsg="请输入登录帐号4-8位" class="form-control" name="name"></td>
										</tr>
										<tr>
											<td class="need" style="width: 290px;">登录密码</td>
											<td style="width: 505px;"><input type="password"
												class="form-control" datatype="*6-16" nullmsg="请设置登录密码！"
												value="${admin.password}" errormsg="请输入登录密码任意字符6-16位"
												name="password"></td>
										</tr>
										<tr>
											<td class="need" style="width: 290px;">管理员电话</td>
											<td style="width: 505px;"><input type="text"
												class="form-control"
												datatype="m | /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/i"
												value="${admin.telphone}" nullmsg="请设置管理员电话！"
												errormsg="填写管理员电话不合法！！" name="telphone"></td>
										</tr>
										<tr>
											<td class="need" style="width: 290px;">管理员名称</td>
											<td style="width: 505px;"><input type="text"
												value="${admin.adminname}" datatype="*2-8"
												errormsg="请输入管理员名称 任意字符2-8位" nullmsg="请设置管理员名称！"
												class="form-control" name="adminname"></td>
										</tr>
										<tr>
											<td class="need" style="width: 290px;">权限组名称</td>
											<td style="width: 505px;"><select id="role_id"
												class="form-control m-bot15" name="role_id">
													<option value="${admin.role_id}">${admin.roleName}</option>
													<c:forEach items="${roleList}" var="role">
														<option value="${role.id}">${role.name}</option>
													</c:forEach>
											</select></td>
										</tr>
									</table>
									<div class="col-md-12" style="margin-bottom: 20px;">
										<input type="submit" value="提 交" /> <input type="reset"
											value="重 置" /><span id="msgdemo2" style="margin-left: 30px;"></span>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				</section>
			</div>
		</div>
	</div>
	<script src="/js/jquery.min.js"></script>

	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>

	<!-- 表单验证 -->
	<script type="text/javascript">
		$(function() {
			//$(".registerform").Validform();  //就这一行代码！;
			$(".registerform").Validform({
				tiptype : function(msg, o, cssctl) {
					var objtip = $("#msgdemo2");
					cssctl(objtip, o.type);
					objtip.text(msg);
				},

			});
		})
	</script>

	<!-- 登录帐号校验 -->
	<script type="text/javascript">
		function funName() {
			var v = $("#loginname").val();
			v = v.trim();
			if (v != null && v != "") {
				$.get("${pageContext.request.contextPath}/admin/queryName.do",
						{
							loginname : v
						}, function(res) {
							if ("ok" == res) {
								/*  alert("该帐号可以！！"); */
								return;
							} else {
								alert("该帐号已存在！！！！");
								return;
							}
							;
						});
			}
		}
	</script>
</body>
</html>
