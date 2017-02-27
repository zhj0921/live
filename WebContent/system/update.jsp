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

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<section class="panel"> <header class="panel-heading">
				版本列表 </header>
				<div class="panel-body">
					<div class="adv-table editable-table ">
						<div class="clearfix">
							<div class="btn-group">
								<a href="/system/add.jsp" id="editable-sample_new"
									class="btn btn-primary"><i class="fa fa-plus">发布新版本</i> </a>
							</div>
						</div>
						<div class="space15" style="margin-bottom: 10px;"></div>
						<table
							class="table table-striped table-hover table-bordered dataTable"
							id="editable-sample" aria-describedby="editable-sample_info">
							<thead>
								<tr role="row">
									<th style="text-align: center; width: 90px;">版本号</th>
									<th style="text-align: center;">版本描述</th>
									<th style="text-align: center; width: 140px;">安装包</th>
							</thead>
							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<c:forEach items="${pagination.list}" var="android">
									<tr class="odd">
										<td align="center">${android.version}</td>
										<td align="center">${android.describe}</td>
										<td align="center"><a href="${android.path}"
											style="color: #fff;" class="btn btn-success">下载</a>
											<button onclick="del('${android.id}');"
												class="btn btn-danger" type="button">删除</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%-- <div class="row">
							<div class="col-lg-12">
								<c:forEach items="${pagination.pageView}" var="page">
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
			$.get("${pageContext.request.contextPath}/system/deleteAndroid.do",{id:iid},function(res){
				 if("ok"==res){
					  alert("删除成功！！");
					location.href = "/system/list.do";
				  }else{
					  alert("删除失败,请与管理员联系！！");
					location.href = "/system/list.do";
				  };
			});
		}
  
    </script>
    
    
    <script type="text/javascript">
			$(document).ready(function(){
					//限制字符个数
					$(".over_text").each(function(){
						var maxwidth=20;
						if($(this).text().length>maxwidth){
							$(this).text($(this).text().substring(0,maxwidth));
							$(this).html($(this).html()+'…');
						}
					});
				});
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