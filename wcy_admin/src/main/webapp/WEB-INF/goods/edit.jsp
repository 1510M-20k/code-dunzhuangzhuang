<!DOCTYPE html>
<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/include/header.inc"%>
<html>
<head>
<%@ include file="/include/csslib.jsp/"%>
</head>
<body>
	<form action="${ctx}/goods/save.do" name="Form" id="Form" method="post">
		<input type="hidden" name="id" id="id" value="${goods.id}"/>
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">商品名称:</td>
				<td><input type="text" name="name" id="商品名称" value="${goods.name}" maxlength="32" placeholder="这里输入商品名称" title="商品名称" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">商品分类:</td>
				<td><input type="text" name="type_id" id="商品分类" value="${goods.type_id}" maxlength="32" placeholder="这里输入商品分类" title="商品分类" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">商品价格:</td>
				<td><input type="text" name="price" id="商品价格" value="${goods.price}" maxlength="32" placeholder="这里输入商品价格" title="商品价格" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">代理价格:</td>
				<td><input type="text" name="proxy_price" id="代理价格" value="${goods.proxy_price}" maxlength="32" placeholder="这里输入代理价格" title="代理价格" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">计量单位:</td>
				<td><input type="text" name="unite" id="计量单位" value="${goods.unite}" maxlength="32" placeholder="这里输入计量单位" title="计量单位" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">库存:</td>
				<td><input type="text" name="num" id="库存" value="${goods.num}" maxlength="32" placeholder="这里输入库存" title="库存" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">标签:</td>
				<td><input type="text" name="tag" id="标签" value="${goods.tag}" maxlength="32" placeholder="这里输入标签" title="标签" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">支持外卖:</td>
				<td><input type="text" name="is_wm" id="支持外卖" value="${goods.is_wm}" maxlength="32" placeholder="这里输入支持外卖" title="支持外卖" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">支持上架:</td>
				<td><input type="text" name="is_sj" id="支持上架" value="${goods.is_sj}" maxlength="32" placeholder="这里输入支持上架" title="支持上架" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">支持优惠券:</td>
				<td><input type="text" name="is_yhj" id="支持优惠券" value="${goods.is_yhj}" maxlength="32" placeholder="这里输入支持优惠券" title="支持优惠券" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">支持会员卡:</td>
				<td><input type="text" name="is_hyk" id="支持会员卡" value="${goods.is_hyk}" maxlength="32" placeholder="这里输入支持会员卡" title="支持会员卡" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">图片:</td>
				<td><input type="text" name="img" id="图片" value="${goods.img}" maxlength="32" placeholder="这里输入图片" title="图片" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">简介:</td>
				<td><input type="text" name="content" id="简介" value="${goods.content}" maxlength="32" placeholder="这里输入简介" title="简介" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">创建人:</td>
				<td><input type="text" name="creater" id="创建人" value="${goods.creater}" maxlength="32" placeholder="这里输入创建人" title="创建人" style="margin-bottom: 0px"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;vertical-align: middle;">最后修改人:</td>
				<td><input type="text" name="updater" id="最后修改人" value="${goods.updater}" maxlength="32" placeholder="这里输入最后修改人" title="最后修改人" style="margin-bottom: 0px"/></td>
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
			url: "${ctx}/goods/save.action",
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