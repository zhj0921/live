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
<script type="text/javascript" src="/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="/js/custom/general.js"></script>
<script type="text/javascript" src="/js/custom/tables.js"></script>
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
    
    
    
    
    

        
    <div class="centercontent tables">
    
         <div class="pageheader notab">
            <h1 class="pagetitle">用户列表</h1>
           <!--  <span class="pagedesc">This is a sample description of a page</span> -->
            
        </div>
        
        <!-- <div class="contenttitle2">
                	<h3>Dynamic Table with Checkbox Column</h3>
                </div>contenttitle -->
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable2">
                    <colgroup>
                        <col class="con0" style="width: 4%" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                          <th class="head0 nosort"><input type="checkbox" /></th>
                            <th class="head0">昵称</th>
                            <th class="head1">手机号</th>
                            <th class="head0">金额</th>
                            <th class="head1">直播时间</th>
                            <th class="head0">登录次数</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                          <th class="head0"><span class="center">
                            <input type="checkbox" />
                          </span></th>
                            <th class="head0">Rendering engine</th>
                            <th class="head1">Browser</th>
                            <th class="head0">Platform(s)</th>
                            <th class="head1">Engine version</th>
                            <th class="head0">CSS grade</th>
                        </tr>
                    </tfoot>
                    <tbody>
                   <c:forEach items="${pagination.list}" var="list">
                    
                        <tr class="gradeX">
                          <td align="center"><span class="center">
                            <input type="checkbox" />
                          </span></td>
                            <td>${list.nickname}</td>
                            <td>${list.phone}</td>
                            <td>${list.memberMoney}</td>
                            <td class="center">${list.memberRegTime}</td>
                            <td class="center">${list.loginnum}</td>
                        </tr>
                    </c:forEach>
                        <!-- <tr class="gradeC">
                          <td align="center"><span class="center">
                            <input type="checkbox" />
                          </span></td>
                            <td>Trident</td>
                            <td>Internet Explorer 5.0</td>
                            <td>Win 95+</td>
                            <td class="center">5</td>
                            <td class="center">C</td>
                        </tr>
                        <tr class="gradeA">
                          <td align="center"><span class="center">
                            <input type="checkbox" />
                          </span></td>
                            <td>Trident</td>
                            <td>Internet Explorer 5.5</td>
                            <td>Win 95+</td>
                            <td class="center">5.5</td>
                            <td class="center">A</td>
                        </tr>
                        <tr class="gradeA">
                          <td align="center"><span class="center">
                            <input type="checkbox" />
                          </span></td>
                            <td>Trident</td>
                            <td>Internet Explorer 6</td>
                            <td>Win 98+</td>
                            <td class="center">6</td>
                            <td class="center">A</td>
                        </tr> -->
                    </tbody>
                </table>
        
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    


</body>
</html>
