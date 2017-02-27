<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>供应商列表</title> 

<link href="css/base.css" rel="stylesheet">
<link rel="stylesheet" href="../custom/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="../custom/uimaker/icon.css">
<link rel="stylesheet" href="css/providers.css">
</head> 
<body>
    <div class="container">
       <table id="dg" style="width:100%;height:554px" title="用户列表" data-options="
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                fitColumns:true,
                striped:true,
                checkOnSelect:false,
                selectOnCheck:false,
                collapsible:true,
                toolbar:'#tb',
                pageSize:10">
            <thead>
                <tr>
                    <th field="uid" width="90">ID</th>
                    <th field="nickname" width="90">昵称</th>
                    <th field="phone" width="126">手机号</th>
                    <th field="memberMoney" width="90">金额</th>
                    <th field="memberRegTime" width="100">注册时间</th>
                    <th field="loginTime" width="130">登录日期</th>
                    <th field="loginnum" width="136">登录次数</th>
                    <th field="ispower" width="120">直播状态</th>
                    <th field="status" width="80">状态</th>
					<th field="play" width="105">操作</th>
                </tr>
            </thead>
        </table>
		<form action="${pagecontext.request.contextPath}/user/list1.do">
		  <div id="tb" style="padding:0 30px;">
			昵称查询: <input class="easyui-textbox" type="text" name="name" style="width:166px;height:35px;line-height:35px;"></input>
			手机号查询: <input class="easyui-textbox" type="text" name="phone" style="width:166px;height:35px;line-height:35px;"></input>
			<select
				class="form-control input-sm" name="ispower"
				style="width: 120px; margin-right: 5px;">
				<option value="0">直播状态</option>
				<option value="1"
					<c:if test="${ispower==1}">selected="selected"</c:if>>启用直播</option>
				<option value="2"
					<c:if test="${ispower==2}">selected="selected"</c:if>>禁止直播</option>
			</select>
			<select
				class="form-control input-sm" name="status"
				style="width: 120px; margin-right: 5px;">
				<option value="0">状态</option>
				<option value="1"
					<c:if test="${status==1}">selected="selected"</c:if>>启用</option>
				<option value="2"
					<c:if test="${status==2}">selected="selected"</c:if>>禁用</option>
			</select>
			<!--<a href="#" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>-->
			<button type="submit" class="btn btn-sm btn-primary  pull-left">搜索</button>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
		  </div>
		</form>
    </div>
	
    <script type="text/javascript" src="../custom/jquery.min.js"></script>
    <script type="text/javascript" src="../custom/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../custom/easyui-lang-zh_CN.js"></script>


    
  

    
    <script type="text/javascript">
	
            (function($){
            function pagerFilter(data){
                if ($.isArray(data)){   // is array
                    data = {
                        total: data.length,
                        rows: data
                    }
                }
                var target = this;
                var dg = $(target);
                var state = dg.data('datagrid');
                var opts = dg.datagrid('options');
                if (!state.allRows){
                    state.allRows = (data.rows);
                }
                if (!opts.remoteSort && opts.sortName){
                    var names = opts.sortName.split(',');
                    var orders = opts.sortOrder.split(',');
                    state.allRows.sort(function(r1,r2){
                        var r = 0;
                        for(var i=0; i<names.length; i++){
                            var sn = names[i];
                            var so = orders[i];
                            var col = $(target).datagrid('getColumnOption', sn);
                            var sortFunc = col.sorter || function(a,b){
                                return a==b ? 0 : (a>b?1:-1);
                            };
                            r = sortFunc(r1[sn], r2[sn]) * (so=='asc'?1:-1);
                            if (r != 0){
                                return r;
                            }
                        }
                        return r;
                    });
                }
                var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
                var end = start + parseInt(opts.pageSize);
                data.rows = state.allRows.slice(start, end);
                return data;
            }

            var loadDataMethod = $.fn.datagrid.methods.loadData;
            var deleteRowMethod = $.fn.datagrid.methods.deleteRow;
            $.extend($.fn.datagrid.methods, {
                clientPaging: function(jq){
                    return jq.each(function(){
                        var dg = $(this);
                        var state = dg.data('datagrid');
                        var opts = state.options;
                        opts.loadFilter = pagerFilter;
                        var onBeforeLoad = opts.onBeforeLoad;
                        opts.onBeforeLoad = function(param){
                            state.allRows = null;
                            return onBeforeLoad.call(this, param);
                        }
                        var pager = dg.datagrid('getPager');
                        pager.pagination({
                            onSelectPage:function(pageNum, pageSize){
                                opts.pageNumber = pageNum;
                                opts.pageSize = pageSize;
                                pager.pagination('refresh',{
                                    pageNumber:pageNum,
                                    pageSize:pageSize
                                });
                                dg.datagrid('loadData',state.allRows);
                            }
                        });
                        $(this).datagrid('loadData', state.data);
                        if (opts.url){
                            $(this).datagrid('reload');
                        }
                    });
                },
                loadData: function(jq, data){
                    jq.each(function(){
                        $(this).data('datagrid').allRows = null;
                    });
                    return loadDataMethod.call($.fn.datagrid.methods, jq, data);
                },
                deleteRow: function(jq, index){
                    return jq.each(function(){
                        var row = $(this).datagrid('getRows')[index];
                        deleteRowMethod.call($.fn.datagrid.methods, $(this), index);
                        var state = $(this).data('datagrid');
                        if (state.options.loadFilter == pagerFilter){
                            for(var i=0; i<state.allRows.length; i++){
                                if (state.allRows[i] == row){
                                    state.allRows.splice(i,1);
                                    break;
                                }
                            }
                            $(this).datagrid('loadData', state.allRows);
                        }
                    });
                },
                getAllRows: function(jq){
                    return jq.data('datagrid').allRows;
                }
            })
        })(jQuery);

        function getData(){
            var rows = [];
            
           for(var i=1; i<=800; i++){
                rows.push({
                	uid:'1',
                	nickname: '10695',
                	phone: '南京天泽星网股份有限公司',
                	memberMoney: '正式',
                	memberRegTime: '光纤通信设备配件',
                	loginTime: '√',
                	loginnum: '√',
                	ispower:'已审核',
                    status: '-',
                    play:'操作'
                });
            }
            return rows;
            
        }
        
        $(function(){
            $('#dg').datagrid({data:getData()}).datagrid('clientPaging');
        });  
        
    </script>
    
    
   <!--  <script type="text/javascript">
    $.ajax({
        method : 'GET',
        url : '${pagecontext.request.contextPath}/user/list.do',
        async : false,
        dataType : 'json',
        beforeSend : function(jqXHR) {
            jqXHR.setRequestHeader('Authorization', 'Bearer '
                    + '3feee5b76d8e698f4e5e29c626eb9dc2');
        },
        success : function(data) {
            for ( var machine in data) {
                alert(data[machine].name);
                var a = [ {
                    'uid' : data[machine].id,
                    'nickname' : data[machine].nickname,
                    'phone' : data[machine].phone,
                    'memberMoney' : data[machine].memberMoney,
                    'memberRegTime' : data[machine].memberRegTime,
                    'loginTime' : data[machine].loginTime,
                    'loginnum' : data[machine].loginnum,
                    'ispower' : data[machine].ispower,
                    'status' : data[machine].status,
                } ];
                $('#dg').datagrid('loadData', a);
            }
        },
        error : function() {
            alert('error');
        }
    });
    </script> -->
    
</body> 
</html>
