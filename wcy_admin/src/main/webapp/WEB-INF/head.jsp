<div class="navbar navbar-inverse">
		  <div class="navbar-inner">
		   <div class="container-fluid">
			  <a class="brand"><small><i class="icon-leaf"></i> wy的demo</small> </a>
			  <ul class="nav ace-nav pull-right">
					<li class="light-blue user-profile">
						<a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
							<img alt="FH" src="${ctx}/include/img/avatars/user.jpg" class="nav-user-photo" />
							<span id="user_info" style="margin-top: 8px">
								admin
							</span>
							<i class="icon-caret-down"></i>
						</a>
						<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
							<li><a onclick="editPwd();" style="cursor:pointer;"><i class="icon-user"></i> 修改密码</a></li>
							<li id="productCode"><a onclick="productCode();" style="cursor:pointer;"><i class="icon-cogs"></i> 代码生成</a></li>
							<!--  <li id="systemset"><a onclick="editSys();" style="cursor:pointer;"><i class="icon-cog"></i> 系统设置</a></li>
							-->
							<li class="divider"></li>
							<li><a href="javascript:;" onclick="logout()"><i class="icon-off"></i> 退出</a></li>
						</ul>
					</li>
			  </ul><!--/.ace-nav-->
		   </div><!--/.container-fluid-->
		  </div><!--/.navbar-inner-->
		</div><!--/.navbar-->
<script type="text/javascript">
function logout(){
	bootbox.confirm("确定要退出登录吗?", function(result) {
		if(result) {
			window.location.href="${ctx}admin/logout.action";
		}
	});
}
//修改个人资料
function productCode(){
	 $.dialog({
		id : 'productCode',
		title : "代码生成",
		content : "url:${ctx}createCode/createCode.action",
		cover : true,
		width : 800,
		height :400,
		lock : true
	});
}
//修改个人资料
function editPwd(){
	$.dialog({
		id : 'editPwd',
		title : "修改密码",
		content : "url:${ctx}user/edit_pwd.action",
		cover : true,
		width : 225,
		height :180,
		lock : true
	});
}
</script>