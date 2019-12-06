<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="订单列表"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<div class="layui-input-inline">
			<input type="text" name="phoneNumber" placeholder="手机号"
				class="layui-input">
		</div>
		<div class="layui-inline">状态</div>
		<div class="layui-input-inline">
			<select name="status">
				<option value="">请选择</option>
				<option value="0">已报名</option>
				<option value="4">已确认</option>
				<option value="1">已修改</option>
				<option value="2">已结束</option>
				<option value="3">已取消</option>
			</select>
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
            , url: '/order/queryorderList'
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
                {field: 'id', width: 50, title: 'ID', align: 'center',templet: '#name'}
                , {field: 'orderId', width: 180, title: '订单编号'}
                , {field: 'customerName',width: 100, title: '姓名' , templet: function (d) {
                    	if(d.customer){
                    		return d.customer.customerName
                    	}else{
                    		return ""
                    	}
                    }
                }
                , {field: 'wechatName',width: 150, title: '昵称' , templet: function (d) {
                    	if(d.customer){
                    		return d.customer.wechatName
                    	}else{
                    		return ""
                    	}
                    }
                }
                , {field: 'phoneNumber',width: 120, title: '手机号码', align: 'center'}
                , {field: 'classType', title: '商品类别',width: 100 , templet: function (d) {
                    	if(d.product){
                    		if(d.product.classType == 0){                    		
                    			return '小聚'
                    		}else if(d.product.classType == 1){
                    			return '短居'
                    		}else if(d.product.classType == 2){
                    			return '出游'
                    		}else{
                    			return ""
                    		}
                    	}else{
                    		return ""
                    	}
                    }
                }
                , {field: 'stitle', title: '商品主标题' ,width: 100 , templet: function (d) {
                    	if(d.product){
                    		return d.product.stitle
                    	}else{
                    		return ""
                    	}
                    }
                }
                , {field: 'count', title: '购买数量',width: 100 , align: 'center'}
                , {field: 'orderPrice',  title: '订单金额',width: 100 , align: 'center'}
                , {
                    field: 'status', title: '状态', align: 'center',width: 80 , templet: function (d) {
                    	if(d.orderStatus == 0){
                    		return "已报名"
                    	}else if(d.orderStatus == 1){
                    		return "已修改"
                    	}else if(d.orderStatus == 2){
                    		return "已结束"
                    	}else if(d.orderStatus == 3){
                    		return "已取消"
                    	}else if(d.orderStatus == 4){
                    		return "已确认"
                    	}else{
                    		return ""
                    	}
                    }
                }
                , {
                    field: 'createTime', title: '创建时间',width: 200 , templet: function (d) {
                        return moment(d.createTime).format('YYYY-MM-DD HH:mm:ss')
                    }
                }
                , {
                    field: 'startDate', title: '开始时间',width: 120 , templet: function (d) {
                        return moment(d.startDate).format('YYYY-MM-DD')
                    }
                }
                , {
                    field: 'endDate', title: '结束时间',width: 120 , templet: function (d) {
                        return moment(d.endDate).format('YYYY-MM-DD')
                    }
                }
                , {fixed: 'right',  title: '操作', align: 'center',width: 80, toolbar: '#toolbar'}
            ]]
            //,height: 'full-200'
        });

		$("#addBtn").on('click',function(){
			var add = layer.open({
                title: '新增demo',
                type: 2,
                content: '/admin/demo/add.html',
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
                phoneNumber: $("input[name='phoneNumber']").val(),
                status: $("select[name='status']").val()
            }
            dataTable.reload(options);
        }

        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'details') {
                var edit = layer.open({
                    title: 'order详情',
                    type: 2,
                    content: '/order/details.html?orderId=' + data.orderId,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});
            	layer.full(edit);
            }
            if (obj.event === 'edit') {
                var edit = layer.open({
                    title: 'order详情',
                    type: 2,
                    content: '/order/edit.html?orderId=' + data.orderId,
                    area: ['0', '0'],
                    end: function () {
                        reload();
                    }
           		 
            	});
            	layer.full(edit);
            }
            if(obj.event == 'product'){
            	var edit = layer.open({
                    title: '产品详情',
                    type: 2,
                    content: '/product/details.html?id=' + data.productId,
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
		{{#  if(d.orderStatus == 0 || d.orderStatus == 1 || d.orderStatus == 4){ }}
		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		{{#  } else { }}
		{{#  } }}
</script>
<script type="text/html" id="name">
		{{#  if(d.isEdit == 1){ }}
		<i class="layui-icon dian"><span class="layui-badge-dot"></span></i>{{d.id }}
		{{#  } else { }}
		<i class="layui-icon" ></i>{{d.id }}
		{{#  } }}
</script>
</body>
</html>