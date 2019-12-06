<!DOCTYPE html>
<html>
<head>
	<@app.head title="角色管理"/>
	<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
  	<link rel="stylesheet" href="/css/metroStyle/metroStyle.css" type="text/css">
  	<script type="text/javascript" src="/js/jquery.ztree.all.min.js"></script>
	<style>
		html{background-color: #f2f2f2;}
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px 15px;">
<div class="layui-row layui-col-space10">
	<div class="layui-col-md4">
		<div class="layui-card">
			<div class="layui-card-header">角色列表</div>
			<div class="layui-card-body">
				<ul id="roleTree" class="ztree"></ul>
			</div>
		</div>
	</div>
    <div class="layui-col-md8">
		<div class="layui-card">
			<div class="layui-card-header">角色详情</div>
			<div class="layui-card-body">
				<form class="layui-form" id="roleForm" action="">
					<input type="hidden" name="id"/>
					<div style="margin-top: 20px;"></div>
					<div class="layui-form-item">
						<label class="layui-form-label">角色名称</label>
						<div class="layui-input-block" style="width:250px;">
							<input type="text" name="name" lay-verify="required"
								placeholder="请输入角色名称" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-disabled" disabled="true" lay-submit lay-filter="updateBtn">修改</button>
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">创建</button>
							<button class="layui-btn layui-btn-disabled layui-btn-danger" disabled="true" lay-submit lay-filter="delBtn">删除</button>
						</div>
					</div>
				</form>
				<div class="layui-input-block">
					<ul id="resourceTree" class="ztree"></ul>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<script>
    layui.use(['form','layer','element'], function () {
        var layer = layui.layer, element=layui.element, form=layui.form;
        
        var currentNode,roleTree,resourceTree;
        
        var roleSetting = {
           		view : {showLine:false,showIcon:true},
       			data: {
       				key: {url: "xUrl"},//与node中的url分开
       				simpleData: {
       					enable: true,
       					idKey:'id',
       					pIdKey:'parentId'
       				}
       			},
           		callback: {
       				onClick : function(event, treeId, treeNode) {
       					jbg.apiRequest({
       			            url: '/admin/role/resource?roleId='+treeNode.id,
       			            method: 'GET', 
       			            dataType: 'json',
       			            success: function (result) {
	       						currentNode = treeNode;
	       						resourceTree.checkAllNodes(false);
	       						jbg.loadFormData($('#roleForm'), result);
	       						$.each(result.resources,function(index,element){
	       							var node = resourceTree.getNodeByParam("id", element.id, null);
	       							resourceTree.checkNode(node, true, false);
	       						});
	       						$('button[lay-filter="updateBtn"]').removeAttr("disabled","true").removeClass("layui-btn-disabled");
	       			        	$('button[lay-filter="delBtn"]').removeAttr("disabled","true").removeClass("layui-btn-disabled");
       			            }
       			        });
       				}
       			}
           	};
        
        var resourceSetting = {
       		view : {showLine:false,showIcon:true},
       		check:{
       			enable:true,
       			chkboxType:{ "Y" : "s", "N" : "ps" }
       		},
   			data: {
   				key: {url: "xUrl"},//与node中的url分开
   				simpleData: {
   					enable: true,
   					idKey:'id',
   					pIdKey:'parentId'
   				}
   			}
       	};
        
        jbg.apiRequest({
    		url : '/admin/resource',
    		success:function(resources) {
    			$.each(resources,function(index,element){
    				element.open =true;
        		});
    			resourceTree = $.fn.zTree.init($("#resourceTree"), resourceSetting, resources);
    		}
    	});
    	
    	jbg.apiRequest({
    		url : '/admin/role',
    		success:function(roles) {
    			$.each(roles,function(index,element){
    				element.open =true;
        		});
    			roleTree = $.fn.zTree.init($("#roleTree"), roleSetting, roles);
    		}
    	});
        
        function resourceToNodes(resources) {
    		$.each(resources,function(index,resource){
    			resource.open =true;
    		});
    		return resources;
    	}
        
        form.on('submit(updateBtn)', function (data) {
        	var params = $.extend({},data.field);
        	params.resources = resourceTree.getCheckedNodes();
            jbg.apiRequest({
                url: '/admin/role',
                method: 'put',
                data: JSON.stringify(params),
                success: function (result) {
                	$.extend(currentNode, result)
                	roleTree.updateNode(currentNode);
                	layer.alert("修改成功");
                }
            });
            return false;
        });
        
        form.on('submit(saveBtn)', function (data) {
        	var params = $.extend({},data.field);
        	params.resources = resourceTree.getCheckedNodes();
        	data.field.id = null;
            jbg.apiRequest({
                url: '/admin/role',
                method: 'post',
                data: JSON.stringify(params),
                success: function (result) {
                	roleTree.addNodes(null,result);
                	resetRoleForm();
                	layer.alert("创建成功");
                }
            });
            return false;
        });
        
        form.on('submit(delBtn)', function (data) {
            jbg.apiRequest({
                url: '/admin/role',
                method: 'delete',
                data: JSON.stringify(data.field),
                success: function (result) {
                	if(currentNode.children != undefined && currentNode.children.length > 0) {
                		layer.alert("请先删除该资源下级所有资源");
                	} else {
                		roleTree.removeNode(currentNode);
                		resetRoleForm();
                		layer.alert("删除成功");
                	}
                }
            });
            return false;
        });
        
        function resetRoleForm() {
        	currentNode && roleTree.cancelSelectedNode(currentNode);
        	currentNode = null;
        	$("#roleForm")[0].reset();
        	$('button[lay-filter="updateBtn"]').attr("disabled","true").addClass("layui-btn-disabled");
        	$('button[lay-filter="delBtn"]').attr("disabled","true").addClass("layui-btn-disabled");
       		resourceTree && resourceTree.checkAllNodes(false);
        }
    });
</script>
</body>
</html>