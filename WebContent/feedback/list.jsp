<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<!-- 百度编辑器 -->
<script type="text/javascript"
	src="../ueditor1_4_3_2-utf8-jsp/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript"
	src="../ueditor1_4_3_2-utf8-jsp/utf8-jsp/ueditor.all.js"></script>
<!-- 百度编辑器end -->
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-12">
				<section class="panel"> <header
					class="panel-heading custom-tab ">
				<ul class="nav nav-tabs">
					<li id="wtxlb" class="active"><a href="#home"
						data-toggle="tab">用户反馈列表</a></li>
					<li id="ytxlb" class=""><a href="#about2" 
						data-toggle="tab">商户反馈列表</a></li>
				</ul>
				</header>
				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane active" id="home">
							<div class="clearfix">
							<div class="btn-group pull-right">
								<form
									action="${pageContext.request.contextPath}/feedback/list.do"
									method="post">
									<div class="input-group m-bot15"
										style="width: 160px; float: left; margin-right: 5px;">
										<input type="text" name="timeStartu" value="${timeStartu}"
											placeholder="请输入开始时间" class="form-control"
											onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
											readonly>
									</div>
									<div class="input-group m-bot15"
										style="width: 160px; float: left; margin-right: 5px;">
										<input type="text" name="timeEndu" value="${timeEndu}"
											class="form-control" placeholder="请输入截止时间"
											onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
											readonly>
									</div>
									<div class="input-group"
										style="float: left; margin-right: 5px;">
										<select id="states" class="form-control m-bot15" name="statusu">
											<option value="0">反馈状态</option>
											<option value="2"
												<c:if test="${statusu==2}">selected="selected"</c:if>>已处理</option>
											<option value="1"
												<c:if test="${statusu==1}">selected="selected"</c:if>>未处理</option>
										</select>
									</div>
									<input type="submit" style="float: left;"
										class="btn btn-primary" value="搜索">
								</form>
							</div>
							</div>
							<div class="space15" style="margin-bottom: 10px;"></div>
							<table
								class="table table-striped table-hover table-bordered dataTable"
								id="editable-sample" aria-describedby="editable-sample_info">
								<thead>
									<tr role="row">
										<th style="text-align: center; width: 40px;">ID</th>
										<th style="text-align: center; width: 70px;">用户昵称</th>
										<th style="text-align: center; width: 90px;">反馈类别</th>
										<th style="text-align: center; width: 200px;">反馈内容</th>
										<th style="text-align: center; width: 80px;">反馈时间</th>
										<th style="text-align: center; width: 60px;">反馈状态</th>
										<th style="text-align: center; width: 40px;">操作</th>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${paginationu.list}" var="feedBack">
										<tr>
											<td align="center">${feedBack.id}</td>
											<td align="center">${feedBack.userName}</td>
											<td align="center">${feedBack.typeName}</td>
											<td align="center">${feedBack.content}</td>
											<td align="center">${feedBack.addtimeStr}</td>
											<td align="center"><!-- 1：未处理，2：已处理 -->
												<c:if test="${feedBack.status==1}">未处理</c:if>
												<c:if test="${feedBack.status==2}">已处理</c:if>
											</td>
											<td align="center">
												<c:if test="${feedBack.status==1}">
												<div class="btn-group btn-group-xs">
													<c:if test="${feedBack.status==1}"><button onclick="handle('${feedBack.id}')"
														class="btn btn-success" type="button" style="color: #fff;">处理</button></c:if>
												</div>
												</c:if>
												<c:if test="${feedBack.status==2}">
												<div class="btn-group btn-group-xs">
													<button onclick="del('${feedBack.id}')"
														class="btn btn-warning" type="button" style="color: #fff;">删除</button>
												</div>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%-- <div class="row">
								<div class="col-lg-12">
									共计${paginationu.totalCount}条
									<c:forEach items="${paginationu.pageView}" var="page">
                                         ${page}
                                    </c:forEach>
								</div>
							</div> --%>
							<ul class="pagination">
								<c:forEach items="${pagination.pageView}" var="page">
									${page}
								</c:forEach>
							</ul>
						</div>
						<div class="tab-pane" id="about2">
							<div class="adv-table editable-table ">
								<div class="clearfix">
									<div class="btn-group pull-right">
										<form
											action="${pageContext.request.contextPath}/feedback/list.do?type=2"
											method="post">
											<div class="input-group m-bot15"
												style="width: 160px; float: left; margin-right: 5px;">
												<input type="text" name="timeStarts" value="${timeStarts}"
													placeholder="请输入开始时间" class="form-control"
													onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
													readonly>
											</div>
											<div class="input-group m-bot15"
												style="width: 160px; float: left; margin-right: 5px;">
												<input type="text" name="timeEnds" value="${timeEnds}"
													class="form-control" placeholder="请输入截止时间"
													onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
													readonly>
											</div>
											<div class="input-group"
												style="float: left; margin-right: 5px;">
												<select id="states" class="form-control m-bot15" name="statuss">
													<option value="0">反馈状态</option>
													<option value="2"
														<c:if test="${statuss==2}">selected="selected"</c:if>>已处理</option>
													<option value="1"
														<c:if test="${statuss==1}">selected="selected"</c:if>>未处理</option>
												</select>
											</div>
											
											<input type="submit" style="float: left;"
												class="btn btn-primary" value="搜索">
										</form>
									</div>
								</div>
								<div class="space15" style="margin-bottom: 10px;"></div>
								<table
								class="table table-striped table-hover table-bordered dataTable"
								id="editable-sample" aria-describedby="editable-sample_info">
								<thead>
									<tr role="row">
										<th style="text-align: center; width: 40px;">ID</th>
										<th style="text-align: center; width: 70px;">商户昵称</th>
										<th style="text-align: center; width: 90px;">反馈类别</th>
										<th style="text-align: center; width: 200px">反馈内容</th>
										<th style="text-align: center; width: 80px;">反馈时间</th>
										<th style="text-align: center; width: 60px;">反馈状态</th>
										<th style="text-align: center; width: 40px;">操作</th>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${paginations.list}" var="feedBack">
										<tr>
											<td align="center">${feedBack.id}</td>
											<td align="center">${feedBack.userName}</td>
											<td align="center">${feedBack.typeName}</td>
											<td align="center">${feedBack.content}</td>
											<td align="center">${feedBack.addtimeStr}</td>
											<td align="center"><!-- 1：未处理，2：已处理 -->
												<c:if test="${feedBack.status==1}">未处理</c:if>
												<c:if test="${feedBack.status==2}">已处理</c:if>
											</td>
											<td align="center">
												<c:if test="${feedBack.status==1}">
												<div class="btn-group btn-group-xs">
													<c:if test="${feedBack.status==1}"><button onclick="handle('${feedBack.id}')"
														class="btn btn-success" type="button" style="color: #fff;">处理</button></c:if>
												</div>
												</c:if>
												<c:if test="${feedBack.status==2}">
												<div class="btn-group btn-group-xs">
													<button onclick="del('${feedBack.id}')"
														class="btn btn-warning" type="button" style="color: #fff;">删除</button>
												</div>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
								<%-- <div class="row">
									<div class="col-lg-12">
										共计${paginations.totalCount}条
										<c:forEach items="${paginations.pageView}" var="page">
                                                        ${page}
                                        </c:forEach>
									</div>
								</div> --%>
								<ul class="pagination">
								<c:forEach items="${pagination.pageView}" var="page">
									${page}
								</c:forEach>
							</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

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

		<!-- 表单验证 -->
		<script type="text/javascript">
	$(function(){
		//$(".registerform").Validform();  //就这一行代码！;
		$(".registerform").Validform({
			tiptype:2
		});
	})
	</script>

		<script>
			function UrlSearch() {
				var name, value;
				var str = location.href; //取得整个地址栏
				var num = str.indexOf("?")
				str = str.substr(num + 1); //取得所有参数   stringvar.substr(start [, length ]

				var arr = str.split("&"); //各个参数放到数组里
				for (var i = 0; i < arr.length; i++) {
					num = arr[i].indexOf("=");
					if (num > 0) {
						name = arr[i].substring(0, num);
						value = arr[i].substr(num + 1);
						this[name] = value;
					}
				}
			}
			var Request = new UrlSearch(); //实例化
			if (Request.type == 2) {

				$('#wtxlb').removeClass('active');
				$('#ytxlb').addClass('active');

				$('#home').removeClass('active');
				$('#about2').addClass('active');
			}
		</script>
		<!-- 时间插件 -->
		<script src="/laydate/laydate.js"></script>
		
		<script type="text/javascript">
		//删除
		function del(iid) {
			if (!confirm('您确定要删除吗？')) {//true 确定。  false:取消
				return;
			}
			$.get("${pageContext.request.contextPath}/feedback/delete.do", {
				id : iid
			}, function(res) {
				if ("ok" == res) {
					alert("删除成功！！");
					location.href = "/feedback/list.do";
				} else {
					alert("删除失败,请与管理员联系！！");
					location.href = "/feedback/list.do";
				}
				;
			});
		}

		//处理
		function handle(iid) {
			//
			if (!confirm('您确定已处理吗？')) {//true 确定。  false:取消
				return;
			};
			$.get("${pageContext.request.contextPath}/feedback/handle.do",
				{id : iid},
				function(res) {
					if ("ok" == res) {
						alert("确定处理成功！！");
						//刷新列表
						location.href = "${pageContext.request.contextPath}/feedback/list.do";
					} else {
						alert("确定处理失败,请与管理员联系！！");
						//刷新列表
						location.href = "${pageContext.request.contextPath}/feedback/list.do";
					}
				});
		}
		
		</script>
		
		
		<script type="text/javascript">
		$(document).ready(function() {
			//限制字符个数
			$(".over_text").each(function() {
				var maxwidth = 8;
				if ($(this).text().length > maxwidth) {
					$(this).text($(this).text().substring(0, maxwidth));
					$(this).html($(this).html() + '…');
				}
			});
		});
	</script>
		
		<!-- 去除空的a标签 -->
	<script type="text/javascript">
		window.onload = function() {
			var as = document.getElementsByTagName("a");
			for (var i = 0; i < as.length; i++) {
				var txt = as[i].innerText || as[i].textContent;
				if (txt === "") {
					as[i].parentNode.removeChild(as[i]);
				}
			}
		};
	</script>
		
</body>

</html>
