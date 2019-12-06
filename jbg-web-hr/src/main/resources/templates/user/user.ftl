<!DOCTYPE html>
<html>
<head>
	<@app.head title="用户列表"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<div class="layui-input-inline">
			<input type="text" name="username" placeholder="用户名"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="realName" placeholder="姓名"
				class="layui-input">
		</div>
		<div class="layui-inline">状态</div>
		<div class="layui-input-inline" >
			<select name="status">
				<option value="">请选择</option>
				<option value="1">启用</option>
				<option value="2">锁定</option>
				<option value="3">过期</option>
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
            , url: '/admin/user'
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
                {field: 'username', width: 150, title: '用户名', align: 'center'}
                , {field: 'realName', width: 150, title: '姓名', align: 'center'}
                , {field: 'gender', width: 100, title: '性别', align: 'center'}
                , {
                    field: 'status', width: 60, title: '状态', align: 'center', templet: function (d) {
                        return d.status == '1' ? '启用' : '锁定'
                    }
                }
                , {
                    field: 'expireTime', title: '过期时间', templet: function (d) {
                        return d.expireTime==undefined?'永不过期':moment(d.expireTime).format('YYYY-MM-DD HH:mm:ss')
                    }
                }
                , {
                    field: 'createTime', title: '创建时间', templet: function (d) {
                        return d.createTime==undefined?'':moment(d.createTime).format('YYYY-MM-DD HH:mm:ss')
                    }
                }
                , {fixed: 'right', width: 150, title: '操作', align: 'center', toolbar: '#toolbar'}
            ]]
            //,height: 'full-200'
        });

		$("#addBtn").on('click',function(){
			var add = layer.open({
                title: '新增用户',
                type: 2,
                content: '/admin/user/add.html',
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
                username: $("input[name='username']").val(),
                realName: $("input[name='realName']").val(),
                status: $("select[name='status']").val()
            }
            dataTable.reload(options);
        }

        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var edit = layer.open({
                    title: '编辑用户',
                    type: 2,
                    content: '/admin/user/edit.html?userId=' + data.id,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});
            	layer.full(edit);
            } else if (obj.event === 'role') {
            	var edit = layer.open({
                    title: '角色分配',
                    type: 2,
                    content: '/admin/user/role.html?userId=' + data.id,
                    area: ['505px', '400px'],
                    end: function () {
                    },
            		yes:function() {
            			
            		}
           		 
            	});
            }
        });
    });
</script>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="role">角色/权限</a>
</script>
</body>
</html>