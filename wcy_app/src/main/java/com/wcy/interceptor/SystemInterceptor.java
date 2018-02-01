package com.wcy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wcy.utils.rest.CheckUtils;
import com.wcy.utils.rest.ErrorCode;
import com.wcy.utils.rest.ResultObj;

@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 拦截器
	 * <p> 内容描述 : 
	 * <p> 修改日期： 2016年7月1日 下午8:00:51 </p>
	 * @author yuewangh
	 * @version V1.0
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String no_filter_path = ".*/((login)|(tologin)|(createCode)).*";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String path = request.getServletPath();
		if(!path.matches(no_filter_path)){
			int res = CheckUtils.checkSignature(request);
			if(res != 0){
				ResultObj ro = new ResultObj();
				ro.setError(ErrorCode.ERROR2);
				PrintWriter out = response.getWriter();
				out.print(JSONObject.fromObject(ro).toString());
				out.close();
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
}