<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="乌山八景陵园管理系统"/>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">
				<a href="/admin/" style="color: #009688; font-size: 18px;">乌山八景陵园管理系统</a>
			</div>
			<ul class="layui-nav layui-layout-left">
			</ul>
			<ul class="layui-nav layui-layout-right" lay-filter="userNav">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="/images/default_header.jpg" class="layui-nav-img">
						<@security.authentication property="principal.realName"/>
				</a>
					<dl class="layui-nav-child" id="userNavMenu">
						<dd data-type="detail" data-url="/admin/user/detail.html">
							<a href="javascript:;">个人资料</a>
						</dd>
						<dd data-type="password" data-url="/admin/user/password.html">
							<a href="javascript:;">修改密码</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item" id="logoutBtn"><a
					href="javascript:;">注销</a></li>
			</ul>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree"
					lay-filter="menuItem"  lay-shrink="all">
					<#list menus as menu>   
			            <li class="layui-nav-item">
							<a href="javascript:;">${menu.name}</a>
							<dl class="layui-nav-child">
								<#if menu.subMenus?exists>
									<#list menu.subMenus as subMenu>
										<dd>
											<a href="javascript:;" data-url="${subMenu.url}">${subMenu.name}</a>
										</dd>
									</#list> 
								</#if>
							</dl> 
						</li>
			        </#list> 
				</ul>
			</div>
		</div>
		
		<div class="layui-layout">
			<div class="layui-body" style="font-size: 0;bottom: 0px;">
				<iframe src="" frameborder="0" id="mainFrame"
					style="width: 100%; height: 100%;"></iframe>
			</div>
		</div>
	</div>
	<script>
		//JavaScript代码区域
		layui.use([ 'element', 'layer' ], function() {
			var element = layui.element;
			var $ = layui.$;
			element.on("nav(menuItem)", function(elem) {
				$(elem).parents("li").addClass("layui-nav-itemed")
				$("#mainFrame").attr("src", $(elem).attr("data-url"));
				layui.data("config", {
					key : 'menu',
					value : $(elem).attr("data-url")
				});
			});

			var config = layui.data("config");
			var menuUrl = config.menu;
			if (menuUrl == undefined) {
				menuUrl = $($("dd a", '.layui-nav-tree')[0]).attr("data-url");
			}
			var navItem = $('dd a[data-url="' + menuUrl + '"]', '.layui-nav-tree');
			if(navItem.length == 0) {
				navItem = $("dd a", '.layui-nav-tree')[0];
			}
			$(navItem).trigger('click');
			
			//让导航在最佳位置
		    var itemTop = navItem.offset().top
		    ,winHeight = $(window).height()
		    ,elemScroll = $('.layui-side-scroll');
		    if(itemTop > winHeight - 120){
		      elemScroll.animate({'scrollTop': itemTop/2}, 200)
		    }
			
			$("#logoutBtn").on("click",function(){
				jbg.apiRequest({
		            url: '/admin/logout',
		            method:'GET',
				    fail:function() {},
				    error:function() {},
				    complete : function() {
				    	layer.open({
						  	content: "注销成功",
						  	end:function() {
					    		window.location = "/admin/";
				    		}
						}); 
				    }
				});
			});
			
			element.on('nav(userNav)', function(elem){
            	$('#userNavMenu').removeClass("layui-show");
            	$(elem).parent().removeClass("layui-this");
            	var type = $(elem).parent().attr("data-type");
            	var openUrl = $(elem).parent().attr("data-url");
            	if(type == 'detail') {
	            	var frame = layer.open({
	                    title: '用户信息',
	                    type: 2,
	                    content: openUrl,
	                    area: ['380px', '380px'],
	                    end: function () {
	                    }
	           		 
            		});
            	} else if(type == 'password') {
   	            	var frame = layer.open({
   	                    title: '修改密码',
   	                    type: 2,
   	                    content: openUrl,
   	                    area: ['400px', '280px'],
   	                    end: function () {
   	                    }
   	           		 
               		});
            	}
			});
		});
	</script>
</body>
</html>