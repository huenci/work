<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0072)http://www.wushanlingyuan.com/cemetery/jianmugcdView.action?jmgcdId=3031 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
<title>无标题文档</title>
	<style>
* {
	margin: 0;
	padding: 0;
}
</style></head>
	
	<body>
	<!--startprint1-->
 		<table style="width: 800px; line-height: 50px; padding: 15px;" align="center">
			<tbody><tr>
				<td>
					<div style="font-size: 35px; font-weight: bold; text-align: center;">
						乌山八景公墓建墓工程单（存根）
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<p id="muxingmingcheng"></p>
				</td>
			</tr>
			<tr>
				<td>
					<p id="sizhexingming1"></p>
				</td>
			</tr>
			<tr>
				<td>
					<table width="500" border="0">
						<tbody><tr>
							<td>
								<p id="position"></p>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="500" border="0">
						<tbody><tr>
							<td>
								<p id="anzangshijian"></p>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="500" border="0">
						<tbody><tr>
							<td>
								<p id="yanshoushijian"></p>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td>
					<p id="zengjianxiangmu"></p>
				</td>
			</tr>
			<tr>
				<td>
					<table border="0">
						<tbody><tr>
							<td width="300">
								<p id="jingbanren"></p>
							</td>
							<td width="300">
								<p id="zerenren"></p>
							</td>
							<td>
								&nbsp;
							</td>
							<td width="250">
							<p id="anzangfang"></p>
							</td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td align="right" style="padding-right: 100px;">
					<p id="nowDate"></p>
				</td>
			</tr>
		</tbody></table>
		<!--endprint1-->
		<div class="noprint" style="float: right;">
			<input id="btnPrint" type="button" value="打印预览" onclick="preview(1)">
		</div>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
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
			

 <script>
 	
    window.onload=function(){
    	debugger;
    	//墓区位置：高塘岭公益性五区,3排,22号
        var muxingmingcheng = GetQueryString("muxingmingcheng");
        var sizhexingming1 = GetQueryString("sizhexingming1");
        var position = GetQueryString("position");
        var anzangshijian = GetQueryString("anzangshijian");
        var yanshoushijian = GetQueryString("yanshoushijian");
        var zengjianxiangmu = GetQueryString("zengjianxiangmu");
        var jingbanren = GetQueryString("jingbanren");
        var zerenren =  GetQueryString("zerenren");
        var anzangfang = GetQueryString("anzangfang");
    	$("#muxingmingcheng").text("墓地名称："+muxingmingcheng);
    	$("#sizhexingming1").text("亡者姓名："+sizhexingming1);
    	$("#position").text("墓区位置："+position);
    	$("#anzangshijian").text("安葬日期："+anzangshijian);
    	$("#yanshoushijian").text("验收日期："+yanshoushijian);
    	$("#zengjianxiangmu").text("增减项目："+zengjianxiangmu);
    	$("#jingbanren").text("八景公墓经办人："+jingbanren);
    	$("#zerenren").text("施工方责任人："+zerenren);
    	$("#anzangfang").text(" 安葬方："+anzangfang);
    	var date = new Date();
        var dateText = date.getFullYear() + '年' + (date.getMonth() + 1) + '月' + date.getDate() +'日';
    	$("#nowDate").text(dateText);
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

</script>
</body>
</html>