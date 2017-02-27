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
                        <h5>用户详情</h5>
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
                                        <td>${userDetails.nickname}</td>
                                        <td>手机号： </td>
                                        <td>${userDetails.phone}</td>
                                    </tr>
                                    <tr>
                                        <td>年龄：</td>
                                        <td>${userDetails.age} </td>
                                        <td>性别： </td>
                                        <td>
                                        	<c:if test="${userDetails.sex==0}">未公开</c:if>
                                        	<c:if test="${userDetails.sex==1}">男</c:if>
                                        	<c:if test="${userDetails.sex==2}">女</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>星座：</td>
                                        <td>${userDetails.constellation} </td>
                                        <td>婚姻状态： </td>
                                        <td>
                                        	<c:if test="${userDetails.emotional==0}">未婚</c:if>
                                        	<c:if test="${userDetails.emotional==1}">已婚</c:if>
                                        	<c:if test="${userDetails.emotional==2}">保密</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>家乡：</td>
                                        <td>${userDetails.hometown}</td>
                                        <td>职业： </td>
                                        <td>${userDetails.profession}</td>
                                    </tr>
                                    
                                    <tr>
                                        <td>登录时间：</td>
                                        <td>${userDetails.loginTime}</td>
                                        <td>退出时间： </td>
                                        <td>${userDetails.quitTime}</td>
                                    </tr>
                                    <tr>
                                        <td>注册时间：</td>
                                        <td>${userDetails.memberRegTime}</td>
                                        <td>登录次数： </td>
                                        <td>${userDetails.loginnum}</td>
                                    </tr>
                                    <tr>
                                        <td>积分：</td>
                                        <td>${userDetails.integral}</td>
                                        <td>金额： </td>
                                        <td>${userDetails.memberMoney}</td>
                                    </tr>
                                    <tr>
                                        <td>豆豆：</td>
                                        <td>${userDetails.dd}</td>
                                        <td>等级： </td>
                                        <td>${userDetails.memberGrade}</td>
                                    </tr>
                                    <tr>
                                        <td>手机型号：</td>
                                        <td>
                                        	<c:if test="${userDetails.deviceType==1}">
                                        		<span style="color: #00A600;">安卓</span>
                                        	</c:if>
                                        	<c:if test="${userDetails.deviceType==2}">
                                        		<span style="color: #D94600;">苹果</span>
                                        	</c:if>
                                        </td>
                                        <td>认证：</td>
                                        <td>
                                        	<c:if test="${userDetails.authenticate==0}">
                                        		<span style="color: red;">未认证</span>
                                        	</c:if>
                                        	<c:if test="${userDetails.authenticate==1}">
                                        		<span style="color: green;">已认证</span>
                                        	</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>直播状态：</td>
                                        <td>
                                        	<c:if test="${userDetails.ispower==2}">
                                        		<span style="color: red;">禁止</span>
                                        	</c:if>
                                        	<c:if test="${userDetails.ispower==1}">
                                        		<span style="color: green;">启用</span>
                                        	</c:if>
                                        </td>
                                        <td>状态：</td>
                                        <td>
                                        	<c:if test="${userDetails.status==2}">
                                        		<span style="color: red;">禁止</span>
                                        	</c:if>
                                        	<c:if test="${userDetails.status==1}">
                                        		<span style="color: green;">启用</span>
                                        	</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>个性签名：</td>
                                        <td colspan="3">${userDetails.trades}</td>
                                    </tr>
                                    <%-- <tr>
                                        <td>用户头像：</td>
                                        <td>
                                        	<img alt="" src="${userDetails.avatar}" height="50px" width="50px"/>
                                        </td>
                                        <td>直播头像： </td>
                                        <td>
                                        	<img alt="" src="${userDetails.liveavatar}" height="50px" width="50px"/>
                                        </td>
                                    </tr> --%>
                                
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
