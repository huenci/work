<!DOCTYPE html>
<html>
<head>
	<@app.head title="资源列表"/>
	<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
  	<link rel="stylesheet" href="/css/metroStyle/metroStyle.css" type="text/css">
  	<script type="text/javascript" src="/js/jquery.ztree.all.min.js"></script>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
		html{background-color: #f2f2f2;}
		
		.layui-elem-quote{background-color: #ffffff;cursor: pointer;boder:1px solid #e6e6e6;}
		.layui-quote-nm{border:none;border-left:5px solid #e6e6e6;}
		
/*  		.ztree li span.button.switch{display: none;} */
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px 15px;;">
<div class="layui-row layui-col-space10">
	<div class="layui-col-md4">
		<div class="layui-card">
        <div class="layui-card-header">
          	资源列表
        </div>
        <div class="layui-card-body">
			<ul id="resourceTree" class="ztree"></ul>
        </div>
      </div>
    </div>
    <div class="layui-col-md8">
		<div class="layui-card">
			<div class="layui-card-header">资源详情</div>
			<div class="layui-card-body layui-text">
				<form class="layui-form" id="resourceForm" action="">
					<input type="hidden" name="id"/>
					<div style="margin-top: 20px;"></div>
					<div class="layui-form-item">
						<label class="layui-form-label">资源名称</label>
						<div class="layui-input-block">
							<input type="text" name="name" lay-verify="required"
								placeholder="请输入资源名称" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">资源描述</label>
						<div class="layui-input-block">
							<input type="text" name="resDesc" placeholder="请输入描述"
								autocomplete="off" class="layui-input">
						</div>
<!-- 						<div class="layui-form-mid layui-word-aux"></div> -->
					</div>
					
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">上级资源</label>
							<div class="layui-input-inline" style="width: 150px">
								<select id="parentSelect" name="parentId">
								</select>
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">排序</label>
							<div class="layui-input-block">
								<input type="text" name="sort" lay-verify="required"
									placeholder="排序" class="layui-input">
							</div>
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">资源URL</label>
						<div class="layui-input-inline">
							<input type="text" name="url" class="layui-input">
						</div>
						<div class="layui-input-inline">
							<input type="checkbox" name="matchType" title="模糊匹配" value="pattern" lay-skin="primary">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">权限</label>
						<div class="layui-input-block">
							<input type="text" name="authority" lay-verify="required"
								placeholder="请输入权限" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">请求方式</label>
							<div class="layui-input-block" style="width: 150px">
								<select name="httpMethod">
									<option value="">请选择</option>
									<option value="GET">GET</option>
									<option value="POST">POST</option>
									<option value="PUT">PUT</option>
									<option value="PATCH">PATCH</option>
									<option value="DELETE">DELETE</option>
								</select>
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">资源类型</label>
							<div class="layui-input-block" style="width: 150px">
								<select name="type" lay-verify="required">
									<option value="">请选择</option>
									<option value="menu_group">菜单组</option>
									<option value="menu">菜单</option>
									<option value="page">页面</option>
									<option value="api">接口</option>
									<option value="button">按钮</option>
									<option value="biz">业务</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-disabled" disabled="true" lay-submit lay-filter="updateBtn">修改</button>
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">添加</button>
							<button class="layui-btn layui-btn-disabled layui-btn-danger" disabled="true" lay-submit lay-filter="delBtn">删除</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
<script>
    layui.use(['form','layer','element'], function () {
        var layer = layui.layer, element=layui.element, form=layui.form;
        
        var currentNode,resourceTree;
        
        var setting = {
       		view : {showLine:false,showIcon:true},
//        	check:{enable:true},
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
   					currentNode = treeNode;
   					debugger;
   					$("#resourceForm")[0].reset();
   					jbg.loadFormData($('#resourceForm'), treeNode);
   					$('button[lay-filter="updateBtn"]').removeAttr("disabled","true").removeClass("layui-btn-disabled");
			        $('button[lay-filter="delBtn"]').removeAttr("disabled","true").removeClass("layui-btn-disabled");
   					form.render();
   				}
   			}
       	};
        
        jbg.apiRequest({
    		url : '/admin/resource',
    		success:function(result) {
   	    		$.each(result,function(index,resource){
   	    			resource.open =true;
   	    		});
    			resourceTree = $.fn.zTree.init($("#resourceTree"), setting, result);
    			initParentSelect(result);
    		}
    	});
        
        function initParentSelect(data) {
        	$("#parentSelect").empty();
			$("#parentSelect").append('<option value="0">请选择</option>');
			$.each(data,function(index,element){
    			var option = $("<option>").val(element.id).text(element.name);
    			$("#parentSelect").append(option);
			});
			form.render('select');
        }
        
        form.on('submit(updateBtn)', function (data) {
            jbg.apiRequest({
                url: '/admin/resource',
                method: 'put',
                data: JSON.stringify(data.field),
                success: function (result) {
                	if(result.parentId != currentNode.parentId) {
                		var parentNode = resourceTree.getNodeByParam("id", result.parentId, null);
                		resourceTree.moveNode(parentNode, currentNode, "inner");
                	}
               		$.extend(currentNode, result)
                   	resourceTree.updateNode(currentNode);
                	$('option[value="'+result.id+'"]',"#parentSelect").text(result.name);
                	form.render('select');
                	layer.alert("修改成功");
                }
            });
            return false;
        });
        
        form.on('submit(saveBtn)', function (data) {
        	data.field.id = null;
            jbg.apiRequest({
                url: '/admin/resource',
                method: 'post',
                data: JSON.stringify(data.field),
                success: function (result) {
               		var parentId = $('select[name="parentId"]').val();
               		var parentNode = resourceTree.getNodeByParam("id", parentId, null);
                	resourceTree.addNodes(parentNode,result);
                	resetResourceForm();
                	var option = $("<option>").val(result.id).text(result.name);
        			$("#parentSelect").append(option);
        			form.render('select');
                }
            });
            return false;
        });
        
        form.on('submit(delBtn)', function (data) {
            jbg.apiRequest({
                url: '/admin/resource',
                method: 'delete',
                data: JSON.stringify(data.field),
                success: function (result) {
                	if(currentNode.children != undefined && currentNode.children.length > 0) {
                		layer.alert("请先删除该资源下级所有资源");
                	} else {
                		resourceTree.removeNode(currentNode);
                		resetResourceForm();
                		$('option[value="'+result.id+'"]',"#parentSelect").remove();
                		form.render('select');
                    	layer.alert("删除成功");
                	}
                }
            });
            return false;
        });
        
        function resetResourceForm() {
        	currentNode && resourceTree.cancelSelectedNode(currentNode);
        	currentNode = null;
        	$("#resourceForm")[0].reset();
    		$('button[lay-filter="updateBtn"]').attr("disabled","true").addClass("layui-btn-disabled");
        	$('button[lay-filter="delBtn"]').attr("disabled","true").addClass("layui-btn-disabled");
        }
    });
</script>
</body>
</html>