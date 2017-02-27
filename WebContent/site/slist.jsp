<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>系统管理页面_动维直播后台管理系统</title>
<link rel="stylesheet" href="/css/style.default.css" type="text/css" />
<link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
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
<script type="text/javascript" src="/js/custom/tables.js"></script>
<script type="text/javascript" src="/js/custom/elements.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.jgrowl.js"></script>
<script type="text/javascript" src="/js/plugins/colorpicker.js"></script>
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
            <h1 class="pagetitle">站点配置</h1>
           <!--  <span class="pagedesc">This is a sample description of a page</span> -->
            
        </div>
        
        <div class="contenttitle2">
                	<!-- <h3>Dynamic Table with Checkbox Column</h3> -->
                	<input type="button" class="anchorbutton" style="width: 100px;" onclick="add()" value="添加" />
                </div>
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
                            <th class="head0">ID</th>
                            <th class="head1">站点标题</th>
                            <th class="head0">关键词</th>
                            <th class="head1">描述</th>
                            <th class="head0">状态</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                          <th class="head0"><span class="center">
                            <input type="checkbox" />
                          </span></th>
                            <th style="width: 60px;" class="head0">ID</th>
                            <th style="width: 120px;" class="head1">站点标题</th>
                            <th style="width: 100px;" class="head0">关键词</th>
                            <th style="width: 160px;" class="head1">描述</th>
                            <th style="width: 80px;" class="head0">状态</th>
                            <th style="width: 100px;" class="head1">操作</th>
                        </tr>
                    </tfoot>
                    <tbody>
                   <c:forEach items="${list}" var="list">
                    
                        <tr class="gradeX">
                          <td align="center"><span class="center">
                            <input type="checkbox" />
                          </span></td>
                            <td>${list.id}</td>
                            <td>${list.title}</td>
                            <td>${list.key_word}</td>
                            <td class="center">${list.describe}</td>
	                            <c:if test="${list.status==0}">
	                            	<td class="center">启用</td>
	                            </c:if>
	                            <c:if test="${list.status==1}">
	                            	<td class="center">禁用</td>
	                            </c:if>
                            
                            	<!-- 启用/禁用 -->
	
								<c:if test="${list.status==0}">
									<td><button type="button" class="btn btn-warning"
										onclick="disable('${list.id}');">禁用</button>
										<button onclick="del('${list.id}');" type="button" class="btn btn-danger">删除</button>
										<button onclick="update('${list.id}');" type="button" class="btn btn-info">编辑</button>
										<%-- <a href="${pagecontext.request.contextPath}/room/look.do?id=${list.id}">查看详情</a> --%>
									</td>
								</c:if>
								<c:if test="${list.status==1}">
									<td><button type="button" class="btn btn-primary"
										onclick="enabled('${list.id}');">启用</button>
										<button onclick="del('${list.id}');" type="button" class="btn btn-danger">删除</button>
										<button onclick="update('${list.id}');" type="button" class="btn btn-info">编辑</button>
										<%-- <a href="${pagecontext.request.contextPath}/room/look.do?id=${list.id}">查看详情</a> --%>
									</td>
								</c:if>
								
                            
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
    
    <script type="text/javascript">
		//删除
		function del(iid) {
			if (!confirm('您确定要删除吗？')) {//true 确定。  false:取消
				return;
			}
			$.get("${pageContext.request.contextPath}/site/delC.do", {
				id : iid
			}, function(res) {
				if ("ok" == res) {
					alert("删除成功！！");
					location.href="${pageContext.request.contextPath}/site/slist.do";
				} else {
					alert("删除失败,请与管理员联系！！");
					location.href="${pageContext.request.contextPath}/site/slist.do";
				};
			});
		}
		
		
		//启用直播 function
		function enabled(iid) {
			//
			if (!confirm('您确定启用吗？')) {//true确定。  false:取消
				return;
			};
			$.get( "${pageContext.request.contextPath}/site/isstatusC.do",
				 { id : iid },
				function(res) {
					if ("ok" == res) {
						alert("启用成功！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/site/slist.do";
					} else {
						alert("启用失败,请与管理员联系！！");
						//刷新列表
						location.href="${pageContext.request.contextPath}/site/slist.do";
					}
				});
		}

		//禁用直播 function
		function disable(iid) {
			//
			if (!confirm('您确定禁用吗？')) {//true确定。  false:取消
				return;
			};
			$.get("${pageContext.request.contextPath}/site/nostatusC.do",
				{id : iid},
				function(res) {
					if ("ok" == res) {
						alert("禁用成功！！");
						location.href="${pageContext.request.contextPath}/site/slist.do";
					} else {
						alert("禁用失败,请与管理员联系！！");
						location.href="${pageContext.request.contextPath}/site/slist.do";
					}
				});
		}

	
	</script>
	
	<!-- 编辑 -->
	<script type="text/javascript">
		function update(id){
			var url = "${pageContext.request.contextPath}/site/editSiteC.do?id=" + id;
 		window.location.href= url;
	}

	</script>
	
	
	<script type="text/javascript">
		function add(){
		 	var url = "${pageContext.request.contextPath}/site/addSiteConfiguration.do";
		 	window.location.href= url;
		}

	</script>


</body>
</html>
