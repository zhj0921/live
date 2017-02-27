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
				编辑权限组 </header>
				<div class="panel-body">
					<form id="roleForm" class="form-horizontal registerform"
						method="post"
						action="${pageContext.request.contextPath}/privilege/updateRole.do"
						target="_self">
						<input type="hidden" name="id" value="${role.id}">
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">权限组名称</label>
							<div class="col-sm-10">
								<input type="text" value="${role.name}" class="form-control" name="name" datatype="*" nullmsg="请设置权限组名称！"  errormsg="输入权限组名称不合法！！">
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
	<!-- 权限树 -->
	<!-- <script type="text/javascript" src="/zTree_v3-master/js/jquery-1.4.4.min.js"></script> -->
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
		src="/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
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

		var zNodes = ${priList};
			
		function disabledNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("functionTree"),
			disabled = e.data.disabled,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请至少选择一个！！");
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
		var qxList = ${qxList};
		$(document).ready(function(){
			$.fn.zTree.init($("#functionTree"), setting, qxList);
			$("#disabledTrue").bind("click", {disabled: true}, disabledNode);
			$("#disabledFalse").bind("click", {disabled: false}, disabledNode);
			/* selectNodes(); */
		});
	
		
		 /* zTreeObj.getCheckedNodes(true) ; */
		
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
	<script type="text/javascript">
	
		function selectNodes(){
			var treeObj = $.fn.zTree.getZTreeObj("functionTree");//先获取这个树
			var nodes = treeObj.getNodes();//获取树上的所有节点
			var qxList = ${qxInt};//后台model域中的数据也就是拥有的权限id
			alert(qxList[0]);
			if (nodes.length>0) {
				for (var i=0, l=qxList.length; i<l; i++) {//循环拥有节点的id
					//treeObj.selectNode(nodes[qxList[i]]);
				alert(qxList[i]);
				alert(nodes[qxList[i]]);
					treeObj.checkNode(nodes[qxList[i]]);//选中节点
				}
			}
		};
	</script>
	


	
</body>

</html>