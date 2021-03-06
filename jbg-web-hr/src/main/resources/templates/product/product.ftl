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
			<input type="text" name="stitle" placeholder="标题"
				class="layui-input">
		</div>
		<div class="layui-inline">状态</div>
		<div class="layui-input-inline">
			<select name="status">
				<option value="">请选择</option>
				<option value="0">启动</option>
				<option value="1">禁用</option>
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
            , url: '/product/queryProductPage'
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
                , {field: 'title', title: '分类'}
                , {field: 'stitle', title: '标题'}
                , {field: 'amount', title: '价格'}
                , {field: 'productNumber', title: '上架总数量'}
                , {
                    field: 'surplusNumber', width: 120, title: '剩余数量', align: 'center', templet: function (d) {
                    	if(d.surplusNumber){
	                        return d.productNumber - d.surplusNumber
                    	}else{
                    		return d.productNumber
                    	}
                    }
                }
                , {field: 'remark', title: '详情'}
                , {
                    field: 'status', width: 60, title: '状态', align: 'center', templet: function (d) {
                        return d.status == '0' ? '启用' : '停用'
                    }
                }
                , {fixed: 'right', width: 120, title: '操作', align: 'center', toolbar: '#toolbar'}
            ]]
            //,height: 'full-200'
        });
		$("#addBtn").on('click',function(){
			var add = layer.open({
                title: '新增',
                type: 2,
                content: '/product/add.html',
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
                stitle: $("input[name='stitle']").val(),
                status: $("select[name='status']").val()
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
                    content: '/product/edit.html?id=' + data.id,
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
                		url: "/product/deleteByPrimaryKey/"+data.id,
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