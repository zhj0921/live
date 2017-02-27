<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
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
			<div class="col-md-12">
				<section class="panel"> <header
					class="panel-heading custom-tab "><button type="button" onclick="history.go(-1)" style="width: 60px;height: 30px;float: right;"
					class="btn btn-info">返回</button>
				<ul class="nav nav-tabs">
					<li id="ytxlb" class="active"><a href="#home" data-toggle="tab">礼物列表</a></li>
					<li id="wtxlb" class=""><a href="#about2" data-toggle="tab">评论列表</a></li>
					<li id="htxlb" class=""><a href="#about3" data-toggle="tab">回放列表</a></li>
				</ul>
				</header>
				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane active" id="home">
							<div class="space15" style="margin-bottom: 10px;"></div>
							<table
								class="table table-striped table-hover table-bordered dataTable"
								id="editable-sample" aria-describedby="editable-sample_info">
								<thead>
									<tr>
										<th style="text-align: center; width: 90px;">ID</th>
										<th style="text-align: center; width: 90px;">直播间ID</th>
										<th style="text-align: center; width: 90px;">送礼物人名称</th>
										<th style="text-align: center; width: 90px;">礼物名称</th>
										<th style="text-align: center; width: 90px;">送礼物时间</th>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${giveGift.list}" var="gg">
										<tr>
											<td align="center">${gg.id}</td>
											<td align="center">${gg.rid}</td>
											<td align="center">${gg.userName}</td>
											<td align="center">${gg.name}</td>
											<td align="center">${gg.time}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<ul class="pagination">
							   	<c:forEach items="${giveGift.pageView}" var="page">
									${page}
								</c:forEach>
							  </ul>
						</div>
						<div class="tab-pane" id="about2">
							<div class="adv-table editable-table ">
								<div class="clearfix"></div>
								<div class="space15" style="margin-bottom: 10px;"></div>
								<table
									class="table table-striped table-hover table-bordered dataTable">
									<thead>
										<tr>
											<th style="text-align: center; width: 90px;">ID</th>
											<th style="text-align: center; width: 90px;">直播间ID</th>
											<th style="text-align: center; width: 90px;">评论人名称</th>
											<th style="text-align: center; width: 159px;">评论内容</th>
											<th style="text-align: center; width: 90px;">评论时间</th>
										</tr>
									</thead>
									<tbody role="alert" aria-live="polite" aria-relevant="all">
										<c:forEach items="${comment.list}" var="c">
											<tr>
												<td align="center">${c.id}</td>
												<td align="center">${c.rid}</td>
												<td align="center">${c.userName}</td>
												<td align="center">${c.comment}</td>
												<td align="center">${c.time}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
									<ul class="pagination">
								   	<c:forEach items="${comment.pageView}" var="page">
										${page}
									</c:forEach>
								  </ul>
							</div>
						</div>
						
						<div class="tab-pane" id="about3">
							<div class="adv-table editable-table ">
								<div class="clearfix"></div>
								<div class="space15" style="margin-bottom: 10px;"></div>
								<table
									class="table table-striped table-hover table-bordered dataTable">
									<thead>
										<tr>
											<th style="text-align: center; width: 60px;">ID</th>
											<th style="text-align: center; width: 60px;">直播间ID</th>
											<th style="text-align: center; width: 90px;">用户名称</th>
											<th style="text-align: center; width: 90px;">视频地址</th>
											<th style="text-align: center; width: 130px;">开始时间</th>
											<th style="text-align: center; width: 130px;">结束时间</th>
											<th style="text-align: center; width: 120px;">时长</th>
											<th style="text-align: center; width: 90px;">历史观看人数</th>
											<th style="text-align: center; width: 90px;">播放次数</th>
										</tr>
									</thead>
									<tbody role="alert" aria-live="polite" aria-relevant="all">
										<c:forEach items="${playBack.list}" var="pb">
											<tr>
												<td align="center">${pb.id}</td>
												<td align="center">${pb.rid}</td>
												<td align="center">${pb.userName}</td>
												<td align="center">${pb.videoaddress}</td>
												<td align="center">${pb.starttime}</td>
												<td align="center">${pb.endtime}</td>
												<td align="center">${pb.time}</td>
												<td align="center">${pb.watchnumber}</td>
												<td align="center">${pb.playnumber}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination">
								   	<c:forEach items="${playBack.pageView}" var="page">
										${page}
									</c:forEach>
								  </ul>
							</div>
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
				
				$('#ytxlb').removeClass('active');
				$('#wtxlb').addClass('active');
				$('#htxlb').removeClass('active');

				$('#home').removeClass('active');
				$('#about2').addClass('active');
				$('#about3').removeClass('active');
			}
			if (Request.type == 3) {
				
				$('#ytxlb').removeClass('active');
				$('#wtxlb').removeClass('active');
				$('#htxlb').addClass('active');

				$('#home').removeClass('active');
				$('#about2').removeClass('active');
				$('#about3').addClass('active');
			}
		</script>
	<!-- 时间插件 -->
	<script src="/laydate/laydate.js"></script>
	
	<script>
	    $(window.onload = function () {
	        $("a").css("color","#676a6c");
	        $(".fadeInRight").css("color","#676a6c");
	    })
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
