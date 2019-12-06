<!DOCTYPE html>
<html>
<head><@app.head title="用户详情"/>
	<style>
		.layui-box .layui-form .layui-form-item {
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
	<div class="layui-box" style="width: 360px; height: 210px;">
		<form class="layui-form" id="passwordForm" action="">
			<input type="hidden" name="id"/>
		    <div style="margin-top: 20px;"></div>
		    <div class="layui-form-item">
				<label class="layui-form-label">原密码</label>
			    <div class="layui-input-inline">
			      <input type="password" name="rawPassword" lay-verify="password" placeholder="请输入原密码" autocomplete="off" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">新密码</label>
			    <div class="layui-input-inline">
			      <input type="password" name="newPassword" lay-verify="password" placeholder="请输入新密码" autocomplete="off" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码</label>
			    <div class="layui-input-inline">
			      <input type="password" name="confirmPassword" lay-verify="password|confirmPassword" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
			    </div>
			</div>
		    <div class="layui-form-item">
		        <div class="layui-input-block">
		            <button class="layui-btn" lay-submit lay-filter="saveBtn">修改</button>
		            <button class="layui-btn layui-btn-normal" id="cancelBtn">取消</button>
		        </div>
		    </div>
		</form>		
	</div>
	<script>
		layui.use([ 'form' ], function() {
			var $ = layui.$;
			var form = layui.form;
			var extendFormVerify = {
				confirmPassword:function(value, item) {
					var newPassword = $('input[name="newPassword"]').val();
					var rawPassword = $('input[name="rawPassword"]').val();
					if(newPassword != value) {
						return "确认密码必须必须与新密码一致";
					} 
					if(rawPassword==newPassword){
						return "新密码不能与原密码一致";
					}
					
				}
			}
			$.extend(extendFormVerify,formVerify);
			form.verify(extendFormVerify);
			form.on('submit(saveBtn)', function (data) {
				jbg.apiRequest({
					url:'/admin/user/password',
					method:'put',
					data: JSON.stringify(data.field),
	                success: function (result) {
	                	parent.layer.alert("修改成功", function (index) {
	                        var dialog = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	                        parent.layer.close(dialog);
	                        parent.layer.close(index);
	                    });
	                },
	                fail:function(data) {
	                	parent.layer.alert(data.resInfo,{icon: 0});
	                },
	                error:function() {
	                	parent.layer.alert("请求服务器错误",{icon: 5});
	                }
				});
				return false;
			});
			
			$('#cancelBtn').on('click', function () {
				var dialog = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(dialog);
				return false;
			});
		});
	</script>
</body>
</html>