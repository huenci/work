<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<title>乌山八景陵园管理系统</title>
		<script src="/layui/layui.js"></script>
		<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/jquery.particleground.min.js"></script>
		<link rel="stylesheet" href="/layui/css/layui.css"/>
		<link rel="stylesheet" href="/css/login.css" />
	</head>

	<body class="beg-login-bg">
		<div id="particles" class="particles-box"></div>
		<div class="beg-login-box">
			<header>

				<h1>乌山八景陵园管理系统</h1>
			</header>
			<div class="beg-login-main">
				<form action="/admin/login" class="layui-form" method="post">
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        	<i class="layui-icon">&#xe612;</i>
                    	</label>
						<input type="text" name="username" lay-verify="username" lay-verType="tips" autocomplete="off" placeholder="请输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">

                        	<i class="layui-icon">&#xe637;</i>
                    	</label>
						<input type="password" name="password" lay-verify="password"  lay-verType="tips" autocomplete="off" placeholder="请输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div>
							<button class="layui-btn layui-btn-primary" style="width:100%;" lay-submit lay-filter="login">
                            	<i class="layui-icon" style="font-size:14px">&#xe650;</i> 
                            	登录 
                            	<i class="layui-icon" style="font-size:14px">&#xe650;</i>
                        	</button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
<!-- 			<footer> -->
<!-- 				<p>©湖南家边购实业集团有限公司版权所有</p> -->
<!-- 				<p>湘ICP备17014741号</p> -->
<!-- 			</footer> -->
		</div>
		<script>
			layui.use(['layer', 'form'], function() {
				$('#particles').particleground({
				    dotColor: '#999999'
				    ,lineColor: '#999999'
				    ,proximity:120
				    ,particleRadius:1
				    ,lineWidth:0.2
				    ,density:8000
				    ,parallax:false
// 				    ,parallaxMultiplier:10
// 				    ,curvedLines:true
				    
				});
				var layer = layui.layer,
					form = layui.form;
				
				   
				form.on('submit(login)',function(data){
					jbg.apiRequest({
		                url: '/admin/login',
		                method: 'post',
		                contentType: 'application/x-www-form-urlencoded',
		                data: data.field,
		                success: function (result) {
		                	window.location = result;
		                },
		                fail : function(res) {
	    					layer.alert(res.resInfo,{icon: 0})
		                }
		            });
		            return false;
				});
				
			});
		</script>
		
		<script type="text/javascript"> 
			if (top.location !== self.location) {
			    top.location=self.location;
			}
		</script>
	</body>
</html>