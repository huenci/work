<!DOCTYPE html>
<html>
<head>
    <@app.head title="兴趣爱好添加"/>
</head>
<body class="layui-layout-body" style="overflow:scroll">
<form class="layui-form" action="">
    <input type="hidden" name="id">
    <input type="hidden" name="imageUrl" id = "imageUrl">
    <input type="hidden" name="detailsImageUrl" id = "detailsImageUrl">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="stitle" lay-verify="required" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">副标题</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="remark" lay-verify="required" placeholder="请输入副标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
	    <label class="layui-form-label">分类</label>
	    <div class="layui-input-block">
	      <input type="radio" name="classType"   value="0" title="小聚" checked="">
	      <input type="radio" name="classType"   value="1" title="短居">
	      <input type="radio" name="classType"   value="2" title="出游">
	    </div>
	</div>
    <div class="layui-form-item">
    	<label class="layui-form-label">产品图片</label>
	    <div class="layui-upload">
		  <button type="button" class="layui-btn" id="image">上传图片</button>
		  <button id="empty" class="layui-btn">清空</button>
		    <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
			    <div class="layui-upload-list" id="demo1"></div>
			 </blockquote>
		</div>  
	</div>
	<div class="layui-form-item">
    	<label class="layui-form-label">详细图片</label>
	    <div class="layui-upload">
		  <button type="button" class="layui-btn" id="detailsImage">上传图片</button>
		  <button id="detailsempty" class="layui-btn">清空</button>
		    <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
			    <div class="layui-upload-list" id="demo2"></div>
			 </blockquote>
		</div>  
	</div>
	<div class="layui-form-item">
        <label class="layui-form-label">库存数量</label>
        <div class="layui-input-inline" style="width: 450px">
            <input type="text" name="productNumber" lay-verify="required" placeholder="请输入库存数量" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">旅游周期</label>
	    <div class="layui-input-block" style="width: 450px">
	      <input type="text" name="cycle" lay-verify="required" placeholder="请输入旅游周期" class="layui-input">
	    </div>
	</div>
	<div class="layui-form-item">
	    <label class="layui-form-label">是否推送</label>
	    <div class="layui-input-block">
	      <input type="radio" name="isRecommend" id="isRecommend" lay-filter="recod" value="0" title="否" checked="">
	      <input type="radio" name="isRecommend" id="isRecommend" lay-filter="recod" value="1" title="是">
	    </div>
	</div>
	<div class="layui-form-item" id = "bqStatus">
		<label class="layui-form-label">标签</label>
	    <div class="layui-input-block">
	      <input type="radio" id = "rendStatus" name = "rendStatus" value="1" title="强烈推荐" checked="">
	      <input type="radio" id = "rendStatus" name = "rendStatus" value="2" title="人气爆款">
	      <input type="radio" id = "rendStatus" name = "rendStatus" value="3" title="即将推出">
	    </div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label" >价格<span style="color:red;">*</span></label>
		<div class="layui-input-inline"> 
			<input type="tel" name="amount" id="amount" lay-verify="required" placeholder="请输入价格" lay-filter="amount" class="layui-input">
		</div>
		<div class="layui-input-inline" style="width: 30%;">
			<span  style="color:#FF5722;font-size: 22px;font-weight: bold;" id="bigTxt"></span>元
		</div>
		<div class="layui-input-inline">
	      <input type="checkbox" name="actv" id= "actv" lay-filter="actv" title="活动">
	    </div>
	</div>
	<div id = "activity">
		<div class="layui-form-item">
			<label class="layui-form-label" >活动价格<span style="color:red;">*</span></label>
			<div class="layui-input-inline"> 
				<input type="text" id="activityAmount" placeholder="请输入价格" lay-filter="activityAmount" class="layui-input">
			</div>
			<div class="layui-input-inline" style="width: 30%;">
				<span  style="color:#FF5722;font-size: 22px;font-weight: bold;" id="activityTxt"></span>元
			</div>
		</div>
	</div>
	<div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-inline" >
            <input type="text" name="company" lay-verify="required" placeholder="请输入单位" class="layui-input">
        </div>
         <div class="layui-form-mid layui-word-aux">此处格式为：元/人、元/份</div>
    </div>
	<div class="layui-form-item">
	    <label class="layui-form-label">是否固定时间</label>
	    <div class="layui-input-block">
	      <input type="radio" name="isLockTime" id="isLockTime" value="0" title="否" checked="">
	      <input type="radio" name="isLockTime" id="isLockTime" value="1" title="是">
	    </div>
	</div>
	<div class="layui-form-item">
		<div class="layui-form-label" >时间</div>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="activityStartDate" name = "activityStartDate" placeholder="开始时间">
		</div>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="activityEndDate" name = "activityEndDate" placeholder="结束时间">
		</div>
	</div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" lay-verify="required" value="0" checked
                   title="上架"> <input type="radio" name="status"
                                      lay-verify="required" value="1" title="下架">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">保存</button>
        </div>
    </div>
</form>
<script>
    layui.use(['form','upload','laydate'], function () {
        var $ = layui.$;
        var form = layui.form, layer = layui.layer, laydate = layui.laydate,upload = layui.upload;
        $("#activity").hide();
        $("#bqStatus").hide();
        laydate.render({
            elem: '#activityStartDate',
        });
        laydate.render({
            elem: '#activityEndDate',
        });
        laydate.render({
            elem: '#lastStart'
            ,range: true
        });
        $("#resetBtn").on("click", function () {
            return false;
        });
        
        form.on('checkbox(actv)', function(data){
    	    if(data.elem.checked)
    	    {
    	    	 $("#activity").show();
    	    }else {
    	    	 $("#activity").hide();
    	    }
    	});
        
        form.on('radio(recod)', function(data){
    	    if('1' == this.value)
    	    {
    	    	 $("#bqStatus").show();
    	    }else {
    	    	 $("#bqStatus").hide();
    	    }
    	});
        
        $(document).on('click','#empty',function(){
         	$('#demo1 img').remove();
         	$("#imageUrl").val("");
         	return false;
     	});
     	
     	$(document).on('click','#detailsempty',function(){
         	$('#demo2 img').remove();
         	$("#detailsImageUrl").val("");
         	return false;
     	});
        
        form.on('submit(saveBtn)', function (data) {
        	debugger;
        	if('on' === data.field.actv){
        		if(!$("#activityAmount").val()){
        			layer.msg("活动价格不能为空");
        			return false;
        		}
        		data.field.activityAmount = $("#activityAmount").val();
        		data.field.isActivity=1;
        	}
    		/*if($("#activityStartDate").val()){
    			data.field.activityStartDate = $("#activityStartDate").val();
    		}
    		if($("#activityEndDate").val()){
    			data.field.activityEndDate = $("#activityEndDate").val();
    		}*/
        	if('0' == data.field.isRecommend){
        		data.field.rendStatus = '';
        	}
            jbg.apiRequest({
                url: '/product/insertProduct',
                method: 'post',
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
      //金额转大写          
		$('#amount').on('input',function(){ 
        	var money=$('#amount').val();
        	// $(this).val($(this).val().replace(/(\D)([^\.])(\D)/g,'')); 
        	money=money.replace(/[^\d.]/g,""); 
        	money=money.replace(/^\./g,""); 
        	money=money.replace(/\.{2,}/g,"."); 
        	money=money.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        	money=money.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
        	$('#amount').val(money);
        	if(money){
	        	var pay = smalltoBIG(money);
				$('#bigTxt').html(pay=='NaN'?"":pay);
        	}else{
        		$('#bigTxt').html("");
        	}
        }); 
      
		//金额转大写          
		$('#activityAmount').on('input',function(){ 
        	var money=$('#activityAmount').val();
        	// $(this).val($(this).val().replace(/(\D)([^\.])(\D)/g,'')); 
        	money=money.replace(/[^\d.]/g,""); 
        	money=money.replace(/^\./g,""); 
        	money=money.replace(/\.{2,}/g,"."); 
        	money=money.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        	money=money.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
        	$('#activityAmount').val(money);
        	if(money){
	        	var pay = smalltoBIG(money);
				$('#activityTxt').html(pay=='NaN'?"":pay);
        	}else{
        		$('#activityTxt').html("");
        	}
        }); 
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
      //普通图片上传
        var uploadInst = upload.render({
          elem: '#image'
          ,url: '/hobbies/uploadFile'
          ,multiple: true
          ,size : 1024
          ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
              //$('#demo1').attr('src', result); //图片链接（base64）
               $('#demo1').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
          }
          ,done: function(res){
            //如果上传失败
            if(res.resCode != 00000){
              return layer.msg('上传失败');
            }
            var url = res.data + ";";
            var imageUrl = "";
            if($("#imageUrl").val() && "null" != $("#imageUrl").val()){
            	imageUrl = $("#imageUrl").val();
            }
            //上传成功
            $("#imageUrl").val(imageUrl+url);
          }
          ,error: function(){
           /*  //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
              uploadInst.upload();
            }); */
          }
        });
      //普通图片上传
        var uploadInst = upload.render({
          elem: '#detailsImage'
          ,url: '/hobbies/uploadFile'
          ,size : 1024
          ,multiple: true
          ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
              //$('#demo2').attr('src', result); //图片链接（base64）
              $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
          }
          ,done: function(res){
            //如果上传失败
            if(res.resCode != 00000){
              return layer.msg('上传失败');
            }
            var url = res.data + ";";
            var detailsImageUrl = "";
            if($("#detailsImageUrl").val() && $("#detailsImageUrl").val()){
            	detailsImageUrl = $("#detailsImageUrl").val();
            }
            //上传成功
            $("#detailsImageUrl").val(detailsImageUrl+url);
          }
          ,error: function(){
           /*  //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
              uploadInst.upload();
            }); */
          }
        });
        
    });
</script>
</body>
</html>