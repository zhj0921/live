<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
    <title>供应商列表</title> 
<link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
 <link href="/css/base.css" rel="stylesheet">
<link rel="stylesheet" href="/custom/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="/custom/easyui/icon.css">
<link rel="stylesheet" href="/css/providers.css">

<script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/datagrid-detailview.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css"> -->
	<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script> -->
	
		<script type="text/javascript">
		function doSearch(){
			$('#tt').datagrid('load',{
				name: $('#name').val(),
				phone: $('#phone').val()
			});
		}
	</script>
	
	
	
</head> 
<body>
    <div class="container">
       <table id="tt" class="easyui-datagrid" style="width:100%;height:669px;"
			url="${pagecontext.request.contextPath}/user/list1.do" toolbar="#tb"
			title="用户列表" 
			rownumbers="true" pagination="true"
			singleSelect="false"
                autoRowHeight="false"
                 fitColumns="true"
                striped="true"
                checkOnSelect="false"
                selectOnCheck="false"
                collapsible="true"
                
                
                pageSize="10"
			>
            <thead>
                <tr>
                    <th field="id" width="40" align="center">ID</th>
                    <th field="nickname" width="90" align="center">昵称</th>
                    <th field="phone" width="100" align="center">手机号</th>
                    <th field="memberMoney" width="90" align="center">金额</th>
                    <th field="memberRegTime" width="160" align="center">注册时间</th>
                    <th field="loginTime" width="160" align="center">登录日期</th>
                    <th field="loginnum" width="90" align="center">登录次数</th>
                    <th field="ispower" width="90" align="center">直播状态</th>
                    <th field="status" width="90" align="center">状态</th>
                    <th field="link" width="90" align="center">操作</th>
                    
                    
                </tr>
            </thead>
            
            
            
            
        </table>
        <div id="tb" style="padding:3px">
			<span>昵称:</span>
			<input id="name" style="line-height:26px;border:1px solid #ccc"><!--  -->
			<span>手机号:</span>
			<input id="phone" style="line-height:26px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">搜索</a>
		</div>
    </div>
	
   <script type="text/javascript" src="/custom/jquery.min.js"></script>
    <script type="text/javascript" src="/custom/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/custom/easyui-lang-zh_CN.js"></script>

	   
    
</body> 
</html>
