<!DOCTYPE html>
<html>
<head>
    <@app.head title="demo添加"/>
</head>
<body class="layui-layout-body">
<form class="layui-form" action="">
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
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline" style="width:450px;">
                <input type="text" name="phoneNumber" lay-verify="required" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">时间范围</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" name = "range" id="range" placeholder=" - ">
      </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" lay-verify="required" value="1" checked=""
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
        var t = "";
        laydate.render({
		    elem: '#range'
		    ,type: 'time'
		    ,range: true
		    ,format : 'HH:mm:ss'
		    ,done: function(value, date, endDate){
		    	var dhours = date.hours;
		    	var ehours = endDate.hours;
		    	date.minutes = 0;
		    	date.seconds = 0;
		    	endDate.minutes = 0;
		    	endDate.seconds = 0;
		    	if(dhours<10){
		    		dhours = "0"+dhours;
		    	}
		    	if(ehours<10){
		    		ehours = "0"+ehours;
		    	}
		    	t =dhours+":00:00 - "+ehours+":00:00";
			  }
		  });

        $("#resetBtn").on("click", function () {
            return false;
        });

        form.on('submit(saveBtn)', function (data) {
        	data.field.range = t;
        	debugger;
            jbg.apiRequest({
                url: '/smsmanage/saveSMSmanage',
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