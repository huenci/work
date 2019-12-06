<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0078)http://www.wushanlingyuan.com/cemetery/tombstoneViewShu.action?tombstoneId=167 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>无标题文档</title>
		<style>
		* {
			margin: 0 auto;
		}
		</style>
		<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){ 
			var deadNames = new Array("");
		    var sizhexingming1 = GetQueryString("sizhexingming1");
		    var sizhexingming2 = GetQueryString("sizhexingming2");
		    var sizheshengyu1 = GetQueryString("sizheshengyu1");
		    var sizheshengyu2 = GetQueryString("sizheshengyu2");
		    var sizhesiyu1 = GetQueryString("sizhesiyu1");
		    var sizhesiyu2 = GetQueryString("sizhesiyu2");
		    var sizhexingbie1 = GetQueryString("sizhexingbie1");
		    var sizhexingbie2 = GetQueryString("sizhexingbie2");
		    var zerenren = GetQueryString("zerenren");
			if(sizhexingming1!=""){
				deadNames.push(sizhexingming1);
			}
			if(sizhexingming2!=""){
				deadNames.push(sizhexingming2);
			}
			var borndates = new Array("");
			if(sizheshengyu1!=""){
				borndates.push(sizheshengyu1);
			}
			if(sizheshengyu2!=""){
				borndates.push(sizheshengyu2);
			}
			var deaddates = new Array("");
			if(sizhesiyu1!=""){
				deaddates.push(sizhesiyu1);
				$('#nandeadtime').html(sizhesiyu1);
			}
			if(sizhesiyu2!=""){
				deaddates.push(sizhesiyu2);
				$('#nvdeadtime').html(sizhesiyu2);
			}
			var sexarr = new Array("");
			if(sizhexingbie1=="男"){
				sexarr.push("0");
			}
			if(sizhexingbie2=="女"){
				sexarr.push("1");
			}
			if(sizhexingbie2=="男"){
				sexarr.push("0");
			}
			if(sizhexingbie1=="女"){
				sexarr.push("1");
			}
			var nanindex=0,nvindex=0;
			if(sexarr.length>=3)
			{
				if(sexarr[1]==0)
				{nanindex=1;}
				else if(sexarr[2]==0)
				{nanindex=2;}
				if(sexarr[1]==1)
				{nvindex=1;}
				else if(sexarr[2]==1)
				{nvindex=2;}
			}
			else
			{
				if(sexarr[1]==0)
				{nanindex=1;nvindex=0;}
				if(sexarr[1]==1)
				{nanindex=0;nvindex=1;}
			}
			$('#piru').html(deadNames[nvindex]);
			$('#kaoda').html(deadNames[nanindex]);
			$('#nvborntime').html(borndates[nvindex]);
			$('#nanborntime').html(borndates[nanindex]);
			//$('#nvdeadtime').html(deaddates[nvindex]);
			//$('#nandeadtime').html(deaddates[nanindex]);
			
			var wangzheerzixingming = GetQueryString("wangzheerzixingming");
			var wangzhennverxingming = GetQueryString("wangzhennverxingming");
			var wangzheerxixingming = GetQueryString("wangzheerxixingming");
			var wangzhenvxuxingming = GetQueryString("wangzhenvxuxingming");
			var wangzhesunbeixingming = GetQueryString("wangzhesunbeixingming");
			var wangzhezengsunbeixingming = GetQueryString("wangzhezengsunbeixingming");
			var position = GetQueryString("position");
		    if(position != ""){
		     	 $("#position").text("墓碑位置："+position);
		     }
			
			if(wangzheerzixingming != ""){
				var wangzheerzixingmingArry = wangzheerzixingming.split('，');
				for(var i=0; i<wangzheerzixingmingArry.length;i++){
					document.getElementById("erziHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzheerzixingmingArry[i]
					+'</span>';
				}
			}
			
			if(wangzhennverxingming != ""){
				var wangzhennverxingmingArry = wangzhennverxingming.split('，');
				for(var i=0; i<wangzhennverxingmingArry.length;i++){
					document.getElementById("nverHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzhennverxingmingArry[i]
					+'</span>';
				}
			}
			
			if(wangzheerxixingming != ""){
				var wangzheerxixingmingArry = wangzheerxixingming.split('，');
				for(var i=0; i<wangzheerxixingmingArry.length;i++){
					document.getElementById("erxiHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzheerxixingmingArry[i]
					+'</span>';
				}
			}
			
			if(wangzhenvxuxingming != ""){
				var wangzhenvxuxingmingArry = wangzhenvxuxingming.split('，');
				for(var i=0; i<wangzhenvxuxingmingArry.length;i++){
					document.getElementById("nvxuHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzhenvxuxingmingArry[i]
					+'</span>';
				}
				document.getElementById("nvxuHtml").innerHTML += '<span style="margin-top: 150px; display: block;">立</span>';
				
			}
			
			if(wangzhesunbeixingming != ""){
				var wangzhesunbeixingmingArry = wangzhesunbeixingming.split('，');
				for(var i=0; i<wangzhesunbeixingmingArry.length;i++){
					document.getElementById("sunbeiHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzhesunbeixingmingArry[i]
					+'</span>';
				}
			}
			
			if(wangzhezengsunbeixingming != ""){
				var wangzhezengsunbeixingmingArry = wangzhezengsunbeixingming.split('，');
				for(var i=0; i<wangzhezengsunbeixingmingArry.length;i++){
					document.getElementById("zengsunbeiHtml").innerHTML  += 
					'<span style="line-height: 17px; display: block; margin-left: 5px; font-size: 14px; margin-top: 10px;">'+ wangzhezengsunbeixingmingArry[i]
					+'</span>';
				}
			}
			
			
			
			function GetQueryString(name){
		       var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		   	   var r = window.location.search.substr(1).match(reg);
		       if(r!=null){
		       	  if(r[2]=="undefined"){
		       	  	 return "";
		       	  }else{
		       	  	return  decodeURI(r[2]);
		       	  }
		       }
		       return null;
			}
			
			
		});
		
		</script>
	</head>

	<body>
		<!--startprint1-->
		<center>
			<table width="900" style=" text-align:center; padding-bottom:20px;border:10px solid #f1f1f1;">
				<tbody><tr>
				<td colspan="10" align="center">  
				<div style="font-size:90px; width:200px; line-height:100px;text-align:center;margin-bottom:30px; margin-top:40px;">顕</div></td>
				</tr>
				<tr>
					<td valign="top" width="100" style="font-size: 30px; line-height: 40px; padding-top: 100px; position: relative;">
						<div style="width: 10px; height: auto; word-wrap: break-word; height: 300px;" id="erxiHtml">
							媳
						</div>
						<div style="width: 10px; height: auto; word-wrap: break-word;" id="nvxuHtml">
							婿
						</div>

					</td>
					<td style="font-size: 30px;" valign="top">
						<div style="width: 10px; height: auto; word-wrap: break-word; padding-top: 60px;">
							孝
						</div>
						<div style="width: 10px; height: auto; word-wrap: break-word; margin-top: 450px;" id="sunbeiHtml">
							孙	
						</div>
					   <div style="width: 10px; height: auto; word-wrap: break-word; margin-top: 80px;" id="zengsunbeiHtml">
							曾孙	
						</div>
					</td>
					<td valign="top" width="100" style="font-size: 30px; line-height: 40px; padding-top: 100px;">
						<div style="width: 10px; height: auto; word-wrap: break-word; height: 300px;" id="erziHtml">
							子
						</div>
						<div style="width: 10px; height: auto; word-wrap: break-word;" id="nverHtml">
							女	
						</div>
					</td>

					<td valign="top">
						<div style="width: 80px; height: auto; word-wrap: break-word; text-align: center;">
							<span style="font-size: 70px;">妣</span>
							<span style="font-size: 45px; line-height: 45px; margin-top: 60px; display: block; height: 125px;" id="piru"></span><span style="font-size: 70px; line-height: 80px; margin-top: 50px; display: block;">
								孺</span>
						</div>
					</td>
					<td style="position: relative;">
						<div style="width: 80px; height: auto; word-wrap: break-word; text-align: center;">
							<span style="font-size: 70px; line-height: 80px; margin-top: 200px; display: block; line-height: 90px;">人之墓</span>
						</div>
					</td>
					<td valign="top">
						<div style="width: 80px; height: auto; word-wrap: break-word;">
							<span style="font-size: 70px;">考</span>
							<span style="font-size: 45px; line-height: 45px; margin-top: 60px; display: block; height: 125px;" id="kaoda"></span><span style="font-size: 70px; line-height: 80px; margin-top: 50px; display: block;">
								大</span>
						</div>
					</td>
					<td align="center" width="100" style="font-size: 20px; line-height: 25px; padding-top: 50px;">
						<div style="width: 10px; height: auto;height:300px; word-wrap: break-word;">
							于<span id="nvborntime"></span>
						</div>
						<div style="width: 10px; height: auto; height:300px;word-wrap: break-word; margin-top: 50px;">
							于<span id="nvdeadtime"></span>
							
						</div>
					</td>
					<td style="font-size: 30px; padding-top: 60px;" valign="top">
						<div style="width: 10px; height: auto; word-wrap: break-word;">
							诞
						</div>
						<div style="width: 10px; height: auto; word-wrap: break-word; margin-top: 300px;">
							卒
						</div>
					</td>
					<td align="center" width="100" style="font-size: 20px; line-height: 25px; padding-top: 50px;">
						<div style="width: 10px; height: auto;height:300px; word-wrap: break-word;">
							于<span id="nanborntime"></span>
						</div>
						<div style="width: 10px; height: auto; height:300px;word-wrap: break-word; margin-top: 50px;">
							于<span id="nandeadtime"></span>
						</div>
					</td>
				</tr>
				<tr><td colspan="9">
  
  <div style=" float:left; left:30px;  width:800px; text-align:left; padding-left:35px; line-height:70px; font-size:20px;">
    <p>购墓方签字：</p>
    <p>陵园签字：<img src="/images/yjw.jpg" align="absmiddle"></p>
    <p>建墓施工方签字：</p>
    <p id="position"></p>
    </div>
  </td></tr>
			</tbody></table>
		</center>
		<!--endprint1-->
		<div class="noprint" style="float: right;">
<input id="btnPrint" type="button" value="打印预览" onclick="preview(1)">
</div>
<style type="text/css" media="print">
.noprint{display : none }
</style>
<script>
function preview(oper)       
{
if (oper < 10)
{
bdhtml=window.document.body.innerHTML;//获取当前页的html代码
sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html

prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml;
} else {
window.print();
}
}
</script>
	

</body></html>