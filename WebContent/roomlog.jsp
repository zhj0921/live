<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>博客管理页面_AmaAdmin后台管理系统模板</title>
<link rel="stylesheet" href="/css/style.default.css" type="text/css" />
 <script type="text/javascript" src="/custom/jquery.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="/js/custom/general.js"></script>
<script type="text/javascript" src="/js/custom/blog.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>
<body class="withvernav">
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">动维<span>直播</span></h1>
            <span class="slogan">后台管理系统</span>
            
            <div class="search">
            	<form action="" method="post">
                	<input type="text" name="keyword" id="keyword" value="请输入" />
                    <button class="submitbutton"></button>
                </form>
            </div><!--search-->
            
            <br clear="all" />
            
        </div><!--left-->
        
        <div class="right">
        	<!--<div class="notification">
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
            <div class="userinfo">
            	<img src="/images/thumbs/avatar.png" alt="" />
            	<span id="uhname"></span>
               <!--  <span id="uhname"></span> -->
            </div><!--userinfo-->
            
            <div class="userinfodrop">
            	<div class="avatar">
                	<a href=""><img src="/images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	切换主题: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a class="custombg"></a>
                    </div>
                </div><!--avatar-->
                <div class="userdata">
                	<h4 id="uhname"></h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                    	<li><a href="editprofile.html">编辑资料</a></li>
                        <li><a href="accountsettings.html">账号设置</a></li>
                        <li><a href="help.html">帮助</a></li>
                        <li><a href="index.html">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
        	<li><a href="${pageContext.request.contextPath}/homepage/findData.do?classify=0"><span class="icon icon-flatscreen"></span>首页</a></li>
            <li><a href="${pageContext.request.contextPath}/homepage/findData.do?classify=1"><span class="icon icon-pencil"></span>系统管理</a></li>
            <li><a href="${pageContext.request.contextPath}/homepage/findData.do?classify=2"><span class="icon icon-message"></span>用户管理</a></li>
            <li class="current"><a href="${pageContext.request.contextPath}/homepage/findData.do?classify=3"><span class="icon icon-chart"></span>直播间管理</a></li>
        </ul>
        
     <!--   <div class="headerwidget">
        	<div class="earnings">
            	<div class="one_half">
                	<h4>Today's Earnings</h4>
                    <h2>$640.01</h2>
                </div>one_half
                <div class="one_half last alignright">
                	<h4>Current Rate</h4>
                    <h2>53%</h2>
                </div>one_half last
            </div>earnings
        </div>headerwidget -->
        
    </div><!--header-->
    
    <div class="vernav">
    	<ul>
        	<!-- <li class="current"><a href="manageblog.html" class="editor">Posts</a></li>
            <li><a href="newpost.html">Create New Post</a></li>
            <li><a href="">Comments</a></li>
            <li><a href="">Categories</a></li> -->
            <c:forEach items="${plist}" var="list">
					<li><a href="#${list.id}"><span class="editor">${list.title}
						</span><span class="arrow"></span></a>
						<ul id="${list.id}">
							<c:forEach items="${list.children}" var="sub">
								<li><a class="J_menuItem" href="${sub.url}">${sub.title}</a>
								</li>
							</c:forEach>
						</ul></li>
				</c:forEach>
				
				
        </ul>
        <a class="togglemenu"></a>
    </div><!--leftmenu-->
    
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">Manage Blog</h1>
            <span class="pagedesc">The content below are loaded using ajax</span>
            
            <ul class="hornav blogmenu">
                <li class="current"><a href="allposts.html">All Post (5)</a></li>
                <li><a href="published.html">Published (5)</a></li>
                <li><a href="draft.html">Draft (3)</a></li>
                <li><a href="trash.html">Trash (1)</a></li>
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
             
        </div><!--contentwrapper-->
    
    </div><!--centercontent-->
    
    
</div><!--bodywrapper-->
<script type="text/javascript">
		/*获取登录name*/
		$.get("${pageContext.request.contextPath}/homepage/getAdmin.do",
				function(data) {
					if (data == null || 'nologin'== data) {
						alert("请先登录再来吧！！");
						localtion.href = "/login.jsp";
					} else {
						$("#uhname").html(data);
					}
				});
	</script>
</body>
</html>
