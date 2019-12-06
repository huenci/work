<!DOCTYPE html>
<html>
<head>
    <@app.head title="区域添加"/>
</head>
<body class="layui-layout-body" style="padding:15px; overflow-y:auto;">
<form class="layui-form" action="" >
    <input type="hidden" name="id">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="name" lay-verify="required" placeholder="请输入名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-inline" >
			<select name="type" id = "type" >
			 		<option value="1">非公益性</option>
			 		<option value="2">公益性</option>
			</select>
		</div>
    </div>
   <div class="layui-form-item">
        <label class="layui-form-label">排数</label>
        <div class="layui-input-inline" style="width: 450px">
            <input id="sortNum" type="text" name="sortNum" lay-verify="required" placeholder="请输入此区域有多少排" class="layui-input">
        </div>
         <div class="layui-input-inline" style="width: 450px">
            <div id="submitPai"  class="layui-btn"  >确认排数</div>
        </div>
    </div>
    <div class="sub-box">
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="resetBtn">重置</button>
        </div>
    </div>
 
</form>
	<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
	
	<script>
	 $('#submitPai').click(function(){
	 	$('.sub-box').empty();
		var val = $('#sortNum').val();
		for(let i=0;i<val;i++){
			$('.sub-box').append('<div class="layui-form-item"> <label class="layui-form-label"> 第'+ ( i + 1 ) +'排列数:</label>   <div class="layui-input-inline" style="width: 450px"> <input id="n'+ ( i + 1 ) +'" type="text"  class="layui-input">         </div></div></div>');
	  }
	 });
	</script>
	
	
	
	
	
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
        
        form.on('submit(saveBtn)', function (data) {
        	var arr = [];
        	var istrue = false;
			$('.sub-box input').each(function(val){
				let json = {};
				debugger;
				json[$(this).attr('id')] = $(this).val();
				if(!$(this).val()){
					istrue = true;
					return false;				
				}
				arr.push( json );
			});
			if(istrue){
				layer.msg('请输入列数');
				return false;
			}
			layer.load(1);
		  	data.field.allLie = arr;
            jbg.apiRequest({
                url: '/area/insertArea',
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