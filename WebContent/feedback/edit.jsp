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
<link rel="stylesheet" href="/validform-5.3.2/css/style.css" type="text/css" media="all" />
<link href="/validform-5.3.2/css/demo.css" type="text/css" rel="stylesheet" />
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-12">
				<section class="panel"> <header
					class="panel-heading custom-tab ">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">编辑反馈类型</a></li>
				</ul>
				</header>
				<form id="jvForm" class="form-horizontal adminex-form registerform"
					enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/feedback/update.do"
					method="post" >
					<!-- 根据id更新 所以提交表单时要有id -->
					<input type="hidden" name="id" value="${feedBackType.id}">
					<div class="panel-body">
						<div class="tab-content">
							<div class="tab-pane active" id="home">
								<table class="display table table-bordered table-striped dataTable">
									<tr>
										<td class="need" style="width:290px;">反馈类型</td>
										<td style="width:505px;">
										<input type="text" value="${feedBackType.name}" name="name" class="form-control" datatype="*" nullmsg="请设置反馈类型！"  errormsg="输入的反馈类型不合法！" /></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
			<div class="col-md-12" style="margin-bottom: 20px;">
				<input type="submit" value="提 交" /> <input type="reset" value="重 置" /><span id="msgdemo2" style="margin-left:30px;"></span>
			</div>
			</form>
			</div>

		</div>
	</div>
	</section>


	<script src="/js/jquery.min.js?v=2.1.4"></script>
	<script src="/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="/js/content.min.js?v=1.0.0"></script>
	<script src="/js/plugins/iCheck/icheck.min.js"></script>
	<script src="/js/demo/peity-demo.min.js"></script>

	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>
	
	<script src="/laydate/laydate.js"></script>

<!-- 表单验证 -->
	<script type="text/javascript">
$(function(){
	//$(".registerform").Validform();  //就这一行代码！;
		
	$(".registerform").Validform({
		tiptype:function(msg,o,cssctl){
			var objtip=$("#msgdemo2");
			cssctl(objtip,o.type);
			objtip.text(msg);
		},
		
	});
})
</script>
</body>

</html>
