var jbg = {
	apiRequest : function(params) {
		var $ = layui.$;
		var that = this;
		var request = {
			url : params.url,
			data : params.data,
			dataType : params.dataType == undefined ? "json":params.dataType,
			contentType : params.contentType == undefined? "application/json" : params.contentType,
			method : params.method,
			type : params.type,
			header : {},
			success : function(res) {
				if (res.resCode == "00000") {
					if (params.success != undefined) {
						params.success.call(that, res.data);
					}
				} else if (params.fail != undefined) {
					params.fail.call(that,res);
				} else if(res.resInfo != undefined) {
					layer.alert(res.resInfo,{icon: 0})
				}
			},
			error : function(event, XMLHttpRequest, ajaxOptions, thrownError) {
				if (params.error != undefined) {
					params.error.call(that)
				} else {
					layer.alert("请求服务器错误",{icon: 5});
				}
			},
			complete : function() {
				if (params.complete != undefined) {
					params.complete.call(that)
				}
			}
		}
		if(params.async!=undefined) {
			request.async = params.async;
		}
		if(params.xhrFields!=undefined) {
			request.xhrFields = params.xhrFields;
		}
		if(params.contentType != undefined) {
			request.contentType = params.contentType;
		}
		$.ajax(request);
	},

	loadFormData : function(form, data) {
		var $ = layui.$;
		var key, value, tagName, type, arr;
		for (key in data) {
			value = data[key];

			$("[name='" + key + "']", $(form))
					.each(
							function() {
								tagName = $(this)[0].tagName;
								type = $(this).attr('type');
								dataType = $(this).attr('data-type');
								if (tagName == 'INPUT') {
									if (type == 'radio') {
										$(this).attr('checked',
												$(this).val() == value);
									} else if (type == 'checkbox') {
										if(value != null || value != undefined) {
											arr = value.split(',');
											for (var i = 0; i < arr.length; i++) {
												if ($(this).val() == arr[i]) {
													$(this).attr('checked', true);
													break;
												}
											}
										} else {
											$(this).attr('checked', false);
										}
									} else if (type == 'dateTime') {
										if(value == null || value != undefined) {
											$(this).val('');
										} else {
											$(this).val(moment(value).format('YYYY-MM-DD HH:mm:ss'));
										}
									} else if (type == 'password'){
										//密码不回显
									}else {
										$(this).val(value);
									}
								} else if (tagName == 'SELECT'
										|| tagName == 'TEXTAREA') {
									$(this).val(value);
								}

							});
		}
	},
	toDecimal : function(num, decimal) {
		var result = parseFloat(num);
		if (isNaN(result)) {
			return false;
		}
		result = num / Math.pow(10, 2);
		return result;
	},
	getUrlParam : function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); // 匹配目标参数
		if (r != null)
			return unescape(r[2]);
		return null; // 返回参数值
	}
}

var formVerify = {
  username: function(value, item){ //value：表单的值、item：表单的DOM对象
	if(value == '') {
		return '用户名不能为空';
	}
    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5@\\s·]+$").test(value)){
      return '用户名不能有特殊字符';
    }
  }
  ,password: function(value, item) {
    if(!(/^[\S]{1,12}$/.test(value) || item.placeholder == "******")) {
    	return '密码不能为空'
    }
  }
}