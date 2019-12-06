<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="smsmanage列表"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<div class="layui-input-inline">
			<input type="text" name="name" placeholder="名称"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="phoneNumber" placeholder="手机号码"
				class="layui-input">
		</div>
		<div class="layui-inline">状态</div>
		<div class="layui-input-inline">
			<select name="status">
				<option value="">请选择</option>
				<option value="1">启动</option>
				<option value="2">停用</option>
			</select>
		</div>
		<div class="layui-inline">
			<button id="queryBtn" class="layui-btn" lay-submit
				lay-filter="queryBtn">查询</button>
			<button class="layui-btn layui-btn-primary" id="resetBtn">重置</button>
			<button class="layui-btn layui-btn-danger" id="addBtn">添加</button>
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
            , url: '/smsmanage/smsmanage'
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
                , {field: 'name', title: '姓名'}
                , {field: 'phoneNumber', width: 150, title: '手机号码', align: 'center'}
                , {
                    field: 'status', width: 60, title: '状态', align: 'center', templet: function (d) {
                        return d.status == '1' ? '启用' : '停用'
                    }
                }
                , {
                    field: 'startTime', title: '时间范围', templet: function (d) {
                        return d.startTime + ' - ' +d.endTime
                    }
                }
                
                , {fixed: 'right', width: 100, title: '操作', align: 'center', toolbar: '#toolbar'}
            ]]
            //,height: 'full-200'
        });

		$("#addBtn").on('click',function(){
			var add = layer.open({
                title: '新增短信',
                type: 2,
                content: '/smsmanage/add.html',
                area: ['0px', '0px'],
                end: function () {
                    reload(1);
                }
            });
            layer.full(add);
            return false;
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
                phoneNumber: $("input[name='phoneNumber']").val(),
                status: $("select[name='status']").val()
            }
            dataTable.reload(options);
        }

        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var edit = layer.open({
                    title: '短信管理编辑',
                    type: 2,
                    content: '/smsmanage/edit.html?id=' + data.id,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});
            	layer.full(edit);
            }
            if (obj.event === 'delete') {
            	layer.confirm('确认删除当前数据吗？', function(index){
            		$.ajax({
            			type: "GET",
                		url: "/smsmanage/deleteByPrimaryKey/"+data.id,
                		dataType:'JSON',
                		contentType:'application/json;charset=UTF-8',
                		success: function(data){
                		debugger;
                    		if(data.resCode==00000){
                        		reload();
                    		}else{
                        	layer.msg(data.resultMsg);
                    		}
                		}
                	});
                	layer.close(index);
            	});
            }
        });
    });
</script>
<script type="text/html" id="toolbar">
    	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    	<a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
</script>
</body>
</html>