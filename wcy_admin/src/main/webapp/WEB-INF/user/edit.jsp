<!DOCTYPE html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/header.inc"%>
<html>
<head>
<%@ include file="/include/csslib.jsp/"%>
</head>
<body>
	<form action="${ctx}/user/save.do" name="Form" id="Form" method="post">
		<input type="hidden" name="id" id="id" value="${user.id}"/>
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">手机号:</td>
				<td><input type="text" name="phone" id="手机号" value="${user.phone}" class="required phone" maxlength="32" placeholder="这里输入手机号" title="手机号" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">中文姓名:</td>
				<td><input type="text" name="name" id="中文姓名" value="${user.name}" class="required" maxlength="32" placeholder="这里输入中文姓名" title="中文姓名" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<button type="button" class="btn btn-primary btn-sm" id="savebtn" onclick="save();">保存</button>
					<button type="button" class="btn btn-info btn-sm" onclick="frameElement.api.close();">取消</button>
				</td>
			</tr>
		</table>
	</form>
<%@ include file="/include/jslib.jsp/"%>
<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
	$(function() {
		if("${otype}" == "look"){
			$("#table_report").find(":input").each(function(){
				$(this).parent().html($(this).val());
			});
			
			$("#savebtn").hide();
		}
	});

	//保存
	function save(){
		if(validateForm()){//如果返回true，表示验证通过、返回false，表示验证失败，不提交
			$("#savebtn").attr("disabled", "disabled");
			$.ajax({
				type: "POST",
				url: "${ctx}/user/save.action",
				data: $("#Form").serialize(),
				dataType:"json",
				success: function(data){
// 					alert(1);//alert是同步的，只有执行完，才执行下边的；
// 					alert(2);
// 					bootbox.alert("保存成功！");//其他插件alert，基本上都是异步的；
// 					alert(3);
					//想要保证同步，必须写在他的方法里边
					bootbox.alert("保存成功！",function(){
						api.reload();
					});
				},
				error: function(request) {
	               bootbox.alert("程序错误！",function(){
						$("#savebtn").removeAttr("disabled");
					});
	            },
			});
		}
	}
</script>
</body>
</html>