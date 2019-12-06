<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="产品统计"/>
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
        var dataTable = table.render({
        	id:"dataTable"
            ,elem: '#dataTable'
            , url: '/product/qryProductCountPage'
            , page: true
            , request: {
                pageName: 'pageNo'
                , limitName: 'pageSize'
            }
            , response: {
                statusName: 'resCode'
                , statusCode: '00000'
                , msgName: 'resInfo'
                , countName: 'count'
                , dataName: 'rows'
            }
            , cols: [[
                {field: 'id', width: 50, title: 'ID', align: 'center'}
                , {field: 'stitle', title: '标题'}
                , {field: 'remark', title: '副标题'}
                , {field: 'amount', title: '价格'}
                , {field: 'productNumber', title: '上架总数量'}
                , {field: 'surplusNumber', title: '交易量'}
                
            ]]
            //,height: 'full-200'
        });
        form.on("submit(queryBtn)",function(data) {
        	console.info(form)
        	reload(1);
        	return false;
        })
        function reload(pageNo) {
        	var options = {};
        	if(pageNo) {
        		options.page={curr:pageNo};
        	}
        	options.where={
                name: $("input[name='name']").val(),
                title: $("input[name='title']").val(),
                status: $("select[name='status']").val()
            }
            dataTable.reload(options);
        }

    });
</script>
<script type="text/html" id="toolbar">
</script>
</body>
</html>