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
<body class="layui-layout-body" style="padding:15px; overflow-y:auto;">
 <form class="layui-form" id="jmhtForm" action="">
<div class="layui-tab layui-tab-card">
  <ul class="layui-tab-title">
    <li class="layui-this">建墓合同</li>
    <li>建墓工程单</li>
    <li>碑文信息</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
		<input type="hidden" name="id" id = "id">
		<input type="hidden" name="qu" id = "qu">
		<input type="hidden" name="pai" id = "pai">
		<input type="hidden" name="hao" id = "hao">
		<input type="hidden" name="type" id = "type">
    	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  			<legend>修改购买墓碑合同</legend>
		</fieldset>
    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">销售方（甲方）：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="xiaoshoufang" name="xiaoshoufang"  placeholder="请输入销售方" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">购买方（乙方）：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="goumaifang" name="goumaifang"  placeholder="请输入购买方" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">购买方联系地址：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="goumaifangdizhi" name="goumaifangdizhi"  placeholder="请输入购买方联系地址" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">购买方联系电话：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="goumaifangdianhua" name="goumaifangdianhua"  placeholder="请输入购买方联系电话" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">墓区位置：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="position" name="position"  placeholder="请输入墓区位置" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">验收时间：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="yanshoushijian" name="yanshoushijian"  placeholder="请输入验收时间" class="layui-input">
	        </div>
	    </div>
	   
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">墓型名称：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="muxingmingcheng"  name="muxingmingcheng"  placeholder="请输入墓型名称" class="layui-input">
	        </div>
	    </div>
	    <@security.authorize access="hasAuthority('bijing_save')">
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">购墓费：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="goumufei" name="goumufei"  placeholder="请输入购墓费" class="layui-input">
	        </div>
	    </div> 
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">管理费：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="guanlifei" name="guanlifei"  placeholder="请输入管理费" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">合墓费：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="hemufei" name="hemufei"  placeholder="请输入合墓费" class="layui-input">
	        </div>
	    </div> 
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">总金额：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="zongjine" name="zongjine"  placeholder="请输入总金额" class="layui-input">
	        </div>
	    </div>
	    </@security.authorize>
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">结算方式：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="jiesuanfangshi" name="jiesuanfangshi"  placeholder="结算方式" class="layui-input">
	        </div>
	    </div>
	    
	   <div class="layui-form-item">
        <div class="layui-input-block">
        	<@security.authorize access="hasAuthority('bijing_save')">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="print1">打印</button>
            </@security.authorize>
        </div>
      </div>
    </div>
    <div class="layui-tab-item">
    	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  			<legend>修改建墓工程单</legend>
		</fieldset>
    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">墓型名称：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" name="muxingmingcheng"  placeholder="请输入销售方" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzhexingming" name="wangzhexingming"  placeholder="请输入亡者姓名" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">墓区位置：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" name="position"  placeholder="请输入墓区位置" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">安葬时间：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="anzangshijian" name="anzangshijian"  placeholder="请输入安葬时间" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">验收时间：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="yanshoushijian1" name="yanshoushijian1"  placeholder="请输入验收时间" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">增减项目：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="zengjianxiangmu" name="zengjianxiangmu"  placeholder="请输入增减项目" class="layui-input">
	        </div>
	    </div>
	   
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">八景公墓经办人：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="jingbanren" name="jingbanren"  placeholder="请输入八景公墓经办人" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">施工方责任人：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="zerenren" name="zerenren"  placeholder="请输入施工方责任人" class="layui-input">
	        </div>
	    </div> 
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">安葬方：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="anzangfang" name="anzangfang"  placeholder="请输入安葬方" class="layui-input">
	        </div>
	    </div>
	    
	   <div class="layui-form-item">
        <div class="layui-input-block">
            <@security.authorize access="hasAuthority('bijing_save')">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="print2">打印</button>
             </@security.authorize>
        </div>
      </div>
    </div>
    <div class="layui-tab-item">
    	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  			<legend>修改碑文信息</legend>
		</fieldset>
		
		<div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">墓区位置：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id= "mubeiposition" name="position"  placeholder="请输入墓区位置" class="layui-input">
	        </div>
	    </div>
	    
	   <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">死者1：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" id="sizhexingming1" name="sizhexingming1"  placeholder="死者1姓名" class="layui-input">
	        </div>
	        
	        <label class="layui-form-label" style="width: 50px;">性别：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" id="sizhexingbie1" name="sizhexingbie1"  placeholder="性别" class="layui-input">
	        </div>
	        
	       <label class="layui-form-label" style="width: 50px;">生于：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" name="sizheshengyu1" id="sizheshengyu1" placeholder="出生日期" class="layui-input">
	        </div>
	        
	       <label class="layui-form-label" style="width: 50px;">死于：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" name="sizhesiyu1" id="sizhesiyu1" placeholder="死亡日期" class="layui-input">
	        </div>
	        
	    </div>
		
	   <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">死者2：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" id="sizhexingming2" name="sizhexingming2"  placeholder="死者2姓名" class="layui-input">
	        </div>
	        
	        <label class="layui-form-label" style="width: 50px;">性别：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" id="sizhexingbie2" name="sizhexingbie2"  placeholder="性别" class="layui-input">
	        </div>
	        
	       <label class="layui-form-label" style="width: 50px;">生于：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" name="sizheshengyu2" id="sizheshengyu2" placeholder="出生日期" class="layui-input">
	        </div>
	        
	       <label class="layui-form-label" style="width: 50px;">死于：</label>
	        <div class="layui-input-inline" style="width: 120px">
	            <input type="text" name="sizhesiyu2" id="sizhesiyu2" placeholder="死亡日期" class="layui-input">
	        </div>
	        
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">碑文显示：</label>
	        <div class="layui-input-inline" style="width: 450px">
				<select name="beiwenxianshi" id = "beiwenxianshi">
					<option value="">请选择</option>
					<option value="显考">显考</option>
					<option value="祖考">祖考</option>
					<option value="曾祖考">曾祖考</option>
					<option value="显妣">显妣</option>
					<option value="祖妣">祖妣</option>
					<option value="曾祖妣">曾祖妣</option>
				</select>
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者儿子姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzheerzixingming" name="wangzheerzixingming"  placeholder="亡者儿子姓名" class="layui-input">
	        </div>
	    </div>
		
		<div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者女儿姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzhennverxingming" name="wangzhennverxingming"  placeholder="请输入亡者女儿姓名" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者儿媳姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzheerxixingming" name="wangzheerxixingming"  placeholder="请输入亡者儿媳姓名" class="layui-input">
	        </div>
	    </div>
		
		<div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者女婿姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzhenvxuxingming" name="wangzhenvxuxingming"  placeholder="请输入亡者女婿姓名" class="layui-input">
	        </div>
	    </div>
	    
	    <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者孙辈姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzhesunbeixingming" name="wangzhesunbeixingming"  placeholder="请输入亡者孙辈姓名" class="layui-input">
	        </div>
	    </div>
	    
	   <div class="layui-form-item">
	        <label class="layui-form-label" style="width: 200px;">亡者曾孙辈姓名：</label>
	        <div class="layui-input-inline" style="width: 450px">
	            <input type="text" id="wangzhezengsunbeixingming" name="wangzhezengsunbeixingming"  placeholder="请输入亡者曾孙辈姓名" class="layui-input">
	        </div>
	    </div>
	    
	   <div class="layui-form-item">
        <div>
            <@security.authorize access="hasAuthority('bijing_save')">
            <div id = "feigy" class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="print3">打印-横版</button>
            <button class="layui-btn layui-btn-primary" id="print4">打印-竖版</button>
            </div>
            <div id = "gy" class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
            <button class="layui-btn layui-btn-primary" id="print5">打印</button>
            </div>
            </@security.authorize>
        </div>
      </div>
    </div>
  </div>
</div>
 </form>
<script>
layui.use(['element','form', 'laydate'], function(){
  var $ = layui.jquery
  ,element = layui.element , laydate = layui.laydate ,form = layui.form; //Tab的切换功能，切换事件监听等，需要依赖element模块
	   var qu = jbg.getUrlParam("qu");
	   var pai = jbg.getUrlParam("pai");
	   var hao = jbg.getUrlParam("hao");
	   $("#qu").val(qu);
	   $("#pai").val(pai);
	   $("#hao").val(hao);
	   jbg.apiRequest({
            url: '/qulie/queryAllinfo?qu='+qu+"&pai="+pai+"&hao="+hao,
            success: function (result) { 	
            	debugger;
            	jbg.loadFormData($('#jmhtForm'), result);
            	jbg.loadFormData($('#gcdForm'), result);	
            	jbg.loadFormData($('#bwxxForm'), result);
            	if(result.type == 1){
            		$("#feigy").show();
            		$("#gy").hide();
            	}else{
            		$("#feigy").hide();
            		$("#gy").show();
            	}	
            }
        });
       laydate.render({
            elem: '#yanshoushijian',
       });
       
       laydate.render({
            elem: '#yanshoushijian1',
       });
       
       laydate.render({
            elem: '#anzangshijian',
       });
       
       laydate.render({
            elem: '#sizheshengyu1',
       });
       
       laydate.render({
            elem: '#sizhesiyu1',
       });
       
       laydate.render({
            elem: '#sizheshengyu2',
       });
       
       laydate.render({
            elem: '#sizhesiyu2',
       });
  	   form.on('submit(saveBtn)', function (data) {
  	   		debugger;
            jbg.apiRequest({
                url: '/mudi/insertAllInfo',
                method: 'POST',
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
        
       $("#print1").click(function(){
       		debugger;
	        var xiaoshoufang = $("#xiaoshoufang").val();
	        var goumaifang = $("#goumaifang").val();
	        var goumaifangdianhua = $("#goumaifangdianhua").val();
	        var position = $("#position").val();
	        var yanshoushijian = $("#yanshoushijian").val();
	        var muxingmingcheng = $("#muxingmingcheng").val();
	        var goumufei = $("#goumufei").val();
	        var guanlifei = $("#guanlifei").val();
	        var hemufei = $("#hemufei").val();
	        var zongjine = $("#zongjine").val();
	        var jiesuanfangshi = $("#jiesuanfangshi").val();
	       	var url = encodeURI("/mudi/print1.html?xiaoshoufang="+xiaoshoufang+"&goumaifang="+goumaifang+"&goumaifangdianhua="+goumaifangdianhua+"&position="+position
	       	+"&yanshoushijian="+yanshoushijian+"&muxingmingcheng="+muxingmingcheng+"&goumufei="+goumufei+"&guanlifei="+guanlifei+"&guanlifei="+guanlifei+"&hemufei="+hemufei
	       	+"&zongjine="+zongjine+"&jiesuanfangshi="+jiesuanfangshi
	       	);
	        window.open(url); 
	        return false;
       });
        
        
       $("#print2").click(function(){
       		debugger;
       		var muxingmingcheng  = $("#muxingmingcheng").val();
       		var sizhexingming1 = $("#wangzhexingming").val();
       		var position = $("#position").val();
       		var anzangshijian = $("#anzangshijian").val();
       		var yanshoushijian = $("#yanshoushijian").val();
       		var zengjianxiangmu = $("#zengjianxiangmu").val();
       		var jingbanren = $("#jingbanren").val();
       		var zerenren = $("#zerenren").val();
       		var anzangfang =$("#anzangfang").val();
       		var url = encodeURI("/mudi/print2.html?muxingmingcheng="+muxingmingcheng+"&sizhexingming1="+sizhexingming1+"&position="+position+"&anzangshijian="+anzangshijian
       		+"&yanshoushijian="+yanshoushijian+"&zengjianxiangmu="+zengjianxiangmu+"&jingbanren="+jingbanren+"&zerenren="+zerenren+"&anzangfang="+anzangfang
       		);
            window.open(url); 
            return false;  
      });
      
      $("#print3").click(function(){
        var sizhexingming1 = $("#sizhexingming1").val();
        var sizhexingbie1 = $("#sizhexingbie1").val();
        var sizheshengyu1 = $("#sizheshengyu1").val();
        var beiwenxianshi = $("#beiwenxianshi").val();
        sizheshengyu1 = transDate(sizheshengyu1);
        var sizhesiyu1 = $("#sizhesiyu1").val();
        sizhesiyu1 = transDate(sizhesiyu1);
        var sizhexingming2 = $("#sizhexingming2").val();
        var sizhexingbie2 = $("#sizhexingbie2").val();
        var sizheshengyu2 = $("#sizheshengyu2").val();
        sizheshengyu2 = transDate(sizheshengyu2);
        var sizhesiyu2 = $("#sizhesiyu2").val();
        sizhesiyu2 = transDate(sizhesiyu2);
        var wangzheerzixingming = $("#wangzheerzixingming").val();
        var wangzhennverxingming = $("#wangzhennverxingming").val();
        var wangzheerxixingming = $("#wangzheerxixingming").val();
        var wangzhenvxuxingming = $("#wangzhenvxuxingming").val();
        var wangzhesunbeixingming = $("#wangzhesunbeixingming").val();
        var wangzhezengsunbeixingming = $("#wangzhezengsunbeixingming").val();
        var zerenren = $("#zerenren").val();
        var position = $("#mubeiposition").val();
        var url = encodeURI("/mudi/print3.html?sizhexingming1="+sizhexingming1+"&sizhexingbie1="+sizhexingbie1+"&sizheshengyu1="+sizheshengyu1+"&sizhesiyu1="+sizhesiyu1
       		+"&sizhexingming2="+sizhexingming2+"&sizhexingbie2="+sizhexingbie2+"&sizheshengyu2="+sizheshengyu2+"&sizhesiyu2="+sizhesiyu2+"&wangzheerzixingming="+wangzheerzixingming
       		+"&wangzhennverxingming="+wangzhennverxingming+"&wangzheerxixingming="+wangzheerxixingming+"&wangzhenvxuxingming="+wangzhenvxuxingming+"&wangzhesunbeixingming="+wangzhesunbeixingming
       		+"&zerenren="+zerenren+"&wangzhezengsunbeixingming="+wangzhezengsunbeixingming+"&beiwenxianshi="+beiwenxianshi+"&position="+position
       		);
        window.open(url);
        return false;
      }); 
      
      $("#print4").click(function(){
        var sizhexingming1 = $("#sizhexingming1").val();
        var sizhexingbie1 = $("#sizhexingbie1").val();
        var sizheshengyu1 = $("#sizheshengyu1").val();
        var beiwenxianshi = $("#beiwenxianshi").val();
        sizheshengyu1 = transDate(sizheshengyu1);
        var sizhesiyu1 = $("#sizhesiyu1").val();
        sizhesiyu1 = transDate(sizhesiyu1);
        var sizhexingming2 = $("#sizhexingming2").val();
        var sizhexingbie2 = $("#sizhexingbie2").val();
        var sizheshengyu2 = $("#sizheshengyu2").val();
        sizheshengyu2 = transDate(sizheshengyu2);
        var sizhesiyu2 = $("#sizhesiyu2").val();
        sizhesiyu2 = transDate(sizhesiyu2);
        var wangzheerzixingming = $("#wangzheerzixingming").val();
        var wangzhennverxingming = $("#wangzhennverxingming").val();
        var wangzheerxixingming = $("#wangzheerxixingming").val();
        var wangzhenvxuxingming = $("#wangzhenvxuxingming").val();
        var wangzhesunbeixingming = $("#wangzhesunbeixingming").val();
        var wangzhezengsunbeixingming = $("#wangzhezengsunbeixingming").val();
        var zerenren = $("#zerenren").val();
        var position = $("#mubeiposition").val();
        var url = encodeURI("/mudi/print4.html?sizhexingming1="+sizhexingming1+"&sizhexingbie1="+sizhexingbie1+"&sizheshengyu1="+sizheshengyu1+"&sizhesiyu1="+sizhesiyu1
       		+"&sizhexingming2="+sizhexingming2+"&sizhexingbie2="+sizhexingbie2+"&sizheshengyu2="+sizheshengyu2+"&sizhesiyu2="+sizhesiyu2+"&wangzheerzixingming="+wangzheerzixingming
       		+"&wangzhennverxingming="+wangzhennverxingming+"&wangzheerxixingming="+wangzheerxixingming+"&wangzhenvxuxingming="+wangzhenvxuxingming+"&wangzhesunbeixingming="+wangzhesunbeixingming
       		+"&zerenren="+zerenren+"&wangzhezengsunbeixingming="+wangzhezengsunbeixingming+"&beiwenxianshi="+beiwenxianshi+"&position="+position
       		);
        window.open(url);
        return false;
      }); 
      
      
      $("#print5").click(function(){
        var sizhexingming1 = $("#sizhexingming1").val();
        var sizhexingbie1 = $("#sizhexingbie1").val();
        var sizheshengyu1 = $("#sizheshengyu1").val();
        var beiwenxianshi = $("#beiwenxianshi").val();
        sizheshengyu1 = transDate(sizheshengyu1);
        var sizhesiyu1 = $("#sizhesiyu1").val();
        sizhesiyu1 = transDate(sizhesiyu1);
        var sizhexingming2 = $("#sizhexingming2").val();
        var sizhexingbie2 = $("#sizhexingbie2").val();
        var sizheshengyu2 = $("#sizheshengyu2").val();
        sizheshengyu2 = transDate(sizheshengyu2);
        var sizhesiyu2 = $("#sizhesiyu2").val();
        sizhesiyu2 = transDate(sizhesiyu2);
        var wangzheerzixingming = $("#wangzheerzixingming").val();
        var wangzhennverxingming = $("#wangzhennverxingming").val();
        var wangzheerxixingming = $("#wangzheerxixingming").val();
        var wangzhenvxuxingming = $("#wangzhenvxuxingming").val();
        var wangzhesunbeixingming = $("#wangzhesunbeixingming").val();
        var wangzhezengsunbeixingming = $("#wangzhezengsunbeixingming").val();
        var zerenren = $("#zerenren").val();
        var position = $("#mubeiposition").val();
        var url = encodeURI("/mudi/print5.html?sizhexingming1="+sizhexingming1+"&sizhexingbie1="+sizhexingbie1+"&sizheshengyu1="+sizheshengyu1+"&sizhesiyu1="+sizhesiyu1
       		+"&sizhexingming2="+sizhexingming2+"&sizhexingbie2="+sizhexingbie2+"&sizheshengyu2="+sizheshengyu2+"&sizhesiyu2="+sizhesiyu2+"&wangzheerzixingming="+wangzheerzixingming
       		+"&wangzhennverxingming="+wangzhennverxingming+"&wangzheerxixingming="+wangzheerxixingming+"&wangzhenvxuxingming="+wangzhenvxuxingming+"&wangzhesunbeixingming="+wangzhesunbeixingming
       		+"&zerenren="+zerenren+"&wangzhezengsunbeixingming="+wangzhezengsunbeixingming+"&beiwenxianshi="+beiwenxianshi+"&position="+position
       		);
        window.open(url);
        return false;
      }); 
      
      $("input[name='muxingmingcheng']").blur('input',function(){ 
        	$("input[name='muxingmingcheng']").val(this.value);
      }); 
      $('#goumufei').on('input',function(){ 
        	jisuan();
        }); 
        $('#guanlifei').on('input',function(){ 
        	jisuan();
        }); 
        $('#hemufei').on('input',function(){ 
        	jisuan();
        }); 
        function jisuan(){
        debugger;
        	var goumufei=$('#goumufei').val();
        	var guanlifei=$('#guanlifei').val();
        	var hemufei=$('#hemufei').val();
        	var zongjine = 0;
        	if(goumufei){
			    zongjine = zongjine + parseInt(goumufei);	
        	}
        	if(guanlifei){
			    zongjine =zongjine + parseInt(guanlifei);	
        	}
        	if(hemufei){
			    zongjine =zongjine + parseInt(hemufei);	
        	}
        	if(zongjine != 0){
        		//zongjine=zongjine.replace(/[^\d.]/g,""); 
	        	//zongjine=zongjine.replace(/^\./g,""); 
	        	//zongjine=zongjine.replace(/\.{2,}/g,"."); 
	        	//zongjine=zongjine.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	        	//zongjine=zongjine.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
	        	var pay = smalltoBIG(zongjine);
				$('#zongjine').val(pay=='NaN'?"":pay);
        	}else{
        		$('#zongjine').val("");
        	}
        }
      //转化为金额格式
		 function toMoney(money){
				var num=parseInt(money);
		        num = num.toFixed(2);
		        num = parseFloat(num)
		        num = num.toLocaleString();
		        return num;
		 }
	    //金额转大写
	    function smalltoBIG(n) {    
	        var fraction = ['角', '分'];    
	        var digit = ['零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'];    
	        var unit = [ ['元', '万', '亿'], ['', '拾', '佰', '仟']  ];    
	        var head = n < 0? '欠': '';    
	        n = Math.abs(n);    
	      
	        var s = '';    
	      
	        for (var i = 0; i < fraction.length; i++) {    
	            s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');    
	        }    
	        s = s || '整';    
	        n = Math.floor(n);    
	      
	        for (var i = 0; i < unit[0].length && n > 0; i++){    
	            var p = '';    
	            for (var j = 0; j < unit[1].length && n > 0; j++){    
	                p = digit[n % 10] + unit[1][j] + p;    
	                n = Math.floor(n / 10);    
	            }    
	            s = p.replace(/(零.)*零$/, '').replace(/^$/, '零')  + unit[0][i] + s;    
	        }    
	        return head + s.replace(/(零.)*零元/, '元').replace(/(零.)+/g, '零').replace(/^整$/, '零元整');    
	    } 

});
</script>

</script>
<script>
	 function transDate(dateStr){
        if(dateStr == null || dateStr == "undefined" || dateStr == ""){
        	return "";
        }
        var dateArry = dateStr.split('-');
      	var today=new Date(dateArry[0],dateArry[1]-1,dateArry[2]);
		var chinese = [ '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' ];
		var y = today.getFullYear().toString();
		var m = (today.getMonth() + 1).toString();
		var d = today.getDate().toString();
		var result = "";
		for (var i = 0; i < y.length; i++) {
			result += chinese[y.charAt(i)];
		}
		result += "年";
		if (m.length == 2) {
			if (m.charAt(0) == "1") {
				result += "十";
				if (m.charAt(1) != "0") {
					result += chinese[m.charAt(1)];
				}
				result += "月";
			}
		} else {
			result += (chinese[m.charAt(0)] + "月");
		}
		if (d.length == 2) {
			result += chinese[d.charAt(0)] + "十";
			if (d.charAt(1) != '0') {
				result += chinese[d.charAt(1)];
			}
			result += "日";
		} else {
			result += (chinese[d.charAt(0)] + "日");
		}
		return result.replace("月一十", "月十");
   }
</script>
</body>
</html>