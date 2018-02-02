<!DOCTYPE html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/header.inc"%>
<html>
<head>
<%@ include file="/include/csslib.jsp/"%>
</head>
<body>
	<form action="${ctx}/goodsType/save.do" name="Form" id="Form" method="post">
		<input type="hidden" name="id" id="id" value="${goodsType.id}"/>
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">分类名称:</td>
				<td><input type="text" name="name" id="分类名称" value="${goodsType.name}" maxlength="32" placeholder="这里输入分类名称" title="分类名称" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">排序:</td>
				<td><input type="text" name="sort" id="排序" value="${goodsType.sort}" maxlength="32" placeholder="这里输入排序" title="排序" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">是否推荐:</td>
				<td><input type="text" name="is_tj" id="是否推荐" value="${goodsType.is_tj}" maxlength="32" placeholder="这里输入是否推荐" title="是否推荐" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">是否收取餐盒费:</td>
				<td><input type="text" name="is_fschf" id="是否收取餐盒费" value="${goodsType.is_fschf}" maxlength="32" placeholder="这里输入是否收取餐盒费" title="是否收取餐盒费" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">分类图片:</td>
				<td><input type="text" name="img" id="分类图片" value="${goodsType.img}" maxlength="32" placeholder="这里输入分类图片" title="分类图片" style="margin-bottom: 0px"/></td>
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
			url: "${ctx}/goodsType/save.action",
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