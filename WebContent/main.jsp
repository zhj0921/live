<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/index_v3.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:46 GMT -->

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <!-- Morris -->
    <link href="/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <!-- Gritter -->
    <link href="/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-success pull-right">总</span>
                        <h5>总流水</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins">${grossed}</h1>
                        <small>总收入</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-info pull-right">总</span>
                        <h5>订单总数</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins">${orderCount}</h1>
                        <small>总订单</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-primary pull-right">今天</span>
                        <h5>今日订单</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins">${orderCountByToday}</h1>
                        <small>新订单</small>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span class="label label-danger pull-right">今天</span>
                        <h5>新用户</h5>
                    </div>
                    <div class="ibox-content">
                        <h1 class="no-margins">${userByToday}</h1>
                        <small>新用户</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>最新订单</h5>
                            </div>
                            <div class="ibox-content">
                                <table class="table table-hover no-margins">
                                    <thead>
                                        <tr>
                                            <th>姓名</th>
                                            <th>订单编号</th>
                                            <th>服务名称</th>
                                            <th>服务类型</th>
                                            <th>价格</th>
                                            <th>下单时间</th>
                                            <th>状态</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${twentyOrder}" var="twentyOrder">
                                    <tbody>
                                        <tr>
                                            <td>${twentyOrder.userName}</td>
                                            <td>${twentyOrder.order_code}</td>
                                            <td>${twentyOrder.name}</td>
                                            <td>
                                            	<c:if test="${twentyOrder.service_type==1}">健康筛查</c:if>
	                                        	<c:if test="${twentyOrder.service_type==2}">中医手诊</c:if>
	                                        	<c:if test="${twentyOrder.service_type==3}">就医绿色通道</c:if>
	                                        	<c:if test="${twentyOrder.service_type==4}">健康银行</c:if>
	                                        	<c:if test="${twentyOrder.service_type==5}">护理</c:if>
                                            </td>
                                            <td>￥${twentyOrder.price}</td>
                                            <td>${twentyOrder.time}</td>
                                            <td class="text-navy">
                                            	<c:if test="${twentyOrder.status==0}">未支付</c:if>
	                                        	<c:if test="${twentyOrder.status==1}">未服务</c:if>
	                                        	<c:if test="${twentyOrder.status==2}">未评价</c:if>
	                                        	<c:if test="${twentyOrder.status==3}">已评价</c:if>
                                            </td>
                                        </tr>
                                    </tbody>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
</body>
<!-- Mirrored from www.zi-han.net/theme/hplus/index_v3.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:49 GMT -->

</html>
