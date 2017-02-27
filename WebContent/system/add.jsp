<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">




<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="favicon.ico">
<link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/style.min.css?v=4.0.0" rel="stylesheet">

<!-- 表单验证 -->
<link rel="stylesheet" href="/validform-5.3.2/css/style.css"
	type="text/css" media="all" />


<base target="_self">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            发布版本
                        </header>
                        
                        
   <%--  <div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
  <div id='tsk'>${error }</div>
    </div> --%>
                        <div class="panel-body">
                            <form id="jvForm" class="form-horizontal adminex-form demoform" method="post" onsubmit=" return submitFun();"
                            action="${pageContext.request.contextPath}/system/addAndroid.do" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">版本号</label>
                                    <div class="col-sm-10">
                                        <input type="text" datatype="*" errormsg="请输入版本号"   name="version" class="form-control">
                                    </div>
                                </div>
                                   <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">版本描述</label>
                                    <div class="col-sm-10">
                                       <textarea rows="6" name="describe" datatype="*" errormsg="请输入版本描述" class="form-control"></textarea>
                                    </div>
                                </div>
                                     <div class="form-group">
                                    <label for="exampleInputFile2" class="col-lg-2 col-sm-2 control-label">安装包上传</label>
                                    <div class="col-lg-10">
                                       <input type="file" name="file" />
                                    </div>
                                </div>
                                     
                                 
                              	<div class="row">
				<div class="col-lg-1 pull-right">
					<button type="button" onclick="history.go(-1)"
						class="btn btn-info btn-block">返回</button>
				</div>
				<div class="col-lg-1 pull-right">
					<input type="submit" id="button" class="btn btn-success btn-block"
						value="提交" />
				</div>
			</div>
		</form>
	</div>
	</section>

</div>
</div>
</div>
<script src="/js/jquery.min.js?v=2.1.4"></script>

<script type="text/javascript"
		src="/validform-5.3.2/js/Validform_v5.3.2_min.js"></script>
	<script src="/laydate/laydate.js"></script>


	<script type="text/javascript">
		$(".demoform").Validform();
	</script>

<script>
if($('#tsk').html() == ''){
	$('.alert-dismissible').hide();
	
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
 
 
 
	<!--<script type="text/javascript">
	    function submitFun() {
	    	var reg= new RegExp("/S");//验证版本号
	    	var version = $("input[name=version]").val();//版本号
	    	if (!reg.test(version)) {
				alert("版本号不合法!");
				return false;//不允许表单提交
			}
	    	return true;//允许表单提交
	    }
	</script>  -->
</body>
</html>