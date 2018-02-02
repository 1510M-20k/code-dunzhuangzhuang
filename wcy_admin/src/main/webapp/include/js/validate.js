var error=0;
var hasfocus = false;
//就绪函数，页面加载完，自动执行
$(function(){
	//获取form表达中的所有input标签，绑定丢失焦点事件；
	$('form').find(":input").blur(function(){
		//获取上一级对象
		var parent = $(this).parent();
		//获取当前input标签的值，并去除空格
		var value = $.trim($(this).val());
		//获取当前标签的title属性；需要注意的是，如果你用的jquery是1.9版本之前的，用attr；如果是1.9或者他之后的版本，用prop
		var title =  $(this).attr("title");
		if(typeof(title) == 'undefined'){
			title="";
		}
		var isHidden = $(this).attr("type") == "hidden";
		//如果不是隐藏的input，并且包含^<>;{0,}这些字符;js正则/^开头$/结尾 []表示选择其中1个{0,}表示任意多个
		if(!isHidden && !/^[^<>;]{0,}$/.test(value)){
			$(this).tips({
				side:2,
				msg:'不能输入符号^<>;',
	            bg:'#AE81FF',
	            time:2
	        });
			if(!hasfocus){
				hasfocus = true;
				$(this).focus();//if the frame is too large with scrollbar, must use focus() to scroll to the item with error.
			}
			error++;
		}
		if($(this).hasClass("required")){
			if(value==""){
				$(this).tips({
					side:2,
		            msg:title+'不能为空',
		            bg:'#AE81FF',
		            time:2
		        });
				if(!hasfocus){
					hasfocus = true;
					$(this).focus();
				}
				error++;
			}
		}
		//以判断不为空，下边的验证都是允许为空的，所以不为空时再校验
		if(value!=""){
			if($(this).hasClass("phone")){//验证手机号码
				if(!/^1\d{10}$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'手机号格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("email")){//验证邮箱
				if(!/.+@.+\.[a-zA-Z]{2,4}$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'邮箱格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("postcode")){//邮政编码
				if(!/^[1-9][0-9]{5}$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'邮政编码格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("linephone")){//固定电话
				if(!/^(\d{3,4})-(\d{7,8})$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'固定电话格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("idcode")){//身份证
				if(!/^(\d{18,18}|\d{15,15}|\d{17,17}[xX]{1})$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'身份证格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("money")){//金额，整数位最多十位，小数为最多为两位，可以无小数位
				if(!/^(([0-9]|([1-9][0-9]{0,9}))((\.[0-9]{1,2})?))$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'数据格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}else if($(this).hasClass("number")){//数字类型校验
				if(!/^[0-9]\d*$/.test(value)){
					$(this).tips({
						side:2,
			            msg:'数据格式错误',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
				
			}else if($(this).hasClass("charnumber")){//只可以是数字和字母
				if(!/^[A-Za-z]+[0-9]+$/.test(value)){ 
					$(this).tips({
						side:2,
			            msg:'只允许是字母+数字',
			            bg:'#AE81FF',
			            time:2
			        });
					if(!hasfocus){
						hasfocus = true;
						$(this).focus();
					}
					error++;
				}
			}
		}
		$(this).val(value);//把去除空格的值，返回
	});
});

function validateForm(){
	//让form表单中的所有input失去焦点
	$('form').find(":input").each(function(){
		$(this).blur();
	})
	//下拉框必选
	$('form').find("select").each(function(){
		var value = $.trim($(this).val());
		var title =  $(this).attr("title");
		if(typeof(title) == 'undefined'){
			title="";
		}
		if($(this).hasClass("required")){
			if(value==""){
				$(this).tips({
					side:2,
			           msg:title+'不能为空',
			           bg:'#AE81FF',
			           time:2
			       });
				error++;
			}
		}
	});
	if(error > 0){
		error =0;
		return false;
	} else{
		return true;
	}
}
