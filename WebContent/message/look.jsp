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
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>消息详情</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <button type="button" class="btn btn-sm btn-primary  pull-left" onclick="history.go(-1)"> 返回</button>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered">
                                <tbody>
                                    <tr>
                                        <td>用户名：</td>
                                        <td>
                                      		<c:if test="${message.uid==0}">
												<span style="color: red;">该消息为广播</span>
											</c:if>
											<c:if test="${message.uid!=0}">
												<span style="color: green;">${message.userName}</span>
											</c:if>
                                        </td>
                                        <td>用户/商户： </td>
                                        <td>
                                        	<c:if test="${message.utype==1}">用户</c:if>
                                        	<c:if test="${message.utype==2}">商户</c:if>
                                    </tr>
                                    <tr>
                                        <td>标题：</td>
                                        <td>${message.title} </td>
                                        <td>发送时间： </td>
                                        <td>${message.addtime}</td>
                                    </tr>
                                    <tr>
                                        <td>发送内容：</td>
                                        <td colspan="3">${message.content} </td>
                                    </tr>
                                
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
</body>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->

</html>
