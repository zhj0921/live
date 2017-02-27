<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<html>

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

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<section class="panel"> <header class="panel-heading">
				管理列表 </header>
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix">
							<div class="btn-group">
								<a href="${pageContext.request.contextPath}/admin/add.do"
									id="editable-sample_new" class="btn btn-primary" target="_self"><i
									class="fa fa-plus">增加管理员</i> </a>
							</div>
						</div>
						<div class="space15" style="margin-bottom: 10px;"></div>
						<table
							class="table table-striped table-hover table-bordered dataTable"
							id="editable-sample" aria-describedby="editable-sample_info">
							<thead>
								<tr role="row">
									<th style="text-align: center; width: 130px;">帐号</th>
									<th style="text-align: center; width: 130px;">手机号</th>
									<th style="text-align: center; width: 129px;">角色名称</th>
									<th style="text-align: center; width: 129px;">帐号状态</th>
									<th style="text-align: center; width: 130px;">最后登录时间</th>
									<th style="text-align: center; width: 145px;">操作</th>
							</thead>
							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<c:forEach items="${pagination.list}" var="admin">
									<tr class="odd">
										<td align="center">${admin.name}</td>
										<td align="center">${admin.telphone}</td>
										<td align="center">${admin.roleName}</td>
										<td align="center"><c:if test="${admin.states==1}">启用</c:if>
											<c:if test="${admin.states==2}">禁用</c:if></td>
										<td align="center">${admin.lastLoginTime}</td>
										<td align="center">
											<div class="btn-group btn-group-xs">
												<c:if test="${admin.states==1}">
													<button onclick="disable('${admin.id}');"
														class="btn btn-primary" type="button">禁用</button>
												</c:if>
												<c:if test="${admin.states==2}">
													<button onclick="enabled('${admin.id}');"
														class="btn btn-success" type="button">启用</button>
												</c:if>
												<a
													href="${pageContext.request.contextPath}/admin/edit.do?id=${admin.id}&pageNo=${pageNo}"
													style="color: #fff;" class="btn btn-warning" target="_self"
													type="button">编辑</a>
												<%-- <a href="${pageContext.request.contextPath}/admin/states.do?id=${admin.id}&pageNo=${pageNo}" class="btn btn-primary" type="button" >启用</a> --%>
												<button onclick="del('${admin.id}');" class="btn btn-danger"
													type="button">删除</button>
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
				</section>
			</div>
		</div>
	</div>
	<script src="/js/jquery.min.js?v=2.1.4"></script>
	<script src="/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="/js/content.min.js?v=1.0.0"></script>
	<script src="/js/plugins/iCheck/icheck.min.js"></script>
	<script src="/js/demo/peity-demo.min.js"></script>
	<script type="text/javascript">
	//删除
	function del(iid){
		 if(!confirm('您确定要删除吗？')){//true 确定。  false:取消
			 return;
		}
		$.get("${pageContext.request.contextPath}/admin/delete.do",{id:iid}, function(res){
			 if("ok"==res){
				  alert("删除成功！！");
				location.href = "${pageContext.request.contextPath}/admin/list.do";
			  }else{
				  alert("删除失败,请与管理员联系！！");
				location.href = "${pageContext.request.contextPath}/admin/list.do";
			  };
		});
	}
	
	//启用
	function enabled(iid){
		
		if(!confirm('您确定启用吗？')){//true 确定。  false:取消
			return;
		};
		$.get("${pageContext.request.contextPath}/admin/enabled.do",{id:iid}, function(res){
			  if("ok"==res){
				  alert("启用成功！！");
				//刷新列表
				location.href = "${pageContext.request.contextPath}/admin/list.do";
			  }else{
				  alert("启用失败,请与管理员联系！！");
				//刷新列表
				location.href = "${pageContext.request.contextPath}/admin/list.do";
			  }
		});
	}

	//禁用
	function disable(iid){
		if(!confirm('您确定禁用吗？')){//true 确定。  false:取消
			return;
		};
		$.get("${pageContext.request.contextPath}/admin/disable.do",{id:iid}, function(res){
			  if("ok"==res){
				  alert("禁用成功！！");
		 		location.href = "${pageContext.request.contextPath}/admin/list.do";
			  }else{
				  alert("禁用失败,请与管理员联系！！");
		 		location.href = "${pageContext.request.contextPath}/admin/list.do";
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

</html>
