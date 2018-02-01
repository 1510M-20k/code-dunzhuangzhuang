package com.wcy.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("main")
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
	@RequestMapping("tab")
	public ModelAndView tab(){
		ModelAndView mv = new ModelAndView("tab");
		return mv;
	}
	 
}
