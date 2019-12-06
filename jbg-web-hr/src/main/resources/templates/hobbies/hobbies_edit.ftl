<!DOCTYPE html>
<html>
<head>
    <@app.head title="demo添加"/>
</head>
<body class="layui-layout-body" style="overflow:scroll">
<form class="layui-form" id="demoForm" action="">
    <input type="hidden" name="id">
    <input type="hidden" name="imagesUrl" id = "imagesUrl">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="name" lay-verify="required" placeholder="请输入名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
    	<label class="layui-form-label">图片</label>
	    <div class="layui-upload">
		  <button type="button" class="layui-btn" id="image">上传图片</button>
		    <img class="layui-upload-img" id="demo1">
		    <p id="imageText"></p>
		</div>  
	</div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" lay-verify="required" value="0"
                   title="启用"> <input type="radio" name="status"
                                      lay-verify="required" value="1" title="停用">
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
            if(form.data.imagesUrl){
            	var url = form.data.imagesUrl;
	            $('#demo1').attr('src', url);
            }
            form.render();
        }

        jbg.apiRequest({
            url: '/hobbies/selectByPrimaryKey/' + jbg.getUrlParam("id"),
            dataType: 'json',
            success: function (result) {
                form.data = result;
                loadData();
            }
        });

        form.on('submit(saveBtn)', function (data) {
            jbg.apiRequest({
                url: '/hobbies/updateByPrimaryKey',
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
      //普通图片上传
        var uploadInst = upload.render({
          elem: '#image'
          ,url: '/hobbies/uploadFile'
          ,size : 1024
          ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
              $('#demo1').attr('src', result); //图片链接（base64）
            });
          }
          ,done: function(res){
        	  debugger;
            //如果上传失败
            if(res.code > 0){
              return layer.msg('上传失败');
            }
            $("#imagesUrl").val(res.data);
          }
          ,error: function(){
          }
        });
    });
</script>
</body>
</html>