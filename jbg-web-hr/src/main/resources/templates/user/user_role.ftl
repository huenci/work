<!DOCTYPE html>
<html>
<head>
    <@app.head title="用户角色分配"/>
    <style>
        html {
            background-color: #f2f2f2;
        }
		.col-box{
			vertical-align: top;
		}
    </style>
</head>
<body>
<div class="layui-box" style="padding:15px 0px 15px 30px;">
    <div class="layui-inline col-box" style="width:440px;margin-left:5px;">
	    <div class="layui-card">
	        <div class="layui-card-header">
	            	角色列表
	        </div>
	        <div class="layui-card-body">
	        	<form class="layui-form" action="">
			    	 <div id="roleBox" class="layui-form-item">
			        </div>
	         </form>
	    </div>
    </div>
    </div>
</div>
<script>
    layui.use(['form', 'layer', 'element'], function () {
        var layer = layui.layer, element = layui.element, form = layui.form;
        var $ = layui.$;
        jbg.apiRequest({
            url: '/admin/role',
            success: function (result) {
            	loadRoles(result)
            }
        });
        function loadRoles(roles) {
        	var userId = jbg.getUrlParam("userId");
        	var params = {
        			userId : userId
        	}
        	jbg.apiRequest({
                url: '/admin/user/role',
                data : params,
                method : 'GET',
                success: function (userRoles) {
                	$.each(roles,function(index,element){
                		var roleCheck = $('<input type="checkbox" name="roleId" lay-filter="role"/>').val(element.id).attr('title',element.name);
                		var box =$("<div/>")
                		roleCheck.appendTo(box);
                		$('#roleBox').append(box);
                	});
                	
                	$.each(userRoles, function(index,element) {
            			$('input[type="checkbox"][name="roleId"][value="'+element.id+'"]').attr("checked","");
            		})
                	form.render();
                }
            });
        }
        
        form.on('checkbox(role)', function(data){
        	var userId = jbg.getUrlParam("userId");
        	var params = {}
        	params.userId = userId;
        	params.status = data.elem.checked?'1':'0'
			params.roleId = data.value; 
       		jbg.apiRequest({
       			url: '/admin/user/role',
                data : JSON.stringify(params),
                method : 'PATCH',
                success : function(result) {
                	data.elem.checked = result.status == '1' ? true : false;
                	form.render('checkbox');
                }
       		});
       	});
    });
</script>
</body>
</html>