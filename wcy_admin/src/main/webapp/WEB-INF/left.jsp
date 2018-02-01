<!-- 本页面涉及的js函数，都在head.jsp页面中 class="menu-min"     -->
<div id="sidebar">

	<div id="sidebar-shortcuts">

		<div id="sidebar-shortcuts-large">

			<!-- <button class="btn btn-small btn-success" onclick="changeMenu();" title="切换菜单"><i class="icon-pencil"></i></button> -->

			<button class="btn btn-small btn-info" title="UI实例"
				onclick="window.open('${ctx}demo/UI_new/index.html');">
				<i class="icon-eye-open"></i>
			</button>

			<button class="btn btn-small btn-warning" title="数据字典"
				id="adminzidian" onclick="zidian();">
				<i class="icon-book"></i>
			</button>

			<button class="btn btn-small btn-danger" title="菜单管理" id="adminmenu"
				onclick="editmenu();">
				<i class="icon-folder-open"></i>
			</button>

		</div>

		<div id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>

	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">

		<li class="active" id="fhindex"><a href="${ctx}/main.action"><i class="icon-dashboard"></i><span>后台首页</span></a></li>
		<li id="lm1">
			<a style="cursor: pointer;" class="dropdown-toggle">
				<i class="icon-desktop"></i> <span>系统管理</span> <b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li id="z1">
				<a style="cursor: pointer;" target="mainFrame" onclick="siMenu('z1','lm1','用户管理','${ctx}/user/list.action')">
				    <i class="icon-double-angle-right"></i>用户管理</a>
				</li>
			</ul>
		</li>
		<li id="lm2">
			<a style="cursor: pointer;" onclick="siMenu('z2','lm2','店铺管理','${ctx}/dianpu/list.action')">
				<i class="icon-desktop"></i> <span>店铺管理</span> 
			</a>
		</li>
	</ul>
	<!--/.nav-list-->

	<div id="sidebar-collapse">
		<i class="icon-double-angle-left"></i>
	</div>

</div>
<!--/#sidebar-->
