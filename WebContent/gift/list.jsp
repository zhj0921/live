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
						<h5>礼物列表</h5>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-sm btn-primary  pull-left"
									data-toggle="modal" data-target="#myModal2">添加礼物</button>
								<div class="input-group pull-right">
									<form
										action="${pagecontext.request.contextPath}/room/giftList.do">
										<select class="form-control input-sm" name="specialeffects"
											style="width: 120px; margin-right: 5px;">
											<option value="2">礼物特效</option>
											<option value="0"
												<c:if test="${specialeffects==0}">selected="selected"</c:if>>普通特效</option>
											<option value="1"
												<c:if test="${specialeffects==1}">selected="selected"</c:if>>特殊特效</option>
										</select>
										<select class="form-control input-sm" name="status"
											style="width: 120px; margin-right: 5px;">
											<option value="2">状态</option>
											<option value="0"
												<c:if test="${status==0}">selected="selected"</c:if>>启用</option>
											<option value="1"
												<c:if test="${status==1}">selected="selected"</c:if>>禁用</option>
										</select>
										<button type="submit" class="btn btn-sm btn-primary ">
											搜索</button>
									</form>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped table-bordered">
								<thead>
									<tr>

										<th style="text-align: center; width: 60px;">ID</th>
										<th style="text-align: center; width: 90px;">礼物名称</th>
										<th style="text-align: center; width: 90px;">礼物图片</th>
										<th style="text-align: center; width: 130px;">所需豆豆</th>
										<th style="text-align: center; width: 130px;">礼物特效</th>
										<th style="text-align: center; width: 130px;">添加时间</th>
										<th style="text-align: center; width: 60px;">状态</th>
										<th style="text-align: center; width: 130px;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pagination.list}" var="list">
										<tr>

											<td align="center">${list.id}</td>
											<td align="center">${list.name}</td>

											<td align="center"><img alt=""
												src="${list.giftpicture}" height="50px" width="50px">
											</td>
											<td align="center">${list.voucher}</td>
											<td align="center"><c:if test="${list.specialeffects==0}">
													<span style="color: #9A2EFE;">普通特效</span></c:if>
												<c:if test="${list.specialeffects==1}">
													<span style="color: #FFBF00">特殊特效</span></c:if></td>
											<td align="center">${list.time}</td>
											<td align="center"><c:if test="${list.status==0}">
													<span style="color: green;">启用</span></c:if>
												<c:if test="${list.status==1}">
													<span style="color: red;">禁用</span></c:if></td>
											<td align="center">
												<div class="btn-group btn-group-xs">
						
														<c:if test="${list.status==1}">
															<button type="button" class="btn btn-success"
															onclick="enabled('${list.id}');">启用</button>
														</c:if>
														<c:if test="${list.status==0}">
															<button type="button" class="btn btn-warning"
															onclick="disable('${list.id}');">禁用</button>
														</c:if>
														<button onclick="editC('${list.id}');"
														class="btn btn-info" type="button" data-toggle="modal" data-target="#myModal3">编辑</button>
														<button onclick="del('${list.id}');" type="button" class="btn btn-danger">删除</button>
														<%-- <a href="${pageContext.request.contextPath}/cm/lookCmDoctors.do?id=${list.id}"
															class="btn btn-primary">查看</a>	 --%>
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
	<div class="modal inmodal" id="myModal2" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<a type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</a>
					<h2 class="modal-title">增加礼物</h2>
				</div>
				<form id="jvForm" class="registerform">
					<div class="modal-body" style="overflow: hidden;">
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>礼物姓名</label>
							<div class="col-sm-12">
								<input id="egiftName" type="text" name="name" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>礼物图片</label>
							<div class="col-sm-12">
								<input id="eTp" type="file" name="pic" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>兑换所需豆豆</label>
							<div class="col-sm-12">
								<input id="eVoucher" type="text" name="voucher" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>礼物特效</label>
							<div class="col-sm-12">
								<select class="form-control input-sm" name="specialeffects"
									style="width: 120px; margin-right: 5px;">
									<option value="0"
										<c:if test="${specialeffects==0}">selected="selected"</c:if>>普通特效</option>
									<option value="1"
										<c:if test="${specialeffects==1}">selected="selected"</c:if>>特殊特效</option>
								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="fun();">保存</button>
						<span id="msgdemo2" style="margin-left: 30px;"></span>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal inmodal" id="myModal3" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<a type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</a>
					<h2 class="modal-title">编辑礼物</h2>
				</div>
				
		
					<form id="jvForm" class="registerform"
						enctype="multipart/form-data"
						action="${pageContext.request.contextPath}/room/editSaveGift.do"
						method="post" onSubmit="return yanzhengz();">
				
					<input id="cid" type="hidden" name="id">
					<div class="modal-body" style="overflow: hidden;">
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>礼物名称</label>
							<div class="col-sm-12">
								<input id="ename" type="text" name="name" class="form-control"
									placeholder="请输入礼物名称" datatype="*" nullmsg="请设置礼物名称！"
									errormsg="输入礼物名称不合法！">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>选择图片</label>
							<div class="col-sm-12">
								<img id="epic" alt="" src="" style="width: 250px; ">
									<input type="hidden"
									name="pichidden" id='' >
									<input type="file" 
									name="pic" class="form-control">
									
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>所需豆豆</label>
							<div class="col-sm-12" >
								<input id="evoucher" type="text" name="voucher" style="width: 200px;" class="form-control"
									placeholder="请输入兑换所需的豆豆" datatype="*" nullmsg="请设置兑换所需的豆豆！"
									errormsg="输入数量不合法！">
							</div> 
						</div>
						
						<div class="form-group">
							<label class="col-sm-12"><span class="need">*</span>礼物特效</label>
							<div class="col-sm-12">
								<select id="especialeffects"
									class="form-control input-sm" name="specialeffects"
									style="width: 120px; margin-right: 5px;">
									<!-- <option value="2">全部</option> -->
									<option value="0"
										<c:if test="${specialeffects==0}">selected="selected"</c:if>>普通特效</option>
									<option value="1"
										<c:if test="${specialeffects==1}">selected="selected"</c:if>>特殊特效</option>
								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">保存</button>
						<span id="msgdemo2" style="margin-left: 30px;"></span>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="/js/jquery.min.js?v=2.1.4"></script>
	<script src="/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="/js/jquery.form.js" type="text/javascript"></script>
	<!-- 表单验证 -->
	<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript"
		src="/validform-5.3.2/plugin/passwordStrength/passwordStrength-min.js"></script>

	<!-- 时间插件 -->
	<script src="/laydate/laydate.js"></script>
	<script type="text/javascript">
	
	<script type="text/javascript">
		$(function() {
			//$(".registerform").Validform();  //就这一行代码！;
			$(".registerform").Validform({
				tiptype : function(msg, o, cssctl) {
					var objtip = $("#msgdemo2");
					cssctl(objtip, o.type);
					objtip.text(msg);
				},
				label : ".label",
				showAllError : true,
				datatype : {
					"zh1-6" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,6}$/
				},
				ajaxPost : true

			});
		});
	</script>

	<!-- 编辑回显 -->
	<script type="text/javascript">
		function editC(iid) {
			$.get(
				"${pageContext.request.contextPath}/room/editGift.do",
				{
					id : iid
				}, function(data) {
					if (data) {
						$('#ebutton').click();
						$("#ename").val(data.name);
						$("#evoucher").val(data.voucher);
						$("#especialeffects").val(data.specialeffects);
						$("#cid").val(data.id);
						/* $("#picPath").val(data.img); */
						$("#pichidden").val(data.giftpicture);
						$("#epicin").val(data.giftpicture);
						
						$("#epic").attr("src", data.giftpicture);
					} else {
						alert("编辑查询失败,请与管理员联系！！");
						location.href = "/room/giftList.do";
					}
					;
				});

		}
	</script>

	<!-- 编辑保存 -->
	<script type="text/javascript">
	function yanzhengz() {
			if(!yanzheng('ename','','请输入礼物名称！')){
				return false;
			}
			
			/* if(!yanzheng('evoucher','','请输入所需豆豆！')){
				return false;
			} */
			
			var reg = /\s/g;
			var forms = $(".form-control");
			for(var i=0;i<forms.length;i++){
				if(reg.test(forms[i].value)){
					alert("不能有空格!");
					return false;
				}
			}
			
			return true;
			
		} 
	</script>



	<!-- 增加 -->
	<script type="text/javascript">
		function fun() {
			
			if(!yanzheng('egiftName','','请输入姓名！')){
				return
			}
			
			
			if(!yanzheng('eTp','','请添加礼物图片！')){
				return
			}
			
			if(!yanzheng('eVoucher','','请输入对话所需的豆豆！')){
				return
			}
	
			
			var options = {
				url : "${pageContext.request.contextPath}/room/addGift.do",
				type : "POST",
				beforeSend:function(){
					var reg = /\s/g;
					var forms = $(".form-control");
					for(var i=0;i<forms.length;i++){
						if(reg.test(forms[i].value)){
							alert("不能有空格!");
							return false;
						}
					}
					
				},
				success : function(data) {
					if ("ok" == data) {
						alert("提交成功！！");
						location.href = "/room/giftList.do";
					} else {
						alert("提交失败,请与管理员联系！！");
						location.href = "/room/giftList.do";
					};
				}
			};
			$("#jvForm").ajaxSubmit(options);
		}
	</script>


	<script type="text/javascript">
		//删除
		function del(iid) {
			if (!confirm('您确定要删除吗？')) {//true 确定。  false:取消
				return;
			}
			$
			.get(
					"${pageContext.request.contextPath}/room/deleteGift.do",
					{
						id : iid
					}, function(res) {
						if ("ok" == res) {
							alert("删除成功！！");
							location.href = "/room/giftList.do";
						} else {
							alert("删除失败,请与管理员联系！！");
							location.href = "/room/giftList.do";
						}
						;
					});
		}

		//启用
		function enabled(iid) {

			//
			if (!confirm('您确定启用吗？')) {//true 确定。  false:取消
				return;
			}
			;
			$.get(
			"${pageContext.request.contextPath}/room/enabledGift.do",
			{
				id : iid
			},
			function(res) {
				if ("ok" == res) {
					alert("启用成功！！");
					//刷新列表
					location.href = "${pageContext.request.contextPath}/room/giftList.do";
				} else {
					alert("启用失败,请与管理员联系！！");
					//刷新列表
					location.href = "${pageContext.request.contextPath}/room/giftList.do";
				}
			});
		}

		//禁用
		function disable(iid) {

			//
			if (!confirm('您确定禁用吗？')) {//true 确定。  false:取消
				return;
			}
			;
			$
			.get(
					"${pageContext.request.contextPath}/room/disableGift.do",
					{
						id : iid
					},
					function(res) {
						if ("ok" == res) {
							alert("禁用成功！！");
							location.href = "${pageContext.request.contextPath}/room/giftList.do";
						} else {
							alert("禁用失败,请与管理员联系！！");
							location.href = "${pageContext.request.contextPath}/room/giftList.do";
						}
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

