<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="产品管理"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<div class="layui-input-inline">
			<input type="text" name="name" placeholder="姓名"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="phoneNumber" placeholder="手机号码"
				class="layui-input">
		</div>
		<div class="layui-inline">
			<button id="queryBtn" class="layui-btn" lay-submit
				lay-filter="queryBtn">查询</button>
			<button class="layui-btn layui-btn-primary" id="resetBtn">重置</button>
		</div>
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
            , url: '/customer/queryCustomerPage'
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
                , {field: 'customerName', title: '姓名'}
                , {field: 'sex', title: '性别', templet: function (d) {
                        return d.sex == '1' ? '男' : '女'
                    }
                 }
                , {field: 'phoneNumber', title: '手机号码'}
                , {field: 'custhobbies', title: '兴趣爱好'}
                , {fixed: 'right', width: 120, title: '操作', align: 'center', toolbar: '#toolbar'}
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
                phoneNumber: $("input[name='phoneNumber']").val()
            }
            dataTable.reload(options);
        }

    layui.laytpl.toDateString = function(d, format){
        if (!d)
        {
            return "";
        }
        return moment(d).format('YYYY-MM-DD HH:mm:ss');
    };		

        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var edit = layer.open({
                    title: '编辑',
                    type: 2,
                    fix:false,
                    content: '/customer/edit.html?id=' + data.id,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});
            	layer.full(edit);
            }
        });
    });
</script>
<script type="text/html" id="toolbar">
    	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
</body>
</html>