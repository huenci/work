<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="区域管理"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<div class="layui-input-inline">
			<input type="text" name="name" placeholder="区域名称"
				class="layui-input">
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
            , url: '/area/queryAreaPage'
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
                {field: 'id', width: '5%', title: 'ID', align: 'center'}
                , {field: 'name', width: '55%',title: '区域名称'}
                , {field: 'type', width: '55%',title: '区域名称', templet: function (d) {
                        return d.type == '1' ? '非公益性' : '公益性'
                    }}
                , {fixed: 'right', width: '20%', title: '操作', align: 'center', toolbar: '#toolbar'}
            ]]
            //,height: 'full-200'
        });
		$("#addBtn").on('click',function(){
			var add = layer.open({
                title: '新增',
                type: 2,
                content: '/area/add.html',
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
                name: $("input[name='name']").val()
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
               /* var edit = layer.open({
                    title: '编辑',
                    type: 2,
                    fix:false,
                    content: '/product/edit.html?id=' + data.id,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});*/
            	layer.full(edit);
            }
            if (obj.event === 'delete') {
            	layer.confirm('确认删除当前数据吗？', function(index){
            		$.ajax({
            			type: "GET",
                		url: "/area/deleteByPrimaryKey/"+data.id,
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
    	<a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
</script>
</body>
</html>