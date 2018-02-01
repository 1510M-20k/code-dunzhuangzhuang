<!DOCTYPE html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/header.inc"%>
<html>
<head>
<%@ include file="/include/csslib.jsp/"%>
</head>
<body>
	<form action="${ctx}/dianpu/save.do" name="Form" id="Form" method="post">
		<input type="hidden" name="id" id="id" value="${dianpu.id}"/>
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺名称:</td>
				<td><input type="text" name="name" id="店铺名称" value="${dianpu.name}" maxlength="32" placeholder="这里输入店铺名称" title="店铺名称" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">推荐人:</td>
				<td><input type="text" name="tjr" id="推荐人" value="${dianpu.tjr}" maxlength="32" placeholder="这里输入推荐人" title="推荐人" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">wifi账号:</td>
				<td><input type="text" name="wifi_name" id="wifi账号" value="${dianpu.wifi_name}" maxlength="32" placeholder="这里输入wifi账号" title="wifi账号" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">wifi密码:</td>
				<td><input type="text" name="wifi_pwd" id="wifi密码" value="${dianpu.wifi_pwd}" maxlength="32" placeholder="这里输入wifi密码" title="wifi密码" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺电话:</td>
				<td><input type="text" name="phone" id="店铺电话" value="${dianpu.phone}" maxlength="32" placeholder="这里输入店铺电话" title="店铺电话" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺地址:</td>
				<td><input type="text" name="address" id="店铺地址" value="${dianpu.address}" maxlength="32" placeholder="这里输入店铺地址" title="店铺地址" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺图片:</td>
				<td><input type="text" name="img" id="店铺图片" value="${dianpu.img}" maxlength="32" placeholder="这里输入店铺图片" title="店铺图片" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">创建人:</td>
				<td><input type="text" name="creater" id="创建人" value="${dianpu.creater}" maxlength="32" placeholder="这里输入创建人" title="创建人" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">最后修改人:</td>
				<td><input type="text" name="updater" id="最后修改人" value="${dianpu.updater}" maxlength="32" placeholder="这里输入最后修改人" title="最后修改人" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">二维码url:</td>
				<td><input type="text" name="erwm" id="二维码url" value="${dianpu.erwm}" maxlength="32" placeholder="这里输入二维码url" title="二维码url" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺总收入:</td>
				<td><input type="text" name="all_money" id="店铺总收入" value="${dianpu.all_money}" maxlength="32" placeholder="这里输入店铺总收入" title="店铺总收入" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">店铺余额:</td>
				<td><input type="text" name="able_modey" id="店铺余额" value="${dianpu.able_modey}" maxlength="32" placeholder="这里输入店铺余额" title="店铺余额" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">当日收入:</td>
				<td><input type="text" name="today_money" id="当日收入" value="${dianpu.today_money}" maxlength="32" placeholder="这里输入当日收入" title="当日收入" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" id="savebtn" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="frameElement.api.close();">取消</a>
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
		$("#savebtn").attr("disabled", "disabled");
		$.ajax({
			type: "POST",
			url: "${ctx}/dianpu/save.action",
			data: $("#Form").serialize(),
			dataType:"json",
			cache: false,
			success: function(data){
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
</script>
</body>
</html>