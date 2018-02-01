package com.wcy.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	/**
	 * 进入主页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
	/**
	 * 进入tab页
	 * @return
	 */
	@RequestMapping("tab")
	public ModelAndView tab(){
		ModelAndView mv = new ModelAndView("tab");
		return mv;
	}
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
