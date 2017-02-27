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
						<h5>用户列表</h5>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-12">
								<div class="input-group pull-right">
									<form
										action="${pagecontext.request.contextPath}/user/list.do">
										<input type="text" placeholder="昵称查询" name="name"
											value="${name}" class="input-sm form-control pull-left"
											style="width: 160px; margin-right: 5px;"> <input
											type="text" placeholder="手机号查询" name="phone" value="${phone}"
											class="input-sm form-control  pull-left"
											style="width: 160px; margin-right: 5px;">
											<select
												class="form-control input-sm" name="ispower"
												style="width: 120px; margin-right: 5px;">
												<option value="0">直播状态</option>
												<option value="1"
													<c:if test="${ispower==1}">selected="selected"</c:if>>启用直播</option>
												<option value="2"
													<c:if test="${ispower==2}">selected="selected"</c:if>>禁止直播</option>
											</select>
											<select
												class="form-control input-sm" name="status"
												style="width: 120px; margin-right: 5px;">
												<option value="0">状态</option>
												<option value="1"
													<c:if test="${status==1}">selected="selected"</c:if>>启用</option>
												<option value="2"
													<c:if test="${status==2}">selected="selected"</c:if>>禁用</option>
											</select>

										<button type="submit"
											class="btn btn-sm btn-primary  pull-left">搜索</button>
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
										<th style="text-align: center;">昵称</th>
										<th style="text-align: center;">手机号</th>
										<th style="text-align: center;">金额</th>
										<th style="text-align: center;">注册时间</th>
										<th style="text-align: center;">登陆日期</th>
										<th style="text-align: center;">登陆次数</th>
										<th style="text-align: center;">直播状态</th>
										<th style="text-align: center;">状态</th>
										<th style="text-align: center;">操作</th>
									</tr>
								</thead>
								<tbody>
					<c:forEach items="${pagination.list}" var="list">
						<tr>
							<td align="center">${list.id}</td>
							<td align="center">${list.nickname}</td>
							<td align="center">${list.phone}</td>
							<td align="center">${list.memberMoney}</td>
							<td align="center">${list.memberRegTime}</td>
							<td align="center">${list.loginTime}</td>
							<td align="center">${list.loginnum}</td>
							<td align="center"><c:if test="${list.ispower==1}">
								<span style="color: green;">启用</span></c:if>
								<c:if test="${list.ispower==2}">
								<span style="color: red;">禁用</span></c:if></td>
							<td align="center"><c:if test="${list.status==1}">
								<span style="color: green;">启用</span></c:if>
								<c:if test="${list.status==2}">
								<span style="color: red;">禁用</span></c:if></td>
							<td align="center" >
								<!-- 启用/禁用 -->
								<div class="btn-group btn-group-xs">
	
									<c:if test="${list.status==2}">
										<button type="button" class="btn btn-info"
										onclick="enabled('${list.id}');">启用</button>
									</c:if>
									<c:if test="${list.status==1}">
										<button type="button" class="btn btn-warning"
										onclick="disable('${list.id}');">禁用</button>
									</c:if>
									<c:if test="${list.ispower==2}">
										<button type="button" class="btn btn-primary"
										onclick="liveEnabled('${list.id}');">启用直播</button>
									</c:if>
									<c:if test="${list.ispower==1}">
										<button type="button" class="btn btn-danger"
										onclick="liveDisable('${list.id}');">禁用直播</button>
									</c:if>
									<a href="${pagecontext.request.contextPath}/user/look.do?id=${list.id}" class="btn btn-success">查看</a>
	
	
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
    </div>
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>
    
    
    <script type="text/javascript">
		//删除
		function del(iid) {
			if (!confirm('您确定要删除吗？')) {//true 确定。  false:取消
				return;
			}
			$.get("${pageContext.request.contextPath}/user/user_deluser.do", {
				id : iid
			}, function(res) {
				if ("ok" == res) {
					alert("删除成功！！");
					location.href="${pageContext.request.contextPath}/user/list.do";
				} else {
					alert("删除失败,请与管理员联系！！");
					location.href="${pageContext.request.contextPath}/user/list.do";
				};
			});
		}

		//启用 function
		function enabled(iid) {
			//
			if (!confirm('您确定启用吗？')) {//true确定。  false:取消
				return;
			};
			$.get( "${pageContext.request.contextPath}/user/isstatus.do",
				 { id : iid },
				function(res) {
					if ("ok" == res) {
						alert("启用成功！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/user/list.do";
					} else {
						alert("启用失败,请与管理员联系！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/user/list.do";
					}
				});
		}

		//禁用 function
		function disable(iid) {
			//
			if (!confirm('您确定禁用吗？')) {//true确定。  false:取消
				return;
			};
			$.get("${pageContext.request.contextPath}/user/nostatus.do",
				{id : iid},
				function(res) {
					if ("ok" == res) {
						alert("禁用成功！！");
						location.href="${pageContext.request.contextPath}/user/list.do";
					} else {
						alert("禁用失败,请与管理员联系！！");
						location.href="${pageContext.request.contextPath}/user/list.do";
					}
				});
		}
		
		
		//启用直播 function
		function liveEnabled(iid) {
			//
			if (!confirm('您确定启用吗？')) {//true确定。  false:取消
				return;
			};
			$.get( "${pageContext.request.contextPath}/user/isispower.do",
				 { id : iid },
				function(res) {
					if ("ok" == res) {
						alert("启用成功！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/user/list.do";
					} else {
						alert("启用失败,请与管理员联系！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/user/list.do";
					}
				});
		}

		//禁用直播 function
		function liveDisable(iid) {
			//
			if (!confirm('您确定禁用吗？')) {//true确定。  false:取消
				return;
			};
			$.get("${pageContext.request.contextPath}/user/noispower.do",
				{id : iid},
				function(res) {
					if ("ok" == res) {
						alert("禁用成功！！");
						location.href="${pageContext.request.contextPath}/user/list.do";
					} else {
						alert("禁用失败,请与管理员联系！！");
						location.href="${pageContext.request.contextPath}/user/list.do";
					}
				});
		}

	
	</script>
	
	<!-- 去除空的a标签 -->
	<script type="text/javascript">
		window.onload = function() {
		    var as = document.getElementsByTagName("a");
		    for(var i = 0; i < as.length; i++) {
		        var txt = as[i].innerText || as[i].textContent;
		        if(txt === "") {
		            as[i].parentNode.removeChild(as[i]);
		        }
		    }
		};
	</script>

</body>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->

</html>
