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
			<input type="text" name="goumaifang" placeholder="购买方"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="goumaifangdianhua" placeholder="购买方电话"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="sizhexingming" placeholder="亡者姓名"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<select name="qu" lay-filter="provice" id="provice" lay-search="" placeholder="区">
				<option value="">全部</option>
				<#list areaList as p>
			 		<option value="${p.id }">${p.name }</option>
				</#list>
			</select>
		</div>
		<div class="layui-input-inline">
			<input type="text" name="pai" placeholder="排"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" name="hao" placeholder="号"
				class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" lay-verify="startDate" class="layui-input" name="startDate" id="startDate" placeholder="安葬日期范围">
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
    layui.use(['table','laydate'], function () {
        var $ = layui.$;
        var table = layui.table, form=layui.form;
        var laydate = layui.laydate;
            laydate.render({
                elem: '#startDate'
                ,range: true
            });
        var dataTable = table.render({
        	id:"dataTable"
            ,elem: '#dataTable'
            , url: '/area/queryAllInfoPage'
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
                , {field: 'goumaifang', width: '10%',title: '购买方'}
                , {field: 'goumaifangdianhua', width: '13%',title: '购买方联系电话'}
                , {field: 'position', width: '20%',title: '墓区位置'}
                , {field: 'anzangshijian', width: '12%',title: '安葬时间'}
                , {field: 'wangzhexingming', width: '25%',title: '亡者姓名'}
                , {fixed: 'right', width: '10%', title: '操作', align: 'center', toolbar: '#toolbar'}
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
                goumaifang: $("input[name='goumaifang']").val(),
                goumaifangdianhua: $("input[name='goumaifangdianhua']").val(),
                sizhexingming: $("input[name='sizhexingming']").val(),
                pai: $("input[name='pai']").val(),
                hao: $("input[name='hao']").val(),
                qu: $("select[name='qu']").val(),
                startDate: $("input[name='startDate']").val()
            }
            dataTable.reload(options);
        }
        
        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
	               var add = layer.open({
	                title: '墓地信息',
	                type: 2,
	                content: '/mudi/mudiMsg.html?qu='+data.qu+"&pai="+data.pai+"&hao="+data.hao,
	                area: ['0px', '0px'],
	                end: function () {
	                    
	                }
	            });
            	layer.full(add);
            }
        });
    });
</script>
<script type="text/html" id="toolbar">
    	<a class="layui-btn layui-btn-xs" lay-event="detail">详情</a>
</script>
</body>
</html>