<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0079)http://www.wushanlingyuan.com/cemetery/tombstoneViewNan.action?tombstoneId=1287 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>无标题文档</title>
		<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			 debugger;
			 var sizhexingming1 = GetQueryString("sizhexingming1");
		     var sizhexingming2 = GetQueryString("sizhexingming2");
		     if(sizhexingming1 != ""){
		     	$("#deadName").html(sizhexingming1);
		     }
		     if(sizhexingming2 != ""){
		     	$("#deadName1").html(sizhexingming2);
		     }
		     
		     var position = GetQueryString("position");
		     if(position != ""){
		     	 $("#position").text("墓碑位置："+position);
		     }
			 
			 var sizhexingbie1 = GetQueryString("sizhexingbie1");
		     var sizhexingbie2 = GetQueryString("sizhexingbie2");
		     var beiwenxianshi = GetQueryString("beiwenxianshi");
		     
		     if(sizhexingbie1 == "男"){
		     	//$('#a').html("顕考");
		     	$('#xk1').html("考");
				$('#b').html("大人");
		     }
		     if(sizhexingbie1 == "女"){
		        //$('#a').html("顕妣");
		        $('#xk1').html("妣");
				$('#b').html("孺人");
		     }
		     if(sizhexingbie2 == "女"){
		       //$('#a').html("顕妣");
		       
		       $('#xk2').html("妣");
				$('#b1').html("孺人");
		     }
		     if(sizhexingbie2 == "男"){
		     	//$('#a').html("顕考");
		     	$('#xk2').html("考");
				$('#b1').html("大人");
		     }
		     
			 if(beiwenxianshi){
			 	$('#a').html(beiwenxianshi.substring(0,beiwenxianshi.length-1));
			 	/*var kao = beiwenxianshi.substring(beiwenxianshi.length-1,beiwenxianshi.length);
			 	if(kao == "考"){
			 		$('#b').html("大人之墓");
			 	}else{
			 		$('#b1').html("孺人之墓");
			 	}*/
			 }
			 
			
			var html ="";
			var wangzheerzixingming = GetQueryString("wangzheerzixingming");
			if(wangzheerzixingming != ""){
				html += "孝儿   "+ wangzheerzixingming
			}
			var wangzhennverxingming = GetQueryString("wangzhennverxingming");
			if(wangzhennverxingming != ""){
				html += "孝女   "+ wangzhennverxingming;
			}
			var wangzheerxixingming = GetQueryString("wangzheerxixingming");
			if(wangzheerxixingming != ""){
				html += "孝媳   "+ wangzheerxixingming;
			}
			var wangzhenvxuxingming = GetQueryString("wangzhenvxuxingming");
			if(wangzhenvxuxingming != ""){
				html += "孝婿   "+ wangzhenvxuxingming;
			}
			var wangzhesunbeixingming = GetQueryString("wangzhesunbeixingming");
			if(wangzhesunbeixingming != ""){
				html += "孝孙   "+ wangzhesunbeixingming;
			}
			var wangzhezengsunbeixingming = GetQueryString("wangzhezengsunbeixingming");
			if(wangzhezengsunbeixingming != ""){
			   html += "孝曾孙   "+ wangzhezengsunbeixingming;
			}
			html += " 率全家立";
			
			document.getElementById("html").innerHTML = html;
			
			 
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
</style></head>
	
	<body>
<!--startprint1-->
		<table style="padding: 35px; width: auto; height: 300px;  text-align: center; line-height: 90px;" align="center">
			<tbody><tr>
				<td></td>
				<td>
					<div id="xk1" style="width:100px; font-size: 50px"></div>
				</td>
				<td>
					<div style="width: 200px; font-size: 35px;" id="deadName"></div>
				</td>
				<td>
					<div style="font-size: 35px;" id="b"></div>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>
					<div id="a" style="width: 35px; height: auto; word-wrap: break-word; font-size: 50px;"></div>
				</td>
				<td></td>
				<td>
				</td>
				<td></td>
				<td>
					<div style="font-size: 35px;" >之墓</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="xk2" style="width: 100px; font-size: 50px"></div>
				</td>
				<td><div style="width: 200px; font-size: 35px;" id="deadName1"></div></td>
				<td>
					<div style="font-size: 35px;" id="b1"></div>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
						<div style="line-height: 35px; width:auto;" id="html">
							
						</div>
				</td>
			</tr>
		</tbody></table>
		<table align="center" width="600" style="text-align: center; line-height: 30px;">
			<tbody><tr>
				<td>
					公墓管理处：
				</td>
				<td>
					购墓方：
				</td>
			</tr>
			<tr>
				<td>
					<p id="position"></p>
				</td>
			</tr>
		</tbody></table>
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