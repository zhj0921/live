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

<!-- 表单验证 -->
<link rel="stylesheet" href="/validform-5.3.2/css/style.css" type="text/css" media="all" />
<link href="/validform-5.3.2/css/demo.css" type="text/css" rel="stylesheet" />


<base target="_self">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel"> 
				<button type="button" onclick="history.go(-1)" class="btn btn-info btn-xs"> 返回</button>
				<header class="panel-heading">
				增加权限组 </header>
				<div class="panel-body">
					<form id="roleForm" method="post" class="form-horizontal adminex-form registerform"
						action="${pageContext.request.contextPath}/privilege/addRole.do"
						target="_self">

						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">权限组名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" datatype="*" nullmsg="请设置权限组名称！"  errormsg="输入权限组名称不合法！！">
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">设置权限</label> <input
								type="hidden" name="qxid">
							<ul id="functionTree" class="ztree">
							</ul>
						</div>

						<div class="row">
							<div class="">
								<input type="button" name="button" id="save" value="提交" />
									<input type="reset" value="重 置" />
									<span id="msgdemo2" style="margin-left:30px;"></span>
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
	
	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>
	<!-- 权限树 -->
	<!-- <script type="text/javascript" src="/zTree_v3-master/js/jquery-1.4.4.min.js"></script> -->
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.excheck.js"></script>


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
	<!-- 权限树 -->
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

		/* var zNodes =[
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
			{ id:23, pId:21, name:"发票类型管理", open:true},
			{ id:24, pId:0, name:"管理员管理", open:true},
			{ id:25, pId:24, name:"管理员管理", open:true},
			{ id:26, pId:24, name:"权限组管理", open:true},
			{ id:27, pId:0, name:"系统统计", open:true},
			{ id:28, pId:0, name:"系统日志", open:true},
			{ id:29, pId:28, name:"操作日志", open:true},
			{ id:30, pId:28, name:"登录日志", open:true},
			{ id:31, pId:27, name:"系统统计表", open:true},
			{ id:32, pId:12, name:"交易记录", open:true},
			{ id:33, pId:27, name:"销量统计", open:true},
			
			
		]; */
		
		
		var zNodes = ${priList};

		function disabledNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("functionTree"),
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
			$.fn.zTree.init($("#functionTree"), setting, zNodes);
			$("#disabledTrue").bind("click", {disabled: true}, disabledNode);
			$("#disabledFalse").bind("click", {disabled: false}, disabledNode);

		});
	
		
		zTreeObj.getCheckedNodes(true)
		
	</SCRIPT>

	<script type="text/javascript">
	// 点击保存
	$('#save').click(function(){
		//校验表单
		//var v = $('#roleForm').form('validate');
		var v = $('#roleForm');
		//判断校验是否成功
		if (v) {
			//选中功能权限树,获得id为ztree的对象
			var treeObj = $.fn.zTree.getZTreeObj("functionTree");
			//在提交表单之前将选中的checkbox收集对应的json数据
			var nodes = treeObj.getCheckedNodes(true);
			if(nodes.length<=0){
				alert("设置的权限不能为空！！");
				return ;
			}
			//创建数组，存放被选中的id
			var funIdsArr = new Array();
			//循环将id放入数组中
			for (var i = 0; i < nodes.length; i++) {
				funIdsArr.push(nodes[i].id);
			}
			//将存放id的数组转换为
			var ids = funIdsArr.join(',');
			//获得授权的
			$('input[name=qxid]').val(ids);
			//校验成功，提交表单
			$('#roleForm').submit();
		}
	});

	</script>


</body>

</html>
