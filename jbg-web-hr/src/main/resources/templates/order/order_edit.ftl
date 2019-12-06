<!DOCTYPE html>
<html>
<head>
    <@app.head title="订单编辑"/>
</head>
<body class="layui-layout-body">
<form class="layui-form" id="demoForm" action="">
    <input type="hidden" name="orderId">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="phoneNumber" lay-verify="required"  class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">订单金额</label>
            <div class="layui-input-inline" style="width:450px;">
                <input type="text" name="orderPrice" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline" style="width:450px;">
                <input type="text" name="count" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
		<div class="layui-form-label" >开始时间</div>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="startDate" name = "startDate" placeholder="开始时间">
		</div>
	</div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">订单状态</label>
            <div class="layui-input-inline">
			<select name="orderStatus">
				<option value="0">已报名</option>
				<option value="4">已确认</option>
				<option value="1">已修改</option>
				<option value="2">已结束</option>
				<option value="3">已取消</option>
			</select>
		</div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
        </div>
    </div>
</form>
<script>
    layui.use(['form', 'laydate'], function () {
        var $ = layui.$;
        var form = layui.form, layer = layui.layer, laydate = layui.laydate;
        laydate.render({
            elem: '#demoTime',
            type: 'datetime'
        });
		laydate.render({
            elem: '#startDate',
        });
        $("#resetBtn").on("click", function () {
            return false;
        });
        
        function loadData() {
            jbg.loadFormData($('#demoForm'), form.data);
            $("#startDate").val(moment(form.data.startDate).format('YYYY-MM-DD'));
            form.render();
        }

        jbg.apiRequest({
            url: '/order/queryByOrderId/' + jbg.getUrlParam("orderId"),
            dataType: 'json',
            success: function (result) {
                form.data = result;
                loadData();
            }
        });
        console.info(jbg);

        form.on('submit(saveBtn)', function (data) {
            jbg.apiRequest({
                url: '/order/updateByOrderId',
                method: 'post',
                data: JSON.stringify(data.field),
                success: function (result) {
                    layer.alert("保存成功", function (index) {
                        var dialog = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(dialog);
                        layer.close(index);
                    });
                }
            });
            return false;
        });
    });
</script>
</body>
</html>