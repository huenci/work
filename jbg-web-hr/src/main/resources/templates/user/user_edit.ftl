<!DOCTYPE html>
<html>
<head>
    <@app.head title="用户编辑"/>
</head>
<body class="layui-layout-body">
<form class="layui-form" id="userForm" action="">
	<input type="hidden" name="id"/>
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="username" lay-verify="username" placeholder="请输入用户名" class="layui-input layui-disabled" readonly="readonly">
        </div>
    </div>
    
    <div class="layui-form-item">
		<label class="layui-form-label">密码</label>
	    <div class="layui-input-inline" style="width: 450px">
	      <input type="password" name="password" lay-verify="password" placeholder="******" autocomplete="off" class="layui-input">
	    </div>
	    <div class="layui-form-mid layui-word-aux"></div>
	</div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline" style="width:450px;">
                <input type="text" name="realName" lay-verify="required" class="layui-input">
            </div>
        </div>
    </div>
    
    <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	      <input type="radio" name="gender" lay-verify="required" value="男" title="男">
	      <input type="radio" name="gender" lay-verify="required" value="女" title="女">
	    </div>
  	</div>
    
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">过期时间</label>
            <div class="layui-input-inline">
                <input type="dateTime" name="expireTime" id="expireTime" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" lay-verify="required" value="1"
                   title="启用"> <input type="radio" name="status"
                                      lay-verify="required" value="0" title="锁定">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="resetBtn">重置</button>
        </div>
    </div>
</form>
<script>
    layui.use(['form', 'laydate'], function () {
        var $ = layui.$;
        var form = layui.form, layer = layui.layer, laydate = layui.laydate;
        laydate.render({
            elem: '#expireTime',
            type: 'datetime'
        });
		
		form.verify(formVerify);
		
        $("#resetBtn").on("click", function () {
            return false;
        });
        
        function loadData() {
            jbg.loadFormData($('#userForm'), form.data);
            if(form.data.expireTime!=undefined){ 
            	$('#expireTime').val(moment(form.data.expireTime).format('YYYY-MM-DD HH:mm:ss'));
            }
            form.render();
        }

        jbg.apiRequest({
            url: '/admin/user/' + jbg.getUrlParam("userId"),
            dataType: 'json',
            success: function (result) {
                form.data = result;
                loadData();
            }
        });

        form.on('submit(saveBtn)', function (data) {
            jbg.apiRequest({
                url: '/admin/user',
                method: 'put',
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