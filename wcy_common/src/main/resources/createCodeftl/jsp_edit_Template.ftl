<!DOCTYPE html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/header.inc"%>
<html>
<head>
<%@ include file="/include/csslib.jsp/"%>
</head>
<body>
	<form action="${r"${ctx}"}/${objectNameLower}/save.do" name="Form" id="Form" method="post">
		<input type="hidden" name="id" id="id" value="${r"${"}${objectNameLower}.id}"/>
		<table id="table_report" class="table table-striped table-bordered table-hover">
		<#list fieldList as var>
			<#if (var_index > 0) >
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">${var[2]}:</td>
				<td><input type="text" name="${var[0]}" id="${var[2]}" value="${r"${"}${objectNameLower}.${var[0]}}" maxlength="32" placeholder="这里输入${var[2]}" title="${var[2]}" style="margin-bottom: 0px"/></td>
			</tr>
			</#if>
		</#list>
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
		if("${r"${otype}"}" == "look"){
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
			url: "${r"${ctx}"}/${objectNameLower}/save.action",
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