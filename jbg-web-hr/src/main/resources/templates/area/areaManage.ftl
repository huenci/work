<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="区域管理"/>
	<style>
		body{overflow-y: scroll;}/*layui table滚动条导致横向滚动条*/
		.layui-btn-lg {
		    height: 100px;
		    line-height: 100px;
		    padding: 0 25px;
		    font-size: 55px;
		}
	</style>
</head>
<body>
<div class="layui-box" style="padding:15px;">
    <form class="layui-form" action="">
		<ul id = "classType">
	  	<li id="currentLi"></li>
	  </ul>
    </form>
</div>

<script>
	layui.use([ 'form', 'table', 'tree', 'layer', 'upload', 'element' ],function() {
		var form = layui.form
		var $ = layui.jquery, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		var cunt = 0;
		
		jbg.apiRequest({
            url: '/area/queryAreaPageAll',
            success: function (result) { 	
            	debugger;				            			            					           
            	//var elem_li = document.createElement('li');
		  		for(var i=0; i<result.length;i++){
            		document.getElementById("currentLi").innerHTML  += 
			  			  '<div class="layui-inline">'+
			  			  '<label class="layui-form-label" style="width: 100%;text-align: center;">'+
			  			  '<img class="layui-upload-img demo" id="demo1" height="100" width="100" onclick="toArea('+result[i].id+',\''+result[i].name+'\')">'+
			  			  	'<div class="layui-form-item">'+
			  			  	'<p id="imageText" style="color: red;" onclick="toArea('+result[i].id+',\''+result[i].name+'\')">'+result[i].name+'</p>'+
						 	'</div></label></div>';
            	}
            	$('.demo').attr('src', "/images/墓群2.jpg");
            }
        });
       
	});
	function toArea(id,name){
			debugger;
			var edit = layer.open({
                title: name,
                type: 2,
                fix:false,
                content: '/qulie/areaManageList.html?id=' + id,
                area: ['0', '0'],
                end: function () {
                    reload();
                }
        	});
            layer.full(edit);
			return false;
		}
</script>
</body>
</html>