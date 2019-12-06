<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0079)http://www.wushanlingyuan.com/cemetery/tombstoneViewHeng.action?tombstoneId=167 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>无标题文档</title>
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
				console.log(sexarr);
				console.log(deadNames);
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
			$("#zerenren").text("建墓施工方签字："+zerenren);
			
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
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzheerzixingmingArry[i]
					+'</div>';
				}
			}
			
			if(wangzhennverxingming != ""){
				var wangzhennverxingmingArry = wangzhennverxingming.split('，');
				for(var i=0; i<wangzhennverxingmingArry.length;i++){
					document.getElementById("nverHtml").innerHTML  += 
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzhennverxingmingArry[i]
					+'</div>';
				}
			}
			
			if(wangzheerxixingming != ""){
				var wangzheerxixingmingArry = wangzheerxixingming.split('，');
				for(var i=0; i<wangzheerxixingmingArry.length;i++){
					document.getElementById("erxiHtml").innerHTML  += 
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzheerxixingmingArry[i]
					+'</div>';
				}
			}
			
			if(wangzhenvxuxingming != ""){
				var wangzhenvxuxingmingArry = wangzhenvxuxingming.split('，');
				for(var i=0; i<wangzhenvxuxingmingArry.length;i++){
					document.getElementById("nvxuHtml").innerHTML  += 
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzhenvxuxingmingArry[i]
					+'</div>';
				}
			}
			
			if(wangzhesunbeixingming != ""){
				var wangzhesunbeixingmingArry = wangzhesunbeixingming.split('，');
				for(var i=0; i<wangzhesunbeixingmingArry.length;i++){
					document.getElementById("sunbeiHtml").innerHTML  += 
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzhesunbeixingmingArry[i]
					+'</div>';
				}
			}
			
		    if(wangzhezengsunbeixingming != ""){
				var wangzhezengsunbeixingmingArry = wangzhezengsunbeixingming.split('，');
				for(var i=0; i<wangzhezengsunbeixingmingArry.length;i++){
					document.getElementById("zengsunbeiHtml").innerHTML  += 
					'<div style="float:left; margin-left:10px;width:70px;">'+ wangzhezengsunbeixingmingArry[i]
					+'</div>';
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
	<style>
* {
	margin: 0;
	padding: 0;
}

body {
	line-height: 90px;
}
</style></head>
	

	<body>
	<!--startprint1-->
		<center>
			<table style="width: 1000px; height: 450px; text-align: center;" align="center">
				<tbody><tr>
					<td colspan="4">
						<table>
							<tbody><tr>
								<td rowspan="2" height="180">
									<img src="" width="120" height="160" style="float: left; margin-left: 100px;">
									<img src="" width="120" height="160" style="float: left; margin-left: 35px;">
								</td>

								<td style="padding-left: 50px;">
									<table>
										<tbody><tr>
											<td>
												<div style="font-size: 20px; line-height: 40px; width: 265px; float: left; text-align: left;">
													诞于<span id="nanborntime"></span>
												</div>
											</td>
											<td>
												<div style="font-size: 20px; line-height: 40px; width: 265px; float: left; text-align: left;">
													卒于<span id="nandeadtime"></span>
												</div>
											</td>

										</tr>
										<tr>
											<td>
												<div style="font-size: 20px; line-height: 40px; width: 265px; float: left; text-align: left;">
													诞于<span id="nvborntime"></span>
												</div>
											</td>
											<td>
												<div style="font-size: 20px; line-height: 40px; width: 265px; float: left; text-align: left;">
													卒于<span id="nvdeadtime"></span>
												</div>
											</td>
										</tr>
									</tbody></table>

								</td>

							</tr>

						</tbody></table>
					</td>
				</tr>
				<tr>
					<td rowspan="2">
						<div style="font-size: 50px;">
							顕
						</div>
					</td>
					<td>
						<div style="font-size: 40px; float: left; margin-left: 85px;">
							<span style="float: left;">考</span>
							<span id="kaoda" style="width: 200px; display: block; font-size: 35px; margin-left: 20px; float: left;position:absolute;"></span>
						</div>
					</td>
					<td>
						<div style="font-size: 40px;">
							大
						</div>
					</td>
					<td rowspan="2" style="padding-left:100px;"><div style="font-size:40px; float:left; ">人之墓</div></td>
				</tr>

				<tr>
					<td>
						<div style="font-size: 40px; float: left; margin-left: 85px;">
							<span style="float: left;">妣</span>
							<span id="piru" style="width: 200px; display: block; font-size: 35px; margin-left: 20px; float: left;position:absolute;"></span>
						</div>
					</td>
					<td>
						<div style="font-size: 40px;">
							孺
						</div>
					</td>

				</tr>

				<tr>
					<td rowspan="2">
						<div style="font-size: 30px;">
							孝
						</div>
					</td>
					<td>
						<table>
							<tbody><tr>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
										子
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="erziHtml">
										
									</div>

								</td>
							</tr>
						</tbody></table>
					</td>
					<td>
						<table>
							<tbody><tr>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
										女
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="nverHtml">
									</div>

								</td>
							</tr>
						</tbody></table>
					</td>
					<td rowspan="2">
						<table>
							<tbody><tr>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
										孙
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="sunbeiHtml">	
									</div>

								</td>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
									曾孙
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="zengsunbeiHtml">	
									</div>

								</td>
								<td>
									<div style="font-size: 30px; padding-left: 15px;">
										立
									</div>
								</td>
							</tr>
						</tbody></table>
					</td>
				</tr>

				<tr>
					<td>
						<table>
							<tbody><tr>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
										媳
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="erxiHtml">
									</div>

								</td>
							</tr>
						</tbody></table>
					</td>
					<td>
						<table>
							<tbody><tr>
								<td>
									<div style="font-size: 30px; padding-right: 15px;">
										婿
									</div>
								</td>

								<td>
									<div style="line-height: 35px; width:220px;" id="nvxuHtml">
									</div>

								</td>
							</tr>
						</tbody></table>
					</td>

				</tr>

				<tr>
					<td colspan="4">
						<table width="100%">
							<tbody><tr>
								<td width="30%">
									购墓方签字：
								</td>
								<td width="20%" align="right">
									陵园签字：
								</td>
								<td width="1%" align="left">
									<img src="/images/yjw.jpg" align="middle">
								</td>
								<td width="29%">
									<p id="zerenren"></p>
								</td>
								<td width="20%">
									 
								</td>

							</tr>

						</tbody></table>

					</td>
				</tr>
				<tr>
					<td></td>
					<td><p id="position"></p></td>
					<td></td>
					<td></td>
				</tr>
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