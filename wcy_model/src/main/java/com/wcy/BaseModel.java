package com.wcy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 分页工具类
 */
public class BaseModel implements java.io.Serializable {
	private static final long serialVersionUID = 4994848560358696240L;
	
	// 查询数据库获取总个数
	private int totalCount;
	// 总的页数
	private int pageCount;
	// 每页的条数
	private int pageSize = 10;
	// 当前页数
	private int pageIndex = 1;
	// 开始位置
	private int startPos;
	// 结束位置
	private int endPos;
	// 开始时间
	private String beginTime;
	// 结束时间
	private String endTime;
	
	private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	
	private String keyword;//查询关键字
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 计算总页数和起始结束值
	 */
	private void calculatePage() {
		// 获取总页数
		if (totalCount % pageSize == 0) {
			pageCount = totalCount / pageSize;
		} else {
			pageCount = totalCount / pageSize + 1;
		}
		startPos = (pageIndex - 1) * pageSize;
		endPos = pageIndex * pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calculatePage();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//获取上一页的方法
	private int getPrevpage() {
		if(pageIndex != 1){
			return pageIndex-1;
		}else{
			return 1;
		}
	}
	//获取上一页的方法
	private int getNextpage() {
		if(pageIndex != pageCount){
			return pageIndex+1;
		}else{
			return pageIndex;
		}
	}
	public String getPageStr() {
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
		String url = request.getRequestURI();
		//计算总页数
		StringBuffer sb = new StringBuffer();
		if(totalCount>0){
			sb.append("	<ul>\n");
			if(pageIndex==1){
				sb.append("	<li><a>共<font color=red>"+totalCount+"</font>条</a></li>\n");
				sb.append("	<li><input type=\"number\" value=\""+pageIndex+"\" id=\"toGoPage\" style=\"width:50px;text-align:center;float:left\" placeholder=\"页码\"/></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"toTZ();\" class=\"btn btn-mini btn-success\">跳转</a></li>\n");
				sb.append("	<li><a>首页</a></li>\n");
				sb.append("	<li><a>上页</a></li>\n");
			}else{
				sb.append("	<li><a>共<font color=red>"+totalCount+"</font>条</a></li>\n");
				sb.append("	<li><input type=\"number\" value=\""+pageIndex+"\" id=\"toGoPage\" style=\"width:50px;text-align:center;float:left\" placeholder=\"页码\"/></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"toTZ();\"  class=\"btn btn-mini btn-success\">跳转</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(1)\">首页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+(pageIndex-1)+")\">上页</a></li>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(pageIndex>showTag){
				startTag = pageIndex-1;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=pageCount && i<=endTag; i++){
				if(pageIndex==i)
					sb.append("<li><a><font color='#808080'>"+i+"</font></a></li>\n");
				else
					sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+i+")\">"+i+"</a></li>\n");
			}
			if(pageIndex==pageCount){
				sb.append("	<li><a>下页</a></li>\n");
				sb.append("	<li><a>尾页</a></li>\n");
			}else{
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+(pageIndex+1)+")\">下页</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage("+pageCount+")\">尾页</a></li>\n");
			}
			sb.append("	<li><a>第"+pageIndex+"页</a></li>\n");
			sb.append("	<li><a>共"+pageCount+"页</a></li>\n");
			
			
			sb.append("	<li><select title='显示条数' style=\"width:55px;float:left;\" onchange=\"changeCount(this.value)\">\n");
			for(int i=1;i<10;i++){
				int cn = 10*i;
				if(pageSize == cn){
					sb.append("	<option value='"+cn+"' selected>"+cn+"</option>\n");
				} else{
					sb.append("	<option value='"+cn+"'>"+cn+"</option>\n");
				}
			}
			sb.append("	</select>\n");
			sb.append("	</li>\n");
			
			
			
			sb.append("</ul>\n");
			sb.append("<script type=\"text/javascript\">\n");
			//翻页
			sb.append("function nextPage(page){\n");
			sb.append("\tvar form = document.forms[0];\n");
			sb.append("\tif(form == undefined){\n");
			sb.append("\t\tform = document.createElement(\"form\");\n");
			sb.append("\tdocument.body.appendChild(form);\n");
			sb.append("\t}\n");
			//创建当前页文本框
			sb.append("\tvar input = document.createElement('input');\n");
			sb.append("\tinput.setAttribute('type', 'hidden');\n");
			sb.append("\tinput.setAttribute('name', 'pageIndex');\n");
			sb.append("\tinput.setAttribute('value', page); \n");
			sb.append("\tform.appendChild(input);\n");
			
			sb.append("\tform.action =\""+url+"\";\n");
			sb.append("\tform.submit();\n");
			sb.append("}\n");
			
			//调整每页显示条数
			sb.append("function changeCount(value){");
			sb.append("\tvar form = document.forms[0];\n");
			sb.append("\tif(form == undefined){\n");
			sb.append("\t\tform = document.createElement(\"form\");\n");
			sb.append("\tdocument.body.appendChild(form);\n");
			sb.append("\t}\n");
			//创建当前页文本框
			sb.append("\tvar input = document.createElement('input');\n");
			sb.append("\tinput.setAttribute('type', 'hidden');\n");
			sb.append("\tinput.setAttribute('name', 'pageIndex');\n");
			sb.append("\tinput.setAttribute('value', 1); \n");
			sb.append("\tform.appendChild(input);\n");
			
			//创建当前页文本框
			sb.append("\tvar input = document.createElement('input');\n");
			sb.append("\tinput.setAttribute('type', 'hidden');\n");
			sb.append("\tinput.setAttribute('name', 'pageSize');\n");
			sb.append("\tinput.setAttribute('value', value); \n");
			sb.append("\tform.appendChild(input);\n");
			
			sb.append("\tform.action =\""+url+"\";\n");
			sb.append("\tform.submit();\n");
			sb.append("}\n");
			
			//跳转函数 
			sb.append("function toTZ(){");
			sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;");
			sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;return;}");
			sb.append("else if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;return;}");
			sb.append("else if(Number(toPaggeVlue) >= "+pageCount+"){toPaggeVlue="+pageCount+";}");
			sb.append("else{toPaggeVlue=1;}");
			sb.append("nextPage(toPaggeVlue);");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}

}
