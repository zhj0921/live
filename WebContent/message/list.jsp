<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
<link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/date/css/pikaday.css" />
<!-- 表单验证 -->
<link rel="stylesheet" href="/validform-5.3.2/css/style.css"
	type="text/css" media="all" />
<link href="/validform-5.3.2/css/demo.css" type="text/css"
	rel="stylesheet" />

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>消息列表</h5>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="btn-group">
								<a
									href="${pageContext.request.contextPath}/message/sendToAll.jsp"
									id="editable-sample_new" class="btn btn-primary" target="_self"><i
									class="fa fa-plus">广播</i> </a>
							</div>
							<div class="btn-group pull-right">
								<form
									action="${pagecontext.request.contextPath}/message/list.do">

									<div class="input-group m-bot15"
										style="width: 160px; float: left; margin-right: 5px;">
										<input type="text" name=timeStart value="${timeStart}"
											placeholder="请输入开始时间" class="form-control"
											onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
											readonly>
									</div>
									<div class="input-group m-bot15"
										style="width: 160px; float: left; margin-right: 5px;">
										<input type="text" name="timeEnd" value="${timeEnd}"
											class="form-control" placeholder="请输入截止时间"
											onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
											readonly>
									</div>
									<%-- <select
												class="form-control input-sm" name="playbackstatus"
												style="width: 120px; height:35px; margin-right: 5px;">
												<option value="2">回放状态</option>
												<option value="0"
													<c:if test="${playbackstatus==0}">selected="selected"</c:if>>启用回放</option>
												<option value="1"
													<c:if test="${playbackstatus==1}">selected="selected"</c:if>>禁止回放</option>
											</select> --%>
									<button type="submit" class="btn btn-sm btn-primary  pull-left"
										style="height: 35px;">搜索</button>
								</form>
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<!-- <th>选择</th> -->
									<th style="text-align: center;">ID</th>
									<th style="text-align: center;">用户昵称</th>
									<th style="text-align: center;">用户/商户</th>
									<th style="text-align: center;">标题</th>
									<th style="text-align: center;">内容</th>
									<th style="text-align: center;">发送时间</th>
									<th style="text-align: center;">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pagination.list}" var="list">
									<tr>
										<!-- <td>
                                        <input type="checkbox" class="i-checks" name="input[]">
                                    </td> -->
										<td align="center">${list.id}</td>
										<td align="center"><c:if test="${list.uid==0}">
												<span style="color: red;">该消息为广播</span>
											</c:if> <c:if test="${list.uid!=0}">
												<span style="color: green;">${list.userName}</span>
											</c:if></td>
										<td align="center"><c:if test="${list.utype==1}">用户</c:if>
											<c:if test="${list.utype==2}">商户</c:if></td>
										<td align="center">${list.title}</td>
										<td align="center" class="over_text">${list.content}</td>
										<td align="center">${list.addtime}</td>
										<td align="center">
											<!-- 启用/禁用 -->
											<div class="btn-group btn-group-xs">

												<%-- <c:if test="${list.playbackstatus==0}">
										<button type="button" class="btn btn-danger"
										onclick="liveDisable('${list.id}');">禁用回放</button>
									</c:if>
									<c:if test="${list.playbackstatus==1}">
										<button type="button" class="btn btn-primary"
										onclick="liveEnabled('${list.id}');">启用回放</button>
									</c:if> --%>
												<a
													href="${pagecontext.request.contextPath}/message/look.do?id=${list.id}"
													class="btn btn-success">查看</a>

											</div>


										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
	




	<script src="/js/jquery.min.js?v=2.1.4"></script>
	<script src="/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>

	<!-- 时间插件 -->
	<script src="/laydate/laydate.js"></script>



	<script type="text/javascript">
		//删除
		function del(iid) {
			if (!confirm('您确定要删除吗？')) {//true 确定。  false:取消
				return;
			}
			$
					.get(
							"${pageContext.request.contextPath}/room/user_deluser.do",
							{
								id : iid
							},
							function(res) {
								if ("ok" == res) {
									alert("删除成功！！");
									location.href = "${pageContext.request.contextPath}/room/list.do";
								} else {
									alert("删除失败,请与管理员联系！！");
									location.href = "${pageContext.request.contextPath}/room/list.do";
								}
								;
							});
		}

		//启用直播 function
		function liveEnabled(iid) {
			//
			if (!confirm('您确定启用吗？')) {//true确定。  false:取消
				return;
			}
			;
			$
					.get(
							"${pageContext.request.contextPath}/room/isplaybackstatus.do",
							{
								id : iid
							},
							function(res) {
								if ("ok" == res) {
									alert("启用成功！！");
									//刷新列表
									location.href = "${pageContext.request.contextPath}/room/list.do";
								} else {
									alert("启用失败,请与管理员联系！！");
									//刷新列表
									location.href = "${pageContext.request.contextPath}/room/list.do";
								}
							});
		}

		//禁用直播 function
		function liveDisable(iid) {
			//
			if (!confirm('您确定禁用吗？')) {//true确定。  false:取消
				return;
			}
			;
			$
					.get(
							"${pageContext.request.contextPath}/room/noplaybackstatus.do",
							{
								id : iid
							},
							function(res) {
								if ("ok" == res) {
									alert("禁用成功！！");
									location.href = "${pageContext.request.contextPath}/room/list.do";
								} else {
									alert("禁用失败,请与管理员联系！！");
									location.href = "${pageContext.request.contextPath}/room/list.do";
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
<!-- Mirrored from www.zi-han.net/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->

</html>
