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
<!--  <script type="text/javascript" src="/custom/jquery.min.js"></script> -->
<script type="text/javascript" src="/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/plugins/colorpicker.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.jgrowl.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="/js/custom/general.js"></script>
<script type="text/javascript" src="/js/custom/elements.js"></script>
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
   
    
    
    
        
    <div class="centercontent">
    
        <div class="pageheader notab">
            <h1 class="pagetitle">编辑站点基本配置</h1>
            <!-- <span class="pagedesc">This is a sample description of a page</span> -->
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper elements">
                
                    <div class="contenttitle2">
                    	<h3>站点基本配置</h3>
                    </div><!--contenttitle-->
                    
                    <br />
                    
                    <form class="stdform stdform2" action="${pagecontext.request.contextPath}/site/updateSite.do">
                    	<input id="id" type="hidden" value="${siteSettings.id}" name="id">
                    	<p>
                        	<label>站点名称</label>
                            <span class="field">
                            	<input type="text" value="${siteSettings.name}" name="name" class="width500" id="colorpicker2" />
                            </span><!--field-->
                        </p>
                        <p>
                        	<label>站点域名</label>
                            <span class="field">
                            	<input type="text" value="${siteSettings.domain_name}" name="domain_name" class="width500" id="colorpicker2" />
                                <!-- <span id="colorSelector" class="colorselector">
                                	<span></span>
                                </span> -->
                            </span><!--field-->
                        </p>
                        <p class="flatmode">
                        	<label>所属企业</label>
                            <span class="field">
                            	<input type="text" value="${siteSettings.enterprise}" name="enterprise" class="width500" id="colorpicker3" />
                               <!--  <br /><br />
                            	<span id="colorpickerholder"></span> -->
                                
                            </span><!--field-->
                        </p>
                        <!-- <p>
                        	<label>Date Picker</label>
                            <span class="field">
                            	<input id="datepicker" type="text" class="width100" /> 
                            </span>
                        </p> -->
                        <br /><br />
                        <button type="submit"
								class="anchorbutton" style="width: 100px;">保存</button>
						<input type="button" class="anchorbutton" style="width: 100px;" onclick="remove()" value="取消" />                 
                    	
                    </form>
                    
                  	
                    
                    <br clear="all" /><br />
        
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

	<script type="text/javascript">
		function remove(){
		 	var url = "${pageContext.request.contextPath}/site/list.do";
		 	window.location.href= url;
		}

	</script>


</body>
</html>
