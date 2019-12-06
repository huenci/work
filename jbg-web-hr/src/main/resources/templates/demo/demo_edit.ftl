<!DOCTYPE html>
<html>
<head>
    <@app.head title="demo添加"/>
</head>
<body class="layui-layout-body">
<form class="layui-form" id="demoForm" action="">
    <input type="hidden" name="id">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="name" lay-verify="required" placeholder="请输入名称" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline" style="width:450px;">
                <input type="text" name="title" lay-verify="required" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">范围</label>
            <div class="layui-input-inline">
                <input type="text" name="min" lay-verify="required|number"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline">
                <input type="text" name="max" lay-verify="required|number"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">时间</label>
            <div class="layui-input-inline">
                <input type="dateTime" name="demoTime" id="demoTime"
                       lay-verify="required" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" lay-verify="required" value="1"
                   title="启用"> <input type="radio" name="status"
                                      lay-verify="required" value="0" title="停用">
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
            elem: '#demoTime',
            type: 'datetime'
        });

        $("#resetBtn").on("click", function () {
            return false;
        });
        
        function loadData() {
            jbg.loadFormData($('#demoForm'), form.data);
            form.render();
        }

        jbg.apiRequest({
            url: '/admin/demo/' + jbg.getUrlParam("id"),
            dataType: 'json',
            success: function (result) {
                form.data = result;
                loadData();
            }
        });
        console.info(jbg);

        form.on('submit(saveBtn)', function (data) {
            jbg.apiRequest({
                url: '/admin/demo',
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