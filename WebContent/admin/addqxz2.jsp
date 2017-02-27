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

<!-- 权限树 -->
<link rel="stylesheet" href="/zTree_v3-master/css/demo.css"
	type="text/css">
<link rel="stylesheet"
	href="/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">

<base target="_self">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel"> <header class="panel-heading">
				增加权限组 </header>
				<div class="panel-body">
					<form id="qxForm" class="form-horizontal adminex-form"
						method="post"
						action="${pageContext.request.contextPath}/privilege/addRole.do"
						target="_self">

						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">权限组名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name">
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">设置权限</label>
							<input type="hidden" id="id" name="role" value="">
							<ul id="treeDemo" class="ztree">
								<li><input type="checkbox" id="py" name="qxid"
									class="checkbox first" checked /></li>
							</ul>
						</div>

						<div class="row">
							<div class="col-lg-6">
								<button type="button" onclick="history.go(-1)"
									class="btn btn-info btn-block">返回</button>
							</div>
							<div class="col-lg-6">
								<input type="button" name="button" id="button"
									class="btn btn-success btn-block" onclick="onCheck()"
									value="提交" />
							</div>
						</div>
					</form>
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
	<!-- <script type="text/javascript" src="/zTree_v3-master/js/jquery-1.4.4.min.js"></script> -->
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.excheck.js"></script>

	<!--  判断复选框-->
	<script>
		function checkbox() {
			var str=document.getElementsByName("qxid");
			var objarray=str.length;
			var chestr="";
			for (i=0;i<objarray;i++) {
			  if(str[i].checked == true) {
			  	 chestr+=str[i].value+",";
			  }
			}
		    if(chestr == "") {
			  	alert("请先选择复选框～！");
			} else {
			  /* 	alert("复选框的值是："+chestr); */
			}
		    $("#qxForm").submit();
		    
		}
	</script>

	<SCRIPT type="text/javascript">
	
		var setting = {
			check: {
				enable: true,
				chkDisabledInherit: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"商户管理", open:true},
			{ id:2, pId:1, name:"新增商户", open:true},
			{ id:3, pId:1, name:"商户列表", open:true},
			{ id:4, pId:0, name:"商品管理", open:true},
			{ id:5, pId:4, name:"新增商品", open:true},
			{ id:6, pId:4, name:"商品列表", open:true},
			{ id:7, pId:4, name:"分类商品", open:true},
			{ id:8, pId:0, name:"用户管理", open:true},
			{ id:9, pId:8, name:"用户列表", open:true},
			{ id:10, pId:0, name:"订单管理", open:true},
			{ id:11, pId:10, name:"订单列表", open:true},
			{ id:12, pId:0, name:"财务管理", open:true},
			{ id:13, pId:12, name:"财务账户", open:true},
			{ id:14, pId:12, name:"提现列表", open:true},
			{ id:15, pId:0, name:"消息管理", open:true},
			{ id:16, pId:15, name:"发送消息", open:true},
			{ id:17, pId:15, name:"消息列表", open:true},
			{ id:18, pId:0, name:"系统设置", open:true},
			{ id:19, pId:18, name:"商户端版本更新", open:true},
			{ id:20, pId:18, name:"用户端版本更新", open:true},
			{ id:21, pId:0, name:"基本设置", open:true},
			{ id:22, pId:21, name:"城市管理", open:true},
			{ id:23, pId:22, name:"发票类型管理", open:true},
			{ id:24, pId:0, name:"管理员管理", open:true},
			{ id:25, pId:24, name:"管理员管理", open:true},
			{ id:26, pId:24, name:"权限组管理", open:true},
			{ id:27, pId:0, name:"系统统计", open:true},
			{ id:28, pId:0, name:"系统日志", open:true},
			{ id:29, pId:28, name:"操作日志", open:true},
			{ id:30, pId:28, name:"登录日志", open:true},
			{ id:31, pId:27, name:"系统统计表", open:true},
			{ id:33, pId:12, name:"交易记录", open:true},
			{ id:34, pId:27, name:"销量统计", open:true},
			
			
		];

		function disabledNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			disabled = e.data.disabled,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("Please select one node at first...");
			}
			if (disabled) {
				inheritParent = $("#py").attr("checked");
				inheritChildren = $("#sy").attr("checked");
			} else {
				inheritParent = $("#pn").attr("checked");
				inheritChildren = $("#sn").attr("checked");
			}

			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.setChkDisabled(nodes[i], disabled, inheritParent, inheritChildren);
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#disabledTrue").bind("click", {disabled: true}, disabledNode);
			$("#disabledFalse").bind("click", {disabled: false}, disabledNode);

		});
	
	</SCRIPT>

	<script type="text/javascript">
	function onCheck(e,treeId,treeNode){
		alert(22);
        var treeObj=$.fn.zTree.getZTreeObj("tree"),
        nodes=treeObj.getCheckedNodes(true),
        v="";
        alert(nodes.length);
        document.getElementById("role")[0].value=nodes.length;
        for(var i=0;i<nodes.length;i++){
        //v+=nodes[i].name + ",";
        alert(nodes[i].id+nodes[i].type); //获取选中节点的值
            }
        }
	</script>


</body>

</html>
