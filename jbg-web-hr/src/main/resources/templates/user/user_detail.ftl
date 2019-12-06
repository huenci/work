<!DOCTYPE html>
<html>
<head>
	<@app.head title="用户详情"/>
	<style>
 		.layui-box .layui-form .layui-form-item {
			margin-bottom: 10px;
		}
		
		.layui-form .layui-form-item .layui-content {
			padding:9px 15px;
			margin-bottom: 10px;
		}
		
		.layui-form-item .layui-inline {
			display: inline-block;
		}
	</style>
</head>
<body>
	<div class="layui-box" style="width: 350px; height: 300px;">
		<form class="layui-form" id="userForm" action="">
			<input type="hidden" name="id"/>
		    <div style="margin-top: 20px;"></div>
		    <div class="layui-form-item">
			        <label class="layui-form-label">用户名</label>
			        <div class="layui-inline layui-content">
				        ${user.username}
				    </div>
		    </div>
		    
		    <div class="layui-form-item">
		            <label class="layui-form-label">姓名</label>
		            <div class="layui-inline layui-content">
				        ${user.realName}
				    </div>
		    </div>
		    
		    <div class="layui-form-item">
				    <label class="layui-form-label">性别</label>
				    <div class="layui-inline layui-content">
				          ${user.gender}
				    </div>
		  	</div>
		    
		    <div class="layui-form-item">
		            <label class="layui-form-label">过期时间</label>
		            <div class="layui-inline layui-content">
			        	 ${(user.expireTime?string("yyyy-MM-dd HH:mm:ss"))!"永不过期"}
			        </div>
		    </div>
		    <div class="layui-form-item">
			        <label class="layui-form-label">状态</label>
			        <div class="layui-inline layui-content">
			        	 ${(user.status == '1')?string('正常','锁定')}
			        </div>
		    </div>
		</form>		
	</div>
	<script>
		layui.use([ 'table' ], function() {
			var $ = layui.$;
			var table = layui.table;
		});
	</script>
</body>
</html>