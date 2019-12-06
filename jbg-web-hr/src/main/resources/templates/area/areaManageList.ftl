<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html>
<head>
	<@app.head title="区域管理"/>
	<style>
		body{overflow-y: scroll;overflow-x: scroll;}/*layui table滚动条导致横向滚动条*/
		.layui-btn-lg {
		    height: 100px;
		    line-height: 100px;
		    padding: 0 25px;
		    font-size: 55px;
		}
		
		.layui-form-label {
		    float: left;
		    display: block;
		    padding: 10px 20px;
		    width: 80px;
		    font-weight: 400;
		    line-height: 20px;
		    text-align: right;
		}
	</style>
</head>
<body >
<div class="layui-box" >
	
    <form class="layui-form" action="" >
    	<#list areaList as a>
    		<table ><tr>
    			<#list a.qulieList as p>
				    <th>
						<div class="layui-inline" >
							<label >
							<#if p.anzangshijian?? && p.allinfoId?? && p.anzangshijian != "">
								<img class="layui-upload-img demo" src="/images/bjs.png" id="demo1" height="90" width="70" onclick="toArea('${p.quid }','${p.pai}','${p.lie}')">
							<#elseif p.allinfoId?? >
								<img class="layui-upload-img demo" src="/images/bjd.png" id="demo1" height="90" width="70" onclick="toArea('${p.quid }','${p.pai}','${p.lie}')">
							<#else>
								<img class="layui-upload-img demo" src="/images/bjy.png" id="demo1" height="90" width="70" onclick="toArea('${p.quid }','${p.pai}','${p.lie}')">
							</#if>
							
							<div class="layui-form-item">
							<p id="imageText" style="color: red;" onclick="toArea('${p.quid }','${p.pai}','${p.lie}')">
							
							${p.pai}排${p.lie}号</p>
							</div></label></div>
					</th>
				</#list>
    		</tr></table>
    	</#list>
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
		var id = jbg.getUrlParam("id");
		
       
	});
	function toArea(qu,pai,hao){
			debugger;
		    var add = layer.open({
                title: '墓地信息',
                type: 2,
                content: '/mudi/mudiMsg.html?qu='+qu+"&pai="+pai+"&hao="+hao,
                area: ['0px', '0px'],
                end: function () {
                   location.reload();
                }
            });
            layer.full(add);
			return false;
		}
</script>
</body>
</html>