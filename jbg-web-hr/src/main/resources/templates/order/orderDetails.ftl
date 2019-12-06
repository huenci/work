<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="demo列表"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		
    </form>
    <table class="layui-hide" id="dataTable" lay-filter="dataTable"></table>
</div>
<script>
    layui.use(['table'], function () {
        var $ = layui.$;
        var table = layui.table, form=layui.form;
        table.render({
		    elem: '#dataTable'
		    ,url:'/order/qryDetailsByOrderId/'+ jbg.getUrlParam("orderId")
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    , response: {
                statusName: 'resCode'
                , statusCode: '00000'
                , msgName: 'resInfo'
                , countName: 'count'
                , dataName: 'data'
            }
		    ,cols: [[
		      {field:'id', title: 'ID', sort: true}
		      ,{field:'orderId',  title: '订单编号'}
		      ,{field:'title',  title: '标题', sort: true}
		      ,{field:'amount', title: '金额'}
		      ,{field:'count', title: '数量', sort: true}
		      , {
                    field: 'createDate', title: '创建时间', templet: function (d) {
                        return moment(d.createDate).format('YYYY-MM-DD HH:mm:ss')
                    }
                }
		    ]]
		  });
    });
</script>
<script type="text/html" id="toolbar">
	<@security.authorize access="hasAuthority('demo_edit_button')">
    	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    </@security.authorize>
</script>
</body>
</html>