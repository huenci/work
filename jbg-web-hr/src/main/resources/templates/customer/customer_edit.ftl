<!DOCTYPE html>
<html>
<head>
    <@app.head title="demo添加"/>
</head>
<body class="layui-layout-body" style="overflow:scroll">
<form class="layui-form" id="demoForm" action="">
    <input type="hidden" name="openId">
    <input type="hidden" name="headImgUrl" id = "headImgUrl">
    <input type="hidden" name="wechatName" id = "wechatName">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="customerName" lay-verify="required" placeholder="请输入姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	      <input type="radio" name="sex" id="sex" value="1" title="男" checked="">
	      <input type="radio" name="sex" id="sex" value="2" title="女">
	    </div>
	</div>
    <div class="layui-form-item">
    	<label class="layui-form-label">头像</label>
	    <div class="layui-upload">
		    <img class="layui-upload-img" id="demo1">
		    <p id="imageText"></p>
		</div>  
	</div>
	<div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="phoneNumber" lay-verify="required" placeholder="请输入姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
        </div>
    </div>
</form>
<script>
    layui.use(['form','upload','laydate'], function () {
        var $ = layui.$;
        var form = layui.form, layer = layui.layer, laydate = layui.laydate,upload  = layui.upload;
        laydate.render({
            elem: '#demoTime',
            type: 'datetime'
        });

        $("#resetBtn").on("click", function () {
            return false;
        });
        
        function loadData() {
            jbg.loadFormData($('#demoForm'), form.data);
            if(form.data.headImgUrl){
            	var url = form.data.headImgUrl;
	            $('#demo1').attr('src', url);
            }
            form.render();
        }

        jbg.apiRequest({
            url: '/customer/qryCustoemrByID/' + jbg.getUrlParam("id"),
            dataType: 'json',
            success: function (result) {
                form.data = result;
                loadData();
            }
        });

        form.on('submit(saveBtn)', function (data) {
            jbg.apiRequest({
                url: '/customer/updateCustomer',
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