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
<base target="_self">

<link rel="stylesheet" href="/validform-5.3.2/css/style.css"
	type="text/css" media="all" />
<link href="/validform-5.3.2/css/demo.css" type="text/css"
	rel="stylesheet" />

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel"> <header class="panel-heading">
				<span style="font-size: 16px; font-weight: bold;">消息广播 </span></header>
				<div class="panel-body">
					<input id="regid" type="hidden" name="token" >
					<input id="uid" type="hidden" name="uid" >
					<form id="messageForm" class="form-horizontal adminex-form registerform"
						method="post" >
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane active" id="home">
									<table
										class="display table table-bordered table-striped dataTable">
										<tr>
											<td style="width: 160px; text-align: center;"><span
												class="need">*</span>标题</td>
											<td><input id="title" type="text" name="title"
												style="width: 480px; text-align: center;"
												class="form-control" datatype="*1-18" nullmsg="请设置标题！"
												errormsg="标题至少1个字符,最多18个字符！" /></td>

										</tr>

										<tr>
											<td style="text-align: center;"><span class="need">*</span>内容</td>
											<td><textarea  id="content"
													style="width: 480px; height: 120px" name="content"
													class="form-control" datatype="*" nullmsg="请设置内容！"
													errormsg="内容不合法！"></textarea></td>
										</tr>

									</table>
								</div>
							</div>
							<div class="col-md-12" style="margin-bottom: 20px;">
								<input type="button" onclick="withdrawal()" value="提 交" class="btn btn-primary"/> <input type="reset"
									value="重 置" class="btn btn-warning"/>
								<button type="button" onclick="history.go(-1)"
									style="width: 58px; height: 34px; "
									class="btn btn-info btn-xs">返回</button>
								<span id="msgdemo2" style="margin-left: 30px;"></span>
							</div>
						</div>
					</form>
				</div>
				</section>
			</div>
		</div>
	</div>
	<script src="/js/jquery.min.js?v=2.1.4"></script>
	
	
	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>

	<script src="/laydate/laydate.js"></script>

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

	<script type="text/javascript">
		function GetUrlPara(){
			var url = document.location.toString();
			var arrUrl = url.split("?");
			var para = arrUrl[1];
			var params1 = para.split("&");
			var para1 = params1[0];
			var para2 = params1[1];
			if(para1){
				var arrparams = para1.split("=");
				var params = arrparams[1];
				alert(params);
				if(params==''){
					alert("该用户不具备单播条件！");
					return;
				}else{
					alert(params);
					$("#regid").val(params);
				}
			}
			if(para2){
				var arrparams = para2.split("=");
				var params = arrparams[1];
				alert(params);
				if(params==''){
					alert("该用户不具备单播条件！");
					return;
				}else{
					alert(params);
					$("#uid").val(params);
				}
			}
		}
		GetUrlPara()
	</script>


	<script type="text/javascript">
		function withdrawal() {
			var title1 = $("#title").val();
			var content1 = $("#content").val();
			var regid1 = $("#regid").val();
			var uid1 = $("#uid").val();
			var n = 0;
			$.post("${pageContext.request.contextPath}/message/sendMessage.do", {
				title : title1,
				content : content1,
				token : regid1,
				uid : uid1,
			}, function(res) {	
				if(res == 1){
					$.post("${pageContext.request.contextPath}/message/saveMessage.do", {
						title : title1,
						content : content1,
						uid : uid1,
					}, function(res) {
						alert("消息推送并保存成功，请耐心等待！");
						window.location.href="/message/list.do";
					});
				}else{
					alert("消息推送失败，请与系统管理员联系！");
				};
			});
		}
	</script>

</body>

</html>
